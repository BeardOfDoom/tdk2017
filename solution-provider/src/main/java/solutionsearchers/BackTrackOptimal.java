package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import nodes.Node;

public class BackTrackOptimal {
	
	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackOptimalNode actual;
	private BackTrackOptimalNode solution;
	private boolean didFind;
	private int pathLengthLimitation;
	private int maxId;
	
	public BackTrackOptimal(BackTrackOptimalNode start, int pathLengthLimitation, Class<?> operatorClass){
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
		didFind = false;
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
				didFind = true;
				solution = actual;
				pathLengthLimitation = actual.getDepth();
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				OperatorInterface operator = actual.getOperator();
				actual = (BackTrackOptimalNode) actual.getParent();
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
					
					BackTrackOptimalNode newNode = new BackTrackOptimalNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					actual = newNode;
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				OperatorInterface operator = actual.getOperator();
				actual = (BackTrackOptimalNode) actual.getParent();
				if(actual != null){
					steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
		}
		
		if(didFind){
			SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackCircleNodes, solution, steps.toString());
		} else {
			System.out.println("Unsuccessfull search.");
		}
	}
}
