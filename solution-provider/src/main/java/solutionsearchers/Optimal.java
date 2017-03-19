package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;
import nodes.OptimalNode;

public class Optimal {
	
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
	private OptimalNode actual;
	private List<OptimalNode> openNodes = new ArrayList<>();
	private List<OptimalNode> closedNodes = new ArrayList<>();
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
	
	public Optimal(OptimalNode start, Class<?> operatorClass){
		stepsOnStates = new HashMap<>();
		reachedBackTrackCircleNodes = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
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
	
	private OptimalNode isContains(List<OptimalNode> nodes, StateInterface state){
		for(OptimalNode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(OptimalNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				OptimalNode openNodesContains = isContains(openNodes, newState);
				OptimalNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					OptimalNode newNode = new OptimalNode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost());
					openNodes.add(newNode);
					
					if(!reachedBackTrackCircleNodes.contains(newNode)){
						reachedBackTrackCircleNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else if (openNodesContains != null){
					double newPathCost = node.getPathCost() + operator.getCost();
					if(newPathCost < openNodesContains.getPathCost()){
						inactivateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
						openNodesContains.setParent(node);
						openNodesContains.setOperator(operator);
						openNodesContains.setPathCost(newPathCost);
						
						if(!reachedBackTrackCircleNodes.contains(openNodesContains)){
							reachedBackTrackCircleNodes.add(openNodesContains);
						}
						
						// TODO ez lehet nem kell mert már eddig is nyitott volt
						//activateNodes.add(String.valueOf(openNodesContains.getId()));
						activateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
						//newOpenNodeIdList.add(openNodesContains.getId());
						//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
					}
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
			
			for(OptimalNode openNode : openNodes){
				if(openNode.getPathCost() < actual.getPathCost()){
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
