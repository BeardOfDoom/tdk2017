package antlr.impl;

import antlr.SMLParser.Reference_exprContext;
import utils.CommonUtils;

public class StateExpressionVisitor extends ExpressionVisitor {
  
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
}
