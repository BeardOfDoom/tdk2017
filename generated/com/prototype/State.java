package com.prototype;

import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class State implements StateInterface {
  private List<List<Double>> attr1;

  private List<List<Double>> attr2;

  public State() {
    List<List<Double>> initAttr1= new ArrayList<>();
    for(int i = 0; i<1; i++) {
      List<Double> tmpList = new ArrayList<>();
      for(int j = 0; j<3; j++) {
        tmpList.add(0.0);
      }
      initAttr1.add(tmpList);
    }
    this.setAttr1(initAttr1);
    List<List<Double>> initAttr2= new ArrayList<>();
    for(int i = 0; i<1; i++) {
      List<Double> tmpList = new ArrayList<>();
      for(int j = 0; j<3; j++) {
        tmpList.add(0.0);
      }
      initAttr2.add(tmpList);
    }
    this.setAttr2(initAttr2);
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
    state.getAttr1().get(0).set(0, 5d);
    state.getAttr1().get(0).set(1, 0d);
    state.getAttr1().get(0).set(2, 0d);
    state.getAttr2().get(0).set(0, 5d);
    state.getAttr2().get(0).set(1, 3d);
    state.getAttr2().get(0).set(2, 2d);
    return state;
  }

  @Override
  public boolean isGoal() {
    return attr1.get(0).get(0) == 4d;
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

    if (attr1 != null ? !attr1.equals(state.attr1) : state.attr1 != null) {
      return false;
    }
    return attr2 != null ? attr2.equals(state.attr2) : state.attr2 == null;
  }

  @Override
  public int hashCode() {
    int result = attr1 != null ? attr1.hashCode() : 0;
    result = 31 * result + (attr2 != null ? attr2.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "State{" +
    	"attr1=" + attr1 +
    	", attr2=" + attr2 +
    	"}";
  }

  public State copy() {
    State result = new State();
    for (List<Double> list : attr1) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : list) {
        tmpList.add(element);
      }
      Integer index = attr1.indexOf(list);
      result.getAttr1().set(index, tmpList);
    }
    for (List<Double> list : attr2) {
      List<Double> tmpList = new ArrayList<>();
      for (Double element : list) {
        tmpList.add(element);
      }
      Integer index = attr2.indexOf(list);
      result.getAttr2().set(index, tmpList);
    }
    return result;
  }
}
