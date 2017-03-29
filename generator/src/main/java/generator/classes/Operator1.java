package generator.classes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
  public void initOperators() {
    for(int i = 0; i <= 2; i += 1) {
      for(int j = 0; j <= 2; j += 1) {
        Operator1 operator1 = new Operator1(i, j);
        OPERATORS.add(operator1);
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
    State original = ((State) stateObject);
    return !i.equals(j) && GeneratedUtils.card(((Set<Double>) original.getAttributeByNumber(i))) != 0d && GeneratedUtils.min(((Set<Double>) original.getAttributeByNumber(i))) < GeneratedUtils.min(((Set<Double>) original.getAttributeByNumber(j))) && original.getAttr3().equals(new HashSet<>(Arrays.asList(1d, 2d, 3d)));}

  @Override
  public StateInterface apply(StateInterface stateObject) {
    State original = ((State) stateObject);
    State state = original.copy();

    state.setAttributeByNumber(j, GeneratedUtils.add(((Set<Double>) original.getAttributeByNumber(j)), GeneratedUtils.min(((Set<Double>) original.getAttributeByNumber(i)))));
    state.setAttributeByNumber(i, GeneratedUtils.remove(((Set<Double>) original.getAttributeByNumber(i)), GeneratedUtils.min(((Set<Double>) original.getAttributeByNumber(i)))));
    original.setAttr3(new HashSet<>(Arrays.asList(1d, 2d, 3d, 10d)));

    return state;
  }

  @Override
  public double getCost() {
    return cost;
  }
}