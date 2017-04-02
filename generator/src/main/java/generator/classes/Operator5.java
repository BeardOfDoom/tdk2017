package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Operator5 implements OperatorInterface {
  private Integer i;

  private Double cost = 1.0;

  public Operator5() {
  }

  public Operator5(Integer i) {
    this.i = i;
  }

  @Override
  public List<OperatorInterface> initOperators() {
    List<OperatorInterface> result = new ArrayList<>();
    for(int i = 0; i<=1; i += 1) {
      Operator5 operator5 = new Operator5(i);
      result.add(operator5);
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

    Operator5 operator5 = (Operator5) o;

    return i != null ? i.equals(operator5.i) : operator5.i == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    return result;
  }

  @Override
  public String toString() {
    return "Operator5{" +
    	"i=" + i +
    	"}";
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    boolean result = true;
    State original = ((State) stateObject);
    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    result = result && x >= 0d && y <= 7d && original.getAttr0().get(Double.valueOf(x).intValue()).get(Double.valueOf(y).intValue()) == 0d;

    return result;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    state.getAttr0().get(Double.valueOf(x).intValue()).set(Double.valueOf(y).intValue(), 1d);
    state.getAttr1().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) - 1d);
    state.getAttr2().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d);

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}