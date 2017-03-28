package antlr.impl;

import antlr.SMLParser.ReferenceContext;
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
}
