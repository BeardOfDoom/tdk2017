package representation;

import java.util.ArrayList;
import java.util.List;
import representation.state.AttributeRepresentation;

public class SetAssignRepresentation {

  AttributeRepresentation attribute = new AttributeRepresentation();
  List<String> values = new ArrayList<>();

  public SetAssignRepresentation() {
  }

  public AttributeRepresentation getAttribute() {
    return attribute;
  }

  public void setAttribute(AttributeRepresentation attribute) {
    this.attribute = attribute;
  }

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SetAssignRepresentation that = (SetAssignRepresentation) o;

    if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) {
      return false;
    }
    return values != null ? values.equals(that.values) : that.values == null;
  }

  @Override
  public int hashCode() {
    int result = attribute != null ? attribute.hashCode() : 0;
    result = 31 * result + (values != null ? values.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SetAssignRepresentation{" +
        "attribute=" + attribute +
        ", values=" + values +
        '}';
  }

  public void addValue(String value) {
    values.add(value);
  }

}


