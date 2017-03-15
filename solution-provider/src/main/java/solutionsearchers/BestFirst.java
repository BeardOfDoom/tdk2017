package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BestFirstNode;
import nodes.Node;

public class BestFirst {

	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private BestFirstNode actual;
	private List<BestFirstNode> openNodes = new ArrayList<>();
	private List<BestFirstNode> closedNodes = new ArrayList<>();
	private int maxId;
	
	public BestFirst(BestFirstNode start, Class<?> operatorClass){
		reachedBackTrackCircleNodes = new ArrayList<>();
		try {
			Field operatorField = operatorClass.getField("OPERATORS");
			OPERATORS = (List<OperatorInterface>) operatorField.get(operatorClass);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		steps = new StringBuilder();
		openNodes.add(start);
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
		List<Integer> newOpenNodeIdList = new ArrayList<>();
		List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				BestFirstNode openNodesContains = isContains(openNodes, newState);
				BestFirstNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BestFirstNode newNode = new BestFirstNode(newState, node, operator, nodeId);
					openNodes.add(newNode);
					
					if(!reachedBackTrackCircleNodes.contains(newNode)){
						reachedBackTrackCircleNodes.add(newNode);
					}
					
					newOpenNodeIdList.add(newNode.getId());
					operatorIdList.add("OP" + OPERATORS.indexOf(operator));
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
			
			for(BestFirstNode openNode : openNodes){
				if(openNode.Heuristic("", null) < actual.Heuristic("", null)){
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
