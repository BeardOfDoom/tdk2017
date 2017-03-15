package Test;

import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State implements StateInterface {

  private List<List<Double>> attr1;

  private List<List<Double>> attr2;

  private Set<Double> attr3;

  public State() {
    List<List<Double>> initAttr1 = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<Double> tmpList = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        tmpList.add(0.0);
      }
      initAttr1.add(tmpList);
    }
    this.setAttr1(initAttr1);
    List<List<Double>> initAttr2 = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      List<Double> tmpList = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        tmpList.add(0.0);
      }
      initAttr2.add(tmpList);
    }
    this.setAttr2(initAttr2);
    this.setAttr3(new HashSet<>());
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

  public Set<Double> getAttr3() {
    return attr3;
  }

  public void setAttr3(Set<Double> attr3) {
    this.attr3 = attr3;
  }

  @Override
  public State getStart() {
    State state = new State();
    state.getAttr1().get(0).set(0, Double.valueOf(5));
    state.getAttr1().get(0).set(1, Double.valueOf(0));
    state.getAttr1().get(0).set(2, Double.valueOf(0));
    state.getAttr2().get(0).set(0, Double.valueOf(5));
    state.getAttr2().get(0).set(1, Double.valueOf(3));
    state.getAttr2().get(0).set(2, Double.valueOf(2));
    return state;
  }

  @Override
  public boolean isGoal() {
    return (attr1.get(0).get(0) == 4);
  }

  

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((attr1 == null) ? 0 : attr1.hashCode());
	result = prime * result + ((attr2 == null) ? 0 : attr2.hashCode());
	result = prime * result + ((attr3 == null) ? 0 : attr3.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	State other = (State) obj;
	if (attr1 == null) {
		if (other.attr1 != null)
			return false;
	} else if (!attr1.equals(other.attr1))
		return false;
	if (attr2 == null) {
		if (other.attr2 != null)
			return false;
	} else if (!attr2.equals(other.attr2))
		return false;
	if (attr3 == null) {
		if (other.attr3 != null)
			return false;
	} else if (!attr3.equals(other.attr3))
		return false;
	return true;
}

@Override
  public String toString() {
    return "State{" +
        "attr1=" + attr1 +
        ", attr2=" + attr2 +
        ", attr3=" + attr3 +
        "}";
  }
}