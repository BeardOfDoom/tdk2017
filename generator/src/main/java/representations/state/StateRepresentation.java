package representations.state;

import java.util.ArrayList;
import java.util.List;
import representations.MatrixAssignRepresentation;
import representations.ParameterRepresentation;
import representations.SetAssignRepresentation;

public class StateRepresentation {

  private List<AttributeRepresentation> attributes = new ArrayList<>();
  private List<SetAssignRepresentation> setStarts = new ArrayList<>();
  private List<MatrixAssignRepresentation> matrixStarts = new ArrayList<>();
  private List<ParameterRepresentation> stateStartParameters = new ArrayList<>();
  private List<ParameterRepresentation> stateGoalParameters = new ArrayList<>();
  private String stateGoal;

  public StateRepresentation() {
  }

  public List<AttributeRepresentation> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributeRepresentation> attributes) {
    this.attributes = attributes;
  }

  public List<SetAssignRepresentation> getSetStarts() {
    return setStarts;
  }

  public void setSetStarts(List<SetAssignRepresentation> setStarts) {
    this.setStarts = setStarts;
  }

  public List<MatrixAssignRepresentation> getMatrixStarts() {
    return matrixStarts;
  }

  public void setMatrixStarts(List<MatrixAssignRepresentation> matrixStarts) {
    this.matrixStarts = matrixStarts;
  }

  public List<ParameterRepresentation> getStateStartParameters() {
    return stateStartParameters;
  }

  public void setStateStartParameters(
      List<ParameterRepresentation> stateStartParameters) {
    this.stateStartParameters = stateStartParameters;
  }

  public List<ParameterRepresentation> getStateGoalParameters() {
    return stateGoalParameters;
  }

  public void setStateGoalParameters(
      List<ParameterRepresentation> stateGoalParameters) {
    this.stateGoalParameters = stateGoalParameters;
  }

  public String getStateGoal() {
    return stateGoal;
  }

  public void setStateGoal(String stateGoal) {
    this.stateGoal = stateGoal;
  }

  public void addAttribute(AttributeRepresentation representation) {
    attributes.add(representation);
  }

  public void addSetStartLine(SetAssignRepresentation setStart) {
    setStarts.add(setStart);
  }

  public void addMatrixStartLine(MatrixAssignRepresentation matrixStart) {
    matrixStarts.add(matrixStart);
  }

  public void addStateStartParameter(ParameterRepresentation parameter) {
    stateStartParameters.add(parameter);
  }

  public void addStateGoalParameter(ParameterRepresentation parameter) {
    stateGoalParameters.add(parameter);
  }
}