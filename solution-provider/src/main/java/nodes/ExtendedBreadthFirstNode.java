package nodes;

import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class ExtendedBreadthFirstNode extends Node{

	private List<Double> F_Distance;
	private List<Double> B_Distance;
	
	public ExtendedBreadthFirstNode(StateInterface state, ExtendedBreadthFirstNode parent, OperatorInterface operator, int id, List<Double> F_Distance, List<Double> B_Distance) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		this.F_Distance = F_Distance;
		this.B_Distance = B_Distance;
	}

	public List<Double> getF_Distance() {
		return F_Distance;
	}

	public void setF_Distance(List<Double> f_Distance) {
		F_Distance = f_Distance;
	}

	public List<Double> getB_Distance() {
		return B_Distance;
	}

	public void setB_Distance(List<Double> b_Distance) {
		B_Distance = b_Distance;
	}
}
