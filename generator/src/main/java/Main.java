import antlr.impl.IncorrectInputException;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import java.io.IOException;
import java.util.List;
import misc.ClassManager;
import misc.InputReader;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

public class Main {

  private static final String INPUT_FILE_NAME = "input.txt";

  private static final String OUTPUT_DIRECTORY_NAME = "generated";
  private static final String OUTPUT_PACKAGE_NAME = "com.prototype";

  //TODO: Error listener on lexer

  public static void main(String[] args) throws IOException {

    StateGenerator stateGenerator = new StateGenerator();
    OperatorGenerator operatorGenerator = new OperatorGenerator();
    ProjectRepresentation projectRepresentation = null;
    InputReader inputReader = new InputReader();

    try {
      projectRepresentation = inputReader.processInputFile(INPUT_FILE_NAME);
    } catch (IncorrectInputException e) {
      System.out
          .println("line " + e.getLine() + ":" + e.getCharPositionInLine() + " " + e.getMsg());
      return;
    }

    ProjectGenerator
        projectGenerator = new ProjectGenerator(stateGenerator, operatorGenerator);
    List<ClassRepresentation> generatedClasses = projectGenerator
        .generate(projectRepresentation, OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME);

    ClassManager classManager = new ClassManager();

    classManager.clear();
    classManager.addClasses(generatedClasses);
    System.out.println("Files generated!");
  }
}