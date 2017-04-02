package generator.classes;

import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class State implements StateInterface {
  private List<List<Double>> attr0;

  public State() {
    List<List<Double>> initAttr0= new ArrayList<>();
    for(int i = 0; i<Double.valueOf(8d).intValue(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for(int j = 0; j<Double.valueOf(8d).intValue(); j++) {
        tmpList.add(0.0);
      }
      initAttr0.add(tmpList);
    }
    this.setAttr0(initAttr0);

  }

  public List<List<Double>> getAttr0() {
    return attr0;
  }

  public void setAttr0(List<List<Double>> attr0) {
    this.attr0 = attr0;
  }

  @Override
  public State getStart() {
    State state = new State();
    return state;
  }

  @Override
  public boolean isGoal() {
    boolean result = true;
    result = result && GeneratedUtils.sum(this.getAttr0()) == 72d;
    return result;
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

    return attr0 != null ? attr0.equals(state.attr0) : state.attr0 == null;
  }

  @Override
  public int hashCode() {
    int result = attr0 != null ? attr0.hashCode() : 0;
    return result;
  }

  @Override
  public String toString() {
    return "State{" +
    	"attr0=" + attr0 +
    	"}";
  }

  public State copy() {
    State result = new State();
    for (List<Double> list : attr0) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : list) {
        tmpList.add(element);
      }
      Integer index = attr0.indexOf(list);
      result.getAttr0().set(index, tmpList);
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
