package antlr.classes;

import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class State implements StateInterface {

  private List<List<String>> attr0;

  private Double attr1;

  private Double attr2;

  private String attr3;

  private String attr4;

  public State() {
    List<List<String>> initAttr0 = new ArrayList<>();
    for (int i = 0; i < Double.valueOf(8d).intValue(); i++) {
      List<String> tmpList = new ArrayList<>();
      for (int j = 0; j < Double.valueOf(8d).intValue(); j++) {
        tmpList.add(new String());
      }
      initAttr0.add(tmpList);
    }
    this.setAttr0(initAttr0);
  }

  public List<List<String>> getAttr0() {
    return attr0;
  }

  public void setAttr0(List<List<String>> attr0) {
    this.attr0 = attr0;
  }

  public Double getAttr1() {
    return attr1;
  }

  public void setAttr1(Double attr1) {
    this.attr1 = attr1;
  }

  public Double getAttr2() {
    return attr2;
  }

  public void setAttr2(Double attr2) {
    this.attr2 = attr2;
  }

  public String getAttr3() {
    return attr3;
  }

  public void setAttr3(String attr3) {
    this.attr3 = attr3;
  }

  public String getAttr4() {
    return attr4;
  }

  public void setAttr4(String attr4) {
    this.attr4 = attr4;
  }

  @Override
  public State getStart() {
    State state = new State();
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(0d).intValue(), "9");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(1d).intValue(), "1");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(2d).intValue(), "5");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(3d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(4d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(5d).intValue(), "8");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(6d).intValue(), "7");
    state.getAttr0().get(Double.valueOf(0d).intValue()).set(Double.valueOf(7d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(0d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(1d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(2d).intValue(), "7");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(3d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(4d).intValue(), "5");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(5d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(6d).intValue(), "9");
    state.getAttr0().get(Double.valueOf(1d).intValue()).set(Double.valueOf(7d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(0d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(1d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(2d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(3d).intValue(), "7");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(4d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(5d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(6d).intValue(), "5");
    state.getAttr0().get(Double.valueOf(2d).intValue()).set(Double.valueOf(7d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(0d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(1d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(2d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(3d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(4d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(5d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(6d).intValue(), "8");
    state.getAttr0().get(Double.valueOf(3d).intValue()).set(Double.valueOf(7d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(0d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(1d).intValue(), "9");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(2d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(3d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(4d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(5d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(6d).intValue(), "0");
    state.getAttr0().get(Double.valueOf(4d).intValue()).set(Double.valueOf(7d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(0d).intValue(), "7");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(1d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(2d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(3d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(4d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(5d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(6d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(5d).intValue()).set(Double.valueOf(7d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(0d).intValue(), "9");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(1d).intValue(), "8");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(2d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(3d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(4d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(5d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(6d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(6d).intValue()).set(Double.valueOf(7d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(0d).intValue(), "3");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(1d).intValue(), "5");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(2d).intValue(), "7");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(3d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(4d).intValue(), "2");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(5d).intValue(), "4");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(6d).intValue(), "6");
    state.getAttr0().get(Double.valueOf(7d).intValue()).set(Double.valueOf(7d).intValue(), "1");
    state.setAttr1(-1d);
    state.setAttr2(-1d);
    state.setAttr3("");
    state.setAttr4("00000000");
    return state;
  }

  @Override
  public boolean isGoal() {
    boolean result = true;
    result = result && this.getAttr3().equals(this.getAttr4());
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
    if (attr2 != null ? !attr2.equals(state.attr2) : state.attr2 != null) {
      return false;
    }
    if (attr3 != null ? !attr3.equals(state.attr3) : state.attr3 != null) {
      return false;
    }
    return attr4 != null ? attr4.equals(state.attr4) : state.attr4 == null;
  }

  @Override
  public int hashCode() {
    int result = attr0 != null ? attr0.hashCode() : 0;
    result = 31 * result + (attr1 != null ? attr1.hashCode() : 0);
    result = 31 * result + (attr2 != null ? attr2.hashCode() : 0);
    result = 31 * result + (attr3 != null ? attr3.hashCode() : 0);
    result = 31 * result + (attr4 != null ? attr4.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "State{" +
        "attr0=" + attr0 +
        ", attr1=" + attr1 +
        ", attr2=" + attr2 +
        ", attr3=" + attr3 +
        ", attr4=" + attr4 +
        "}";
  }

  public State copy() {
    State result = new State();
    for (Integer i = 0; i < attr0.size(); i++) {
      List<String> tmpList = new ArrayList<>();
      for (String element : attr0.get(i)) {
        tmpList.add(element);
      }
      result.getAttr0().set(i, tmpList);
    }
    result.setAttr1(attr1);
    result.setAttr2(attr2);
    result.setAttr3(attr3);
    result.setAttr4(attr4);
    return result;
  }

  public Object getAttributeByNumber(Double number) {
    try {
      return this.getClass().getDeclaredFields()[number.intValue()].get(this);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void setAttributeByNumber(Double number, Object value) {
    try {
      this.getClass().getDeclaredFields()[number.intValue()].set(this, value);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
