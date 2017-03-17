package representation.state;

import java.util.ArrayList;
import java.util.List;
import representation.AssignExpressionsRepresentation;
import representation.ParameterRepresentation;

public class StateRepresentation {

  private String name;
  private List<AttributeRepresentation> attributes = new ArrayList<>();
  private AssignExpressionsRepresentation assigns;
  private List<ParameterRepresentation> stateStartParameters = new ArrayList<>();
  private List<ParameterRepresentation> stateGoalParameters = new ArrayList<>();
  private String stateGoal;

  public StateRepresentation() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AttributeRepresentation> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributeRepresentation> attributes) {
    this.attributes = attributes;
  }

  public AssignExpressionsRepresentation getAssigns() {
    return assigns;
  }

  public void setAssigns(AssignExpressionsRepresentation assigns) {
    this.assigns = assigns;
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

  public void addStateStartParameter(ParameterRepresentation parameter) {
    stateStartParameters.add(parameter);
  }

  public void addStateGoalParameter(ParameterRepresentation parameter) {
    stateGoalParameters.add(parameter);
  }
}