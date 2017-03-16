package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.Binary_exprContext;
import antlr.SMLParser.Binary_operatorContext;
import antlr.SMLParser.Bool_exprContext;
import antlr.SMLParser.Boolean_operatorContext;
import antlr.SMLParser.ComparatorContext;
import antlr.SMLParser.Compare_exprContext;
import antlr.SMLParser.Name_exprContext;
import antlr.SMLParser.Number_exprContext;
import antlr.SMLParser.Paren_exprContext;
import antlr.SMLParser.Reference_exprContext;
import antlr.SMLParser.Unary_exprContext;
import antlr.SMLParser.Word_exprContext;
import utils.CommonUtils;

public class StateExpressionVisitor extends SMLBaseVisitor<String> {

  @Override
  public String visitParen_expr(Paren_exprContext ctx) {
    return ctx.SYMBOL_LPAREN().getText() + visit(ctx.expression()) + ctx.SYMBOL_RPAREN().getText();
  }

  @Override
  public String visitCompare_expr(Compare_exprContext ctx) {
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
  public String visitUnary_expr(Unary_exprContext ctx) {
    String result =
        "GeneratedUtils." + ctx.unary_operator().getText() + ctx.SYMBOL_LPAREN().getText() + visit(
            ctx.left);

    if (ctx.right != null) {
      result += ctx.SYMBOL_COMMA() + " ";
      result += visit(ctx.right);
    }

    result += ctx.SYMBOL_RPAREN();

    return result;
  }

  @Override
  public String visitReference_expr(Reference_exprContext ctx) {
    if (ctx.reference().matrix_reference() != null && ctx.reference().attr_reference() == null) {
      String dimensionN = CommonUtils
          .getDimensionsFromMatrixReferenceContext(ctx.reference().matrix_reference()).get(0);
      String dimensionM = CommonUtils
          .getDimensionsFromMatrixReferenceContext(ctx.reference().matrix_reference()).get(1);

      return "attr" + ctx.reference().matrix_reference().attr_reference().INT().getText() + ".get("
          + dimensionN + ").get(" + dimensionM + ")";
    } else {
      return "attr" + ctx.reference().attr_reference().INT().getText();
    }
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
  public String visitComparator(ComparatorContext ctx) {
    return ctx.getText();
  }

  @Override
  public String visitBinary_operator(Binary_operatorContext ctx) {
    return ctx.getText();
  }
}
