import antlr.generated.SMLParser;
import antlr.Visitor;
import generator.OperatorGenerator;
import generator.StateGenerator;
import java.io.IOException;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import utils.ErrorHandler;
import utils.Utils;

public class Main {

  private static final String INPUT_FILE_NAME = "generator/input.txt";

  //TODO: Error listener on lexer

  public static void main(String[] args) throws IOException {
    CommonTokenStream tokens = Utils.readTokensFromFile(INPUT_FILE_NAME);

    SMLParser parser = new SMLParser(tokens);
    parser.setBuildParseTree(true);

    ParseTree tree = parser.expr();

    Visitor visitor = new Visitor();
    visitor.visit(tree);

    if (!ErrorHandler.containsAnyError()) {
      StateGenerator stateGenerator = new StateGenerator();
      stateGenerator.setState(visitor.getStateRepresentation());
      stateGenerator.setDirectoryName("generated");
      stateGenerator.setPackageName("com.prototype");
      stateGenerator.setFileName("State");
      stateGenerator.setKeepTogetherGettersAndSetters(true);
      stateGenerator.generateState();

      OperatorGenerator operatorGenerator = new OperatorGenerator();
      operatorGenerator.setOperator(visitor.getOperatorRepresentation());
      operatorGenerator.setDirectoryName("generated");
      operatorGenerator.setPackageName("com.prototype");
      operatorGenerator.setFileName("Operator");
      operatorGenerator.generateOperator();

      System.out.println("File created!");
    }

    Double a = 5d;
    Integer b = 1;

    System.out.println(a >= b);
  }
}