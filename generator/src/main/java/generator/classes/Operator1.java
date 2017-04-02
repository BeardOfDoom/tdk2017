package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Operator1 implements OperatorInterface {
  private Integer i;

  private Integer j;

  private Double cost = 1.0;

  public Operator1() {
  }

  public Operator1(Integer i, Integer j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public List<OperatorInterface> initOperators() {
    List<OperatorInterface> result = new ArrayList<>();
    for(int i = 0; i<=7; i += 1) {
      for(int j = 0; j<=7; j += 1) {
        Operator1 operator1 = new Operator1(i, j);
        result.add(operator1);
      }
    }
    return result;
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

    Operator1 operator1 = (Operator1) o;

    if (i != null ? !i.equals(operator1.i) : operator1.i != null) {
      return false;
    }
    return j != null ? j.equals(operator1.j) : operator1.j == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    result = 31 * result + (j != null ? j.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Operator1{" +
    	"i=" + i +
    	", j=" + j +
    	"}";
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    boolean result = true;
    State original = ((State) stateObject);
    result = result && original.getAttr0().get(Double.valueOf(i).intValue()).get(Double.valueOf(j).intValue()) == 0d;

    return result;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    for(Double k = 0d; k<=7d; k += 1d) {
      state.getAttr0().get(Double.valueOf(k).intValue()).set(Double.valueOf(j).intValue(), 1d);
      state.getAttr0().get(Double.valueOf(i).intValue()).set(Double.valueOf(k).intValue(), 1d);
    }
    for(Double k = 1d; k<=GeneratedUtils.min(i, j); k += 1d) {
      state.getAttr0().get(Double.valueOf(i - k).intValue()).set(Double.valueOf(j - k).intValue(), 1d);
    }
    for(Double k = 1d; k<=7d - GeneratedUtils.max(i, j); k += 1d) {
      state.getAttr0().get(Double.valueOf(i + k).intValue()).set(Double.valueOf(j + k).intValue(), 1d);
    }

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}
