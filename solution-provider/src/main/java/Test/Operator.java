package Test;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.util.ArrayList;
import java.util.List;

public class Operator implements OperatorInterface {

  @Override
	public void initOperators(){
		for (int i = 0; i <= 2; i += 1) {
      for (int j = 0; j <= 2; j += 1) {
        Operator operator = new Operator(i, j);
        OPERATORS.add(operator);
      }
    }
	}

  private Integer i;

  private Integer j;

  public Operator() {
  }

  public Operator(Integer i, Integer j) {
    this.i = i;
    this.j = j;
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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((i == null) ? 0 : i.hashCode());
	result = prime * result + ((j == null) ? 0 : j.hashCode());
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
	Operator other = (Operator) obj;
	if (i == null) {
		if (other.i != null)
			return false;
	} else if (!i.equals(other.i))
		return false;
	if (j == null) {
		if (other.j != null)
			return false;
	} else if (!j.equals(other.j))
		return false;
	return true;
}

@Override
  public String toString() {
    return "Operator{" +
        "i=" + i +
        ", j=" + j +
        "}";
  }

  @Override
  public boolean isApplicable(StateInterface state) {
    return !i.equals(j) &&
        !((State) state).getAttr1().get(0).get(i).equals(0d) &&
        !((State) state).getAttr1().get(0).get(j).equals(((State) state).getAttr2().get(0).get(j));
  }

  @Override
  public StateInterface apply(StateInterface state) {
    State result = new State();
    result.setAttr1(((State) state).getAttr1());
    result.setAttr2(((State) state).getAttr2());

    Double beer = Math.min(((State) state).getAttr1().get(0).get(i),
        ((State) state).getAttr2().get(0).get(j) - ((State) state).getAttr1().get(0).get(j));
    
    

    result.getAttr1().get(0).set(i, ((State) state).getAttr1().get(0).get(i) - beer);
    result.getAttr1().get(0).set(j, ((State) state).getAttr1().get(0).get(j) + beer);

    return result;
  }
}