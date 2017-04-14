package antlr.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Operator1 implements OperatorInterface {
  private Double i;

  private Double j;

  private Double cost = 1.0;

  public Operator1() {
  }

  public Operator1(Double i, Double j) {
    this.i = i;
    this.j = j;
  }

  public Double getI() {
    return i;
  }

  public void setI(Double i) {
    this.i = i;
  }

  public Double getJ() {
    return j;
  }

  public void setJ(Double j) {
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
    if (j != null ? !j.equals(operator1.j) : operator1.j != null) {
      return false;
    }
    return cost != null ? cost.equals(operator1.cost) : operator1.cost == null;
  }

  @Override
  public int hashCode() {
    int result = i != null ? i.hashCode() : 0;
    result = 31 * result + (j != null ? j.hashCode() : 0);
    result = 31 * result + (cost != null ? cost.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Operator1{" +
    	"i=" + i +
    	", j=" + j +
    	", cost=" + cost +
    	"}";
  }

  @Override
  public List<OperatorInterface> initOperators() {
    List<OperatorInterface> result = new ArrayList<>();
    for(Double i = 0.0; i<=7.0; i += 1.0) {
      for(Double j = 0.0; j<=7.0; j += 1.0) {
        Operator1 operator1 = new Operator1(i, j);
        result.add(operator1);
      }
    }
    return result;
  }

  @Override
  public boolean isApplicable(StateInterface stateObject) {
    boolean result = true;
    State original = ((State) stateObject);
    result = result && (GeneratedUtils.abs(i - original.getAttr1()) == 1d && GeneratedUtils.abs(j - original.getAttr2()) == 1d) || (GeneratedUtils.abs(i - original.getAttr1()) + GeneratedUtils.abs(j - original.getAttr2()) == 1d);

    return result;
  }

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    if(GeneratedUtils.charAt(original.getAttr4(), GeneratedUtils.length(original.getAttr3())).equals(original.getAttr0().get(Double.valueOf(i).intValue()).get(Double.valueOf(j).intValue()))) {
      state.setAttr3(original.getAttr3() + original.getAttr0().get(Double.valueOf(i).intValue()).get(Double.valueOf(j).intValue()));
    }
    else {
      state.setAttr3("");
    }

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}
