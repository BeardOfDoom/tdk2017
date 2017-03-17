package utils;

import antlr.SMLLexer;
import antlr.SMLParser.Dimension_partContext;
import antlr.SMLParser.Matrix_referenceContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.impl.ErrorListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import representation.ParameterRepresentation;

public class CommonUtils {

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

  public static ParameterRepresentation getParameterRepresentationFromContext(
      Parameter_description_lineContext parameter) {

    String paramName = parameter.name().getText();
    Integer from = Integer.parseInt(parameter.INT(0).getText());
    Integer to = Integer.parseInt(parameter.INT(1).getText());
    Integer by = parameter.INT(2) == null ? 1 : Integer.parseInt(parameter.INT(2).getText());

    ParameterRepresentation parameterRepresentation = new ParameterRepresentation();
    parameterRepresentation.setParameterName(paramName);
    parameterRepresentation.setFrom(from);
    parameterRepresentation.setTo(to);
    parameterRepresentation.setBy(by);

    return parameterRepresentation;
  }


  public static List<String> getDimensionsFromMatrixReferenceContext(
      Matrix_referenceContext matrix) {
    Dimension_partContext dimensionPartN = matrix.dimension()
        .dimension_part(0);
    Dimension_partContext dimensionPartM = matrix.dimension()
        .dimension_part(1);

    String dimensionN =
        dimensionPartN.INT() != null ? dimensionPartN.INT().getText()
            : dimensionPartN.name().getText();

    String dimensionM =
        dimensionPartM.INT() != null ? dimensionPartM.INT().getText()
            : dimensionPartM.name().getText();

    return Arrays.asList(dimensionN, dimensionM);
  }

  public static String getFilePath(String directoryName, String packageName, String fileName) {
    return directoryName + "\\" + packageName.replace(".", "\\") + "\\" + fileName;
  }

}