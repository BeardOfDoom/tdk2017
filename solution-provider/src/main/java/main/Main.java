package main;

import exceptions.CompilationException;
import exceptions.OperatorInitializationException;
import exceptions.OperatorNotFoundException;
import exceptions.StateInitializationException;
import exceptions.StateNotFoundException;
import exceptions.TemporaryFolderCreationException;
import exceptions.TemporaryFolderDeletionException;
import exceptions.WrongFileExtensionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import model.UserInput;

public class Main {

  // TODO valamilyen segitséget nyujtani hogy az interfaceket könnyen elérje a felhasználó (kiirni a felületre)

  // TODO statisztika opció (külön szálakon elindul az összes keresés)

  // TODO fa ugye nem kell szélességi és mélységi keresőkbe, mert azok mindig fák

  // TODO sima backtrack mikor álljon meg???

  // TODO projekt/program neve?

  // TODO info-ba mik kerülhetnek még bele?
  public static void main(String[] args) {
    String laciState = "D:\\Laci\\egyetem\\szakdolgozat\\tdk2017\\visualizer\\generated\\pkg\\McclUMCizdwxZqmgdeRp\\uQdbLaEwKLpcfPzwsSjx\\Operator1.java";
    String laciOperator = "D:\\Laci\\egyetem\\szakdolgozat\\tdk2017\\visualizer\\generated\\pkg\\McclUMCizdwxZqmgdeRp\\uQdbLaEwKLpcfPzwsSjx\\GeneratedUtils.java";
    String laciPlusz = "D:\\Laci\\egyetem\\szakdolgozat\\tdk2017\\visualizer\\generated\\pkg\\McclUMCizdwxZqmgdeRp\\uQdbLaEwKLpcfPzwsSjx\\State.java";

    UserInput userInput = new UserInput("", false, true, false, false, false, false, false, false, false);

    try {
      SolutionMaker asd = new SolutionMaker(new ArrayList<>(Arrays.asList(laciState, laciOperator, laciPlusz/*"C:\\workspace\\Prototypes\\src\\Hanoi\\State.java", "C:\\workspace\\Prototypes\\src\\Hanoi\\Operator.java"*/))/*, new UserInput("", false, false, true, false, false, false, false, false, false)*/);
      SolutionManager solutionManager = asd.start();
      if (userInput.isDoBackTrackSimple()) {
        solutionManager.doBackTrackSimple(userInput.getHeuristicFunction());
      }

      if (userInput.isDoBackTrackCircle()) {
        solutionManager.doBackTrackCircle(userInput.getHeuristicFunction());
      }

      if (userInput.isDoBackTrackPathLengthLimitation()) {
        solutionManager.doBackTrackPathLengthLimitation(userInput.getHeuristicFunction());
      }

      if (userInput.isDoBackTrackOptimal()) {
        solutionManager.doBackTrackOptimal(userInput.getHeuristicFunction());
      }

      if (userInput.isDoBreadthFirst()) {
        solutionManager.doBreadthFirst(userInput.getHeuristicFunction());
      }

      if (userInput.isDoDepthFirst()) {
        solutionManager.doDepthFirst(userInput.getHeuristicFunction());
      }

      if (userInput.isDoOptimal()) {
        solutionManager.doOptimal(userInput.getHeuristicFunction());
      }

      if (userInput.isDoBestFirst()) {
        solutionManager.doBestFirst(userInput.getHeuristicFunction());
      }

      if (userInput.isDoA()) {
        solutionManager.doA(userInput.getHeuristicFunction());
      }
    } catch (WrongFileExtensionException | TemporaryFolderCreationException | CompilationException | IOException | ClassNotFoundException | StateNotFoundException | OperatorNotFoundException | StateInitializationException | OperatorInitializationException | TemporaryFolderDeletionException | URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
