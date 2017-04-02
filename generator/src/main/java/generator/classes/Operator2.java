package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Operator2 implements OperatorInterface {
  private Integer i;

  private Double cost = 1.0;

  public Operator2() {
  }

  public Operator2(Integer i) {
    this.i = i;
  }

  @Override
  public List<OperatorInterface> initOperators() {
    List<OperatorInterface> result = new ArrayList<>();
    for(int i = 0; i<=1; i += 1) {
      Operator2 operator2 = new Operator2(i);
      result.add(operator2);
    }
    return result;
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
    boolean result = true;
    State original = ((State) stateObject);
    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d;
    result = result && x <= 7d && y >= 0d && original.getAttr0().get(Double.valueOf(x).intValue()).get(Double.valueOf(y).intValue()) == 0d;

    return result;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d;
    state.getAttr0().get(Double.valueOf(x).intValue()).set(Double.valueOf(y).intValue(), 1d);
    state.getAttr1().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d);
    state.getAttr2().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d);

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}