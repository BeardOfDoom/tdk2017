package representation.operator;

import com.squareup.javapoet.ClassName;

public class VariableRepresentation {

  ClassName className;
  String name;
  String value;

  public ClassName getClassName() {
    return className;
  }

  public void setClassName(ClassName className) {
    this.className = className;
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

    if (className != null ? !className.equals(that.className) : that.className != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = className != null ? className.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "VariableRepresentation{" +
        "className=" + className +
        ", name='" + name + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
