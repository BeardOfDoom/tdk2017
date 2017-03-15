package representations;

import representations.state.AttributeRepresentation;

public class MatrixAssignRepresentation {

  private AttributeRepresentation attribute;
  private String dimensionN;
  private String dimensionM;
  private String value;

  public MatrixAssignRepresentation() {
  }

  public AttributeRepresentation getAttribute() {
    return attribute;
  }

  public void setAttribute(AttributeRepresentation attribute) {
    this.attribute = attribute;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDimensionN() {
    return dimensionN;
  }

  public void setDimensionN(String dimensionN) {
    this.dimensionN = dimensionN;
  }

  public String getDimensionM() {
    return dimensionM;
  }

  public void setDimensionM(String dimensionM) {
    this.dimensionM = dimensionM;
  }
}
