package nodes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class ANode extends Node{
	private double pathCost;

	public ANode() {
		// TODO Auto-generated constructor stub
	}
	
	public ANode(StateInterface state, ANode parent, OperatorInterface operator, int id, double pathCost) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		this.pathCost = pathCost;
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}
}
