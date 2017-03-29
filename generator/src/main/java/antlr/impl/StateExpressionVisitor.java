package antlr.impl;

import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.ReferenceContext;
import antlr.SMLParser.Set_init_exprContext;
import misc.Dimension;
import utils.InputProcessUtils;

public class StateExpressionVisitor extends ExpressionVisitor {

  @Override
  public String visitReference(ReferenceContext ctx) {
    if (ctx.normal_reference().matrix_reference() != null
        && ctx.normal_reference().attr_reference() == null) {

      Dimension dimension = InputProcessUtils
          .getDimensionsFromDimensionContext(
              ctx.normal_reference().matrix_reference().dimension());

      return "$attr" + ctx.normal_reference().matrix_reference().attr_reference().INT()
          .getText()
          + ":L.get("
          + dimension.getDimensionN() + ").get(" + dimension.getDimensionM() + ")";
    } else {
      return "$attr" + ctx.normal_reference().attr_reference().INT().getText() + ":L";
    }
  }


  @Override
  public String visitSet_init_expr(Set_init_exprContext ctx) {
    String result = "new $hash_set:T<>($arrays:T.asList(";

    for (ExpressionContext expression : ctx.expression()) {
      result += visit(expression);

      if (ctx.expression().indexOf(expression) < ctx.expression().size() - 1) {
        result += ", ";
      }
    }

    result += "))";
    return result;
  }
}
