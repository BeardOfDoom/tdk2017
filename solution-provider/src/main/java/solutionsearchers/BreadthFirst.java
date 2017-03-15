package solutionsearchers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BreadthFirstNode;
import nodes.Node;

public class BreadthFirst {

	private List<Node> reachedBackTrackCircleNodes;
	private StringBuilder steps;
	
	private List<OperatorInterface> OPERATORS;
	private BreadthFirstNode actual;
	private LinkedList<BreadthFirstNode> openNodes = new LinkedList<>();
	private LinkedList<BreadthFirstNode> closedNodes = new LinkedList<>();
	private int maxId;
	
	public BreadthFirst(BreadthFirstNode start, Class<?> operatorClass){
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
	
	private boolean isContains(List<BreadthFirstNode> nodes, StateInterface state){
		for(BreadthFirstNode node : nodes){
			if(node.getState().equals(state)){
				return true;
			}
		}
		return false;
	}
	
	private void extend(BreadthFirstNode node){
		List<Integer> newOpenNodeIdList = new ArrayList<>();
		List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				boolean isOpenNodesContains = isContains(openNodes, newState);
				boolean isClosedNodesContains = isContains(closedNodes, newState);
				
				if(!(isOpenNodesContains || isClosedNodesContains)){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackCircleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BreadthFirstNode newNode = new BreadthFirstNode(newState, node, operator, nodeId, node.getDepth() + 1);
					openNodes.addLast(newNode);
					
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
			
			actual = openNodes.getFirst();
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
