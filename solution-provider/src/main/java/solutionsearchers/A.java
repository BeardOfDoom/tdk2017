package solutionsearchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.ANode;
import nodes.Node;

public class A {

	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private ANode actual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<ANode> openNodes = new ArrayList<>();
	private List<ANode> closedNodes = new ArrayList<>();
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
	
	public A(ANode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, List<OperatorInterface> OPERATORS){
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
		this.OPERATORS = OPERATORS;
		openNodes.add(start);
		activateNodes.add(String.valueOf(start.getId()));
		appendSteps();
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
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				ANode openNodesContains = isContains(openNodes, newState);
				ANode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					ANode newNode = new ANode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost(), heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					if(!reachedBackTrackCircleNodes.contains(newNode)){
						reachedBackTrackCircleNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else {
					double newPathCost = node.getPathCost() + operator.getCost();
					
					if (openNodesContains != null){
						if(newPathCost < openNodesContains.getPathCost()){
							inactivateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							openNodesContains.setParent(node);
							openNodesContains.setOperator(operator);
							openNodesContains.setPathCost(newPathCost);
							
							if(!reachedBackTrackCircleNodes.contains(openNodesContains)){
								reachedBackTrackCircleNodes.add(openNodesContains);
							}
							
							//activateNodes.add(String.valueOf(openNodesContains.getId()));
							activateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							//newOpenNodeIdList.add(openNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					} else {
						if(newPathCost < closedNodesContains.getPathCost()){
							inactivateEdges.add(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							closedNodesContains.setParent(node);
							closedNodesContains.setOperator(operator);
							closedNodesContains.setPathCost(newPathCost);
							closedNodes.remove(closedNodesContains);
							openNodes.add(closedNodesContains);
							
							if(!reachedBackTrackCircleNodes.contains(closedNodesContains)){
								reachedBackTrackCircleNodes.add(closedNodesContains);
							}
							
							activateNodes.add(String.valueOf(closedNodesContains.getId()));
							activateEdges.add(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							//newOpenNodeIdList.add(closedNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
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
	
	public String search(){
		while(true){
			if(openNodes.isEmpty()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			actual = openNodes.get(0);
			
			for(ANode openNode : openNodes){
				if(openNode.getPathCost() + openNode.getHeuristic() < actual.getPathCost() + actual.getHeuristic()){
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
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackCircleNodes, actual, steps.toString());
		} else {
			System.out.println("No solution.");
			// TODO
			return null;
		}
	}
}
