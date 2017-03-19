package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BestFirstNode;
import nodes.Node;

public class BestFirst {

	private Map<StateInterface, Integer> stepsOnStates;
	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BestFirstNode actual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<BestFirstNode> openNodes = new ArrayList<>();
	private List<BestFirstNode> closedNodes = new ArrayList<>();
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
	
	public BestFirst(BestFirstNode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, Class<?> operatorClass){
		stepsOnStates = new HashMap<>();
		reachedBackTrackCircleNodes = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		this.heuristicFunction = heuristicFunction;
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
		try {
			Field operatorField = operatorClass.getField("OPERATORS");
			OPERATORS = (List<OperatorInterface>) operatorField.get(operatorClass);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openNodes.add(start);
		activateNodes.add(String.valueOf(start.getId()));
		appendSteps();
		maxId = start.getId();
	}
	
	private BestFirstNode isContains(List<BestFirstNode> nodes, StateInterface state){
		for(BestFirstNode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(BestFirstNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				BestFirstNode openNodesContains = isContains(openNodes, newState);
				BestFirstNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BestFirstNode newNode = new BestFirstNode(newState, node, operator, nodeId, heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					if(!reachedBackTrackCircleNodes.contains(newNode)){
						reachedBackTrackCircleNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		appendSteps();
		closeNodes.add(String.valueOf(node.getId()));
		//steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public void search(){
		while(true){
			if(openNodes.isEmpty()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			actual = openNodes.get(0);
			
			for(BestFirstNode openNode : openNodes){
				if(openNode.getHeuristic() < actual.getHeuristic()){
					actual = openNode;
				}
			}
			
			stepOnNodes.add(String.valueOf(actual.getId()));
			if(!reachedBackTrackCircleNodes.contains(actual)){
				reachedBackTrackCircleNodes.add(actual);
			}
			
			/*if(actual.getOperator() != null){
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				steps.append(actual.getId() + "\n");
			}*/
			
			if(actual.getState().isGoal()){
				appendSteps();
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			extend(actual);
		}
		if(!openNodes.isEmpty()){
			SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackCircleNodes, actual, steps.toString());
		} else {
			System.out.println("No solution.");
		}
	}
}
