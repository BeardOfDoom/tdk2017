package representation;

import enums.AssignType;
import misc.Dimension;
import representation.state.AttributeRepresentation;

public class AssignRepresentation {

  AttributeRepresentation attributeRepresentation;
  AssignType type;
  Dimension dimension;
  String value;

  public AssignRepresentation() {
  }

  public AttributeRepresentation getAttributeRepresentation() {
    return attributeRepresentation;
  }

  public void setAttributeRepresentation(
      AttributeRepresentation attributeRepresentation) {
    this.attributeRepresentation = attributeRepresentation;
  }

  public AssignType getType() {
    return type;
  }

  public void setType(AssignType type) {
    this.type = type;
  }

  public Dimension getDimension() {
    return dimension;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
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

    AssignRepresentation that = (AssignRepresentation) o;

    if (attributeRepresentation != null ? !attributeRepresentation
        .equals(that.attributeRepresentation) : that.attributeRepresentation != null) {
      return false;
    }
    if (type != that.type) {
      return false;
    }
    if (dimension != null ? !dimension.equals(that.dimension) : that.dimension != null) {
      return false;
    }
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = attributeRepresentation != null ? attributeRepresentation.hashCode() : 0;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AssignRepresentation{" +
        "attributeRepresentation=" + attributeRepresentation +
        ", type=" + type +
        ", dimension=" + dimension +
        ", value='" + value + '\'' +
        '}';
  }
}
