package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackSimpleNode;
import nodes.Node;

public class BackTrackSimple{

	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackSimpleNode actual;
	private int maxId;
	
	public BackTrackSimple(BackTrackSimpleNode start, Class<?> operatorClass){
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
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackSimpleNode newNode = new BackTrackSimpleNode(newState, actual, operator, nodeId, new ArrayList<>());
					actual = newNode;
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				OperatorInterface operator = actual.getOperator();
				actual = (BackTrackSimpleNode) actual.getParent();
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
