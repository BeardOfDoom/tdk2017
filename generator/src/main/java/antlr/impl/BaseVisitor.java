package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.ExprContext;
import antlr.SMLParser.Operator_descriptionContext;
import antlr.SMLParser.Operator_effectContext;
import antlr.SMLParser.Operator_effect_lineContext;
import antlr.SMLParser.Operator_preconditionContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.SMLParser.State_descriptionContext;
import antlr.SMLParser.State_description_lineContext;
import antlr.SMLParser.State_goalContext;
import antlr.SMLParser.State_startContext;
import antlr.SMLParser.State_start_lineContext;
import antlr.SMLParser.Var_defining_expressionContext;
import enums.AssignType;
import enums.VarStruct;
import enums.VarType;
import java.util.ArrayList;
import java.util.List;
import misc.Dimension;
import representation.AssignRepresentation;
import representation.operator.OperatorRepresentation;
import representation.operator.VariableRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtils;
import utils.InputProcessUtils;

public class BaseVisitor extends SMLBaseVisitor {

  private StateRepresentation stateRepresentation = new StateRepresentation();
  private OperatorRepresentation operatorRepresentation = new OperatorRepresentation();
  private List<OperatorRepresentation> operatorRepresentations = new ArrayList<>();

  public StateRepresentation getStateRepresentation() {
    return stateRepresentation;
  }

  public List<OperatorRepresentation> getOperatorRepresentations() {
    return operatorRepresentations;
  }

  @Override
  public Object visitExpr(ExprContext ctx) {
    if (ctx.name_defining_expression() != null) {
      stateRepresentation.setName(ctx.name_defining_expression().word().getText());
    } else {
      stateRepresentation.setName("State");
    }

    return super.visitExpr(ctx);
  }

  @Override
  public Object visitState_description(State_descriptionContext ctx) {
    for (State_description_lineContext currentLine : ctx.state_description_line()) {
      String varName = currentLine.attr_name().getText();
      String varType = currentLine.attr_type().getText();

      // TODO: Handle error!
      if (isAvailableVariable(varName)) {
        if (currentLine.attr_struct().KEYWORD_MATRIX() != null) {

          Dimension dimension = InputProcessUtils
              .getDimensionsFromDimensionContext(currentLine.attr_struct().dimension());

          AttributeRepresentation attribute = new AttributeRepresentation(varName, VarStruct.MATRIX,
              VarType.valueOf(VarType.class, varType.toUpperCase()), dimension);

          stateRepresentation.addAttribute(attribute);
        } else {
          AttributeRepresentation attribute = new AttributeRepresentation(varName, VarStruct.SET,
              VarType.valueOf(VarType.class, varType.toUpperCase()));
          stateRepresentation.addAttribute(attribute);
        }
      }

      //TODO: Handle error
    }
    return super.visitState_description(ctx);
  }

  @Override
  public Object visitState_start(State_startContext ctx) {
    for (Parameter_description_lineContext parameter : ctx
        .parameter_description_line()) {
      stateRepresentation
          .addStateStartParameter(GeneratorUtils.getParameterRepresentationFromContext(parameter));
    }

    for (State_start_lineContext currentLine : ctx.state_start_line()) {
      stateRepresentation.addAssignStatement(getAssignRepresentationFromContext(currentLine));
    }

    return super.visitState_start(ctx);
  }

  @Override
  public Object visitState_goal(State_goalContext ctx) {
    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      stateRepresentation
          .addStateGoalParameter(GeneratorUtils.getParameterRepresentationFromContext(parameter));
    }

    stateRepresentation
        .setStateGoal(
            InputProcessUtils.getStateExpressionValue(ctx.expression()));

    return super.visitState_goal(ctx);
  }

  @Override
  public Object visitOperator_description(Operator_descriptionContext ctx) {
    if (ctx.name_defining_expression() != null) {
      operatorRepresentation.setName(ctx.name_defining_expression().word().getText());
    } else {
      operatorRepresentation.setName("Operator" + (operatorRepresentations.size() + 1));
    }

    Double operatorCost =
        ctx.operator_cost() == null ? 1d
            : Double.parseDouble(ctx.operator_cost().number().getText());

    operatorRepresentation.setCost(operatorCost);

    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      operatorRepresentation
          .addParameter(GeneratorUtils.getParameterRepresentationFromContext(parameter));
    }

    return super.visitOperator_description(ctx);
  }

  @Override
  public Object visitOperator_precondition(Operator_preconditionContext ctx) {
    if (ctx.expression() != null) {
      String operatorPrecondition = InputProcessUtils
          .getOperatorExpressionValue(ctx.expression());

      operatorRepresentation
          .setOperatorPrecondition(operatorPrecondition);
    }
    //TODO: Handle error

    return super.visitOperator_precondition(ctx);
  }

  @Override
  public Object visitOperator_effect(Operator_effectContext ctx) {
    List<VariableRepresentation> variables = new ArrayList<>();

    for (Var_defining_expressionContext variable : ctx.var_defining_expression()) {
      variables.add(InputProcessUtils
          .getVarRepresentationFromContext(variable));
    }
    operatorRepresentation.setVariables(variables);

    for (Operator_effect_lineContext currentLine : ctx.operator_effect_line()) {
      operatorRepresentation
          .addOperatorEffect(InputProcessUtils.getOperatorExpressionValue(currentLine));
    }

    operatorRepresentations.add(operatorRepresentation);

    operatorRepresentation = new OperatorRepresentation();

    return super.visitOperator_effect(ctx);
  }

  private boolean isAvailableVariable(String varName) {
    return stateRepresentation.getAttributes().stream()
        .noneMatch(attribute -> attribute.getAttributeName().equals(varName));
  }

  //TODO: Handle error
  public AttributeRepresentation getAttributeFromReference(String reference) {
    String attrName = "Attr" + reference.substring(1);

    for (AttributeRepresentation currentAttr : stateRepresentation.getAttributes()) {
      if (currentAttr.getAttributeName().equals(attrName)) {
        return currentAttr;
      }
    }
    return null;
  }

  public AssignRepresentation getAssignRepresentationFromContext(
      State_start_lineContext assignExpression) {
    AssignRepresentation assignStatement = new AssignRepresentation();

    if (assignExpression.attr_reference() != null && assignExpression.matrix_reference() == null) {

      AttributeRepresentation attribute = getAttributeFromReference(assignExpression.attr_reference().getText());
      assignStatement.setAttributeRepresentation(attribute);

      assignStatement.setType(AssignType.SET);
      assignStatement.setValue(InputProcessUtils.getStateExpressionValue(assignExpression.expression()));

    } else {
      assignStatement.setType(AssignType.MATRIX);
      AttributeRepresentation attribute = getAttributeFromReference(
          assignExpression.matrix_reference().attr_reference().getText());
      assignStatement.setAttributeRepresentation(attribute);

      Dimension dimension = InputProcessUtils.getDimensionsFromDimensionContext(
          assignExpression.matrix_reference().dimension());

      assignStatement.setDimension(dimension);

      assignStatement
          .setValue(InputProcessUtils
              .getStateExpressionValue(assignExpression.expression()));

    }

    return assignStatement;
  }
}