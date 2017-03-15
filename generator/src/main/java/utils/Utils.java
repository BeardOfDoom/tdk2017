package utils;

import antlr.ErrorListener;
import antlr.generated.SMLLexer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Utils {

  public static CommonTokenStream readTokensFromFile(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    ANTLRInputStream input = new ANTLRInputStream(reader);

    SMLLexer lexer = new SMLLexer(input);
    lexer.addErrorListener(new ErrorListener());
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    return tokens;
  }

  public static String getWordContent(String word) {
    return word.substring(1, word.length() - 1);
  }

}