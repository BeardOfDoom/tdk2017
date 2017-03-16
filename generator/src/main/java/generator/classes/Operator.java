package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class Operator implements OperatorInterface {

  private Integer i;

  private Integer j;

  private Double cost = 1.0;

  public Operator() {
  }

  public Operator(Integer i, Integer j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public void initOperators() {
    for (int i = 0; i <= 2; i += 1) {
      for (int j = 0; j <= 2; j += 1) {
        Operator operator = new Operator(i, j);
        OPERATORS.add(operator);
      }
    }
  }

  public Integer getI() {
    return i;
  }

  public void setI(Integer i) {
    this.i = i;
  }

  public Integer getJ() {
    return j;
  }

  public void setJ(Integer j) {
    this.j = j;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Operator operator = (Operator) o;

    if (i != null ? !i.equals(operator.i) : operator.i != null) {
      return false;
    }
    return j != null ? j.equals(operator.j) : operator.j == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    result = 31 * result + (j != null ? j.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Operator{" +
        "i=" + i +
        ", j=" + j +
        "}";
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    State original = ((State) stateObject);
    return i != j && original.getAttr1().get(0).get(i) != 0d
        && original.getAttr1().get(0).get(j) != original.getAttr2().get(0).get(j);
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    Double beer = GeneratedUtils.min(original.getAttr1().get(0).get(i),
        original.getAttr2().get(0).get(j) - original.getAttr1().get(0).get(j));

    state.getAttr1().get(0).set(i, original.getAttr1().get(0).get(i) - beer);
    state.getAttr1().get(0).set(j, original.getAttr1().get(0).get(j) + beer);
    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}