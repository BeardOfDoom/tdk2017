package nodes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class BestFirstNode extends Node{

	public BestFirstNode(StateInterface state, BestFirstNode parent, OperatorInterface operator, int id) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
	}
}
