package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class Operator implements OperatorInterface {

  public static final List<Operator> OPERATORS = new ArrayList<>();

  static {
    for (int i = 0; i <= 2; i += 1) {
      for (int j = 0; j <= 2; j += 1) {
        Operator operator = new Operator(i, j);
        OPERATORS.add(operator);
      }
    }
  }

  private Integer i;

  private Integer j;

  public Operator() {
  }

  public Operator(Integer i, Integer j) {
    this.i = i;
    this.j = j;
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
  public boolean isApplicable(StateInterface state) {
    return true;
  }

  @Override
  public StateInterface apply(StateInterface state) {
    State result = new State();
    result.setAttr1(((State) state).getAttr1());
    result.setAttr2(((State) state).getAttr2());

    Double beer = Math.min(((State) state).getAttr1().get(0).get(i),
        ((State) state).getAttr2().get(0).get(j) - ((State) state).getAttr1().get(0).get(j));

    result.getAttr1().get(0).set(i, ((State) state).getAttr1().get(0).get(i) - beer);
    result.getAttr1().get(0).set(j, ((State) state).getAttr1().get(0).get(j) + beer);

    return result;
  }
}

