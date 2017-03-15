package antlr;

import antlr.generated.SMLBaseVisitor;
import antlr.generated.SMLParser;
import antlr.generated.SMLParser.Assigning_expressionContext;
import antlr.generated.SMLParser.Dimension_partContext;
import antlr.generated.SMLParser.ExpressionContext;
import antlr.generated.SMLParser.Matrix_referenceContext;
import antlr.generated.SMLParser.Operation_descriptionContext;
import antlr.generated.SMLParser.Operator_effectContext;
import antlr.generated.SMLParser.Operator_preconditionContext;
import antlr.generated.SMLParser.Parameter_description_lineContext;
import antlr.generated.SMLParser.State_descriptionContext;
import antlr.generated.SMLParser.State_goalContext;
import antlr.generated.SMLParser.State_startContext;
import antlr.generated.SMLParser.State_start_lineContext;
import antlr.generated.SMLParser.Var_defining_expressionContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import misc.Dimension;
import misc.VarStruct;
import misc.VarType;
import representations.MatrixAssignRepresentation;
import representations.ParameterRepresentation;
import representations.SetAssignRepresentation;
import representations.operator.OperatorRepresentation;
import representations.operator.VariableRepresentation;
import representations.state.AttributeRepresentation;
import representations.state.StateRepresentation;

public class Visitor extends SMLBaseVisitor {

  //TODO: What should happen with integers

  private ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  private StateRepresentation stateRepresentation = new StateRepresentation();
  private OperatorRepresentation operatorRepresentation = new OperatorRepresentation();

  public StateRepresentation getStateRepresentation() {
    return stateRepresentation;
  }

  public OperatorRepresentation getOperatorRepresentation() {
    return operatorRepresentation;
  }

  @Override
  public Object visitState_description(State_descriptionContext ctx) {
    for (SMLParser.State_description_lineContext currentLine : ctx.state_description_line()) {
      String varName = currentLine.attr_name().getText();
      String varType = currentLine.attr_type().getText();

      // TODO: Handle error!
      if (isAvailableVariable(varName)) {
        if (currentLine.attr_struct().KEYWORD_MATRIX() != null) {
          Integer n = Integer
              .parseInt(currentLine.attr_struct().dimension().dimension_part(0).INT().getText());
          Integer m = Integer
              .parseInt(currentLine.attr_struct().dimension().dimension_part(1).INT().getText());
          AttributeRepresentation attribute = new AttributeRepresentation(varName, VarStruct.MATRIX,
              VarType.valueOf(VarType.class, varType.toUpperCase()), new Dimension(n, m));
          stateRepresentation.addAttribute(attribute);
        } else {
          AttributeRepresentation attribute = new AttributeRepresentation(varName, VarStruct.SET,
              VarType.valueOf(VarType.class, varType.toUpperCase()));
          stateRepresentation.addAttribute(attribute);
        }
      }
    }
    return super.visitState_description(ctx);
  }

  @Override
  public Object visitState_start(State_startContext ctx) {
    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      stateRepresentation.addStateStartParameter(getParameterRepresentationFromContext(parameter));
    }

    for (State_start_lineContext currentLine : ctx.state_start_line()) {
      if (currentLine.attr_reference() != null && currentLine.matrix_reference() == null) {
        SetAssignRepresentation setStart = new SetAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            currentLine.attr_reference().getText());
        setStart.setAttribute(attribute);

        for (ExpressionContext expression : currentLine.init_statement().expression()) {
          setStart.addValue(expression.getText());
        }
        stateRepresentation.addSetStartLine(setStart);
      } else if (currentLine.attr_reference() == null && currentLine.matrix_reference() != null) {
        MatrixAssignRepresentation matrixStart = new MatrixAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            currentLine.matrix_reference().attr_reference().getText());
        matrixStart.setAttribute(attribute);

        String dimensionN = getDimensionsFromMatrixReferenceContext(currentLine.matrix_reference())
            .get(0);
        String dimensionM = getDimensionsFromMatrixReferenceContext(currentLine.matrix_reference())
            .get(1);

        matrixStart.setDimensionN(dimensionN);
        matrixStart.setDimensionM(dimensionM);

        String value = resolveStateExpression(currentLine.expression().getText());

        matrixStart.setValue(value);

        stateRepresentation.addMatrixStartLine(matrixStart);
      }
    }
    return super.visitState_start(ctx);
  }

  @Override
  public Object visitState_goal(State_goalContext ctx) {
    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      stateRepresentation.addStateGoalParameter(getParameterRepresentationFromContext(parameter));
    }
    stateRepresentation.setStateGoal(resolveStateExpression(ctx.boolean_expression().getText()));
    return super.visitState_goal(ctx);
  }

  @Override
  public Object visitOperation_description(Operation_descriptionContext ctx) {
    Double operatorCost =
        ctx.operator_cost() == null ? 1d
            : Double.parseDouble(ctx.operator_cost().number().getText());

    operatorRepresentation.setCost(operatorCost);

    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      operatorRepresentation.addParameter(getParameterRepresentationFromContext(parameter));
    }

    return super.visitOperation_description(ctx);
  }

  @Override
  public Object visitOperator_precondition(Operator_preconditionContext ctx) {
    operatorRepresentation
        .setOperatorPrecondition(expressionVisitor.visit(ctx.boolean_expression()));
    return super.visitOperator_precondition(ctx);
  }

  @Override
  public Object visitOperator_effect(Operator_effectContext ctx) {
    List<VariableRepresentation> variables = new ArrayList<>();

    for (Var_defining_expressionContext variable : ctx.var_defining_expression()) {
      variables.add(getVarRepresentationFromContext(variable));
    }

    for (Assigning_expressionContext expression : ctx.assigning_expression()) {
      if (expression.reference().attr_reference() != null
          && expression.reference().matrix_reference() == null) {
        SetAssignRepresentation setEffect = new SetAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            expression.reference().attr_reference().getText());
        String value = expression.expression().getText();

        setEffect.setAttribute(attribute);
        setEffect.addValue(value);
        operatorRepresentation.addSetEffect(setEffect);
      } else if (expression.reference().attr_reference() == null
          && expression.reference().matrix_reference() != null) {
        MatrixAssignRepresentation matrixEffect = new MatrixAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            expression.reference().matrix_reference().getText());

        String dimensionN = getDimensionsFromMatrixReferenceContext(
            expression.reference().matrix_reference())
            .get(0);
        String dimensionM = getDimensionsFromMatrixReferenceContext(
            expression.reference().matrix_reference())
            .get(1);

      } else {
        //TODO: Handle error
      }
    }

    return super.visitOperator_effect(ctx);
  }

  private ParameterRepresentation getParameterRepresentationFromContext(
      Parameter_description_lineContext parameter) {

    String paramName = parameter.name().getText();
    Integer from = Integer.parseInt(parameter.INT(0).getText());
    Integer to = Integer.parseInt(parameter.INT(1).getText());
    Integer by = parameter.INT(2) == null ? 1 : Integer.parseInt(parameter.INT(2).getText());

    ParameterRepresentation parameterRepresentation = new ParameterRepresentation();
    parameterRepresentation.setParameterName(paramName);
    parameterRepresentation.setFrom(from);
    parameterRepresentation.setTo(to);
    parameterRepresentation.setBy(by);

    return parameterRepresentation;
  }

  private VariableRepresentation getVarRepresentationFromContext(
      Var_defining_expressionContext variable) {

    String varName = variable.name().getText();
    VarType varType = VarType.valueOf(VarType.class, variable.attr_type().getText().toUpperCase());
    String value = variable.expression().getText();

    VariableRepresentation variableRepresentation = new VariableRepresentation();
    variableRepresentation.setName(varName);
    variableRepresentation.setVarType(varType);
    variableRepresentation.setValue(value);

    return variableRepresentation;
  }

  private List<String> getDimensionsFromMatrixReferenceContext(Matrix_referenceContext matrix) {
    Dimension_partContext dimensionPartN = matrix.dimension()
        .dimension_part(0);
    Dimension_partContext dimensionPartM = matrix.dimension()
        .dimension_part(1);

    String dimensionN =
        dimensionPartN.INT() != null ? dimensionPartN.INT().getText()
            : dimensionPartN.name().getText();

    String dimensionM =
        dimensionPartM.INT() != null ? dimensionPartM.INT().getText()
            : dimensionPartM.name().getText();

    return Arrays.asList(dimensionN, dimensionM);
  }

  private boolean isAvailableVariable(String varName) {
    return stateRepresentation.getAttributes().stream()
        .noneMatch(attribute -> attribute.getAttributeName().equals(varName));
  }

  //TODO: Handle error
  private AttributeRepresentation getAttributeFromReference(String reference) {
    String attrName = "Attr" + reference.substring(1);

    for (AttributeRepresentation currentAttr : stateRepresentation.getAttributes()) {
      if (currentAttr.getAttributeName().equals(attrName)) {
        return currentAttr;
      }
    }
    return null;
  }

  //TODO: Implement method
  private String resolveStateExpression(String expression) {
    String result = expression
        .replace("and", " && ")
        .replace("or", " || ")
        .replace("not", " !")
        .replace("$", "attr")
        .replace("[", ".get(")
        .replace("]", ")")
        .replace("==", " == ")
        .replace("<=", " <= ")
        .replace(">=", " >= ")
        .replace("!=", " != ");

    return result;
  }

}