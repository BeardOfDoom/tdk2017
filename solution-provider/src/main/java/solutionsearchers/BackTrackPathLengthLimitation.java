package solutionsearchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackPathLengthLimitationNode;
import nodes.Node;

public class BackTrackPathLengthLimitation {
	
	private List<Node> listForTree;
	private Map<StateInterface, Integer> stepsOnStates;
	private Map<String, Integer> stepsOnEdges;
	private List<Node> reachedBackTrackPathLengthLimitationNodes;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackPathLengthLimitationNode actual;
	private int pathLengthLimitation;
	private int maxId;
	private int nextId;
	
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
	
	public BackTrackPathLengthLimitation(BackTrackPathLengthLimitationNode start, int pathLengthLimitation, List<OperatorInterface> OPERATORS){
		listForTree = new ArrayList<>();
		listForTree.add(start);
		stepsOnStates = new HashMap<>();
		stepsOnEdges = new HashMap<>();
		reachedBackTrackPathLengthLimitationNodes = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		actual = start;
		actual.setNumOfNodeStepOns(1);
		this.pathLengthLimitation = pathLengthLimitation;
		this.OPERATORS = OPERATORS;
		activateNodes.add(String.valueOf(actual.getId()));
		stepOnNodes.add(String.valueOf(actual.getId()));
		appendSteps();
		//steps.append(actual.getId() + "\n");
		maxId = start.getId();
		nextId = start.getId() + 1;
	}
	
	/*public void search(){
		while(true){
			if(actual == null){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(!reachedBackTrackPathLengthLimitationNodes.contains(actual)){
				reachedBackTrackPathLengthLimitationNodes.add(actual);
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
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
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
				
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				
				stepOnNodes.add(String.valueOf(actual.getId()));
				appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {
				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {
					if(actual.getId() == 1){
						System.out.println(actual.getParent());
					}
					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackPathLengthLimitationNodes);
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackPathLengthLimitationNode newNode = new BackTrackPathLengthLimitationNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					
					BackTrackPathLengthLimitationNode tmpNode = new BackTrackPathLengthLimitationNode(newState, (BackTrackPathLengthLimitationNode)listForTree.get(listForTree.indexOf(actual)), operator, nextId, new ArrayList<>(), actual.getDepth() + 1);
					listForTree.add(tmpNode);
					nextId++;
					
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					actual.setNumOfEdgeStepOns(1);
					wasOperatorUsed = true;
					break;
				}
			}
			
			if (!wasOperatorUsed) {
				Node tmp = listForTree.get(listForTree.indexOf(actual));
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					//String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					String operatorId = tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId();
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
				
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				
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
		
		if(actual != null){
			//SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackPathLengthLimitationNodes, actual, steps.toString());
			SolutionHelper.writeOutputForGraphic(getClass(), listForTree, actual, steps.toString());
		} else {
			System.out.println("No solution.");
		}
	}*/
	
	public String search(){
		while(true){
			if(actual == null){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			Node tmp = listForTree.get(listForTree.indexOf(actual));
			
			if(!reachedBackTrackPathLengthLimitationNodes.contains(actual)){
				reachedBackTrackPathLengthLimitationNodes.add(actual);
			}
			
			if(!stepsOnStates.containsKey(actual.getState())){
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			if(actual.getOperator() != null){
				String operatorId = tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId();
				if(!stepsOnEdges.containsKey(operatorId)){
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
			}

			if(actual.getState().isGoal()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				//OperatorInterface operator = actual.getOperator();
				String operatorId = tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId();
				if(actual.getNumOfEdgeStepOns() == 1){
					inactivateEdges.add(operatorId);
				}
				stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);
				
				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(tmp.getId()));
				} else {
					closeNodes.add(String.valueOf(tmp.getId()));
				}
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				tmp = tmp.getParent();
				
				stepOnNodes.add(String.valueOf(tmp.getId()));
				appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {
				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {
					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackPathLengthLimitationNodes);
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackPathLengthLimitationNode newNode = new BackTrackPathLengthLimitationNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					
					BackTrackPathLengthLimitationNode tmpNode = new BackTrackPathLengthLimitationNode(newState, (BackTrackPathLengthLimitationNode)listForTree.get(listForTree.indexOf(actual)), operator, nextId, new ArrayList<>(), actual.getDepth() + 1);
					tmpNode.setNumOfNodeStepOns(1);
					tmpNode.setNumOfEdgeStepOns(1);
					listForTree.add(tmpNode);
					nextId++;
					
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					actual.setNumOfEdgeStepOns(1);
					wasOperatorUsed = true;
					break;
				}
			}
			
			tmp = listForTree.get(listForTree.indexOf(actual));
			if (!wasOperatorUsed) {
				//OperatorInterface operator = actual.getOperator();
				if(tmp.getParent() != null){
					//String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					String operatorId = tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId();
					if(actual.getNumOfEdgeStepOns() == 1){
						inactivateEdges.add(operatorId);
					}
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);
				}
				
				if(tmp.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(tmp.getId()));
				} else {
					closeNodes.add(String.valueOf(tmp.getId()));
				}
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackPathLengthLimitationNode) actual.getParent();
				tmp = tmp.getParent();
				
				if(tmp != null){
					stepOnNodes.add(String.valueOf(tmp.getId()));
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				String operatorId = tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId();
				if(stepsOnEdges.containsKey(operatorId)){
					actual.setNumOfEdgeStepOns(stepsOnEdges.get(operatorId) + 1);
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
				
				if(stepsOnStates.containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(stepsOnStates.get(actual.getState()) + 1);
					stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				activateEdges.add(tmp.getParent().getId() + "-OP" + OPERATORS.indexOf(tmp.getOperator()) + "-" + tmp.getId());
				activateNodes.add(String.valueOf(tmp.getId()));
				stepOnNodes.add(String.valueOf(tmp.getId()));
				closeNodes.add(String.valueOf(tmp.getParent().getId()));
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
			appendSteps();
		}
		
		if(actual != null){
			//SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackPathLengthLimitationNodes, actual, steps.toString());
			return SolutionHelper.writeOutputForGraphic(getClass(), listForTree, listForTree.get(listForTree.indexOf(actual)), steps.toString());
		} else {
			System.out.println("No solution.");
			return null;
		}
	}
}