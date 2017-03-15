package representations.operator;

import misc.VarType;

public class VariableRepresentation {

  VarType varType;
  String name;
  String value;

  public VarType getVarType() {
    return varType;
  }

  public void setVarType(VarType varType) {
    this.varType = varType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    VariableRepresentation that = (VariableRepresentation) o;

    if (varType != that.varType) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = varType != null ? varType.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "VariableRepresentation{" +
        "varType=" + varType +
        ", name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
