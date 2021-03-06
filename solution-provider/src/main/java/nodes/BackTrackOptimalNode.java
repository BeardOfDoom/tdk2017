package nodes;

import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class BackTrackOptimalNode extends Node{
	
	private List<OperatorInterface> tried;
	private int depth;

	public BackTrackOptimalNode(StateInterface state, BackTrackOptimalNode parent, OperatorInterface operator, int id, List<OperatorInterface> tried, int depth) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.id = id;
		this.tried = tried;
		this.depth = depth;
	}
	
	public List<OperatorInterface> getTried() {
		return tried;
	}

	public void setTried(List<OperatorInterface> tried) {
		this.tried = tried;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
