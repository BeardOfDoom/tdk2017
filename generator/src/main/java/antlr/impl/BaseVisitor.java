package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.Assign_expressionContext;
import antlr.SMLParser.ExprContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Operation_descriptionContext;
import antlr.SMLParser.Operator_effectContext;
import antlr.SMLParser.Operator_preconditionContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.SMLParser.State_descriptionContext;
import antlr.SMLParser.State_description_lineContext;
import antlr.SMLParser.State_goalContext;
import antlr.SMLParser.State_startContext;
import antlr.SMLParser.Var_defining_expressionContext;
import com.squareup.javapoet.ClassName;
import java.util.ArrayList;
import java.util.List;
import misc.Dimension;
import misc.ExpressionType;
import misc.VarStruct;
import misc.VarType;
import representation.AssignExpressionsRepresentation;
import representation.MatrixAssignRepresentation;
import representation.SetAssignRepresentation;
import representation.operator.OperatorRepresentation;
import representation.operator.VariableRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.CommonUtils;

public class BaseVisitor extends SMLBaseVisitor {

  //TODO: What should happen with integers

  private StateRepresentation stateRepresentation = new StateRepresentation();
  private OperatorRepresentation operatorRepresentation = new OperatorRepresentation();
  private List<OperatorRepresentation> operatorRepresentations = new ArrayList<>();

  private StateExpressionVisitor stateExpressionVisitor = new StateExpressionVisitor();
  private OperatorExpressionVisitor operatorExpressionVisitor = new OperatorExpressionVisitor();

  public StateRepresentation getStateRepresentation() {
    return stateRepresentation;
  }

  public List<OperatorRepresentation> getOperatorRepresentations() {
    return operatorRepresentations;
  }

  @Override
  public Object visitExpr(ExprContext ctx) {
    if (ctx.name_defining_expression() != null) {
      stateRepresentation.setName(ctx.name_defining_expression().name().getText());
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
    for (Parameter_description_lineContext parameter : ctx
        .parameter_description_line()) {
      stateRepresentation
          .addStateStartParameter(CommonUtils.getParameterRepresentationFromContext(parameter));
    }

    AssignExpressionsRepresentation assignRepresentation = getAssignFromContexts(
        ctx.assign_expression(), ExpressionType.STATE);

    stateRepresentation.setAssigns(assignRepresentation);

    return super.visitState_start(ctx);
  }

  @Override
  public Object visitState_goal(State_goalContext ctx) {
    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      stateRepresentation
          .addStateGoalParameter(CommonUtils.getParameterRepresentationFromContext(parameter));
    }

    stateRepresentation.setStateGoal(stateExpressionVisitor.visit(ctx));

    return super.visitState_goal(ctx);
  }

  @Override
  public Object visitOperation_description(Operation_descriptionContext ctx) {
    if (ctx.name_defining_expression() != null) {
      operatorRepresentation.setName(ctx.name_defining_expression().name().getText());
    } else {
      operatorRepresentation.setName("Operator" + (operatorRepresentations.size() + 1));
    }

    Double operatorCost =
        ctx.operator_cost() == null ? 1d
            : Double.parseDouble(ctx.operator_cost().number().getText());

    operatorRepresentation.setCost(operatorCost);

    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      operatorRepresentation
          .addParameter(CommonUtils.getParameterRepresentationFromContext(parameter));
    }

    return super.visitOperation_description(ctx);
  }

  @Override
  public Object visitOperator_precondition(Operator_preconditionContext ctx) {
    operatorRepresentation
        .setOperatorPrecondition(operatorExpressionVisitor.visit(ctx.expression()));
    return super.visitOperator_precondition(ctx);
  }

  @Override
  public Object visitOperator_effect(Operator_effectContext ctx) {
    List<VariableRepresentation> variables = new ArrayList<>();

    for (Var_defining_expressionContext variable : ctx.var_defining_expression()) {
      variables.add(getVarRepresentationFromContext(variable));
    }
    operatorRepresentation.setVariables(variables);

    AssignExpressionsRepresentation assignRepresentation = getAssignFromContexts(
        ctx.assign_expression(), ExpressionType.OPERATOR);

    operatorRepresentation.setAssigns(assignRepresentation);

    operatorRepresentations.add(operatorRepresentation);

    operatorRepresentation = new OperatorRepresentation();

    return super.visitOperator_effect(ctx);
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

  private VariableRepresentation getVarRepresentationFromContext(
      Var_defining_expressionContext variable) {

    String varName = variable.name().getText();
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

  private AssignExpressionsRepresentation getAssignFromContexts(
      List<Assign_expressionContext> expressions, ExpressionType type) {
    AssignExpressionsRepresentation result = new AssignExpressionsRepresentation();

    for (Assign_expressionContext currentLine : expressions) {
      if (currentLine.attr_reference() != null && currentLine.matrix_reference() == null) {
        SetAssignRepresentation setAssign = new SetAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            currentLine.attr_reference().getText());
        setAssign.setAttribute(attribute);

        for (ExpressionContext expression : currentLine.init_statement().expression()) {
          setAssign.addValue(getExpressionValue(expression, type));
        }
        result.addSetAssignment(setAssign);
      } else if (currentLine.attr_reference() == null && currentLine.matrix_reference() != null) {
        MatrixAssignRepresentation matrixStart = new MatrixAssignRepresentation();
        AttributeRepresentation attribute = getAttributeFromReference(
            currentLine.matrix_reference().attr_reference().getText());
        matrixStart.setAttribute(attribute);

        String dimensionN = CommonUtils
            .getDimensionsFromMatrixReferenceContext(currentLine.matrix_reference())
            .get(0);
        String dimensionM = CommonUtils
            .getDimensionsFromMatrixReferenceContext(currentLine.matrix_reference())
            .get(1);

        matrixStart.setDimensionN(dimensionN);
        matrixStart.setDimensionM(dimensionM);

        matrixStart.setValue(getExpressionValue(currentLine.expression(), type));

        result.addMatrixAssignment(matrixStart);
      }
    }

    return result;
  }

  private String getExpressionValue(ExpressionContext expression, ExpressionType type) {
    return type.equals(ExpressionType.STATE) ? stateExpressionVisitor.visit(expression)
        : operatorExpressionVisitor.visit(expression);
  }
}