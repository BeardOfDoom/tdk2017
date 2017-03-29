package antlr.impl;

import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Normal_referenceContext;
import antlr.SMLParser.Operator_effect_lineContext;
import antlr.SMLParser.Parameterized_referenceContext;
import antlr.SMLParser.ReferenceContext;
import antlr.SMLParser.Set_init_exprContext;
import misc.Dimension;
import utils.InputProcessUtils;

public class OperatorExpressionVisitor extends ExpressionVisitor {

  // TODO: Review this class some of the return methods almost identical possible refactor with method extract

  @Override
  public String visitReference(ReferenceContext ctx) {
    if (ctx.normal_reference() != null
        && ctx.parameterized_reference() == null) {

      Normal_referenceContext reference = ctx.normal_reference();

      if (reference.matrix_reference() != null && reference.attr_reference() == null) {

        Dimension dimension = InputProcessUtils
            .getDimensionsFromDimensionContext(reference.matrix_reference().dimension());

        return "original.getAttr" + reference.matrix_reference().attr_reference().INT().getText()
            + "().get("
            + dimension.getDimensionM() + ").get(" + dimension.getDimensionM() + ")";
      } else {
        return "original.getAttr" + reference.attr_reference().INT()
            .getText() + "()";
      }
    } else {
      Parameterized_referenceContext reference = ctx.parameterized_reference();

      if (reference.parameterized_attr_reference() != null
          && reference.parameterized_matrix_reference() == null) {

        String parameterName = reference.parameterized_attr_reference().PARAM_NAME().getText();
        return "(($" + parameterName + ":T) original.getAttributeByNumber(" + parameterName + "))";

      } else {

        String parameterName = reference.parameterized_attr_reference().PARAM_NAME().getText();
        Dimension dimension = InputProcessUtils
            .getDimensionsFromDimensionContext(
                reference.parameterized_matrix_reference().dimension());

        return "(($" + parameterName + ":T) original.getAttributeByNumber(" + parameterName + "))"
            + ".get("
            + dimension.getDimensionM() + ").get(" + dimension.getDimensionM() + ")";
      }
    }
  }

  @Override
  public String visitOperator_effect_line(Operator_effect_lineContext ctx) {

    if (ctx.reference().parameterized_reference() != null
        && ctx.reference().normal_reference() == null) {
      Parameterized_referenceContext reference = ctx.reference().parameterized_reference();

      if (reference.parameterized_attr_reference() != null
          && reference.parameterized_matrix_reference() == null) {
        String attributeName = reference.parameterized_attr_reference().PARAM_NAME()
            .getText();

        return "state.setAttributeByNumber(" + attributeName + ", " + visit(ctx.expression()) + ")";
      } else {
        String attributeName = reference.parameterized_matrix_reference()
            .parameterized_attr_reference().PARAM_NAME().getText();

        Dimension dimension = InputProcessUtils
            .getDimensionsFromDimensionContext(
                reference.parameterized_matrix_reference().dimension());

        return "(($" + attributeName + ":T) original.getAttributeByNumber(" + attributeName + "))"
            + ".get("
            + dimension.getDimensionM() + ").set(" + dimension.getDimensionM() + ")";
      }
    } else {
      Normal_referenceContext reference = ctx.reference().normal_reference();

      if (reference.attr_reference() != null && reference.matrix_reference() == null) {
        return "original.setAttr" + reference.attr_reference().INT() + "(" + InputProcessUtils
            .getOperatorExpressionValue(ctx.expression()) + ")";
      } else {
        Dimension dimension = InputProcessUtils
            .getDimensionsFromDimensionContext(reference.matrix_reference().dimension());

        return "original.getAttr" + reference.matrix_reference().attr_reference().INT() + "().get("
            + dimension.getDimensionN() + ").set(" + dimension.getDimensionM() + ", "
            + InputProcessUtils.getOperatorExpressionValue(ctx.expression()) + ")";

      }
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
