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
	
	// TODO valamilyen segitséget nyujtani hogy az interfaceket könnyen elérje a felhasználó
		
	// TODO érdekes részek kiemelése
	
	// TODO statisztika opció (külön szálakon elindul az összes keresés)
	public static void main(String[] args){
		
		String laciState = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\State.java";
		String laciOperator = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\Operator1.java";
		String laciPlusz = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\GeneratedUtils.java";
		try {
		SolutionMaker asd = new SolutionMaker(new ArrayList<>(Arrays.asList(laciState, laciOperator, laciPlusz/*"C:\\workspace\\Prototypes\\src\\Hanoi\\State.java", "C:\\workspace\\Prototypes\\src\\Hanoi\\Operator.java"*/)), new UserInput("", false, true, false, false, true, false, false, false, false));
			asd.start();
		} catch (WrongFileExtensionException | TemporaryFolderCreationException | CompilationException | IOException | ClassNotFoundException | StateNotFoundException | OperatorNotFoundException | StateInitializationException | OperatorInitializationException | TemporaryFolderDeletionException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
