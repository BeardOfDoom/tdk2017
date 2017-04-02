import exceptions.IncorrectInputException;
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
        projectGenerator = new ProjectGenerator(projectRepresentation);
    List<ClassRepresentation> generatedClasses = projectGenerator
        .generate(OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME, true);

    ClassManager classManager = new ClassManager();

    classManager.clear();
    classManager.addClasses(generatedClasses);
    System.out.println("Files generated!");

    /* ---------------------------------------- */

//    State state = new State();
//    state = state.getStart();
//
//    Operator1 op1 = new Operator1();
//    Operator2 op2 = new Operator2();
//    Operator3 op3 = new Operator3();
//    Operator4 op4 = new Operator4();
//    Operator5 op5 = new Operator5();
//    Operator6 op6 = new Operator6();
//    Operator7 op7 = new Operator7();
//    Operator8 op8 = new Operator8();
//
//    System.out.println("start: " + state);
//
//    op1.isApplicable(state);
//
//    for (int i = 0; i < 8; i++) {
//      for (int j = 0; j < 8; j++) {
//        state.getAttr0().get(i).set(j, 1d);
//      }
//    }
//
//    state.getAttr0().get(1).set(2, 0d);
//    op1.isApplicable(state);
//    state = ((State) op1.apply(state));
//    System.out.println(state.isGoal());
//
//    System.out.println(state.getAttr0());


  }
}