package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.Binary_exprContext;
import antlr.SMLParser.Binary_operatorContext;
import antlr.SMLParser.Bool_exprContext;
import antlr.SMLParser.Boolean_operatorContext;
import antlr.SMLParser.ComparatorContext;
import antlr.SMLParser.Compare_exprContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Name_exprContext;
import antlr.SMLParser.Number_exprContext;
import antlr.SMLParser.One_param_unary_exprContext;
import antlr.SMLParser.Paren_exprContext;
import antlr.SMLParser.Reference_exprContext;
import antlr.SMLParser.Two_param_unary_exprContext;
import antlr.SMLParser.Word_exprContext;

public class ExpressionVisitor extends SMLBaseVisitor<String> {

  @Override
  public String visitParen_expr(Paren_exprContext ctx) {
    return ctx.SYMBOL_LPAREN().getText() + visit(ctx.expression()) + ctx.SYMBOL_RPAREN().getText();
  }

  @Override
  public String visitCompare_expr(Compare_exprContext ctx) {

    if (isReferenceOrName(ctx.left) && isReferenceOrName(ctx.right)) {
      if (ctx.comparator().SYMBOL_EQUAL() != null) {
        return visit(ctx.left) + ".equals(" + visit(ctx.right) + ")";
      }

      if (ctx.comparator().SYMBOL_NOT_EQUAL() != null) {
        return "!" + visit(ctx.left) + ".equals(" + visit(ctx.right) + ")";
      }
    }

    return visit(ctx.left) + " " + visitComparator(ctx.comparator()) + " " + visit(ctx.right);
  }

  @Override
  public String visitBool_expr(Bool_exprContext ctx) {
    return visit(ctx.left) + " " + visitBoolean_operator(ctx.boolean_operator()) + " " + visit(
        ctx.right);
  }

  @Override
  public String visitBinary_expr(Binary_exprContext ctx) {
    return visit(ctx.left) + " " + visitBinary_operator(ctx.binary_operator()) + " " + visit(
        ctx.right);
  }

  @Override
  public String visitOne_param_unary_expr(One_param_unary_exprContext ctx) {
    String result =
        "GeneratedUtils" + "." + ctx.unary_operator().getText() +
            ctx.SYMBOL_LPAREN().getText() + visit(ctx.expression()) + ctx.SYMBOL_RPAREN();

    return result;
  }

  @Override
  public String visitTwo_param_unary_expr(Two_param_unary_exprContext ctx) {
    String result =
        "GeneratedUtils" + "." + ctx.unary_operator().getText() + ctx
            .SYMBOL_LPAREN()
            .getText() + visit(
            ctx.left);

    result += ctx.SYMBOL_COMMA() + " ";
    result += visit(ctx.right);
    result += ctx.SYMBOL_RPAREN();

    return result;
  }

  @Override
  public String visitName_expr(Name_exprContext ctx) {
    return ctx.name().getText();
  }

  @Override
  public String visitNumber_expr(Number_exprContext ctx) {
    return ctx.number().getText() + "d";
  }

  @Override
  public String visitWord_expr(Word_exprContext ctx) {
    return ctx.word().getText();
  }

  @Override
  public String visitBoolean_operator(Boolean_operatorContext ctx) {
    if (ctx.KEYWORD_AND() != null && ctx.KEYWORD_OR() == null) {
      return "&&";
    } else {
      return "||";
    }
  }

  @Override
  public String visitBinary_operator(Binary_operatorContext ctx) {
    return ctx.getText();
  }

  @Override
  public String visitComparator(ComparatorContext ctx) {
    return ctx.getText();
  }

  private Boolean isReferenceOrName(ExpressionContext expression) {
    return expression.getClass().equals(Reference_exprContext.class) || expression.getClass()
        .equals(Name_exprContext.class);
  }
}
