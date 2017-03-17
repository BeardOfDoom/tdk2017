import antlr.SMLParser;
import antlr.impl.BaseVisitor;
import generator.OperatorGenerator;
import generator.OperatorInstantiatorGenerator;
import generator.StateGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import misc.ClassManager;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import representation.ClassRepresentation;
import representation.operator.OperatorRepresentation;
import representation.state.StateRepresentation;
import utils.CommonUtils;
import utils.ErrorHandler;

public class Main {

  private static final String INPUT_FILE_NAME = "input.txt";

  private static final String OUTPUT_DIRECTORY_NAME = "generated";
  private static final String OUTPUT_PACKAGE_NAME = "com.prototype";
  private static final String OPERATOR_INSTANTIATOR_NAME = "OperatorInstantiator";

  //TODO: Error listener on lexer

  public static void main(String[] args) throws IOException, IllegalAccessException {
    CommonTokenStream tokens = CommonUtils.readTokensFromFile(INPUT_FILE_NAME);

    SMLParser parser = new SMLParser(tokens);
    parser.setBuildParseTree(true);

    ParseTree tree = parser.expr();

    BaseVisitor baseVisitor = new BaseVisitor();
    baseVisitor.visit(tree);

    if (!ErrorHandler.containsAnyError()) {
      ClassManager classManager = new ClassManager();

      StateRepresentation stateRepresentation = baseVisitor.getStateRepresentation();

      StateGenerator stateGenerator = new StateGenerator();
      stateGenerator.setState(stateRepresentation);
      stateGenerator.setKeepTogetherGettersAndSetters(true);
      ClassRepresentation stateClass = stateGenerator
          .generate(OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME, stateRepresentation.getName());
      classManager.addClassRepresentation(stateClass);

      List<OperatorRepresentation> operators = baseVisitor.getOperatorRepresentations();

      OperatorGenerator operatorGenerator = new OperatorGenerator();
      operatorGenerator.setStateClass(stateClass);

      List<ClassRepresentation> operatorClasses = new ArrayList<>();

      for (int i = 0; i < operators.size(); i++) {
        operatorGenerator.setOperator(operators.get(i));
        ClassRepresentation operatorClass = operatorGenerator
            .generate(OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME, operators.get(i).getName());

        operatorClasses.add(operatorClass);
        classManager.addClassRepresentation(operatorClass);
      }

      OperatorInstantiatorGenerator operatorInstantiatorGenerator = new OperatorInstantiatorGenerator();
      operatorInstantiatorGenerator.setOperatorRepresentations(operatorClasses);

      ClassRepresentation operatorInstantiatorClass = operatorInstantiatorGenerator
          .generate(OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME, OPERATOR_INSTANTIATOR_NAME);

      classManager.addClassRepresentation(operatorInstantiatorClass);

      System.out.println(classManager.getFilePaths());

      //TODO: Add GeneratedUtils to classManager
      System.out.println("Files created!");
    }
  }
}