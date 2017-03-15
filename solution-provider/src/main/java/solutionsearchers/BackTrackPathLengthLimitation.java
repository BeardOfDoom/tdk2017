package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackPathLengthLimitationNode;
import nodes.Node;

public class BackTrackPathLengthLimitation {
	
	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackPathLengthLimitationNode actual;
	private int pathLengthLimitation;
	private int maxId;
	
	public BackTrackPathLengthLimitation(BackTrackPathLengthLimitationNode start, int pathLengthLimitation, Class<?> operatorClass){
		reachedBackTrackCircleNodes = new ArrayList<>();
		steps = new StringBuilder();
		actual = start;
		try {
			Field operatorField = operatorClass.getField("OPERATORS");
			OPERATORS = (List<OperatorInterface>) operatorField.get(operatorClass);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		steps.append(actual.getId() + "\n");
		this.pathLengthLimitation = pathLengthLimitation;
		maxId = start.getId();
	}
	
	public void search(){
		while(true){
			if(actual == null){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(!reachedBackTrackCircleNodes.contains(actual)){
				reachedBackTrackCircleNodes.add(actual);
			}
			
			if(actual.getState().isGoal()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				OperatorInterface operator = actual.getOperator();
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {
				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {
					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackPathLengthLimitationNode newNode = new BackTrackPathLengthLimitationNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					actual = newNode;
					wasOperatorUsed = true;
					break;
				}
			}
			
			if (!wasOperatorUsed) {
				OperatorInterface operator = actual.getOperator();
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				if(actual != null){
					steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
		}
		
		if(actual != null){
			SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackCircleNodes, actual, steps.toString());
		} else {
			System.out.println("No solution.");
		}
	}
}
