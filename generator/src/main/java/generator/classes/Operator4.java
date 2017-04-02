package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Operator4 implements OperatorInterface {
  private Integer i;

  private Double cost = 1.0;

  public Operator4() {
  }

  public Operator4(Integer i) {
    this.i = i;
  }

  @Override
  public List<OperatorInterface> initOperators() {
    List<OperatorInterface> result = new ArrayList<>();
    for(int i = 0; i<=1; i += 1) {
      Operator4 operator4 = new Operator4(i);
      result.add(operator4);
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

    Operator4 operator4 = (Operator4) o;

    return i != null ? i.equals(operator4.i) : operator4.i == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    return result;
  }

  @Override
  public String toString() {
    return "Operator4{" +
    	"i=" + i +
    	"}";
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    boolean result = true;
    State original = ((State) stateObject);
    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 1d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    result = result && x <= 7d && y <= 7d && original.getAttr0().get(Double.valueOf(x).intValue()).get(Double.valueOf(y).intValue()) == 0d;

    return result;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    Double x = original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 1d;
    Double y = original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d;
    state.getAttr0().get(Double.valueOf(x).intValue()).set(Double.valueOf(y).intValue(), 1d);
    state.getAttr1().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr1().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 1d);
    state.getAttr2().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), original.getAttr2().get(Double.valueOf(0d).intValue()).get(Double.valueOf(0d).intValue()) + 2d);

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}
