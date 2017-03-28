package representation.operator;

import java.util.ArrayList;
import java.util.List;
import representation.ParameterRepresentation;


public class OperatorRepresentation {

  String name;
  Double cost;
  String operatorPrecondition;
  List<String> operatorEffects = new ArrayList<>();
  List<ParameterRepresentation> parameters = new ArrayList<>();
  List<VariableRepresentation> variables = new ArrayList<>();

  public OperatorRepresentation() {
  }

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

  public String getOperatorPrecondition() {
    return operatorPrecondition;
  }

  public void setOperatorPrecondition(String operatorPrecondition) {
    this.operatorPrecondition = operatorPrecondition;
  }

  public List<String> getOperatorEffects() {
    return operatorEffects;
  }

  public void setOperatorEffects(List<String> operatorEffects) {
    this.operatorEffects = operatorEffects;
  }

  public List<ParameterRepresentation> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterRepresentation> parameters) {
    this.parameters = parameters;
  }

  public List<VariableRepresentation> getVariables() {
    return variables;
  }

  public void setVariables(List<VariableRepresentation> variables) {
    this.variables = variables;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OperatorRepresentation that = (OperatorRepresentation) o;

    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (cost != null ? !cost.equals(that.cost) : that.cost != null) {
      return false;
    }
    if (operatorPrecondition != null ? !operatorPrecondition.equals(that.operatorPrecondition)
        : that.operatorPrecondition != null) {
      return false;
    }
    if (operatorEffects != null ? !operatorEffects.equals(that.operatorEffects)
        : that.operatorEffects != null) {
      return false;
    }
    if (parameters != null ? !parameters.equals(that.parameters) : that.parameters != null) {
      return false;
    }
    return variables != null ? variables.equals(that.variables) : that.variables == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (cost != null ? cost.hashCode() : 0);
    result = 31 * result + (operatorPrecondition != null ? operatorPrecondition.hashCode() : 0);
    result = 31 * result + (operatorEffects != null ? operatorEffects.hashCode() : 0);
    result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
    result = 31 * result + (variables != null ? variables.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OperatorRepresentation{" +
        "name='" + name + '\'' +
        ", cost=" + cost +
        ", operatorPrecondition='" + operatorPrecondition + '\'' +
        ", operatorEffects=" + operatorEffects +
        ", parameters=" + parameters +
        ", variables=" + variables +
        '}';
  }

  public void addParameter(ParameterRepresentation parameter) {
    parameters.add(parameter);
  }

  public void addVariable(VariableRepresentation variable) {
    variables.add(variable);
  }

  public void addOperatorEffect(String operatorEffectStatement) {
    operatorEffects.add(operatorEffectStatement);
  }
}