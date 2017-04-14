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


  public static void main(String[] args) throws IOException {

    StateGenerator stateGenerator = new StateGenerator();
    OperatorGenerator operatorGenerator = new OperatorGenerator();
    ProjectRepresentation projectRepresentation;
    InputReader inputReader = new InputReader();

    try {
      projectRepresentation = inputReader.processInputFile(INPUT_FILE_NAME);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      return;
    }

    ProjectGenerator
        projectGenerator = new ProjectGenerator(projectRepresentation);
    List<ClassRepresentation> generatedClasses = projectGenerator
        .generate(OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME, true);

    ClassManager classManager = new ClassManager();

    classManager.clear();
    classManager.addClasses(generatedClasses);
    System.out.println("Files generated!");

    /* ---------------------------------------- */
  }
}