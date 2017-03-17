package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class Operator2 implements OperatorInterface {
  private Integer i;

  private Double cost = 10.0;

  public Operator2() {
  }

  public Operator2(Integer i) {
    this.i = i;
  }

  @Override
  public void initOperators() {
    for(int i = 0; i <= 2; i += 1) {
      Operator2 operator2 = new Operator2(i);
      OPERATORS.add(operator2);
    }
  }

  public Integer getI() {
    return i;
  }

  public void setI(Integer i) {
    this.i = i;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Operator2 operator2 = (Operator2) o;

    return i != null ? i.equals(operator2.i) : operator2.i == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    return result;
  }

  @Override
  public String toString() {
    return "Operator2{" +
    	"i=" + i +
    	"}";
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    State original = ((State) stateObject);
    return original.getAttr1().get(0).get(i) != 0d;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();


    state.getAttr1().get(0).set(i, 0d);
    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}
