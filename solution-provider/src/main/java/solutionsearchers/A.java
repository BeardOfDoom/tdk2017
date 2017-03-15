package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.ANode;
import nodes.Node;

public class A {

	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private ANode actual;
	private List<ANode> openNodes = new ArrayList<>();
	private List<ANode> closedNodes = new ArrayList<>();
	private int maxId;
	
	public A(ANode start, Class<?> operatorClass){
		reachedBackTrackCircleNodes = new ArrayList<>();
		steps = new StringBuilder();
		openNodes.add(start);
		try {
			Field operatorField = operatorClass.getField("OPERATORS");
			OPERATORS = (List<OperatorInterface>) operatorField.get(operatorClass);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maxId = start.getId();
	}
	
	private ANode isContains(List<ANode> nodes, StateInterface state){
		for(ANode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(ANode node){
		List<Integer> newOpenNodeIdList = new ArrayList<>();
		List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				ANode openNodesContains = isContains(openNodes, newState);
				ANode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					ANode newNode = new ANode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost());
					openNodes.add(newNode);
					
					if(!reachedBackTrackCircleNodes.contains(newNode)){
						reachedBackTrackCircleNodes.add(newNode);
					}
					
					newOpenNodeIdList.add(newNode.getId());
					operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else {
					double newPathCost = node.getPathCost() + operator.getCost();
					
					if (openNodesContains != null){
						if(newPathCost < openNodesContains.getPathCost()){
							openNodesContains.setParent(node);
							openNodesContains.setOperator(operator);
							openNodesContains.setPathCost(newPathCost);
							
							if(!reachedBackTrackCircleNodes.contains(openNodesContains)){
								reachedBackTrackCircleNodes.add(openNodesContains);
							}
							
							newOpenNodeIdList.add(openNodesContains.getId());
							operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					} else {
						if(newPathCost < closedNodesContains.getPathCost()){
							closedNodesContains.setParent(node);
							closedNodesContains.setOperator(operator);
							closedNodesContains.setPathCost(newPathCost);
							closedNodes.remove(closedNodesContains);
							openNodes.add(closedNodesContains);
							
							if(!reachedBackTrackCircleNodes.contains(closedNodesContains)){
								reachedBackTrackCircleNodes.add(closedNodesContains);
							}
							
							newOpenNodeIdList.add(closedNodesContains.getId());
							operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					}
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public void search(){
		while(true){
			if(openNodes.isEmpty()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			actual = openNodes.get(0);
			
			for(ANode openNode : openNodes){
				if(openNode.getPathCost() + openNode.Heuristic("", null) < actual.getPathCost() + actual.Heuristic("", null)){
					actual = openNode;
				}
			}
			
			if(!reachedBackTrackCircleNodes.contains(actual)){
				reachedBackTrackCircleNodes.add(actual);
			}
			if(actual.getOperator() != null){
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				steps.append(actual.getId() + "\n");
			}
			
			if(actual.getState().isGoal()){
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
