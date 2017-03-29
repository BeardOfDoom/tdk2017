package utils;

import antlr.SMLParser.DimensionContext;
import antlr.SMLParser.Var_defining_expressionContext;
import antlr.impl.OperatorExpressionVisitor;
import antlr.impl.StateExpressionVisitor;
import com.squareup.javapoet.ClassName;
import misc.Dimension;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.math.NumberUtils;
import representation.operator.VariableRepresentation;

public final class InputProcessUtils {

  private static StateExpressionVisitor stateExpressionVisitor = new StateExpressionVisitor();
  private static OperatorExpressionVisitor operatorExpressionVisitor = new OperatorExpressionVisitor();

  private InputProcessUtils() {
  }

  public static VariableRepresentation getVarRepresentationFromContext(
      Var_defining_expressionContext variable) {

    String varName = variable.PARAM_NAME().getText();
    ClassName className =
        variable.attr_type().KEYWORD_NUMBER() != null ? ClassName.get(Double.class)
            : ClassName.get(String.class);
    String value = operatorExpressionVisitor.visit(variable.expression());

    VariableRepresentation variableRepresentation = new VariableRepresentation();
    variableRepresentation.setName(varName);
    variableRepresentation.setClassName(className);
    variableRepresentation.setValue(value);

    return variableRepresentation;
  }

  public static Dimension getDimensionsFromDimensionContext(
      DimensionContext dimension) {

    String dimensionN = getStateExpressionValue(dimension.dimensionN);
    dimensionN = NumberUtils.isCreatable(dimensionN) ? "Double.valueOf(" + dimensionN + ").intValue()" : dimensionN;

    String dimensionM = getStateExpressionValue(dimension.dimensionM);
    dimensionM = NumberUtils.isCreatable(dimensionM) ? "Double.valueOf(" + dimensionM + ").intValue()" : dimensionM;

    return new Dimension(dimensionN, dimensionM);
  }

  public static String getStateExpressionValue(ParseTree tree) {
    return stateExpressionVisitor.visit(tree);
  }

  public static String getOperatorExpressionValue(ParseTree tree) {
    return operatorExpressionVisitor.visit(tree);
  }
}

