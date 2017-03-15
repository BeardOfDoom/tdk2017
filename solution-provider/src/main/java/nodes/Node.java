package nodes;

import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.heuristicparser.HeuristicParser;

public abstract class Node {
	
	private StateInterface state;
	private Node parent;
	private OperatorInterface operator;
	private int id;
	private double heuristic;
	private boolean isHeuristicCalculated;

	public StateInterface getState() {
		return state;
	}

	public void setState(StateInterface state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public OperatorInterface getOperator() {
		return operator;
	}

	public void setOperator(OperatorInterface operator) {
		this.operator = operator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Node [state=" + state + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.getState().hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Node other = (Node) obj;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.getState().equals(other.parent.getState()))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	public double Heuristic(String heuristic, Set<String> variables){
		if(isHeuristicCalculated){
			return this.heuristic;
		} else {
			if(heuristic.isEmpty()){
				this.heuristic = 1;
				isHeuristicCalculated = true;
			} else {
				HeuristicParser heuristicParser = new HeuristicParser(heuristic, variables, this);
				this.heuristic = heuristicParser.Parse();
				isHeuristicCalculated = true;
			}
			return this.heuristic;
		}
	}
}
