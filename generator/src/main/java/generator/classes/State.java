package generator.classes;

import interfaces.StateInterface;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class State implements StateInterface {
  private Set<Double> attr0;

  private Set<Double> attr1;

  private Set<Double> attr2;

  private Set<Double> attr3;

  public State() {
    this.setAttr0(new HashSet<>());
    this.setAttr1(new HashSet<>());
    this.setAttr2(new HashSet<>());
    this.setAttr3(new HashSet<>());
  }

  public Set<Double> getAttr0() {
    return attr0;
  }

  public void setAttr0(Set<Double> attr0) {
    this.attr0 = attr0;
  }

  public Set<Double> getAttr1() {
    return attr1;
  }

  public void setAttr1(Set<Double> attr1) {
    this.attr1 = attr1;
  }

  public Set<Double> getAttr2() {
    return attr2;
  }

  public void setAttr2(Set<Double> attr2) {
    this.attr2 = attr2;
  }

  public Set<Double> getAttr3() {
    return attr3;
  }

  public void setAttr3(Set<Double> attr3) {
    this.attr3 = attr3;
  }

  @Override
  public State getStart() {
    State state = new State();
    state.setAttr0(new HashSet<>(Arrays.asList(1d, 2d, 3d, Double.POSITIVE_INFINITY)));
    state.setAttr1(new HashSet<>(Arrays.asList(10d)));
    state.setAttr2(new HashSet<>(Arrays.asList(10d)));
    state.setAttr3(new HashSet<>(Arrays.asList(1d, 2d, 3d, 10d)));
    return state;
  }

  @Override
  public boolean isGoal() {
    return attr2.equals(new HashSet<>(Arrays.asList(1d, 2d, 3d, 10d)));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    State state = (State) o;

    if (attr0 != null ? !attr0.equals(state.attr0) : state.attr0 != null) {
      return false;
    }
    if (attr1 != null ? !attr1.equals(state.attr1) : state.attr1 != null) {
      return false;
    }
    if (attr2 != null ? !attr2.equals(state.attr2) : state.attr2 != null) {
      return false;
    }
    return attr3 != null ? attr3.equals(state.attr3) : state.attr3 == null;
  }

  @Override
  public int hashCode() {
    int result = attr0 != null ? attr0.hashCode() : 0;
    result = 31 * result + (attr1 != null ? attr1.hashCode() : 0);
    result = 31 * result + (attr2 != null ? attr2.hashCode() : 0);
    result = 31 * result + (attr3 != null ? attr3.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "State{" +
    	"attr0=" + attr0 +
    	", attr1=" + attr1 +
    	", attr2=" + attr2 +
    	", attr3=" + attr3 +
    	"}";
  }

  public State copy() {
    State result = new State();
    for (Double element : attr0) {
      result.getAttr0().add(element);
    }
    for (Double element : attr1) {
      result.getAttr1().add(element);
    }
    for (Double element : attr2) {
      result.getAttr2().add(element);
    }
    for (Double element : attr3) {
      result.getAttr3().add(element);
    }
    return result;
  }

  public Object getAttributeByNumber(Integer number) {
    try {
      return this.getClass().getDeclaredFields()[number].get(this);
    }
    catch(IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void setAttributeByNumber(Integer number, Object value) {
    try {
      this.getClass().getDeclaredFields()[number].set(this, value);
    }
    catch(IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
