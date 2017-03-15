package antlr;

import antlr.SMLParser.Boolean_expressionContext;
import antlr.SMLParser.Comparing_expressionContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Expression_unitContext;
import antlr.SMLParser.NameContext;

public class ExpressionVisitor extends SMLBaseVisitor<String> {

  @Override
  public String visitName(NameContext ctx) {
    return "[%param% " + ctx.getText() + "]";
  }

  @Override
  public String visitBoolean_expression(Boolean_expressionContext ctx) {
    String result = ctx.KEYWORD_NOT() != null ? "!(" : "";

    return null;
  }

  @Override
  public String visitComparing_expression(Comparing_expressionContext ctx) {
    return visitExpression(ctx.expression(0)) + ctx.comparator().getText() + visitExpression(
        ctx.expression(1));
  }

  @Override
  public String visitExpression(ExpressionContext ctx) {
    if (ctx.expression_unit() != null) {
      return visitExpression_unit(ctx.expression_unit());
    } else if (ctx.unary_expression() != null) {
      return visitUnary_expression(ctx.unary_expression());
    } else {
      return visitBinary_expression(ctx.binary_expression());
    }
  }

  @Override
  public String visitExpression_unit(Expression_unitContext ctx) {
    if (ctx.unary_expression() != null) {
      return visitUnary_expression(ctx.unary_expression());
    } else if (ctx.reference() != null) {
      return visitReference(ctx.reference());
    } else if (ctx.name() != null) {
      return visitName(ctx.name());
    } else if (ctx.number() != null) {
      return visitNumber(ctx.number());
    } else {
      return visitWord(ctx.word());
    }
  }
}
