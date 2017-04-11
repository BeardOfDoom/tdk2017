package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import exceptions.CompilationException;
import exceptions.OperatorInitializationException;
import exceptions.OperatorNotFoundException;
import exceptions.StateInitializationException;
import exceptions.StateNotFoundException;
import exceptions.TemporaryFolderCreationException;
import exceptions.TemporaryFolderDeletionException;
import exceptions.WrongFileExtensionException;
import model.UserInput;

public class Main {
	
	// TODO valamilyen segitséget nyujtani hogy az interfaceket könnyen elérje a felhasználó (kiirni a felületre)

	// TODO sima backtrack mikor álljon meg??? (while helyett for?)
	
	// TODO info-ba mik kerülhetnek még bele?
	public static void main(String[] args){
		String laciState = "C:\\Users\\Vécsi Ádám\\Downloads\\State.java";
		String laciOperator = "C:\\Users\\Vécsi Ádám\\Downloads\\Operator1.java";
		String laciPlusz = "C:\\Users\\Vécsi Ádám\\Downloads\\GeneratedUtils.java";
		
		UserInput userInput = new UserInput("", null, false, true, false, false, false, true, false, false, true, false, 10, 10);
		
		try {
		SolutionMaker asd = new SolutionMaker(new ArrayList<>(Arrays.asList(/*laciState, laciOperator, laciPlusz*/"C:\\workspace\\Prototypes\\src\\Hanoi\\State.java", "C:\\workspace\\Prototypes\\src\\Hanoi\\Operator.java"))/*, new UserInput("", false, false, true, false, false, false, false, false, false)*/);
			SolutionManager solutionManager = asd.start();
			if(userInput.isDoBackTrackSimple()){
				solutionManager.doBackTrackSimple(userInput.isDoTree());
			}
			
			if(userInput.isDoBackTrackCircle()){
				solutionManager.doBackTrackCircle(userInput.isDoTree());
			}
			
			if(userInput.isDoBackTrackPathLengthLimitation()){
				solutionManager.doBackTrackPathLengthLimitation(userInput.isDoTree(), userInput.getBackTrackPathLengthLimitationLimit());
			}
			
			if(userInput.isDoBackTrackOptimal()){
				solutionManager.doBackTrackOptimal(userInput.isDoTree(), userInput.getBackTrackOptimalLimit());
			}
			
			if(userInput.isDoBreadthFirst()){
				solutionManager.doBreadthFirst(userInput.isDoTree());
			}
			
			if(userInput.isDoDepthFirst()){
				solutionManager.doDepthFirst(userInput.isDoTree());
			}
			
			if(userInput.isDoOptimal()){
				solutionManager.doOptimal(userInput.isDoTree());
			}
			
			if(userInput.isDoBestFirst()){
				solutionManager.doBestFirst(userInput.getHeuristicFunction(), userInput.getVariablesInHeuristicFunction(), userInput.isDoTree());
			}
			
			if(userInput.isDoA()){
				solutionManager.doA(userInput.getHeuristicFunction(), userInput.getVariablesInHeuristicFunction(), userInput.isDoTree());
			}
		} catch (WrongFileExtensionException | TemporaryFolderCreationException | CompilationException | IOException | ClassNotFoundException | StateNotFoundException | OperatorNotFoundException | StateInitializationException | OperatorInitializationException | TemporaryFolderDeletionException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
