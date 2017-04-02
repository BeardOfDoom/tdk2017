package generator.classes;

import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class State implements StateInterface {
  private List<List<Double>> attr0;

  private List<List<Double>> attr1;

  private List<List<Double>> attr2;

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

    List<List<Double>> initAttr1= new ArrayList<>();
    for(int i = 0; i<Double.valueOf(1d).intValue(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for(int j = 0; j<Double.valueOf(1d).intValue(); j++) {
        tmpList.add(0.0);
      }
      initAttr1.add(tmpList);
    }
    this.setAttr1(initAttr1);

    List<List<Double>> initAttr2= new ArrayList<>();
    for(int i = 0; i<Double.valueOf(1d).intValue(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for(int j = 0; j<Double.valueOf(1d).intValue(); j++) {
        tmpList.add(0.0);
      }
      initAttr2.add(tmpList);
    }
    this.setAttr2(initAttr2);

  }

  public List<List<Double>> getAttr0() {
    return attr0;
  }

  public void setAttr0(List<List<Double>> attr0) {
    this.attr0 = attr0;
  }

  public List<List<Double>> getAttr1() {
    return attr1;
  }

  public void setAttr1(List<List<Double>> attr1) {
    this.attr1 = attr1;
  }

  public List<List<Double>> getAttr2() {
    return attr2;
  }

  public void setAttr2(List<List<Double>> attr2) {
    this.attr2 = attr2;
  }

  @Override
  public State getStart() {
    State state = new State();
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(4d).intValue(), 1d);
    state.getAttr1().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), 0d);
    state.getAttr2().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), 4d);
    return state;
  }

  @Override
  public boolean isGoal() {
    boolean result = true;
    result = result && GeneratedUtils.sum(this.getAttr0()) == 64d;
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

    if (attr0 != null ? !attr0.equals(state.attr0) : state.attr0 != null) {
      return false;
    }
    if (attr1 != null ? !attr1.equals(state.attr1) : state.attr1 != null) {
      return false;
    }
    return attr2 != null ? attr2.equals(state.attr2) : state.attr2 == null;
  }

  @Override
  public int hashCode() {
    int result = attr0 != null ? attr0.hashCode() : 0;
    result = 31 * result + (attr1 != null ? attr1.hashCode() : 0);
    result = 31 * result + (attr2 != null ? attr2.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "State{" +
    	"attr0=" + attr0 +
    	", attr1=" + attr1 +
    	", attr2=" + attr2 +
    	"}";
  }

  public State copy() {
    State result = new State();
    for (Integer i=0; i < attr0.size(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : attr0.get(i)) {
        tmpList.add(element);
      }
      result.getAttr0().set(i, tmpList);
    }
    for (Integer i=0; i < attr1.size(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : attr1.get(i)) {
        tmpList.add(element);
      }
      result.getAttr1().set(i, tmpList);
    }
    for (Integer i=0; i < attr2.size(); i++) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : attr2.get(i)) {
        tmpList.add(element);
      }
      result.getAttr2().set(i, tmpList);
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
