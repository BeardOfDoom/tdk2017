package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import nodes.Node;

public class BackTrackOptimal {
	
	private Map<StateInterface, Integer> stepsOnStates;
	private Map<String, Integer> stepsOnEdges;
	private List<Node> reachedBackTrackOptimalNodes;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackOptimalNode actual;
	private BackTrackOptimalNode solution;
	private boolean didFind;
	private int pathLengthLimitation;
	private int maxId;
	
	private void appendSteps(){
		steps.append("Activated nodes: " + activateNodes);
		activateNodes.clear();
		steps.append(" Inactivated nodes: " + inactivateNodes);
		inactivateNodes.clear();
		steps.append(" Stepped on nodes: " + stepOnNodes);
		stepOnNodes.clear();
		steps.append(" Closed nodes: " + closeNodes);
		closeNodes.clear();
		steps.append(" Activated edges: " + activateEdges);
		activateEdges.clear();
		steps.append(" Inactivated edges: " + inactivateEdges + "\n");
		inactivateEdges.clear();
	}
	
	public BackTrackOptimal(BackTrackOptimalNode start, int pathLengthLimitation, Class<?> operatorClass){
		stepsOnStates = new HashMap<>();
		stepsOnEdges = new HashMap<>();
		reachedBackTrackOptimalNodes = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		actual = start;
		actual.setNumOfNodeStepOns(1);
		try {
			Field operatorField = operatorClass.getField("OPERATORS");
			OPERATORS = (List<OperatorInterface>) operatorField.get(operatorClass);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activateNodes.add(String.valueOf(actual.getId()));
		stepOnNodes.add(String.valueOf(actual.getId()));
		appendSteps();
		//steps.append(actual.getId() + "\n");
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
			
			if(!reachedBackTrackOptimalNodes.contains(actual)){
				reachedBackTrackOptimalNodes.add(actual);
			}
			
			if(!stepsOnStates.containsKey(actual.getState())){
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			if(actual.getOperator() != null){
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				if(!stepsOnEdges.containsKey(operatorId)){
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
			}

			if(actual.getState().isGoal()){
				didFind = true;
				solution = actual;
				pathLengthLimitation = actual.getDepth();
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				//OperatorInterface operator = actual.getOperator();
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				if(actual.getNumOfEdgeStepOns() == 1){
					inactivateEdges.add(operatorId);
				}
				stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);

				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(actual.getId()));
				} else {
					closeNodes.add(String.valueOf(actual.getId()));
				}
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				
				stepOnNodes.add(String.valueOf(actual.getId()));
				appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackOptimalNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackOptimalNode newNode = new BackTrackOptimalNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					actual.setNumOfEdgeStepOns(1);
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					if(actual.getNumOfEdgeStepOns() == 1){
						inactivateEdges.add(operatorId);
					}
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(actual.getId()));
				} else {
					closeNodes.add(String.valueOf(actual.getId()));
				}
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				
				if(actual != null){
					stepOnNodes.add(String.valueOf(actual.getId()));
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				if(stepsOnEdges.containsKey(operatorId)){
					actual.setNumOfEdgeStepOns(stepsOnEdges.get(operatorId) + 1);
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
				
				if(stepsOnStates.containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(stepsOnStates.get(actual.getState()) + 1);
					stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				activateEdges.add(actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId());
				activateNodes.add(String.valueOf(actual.getId()));
				stepOnNodes.add(String.valueOf(actual.getId()));
				closeNodes.add(String.valueOf(actual.getParent().getId()));
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
			appendSteps();
		}
		
		if(didFind){
			SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackOptimalNodes, solution, steps.toString());
		} else {
			System.out.println("Unsuccessfull search.");
		}
	}
}
