package representation.state;

import java.util.ArrayList;
import java.util.List;
import representation.AssignRepresentation;
import representation.ParameterRepresentation;

public class StateRepresentation {

  private String name;
  private List<AttributeRepresentation> attributes = new ArrayList<>();
  private List<ParameterRepresentation> stateStartParameters = new ArrayList<>();
  private List<ParameterRepresentation> stateGoalParameters = new ArrayList<>();
  private List<AssignRepresentation> assignRepresentations = new ArrayList<>();
  private String stateGoal;

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

  public List<AssignRepresentation> getAssignRepresentations() {
    return assignRepresentations;
  }

  public void setAssignRepresentations(
      List<AssignRepresentation> assignRepresentations) {
    this.assignRepresentations = assignRepresentations;
  }

  public String getStateGoal() {
    return stateGoal;
  }

  public void setStateGoal(String stateGoal) {
    this.stateGoal = stateGoal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    StateRepresentation that = (StateRepresentation) o;

    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (attributes != null ? !attributes.equals(that.attributes) : that.attributes != null) {
      return false;
    }
    if (stateStartParameters != null ? !stateStartParameters.equals(that.stateStartParameters)
        : that.stateStartParameters != null) {
      return false;
    }
    if (stateGoalParameters != null ? !stateGoalParameters.equals(that.stateGoalParameters)
        : that.stateGoalParameters != null) {
      return false;
    }
    if (assignRepresentations != null ? !assignRepresentations.equals(that.assignRepresentations)
        : that.assignRepresentations != null) {
      return false;
    }
    return stateGoal != null ? stateGoal.equals(that.stateGoal) : that.stateGoal == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
    result = 31 * result + (stateStartParameters != null ? stateStartParameters.hashCode() : 0);
    result = 31 * result + (stateGoalParameters != null ? stateGoalParameters.hashCode() : 0);
    result = 31 * result + (assignRepresentations != null ? assignRepresentations.hashCode() : 0);
    result = 31 * result + (stateGoal != null ? stateGoal.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "StateRepresentation{" +
        "name='" + name + '\'' +
        ", attributes=" + attributes +
        ", stateStartParameters=" + stateStartParameters +
        ", stateGoalParameters=" + stateGoalParameters +
        ", assignRepresentations=" + assignRepresentations +
        ", stateGoal='" + stateGoal + '\'' +
        '}';
  }

  public void addAttribute(AttributeRepresentation attribute){
    attributes.add(attribute);
  }

  public void addStateStartParameter(ParameterRepresentation parameter){
    stateStartParameters.add(parameter);
  }

  public void addStateGoalParameter(ParameterRepresentation parameter){
    stateGoalParameters.add(parameter);
  }

  public void addAssignStatement(AssignRepresentation assignStatement){
    assignRepresentations.add(assignStatement);
  }
}