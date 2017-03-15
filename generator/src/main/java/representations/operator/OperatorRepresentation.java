package representations.operator;

import java.util.ArrayList;
import java.util.List;
import representations.MatrixAssignRepresentation;
import representations.ParameterRepresentation;
import representations.SetAssignRepresentation;


public class OperatorRepresentation {

  Double cost;
  String operatorPrecondition;
  List<ParameterRepresentation> parameters = new ArrayList<>();
  List<VariableRepresentation> variables = new ArrayList<>();
  List<MatrixAssignRepresentation> matrixEffects = new ArrayList<>();
  List<SetAssignRepresentation> setEffects = new ArrayList<>();

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

  public List<MatrixAssignRepresentation> getMatrixEffects() {
    return matrixEffects;
  }

  public void setMatrixEffects(
      List<MatrixAssignRepresentation> matrixEffects) {
    this.matrixEffects = matrixEffects;
  }

  public List<SetAssignRepresentation> getSetEffects() {
    return setEffects;
  }

  public void setSetEffects(List<SetAssignRepresentation> setEffects) {
    this.setEffects = setEffects;
  }

  public void addParameter(ParameterRepresentation parameter) {
    parameters.add(parameter);
  }

  public void addVariable(VariableRepresentation variable) {
    variables.add(variable);
  }

  public void addMatrixEffect(MatrixAssignRepresentation matrixEffect) {
    matrixEffects.add(matrixEffect);
  }

  public void addSetEffect(SetAssignRepresentation setEffect) {
    setEffects.add(setEffect);
  }
}