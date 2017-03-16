import antlr.impl.BaseVisitor;
import antlr.SMLParser;
import generator.OperatorGenerator;
import generator.StateGenerator;
import java.io.IOException;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import representation.ClassRepresentation;
import utils.CommonUtils;
import utils.ErrorHandler;

public class Main {

  private static final String INPUT_FILE_NAME = "input.txt";

  //TODO: Error listener on lexer

  public static void main(String[] args) throws IOException, IllegalAccessException {
    CommonTokenStream tokens = CommonUtils.readTokensFromFile(INPUT_FILE_NAME);

    SMLParser parser = new SMLParser(tokens);
    parser.setBuildParseTree(true);

    ParseTree tree = parser.expr();

    BaseVisitor baseVisitor = new BaseVisitor();
    baseVisitor.visit(tree);

    if (!ErrorHandler.containsAnyError()) {
      StateGenerator stateGenerator = new StateGenerator();
      stateGenerator.setState(baseVisitor.getStateRepresentation());
      stateGenerator.setDirectoryName("generated");
      stateGenerator.setPackageName("com.prototype");
      stateGenerator.setFileName("State");
      stateGenerator.setKeepTogetherGettersAndSetters(true);
      ClassRepresentation stateClass = stateGenerator.generateState();

      OperatorGenerator operatorGenerator = new OperatorGenerator();
      operatorGenerator.setOperator(baseVisitor.getOperatorRepresentation());
      operatorGenerator.setDirectoryName("generated");
      operatorGenerator.setPackageName("com.prototype");
      operatorGenerator.setFileName("Operator");
      operatorGenerator.setStateClass(stateClass);
      operatorGenerator.generateOperator();

      System.out.println("File created!");
    }
  }
}