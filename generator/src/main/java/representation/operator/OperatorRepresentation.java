package representation.operator;

import java.util.ArrayList;
import java.util.List;
import representation.AssignExpressionsRepresentation;
import representation.ParameterRepresentation;


public class OperatorRepresentation {

  String name;
  Double cost;
  String operatorPrecondition;
  List<ParameterRepresentation> parameters = new ArrayList<>();
  List<VariableRepresentation> variables = new ArrayList<>();
  AssignExpressionsRepresentation assigns;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public List<ParameterRepresentation> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterRepresentation> parameters) {
    this.parameters = parameters;
  }

  public String getOperatorPrecondition() {
    return operatorPrecondition;
  }

  public void setOperatorPrecondition(String operatorPrecondition) {
    this.operatorPrecondition = operatorPrecondition;
  }

  public List<VariableRepresentation> getVariables() {
    return variables;
  }

  public void setVariables(List<VariableRepresentation> variables) {
    this.variables = variables;
  }

  public AssignExpressionsRepresentation getAssigns() {
    return assigns;
  }

  public void setAssigns(AssignExpressionsRepresentation assigns) {
    this.assigns = assigns;
  }

  public void addParameter(ParameterRepresentation parameter) {
    parameters.add(parameter);
  }

  public void addVariable(VariableRepresentation variable) {
    variables.add(variable);
  }
}