package solutionsearchers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;

public class SolutionHelper {
	
	public static String writeSolution(Node node){
		StringBuilder builder = new StringBuilder();
		LinkedList<Node> nodes = new LinkedList<>();
		
		while(node != null){
			nodes.addFirst(node);
			node = node.getParent();
		}
		
		for(Node tmpNode : nodes){
			if(tmpNode.getOperator() == null){
				builder.append(tmpNode.getId() + " ");
			} else {
				builder.append("OP" + OperatorInterface.OPERATORS.indexOf(tmpNode.getOperator()) + " " + tmpNode.getId() + " ");
			}
		}
		return builder.toString();
	}
	
	public static String writeOutputForGraphic(Class<?> solutionSearcher, List<Node> nodes, Node solution, String steps){
		File outputFolder = new File("solutionOutputs");
		File output = new File("solutionOutputs/" + solutionSearcher.getSimpleName() + ".txt");
		if(!outputFolder.exists())
			outputFolder.mkdirs();
			
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(output.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		class StateWithId{
			private StateInterface state;
			private int id;
			
			public StateWithId(StateInterface state, int id){
				this.state = state;
				this.id = id;
			}

			/*public StateInterface getState() {
				return state;
			}

			public void setState(StateInterface state) {
				this.state = state;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}*/

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + id;
				result = prime * result + ((state == null) ? 0 : state.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				StateWithId other = (StateWithId) obj;
				if (id != other.id)
					return false;
				if (state == null) {
					if (other.state != null)
						return false;
				} else if (!state.equals(other.state))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return id + "|" + state;
			}
		}
		
		
		try {
			writer.write("info\n");
			writer.write(solutionSearcher.getSimpleName() + "\n");
			
			Set<StateWithId> uniqueStatesWithId = new HashSet<>();
			for(Node node : nodes){
				uniqueStatesWithId.add(new StateWithId(node.getState(), node.getId()));
			}
			
			writer.write("nodes\n");
			for(StateWithId stateWithId : uniqueStatesWithId){
				writer.write(stateWithId.toString() + "\n");
			}
			
			writer.write("operators\n");
			for(int i = 0; i < OperatorInterface.OPERATORS.size(); i++){
				writer.write("OP" + i + "|" + OperatorInterface.OPERATORS.get(i) + "\n");
			}

			writer.write("connections\n");
			for(Node node : nodes){
				if(node.getParent() != null){
					writer.write(node.getParent().getId() + "|" + node.getId() + "|" + "OP" + OperatorInterface.OPERATORS.indexOf(node.getOperator()) + "\n");
				}
			}
			
			writer.write("steps\n");
			writer.write(steps + "\n");
			
			writer.write("solution\n");
			writer.write(writeSolution(solution));

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output.getAbsolutePath();
	}
	
	public static int getNodeId(StateInterface state, int maxId, List<Node> reachedNodes){
		
		for(Node reachedNode : reachedNodes){
			if(reachedNode.getState().equals(state)){
				return reachedNode.getId();
			}
		}
		return maxId + 1;
	}
}
