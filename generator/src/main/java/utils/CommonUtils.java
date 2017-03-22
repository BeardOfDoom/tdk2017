package utils;

import antlr.SMLLexer;
import antlr.SMLParser;
import antlr.SMLParser.Dimension_partContext;
import antlr.SMLParser.Matrix_referenceContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.impl.BaseVisitor;
import antlr.impl.ErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import representation.ParameterRepresentation;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;
import representation.state.StateRepresentation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class CommonUtils {

    private CommonUtils() {
    }

    public static ProjectRepresentation processInputFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ANTLRInputStream input = new ANTLRInputStream(reader);
        SMLLexer lexer = new SMLLexer(input);
        lexer.addErrorListener(new ErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SMLParser parser = new SMLParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.expr();

        BaseVisitor baseVisitor = new BaseVisitor();
        baseVisitor.visit(tree);

        StateRepresentation stateRepresentation = baseVisitor.getStateRepresentation();
        List<OperatorRepresentation> operatorRepresentations = baseVisitor
                .getOperatorRepresentations();


        return new ProjectRepresentation(true, stateRepresentation, operatorRepresentations);
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
        System.out.println(new File(directoryName + "\\" + packageName.replace(".", "\\") + "\\" + fileName + ".java").getAbsolutePath());
        return new File(directoryName + "\\" + packageName.replace(".", "\\") + "\\" + fileName + ".java").getAbsolutePath();
    }

}