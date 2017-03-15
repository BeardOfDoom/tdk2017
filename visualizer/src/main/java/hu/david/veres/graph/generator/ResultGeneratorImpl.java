package hu.david.veres.graph.generator;

import hu.david.veres.graph.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
@Scope("prototype")
public class ResultGeneratorImpl implements ResultGenerator {

    private static final String DELIMITER_PIPE = "\\|";
    private static final String DELIMITER_SPACE = " ";

    private static final String LABEL_INFO = "info";
    private static final String LABEL_NODES = "nodes";
    private static final String LABEL_OPERATORS = "operators";
    private static final String LABEL_CONNECTIONS = "connections";
    private static final String LABEL_STEPS = "steps";
    private static final String LABEL_SOLUTION = "solution";

    private static final int STATE_EMPTY = 0;
    private static final int STATE_INFO = 1;
    private static final int STATE_NODES = 2;
    private static final int STATE_OPERATORS = 3;
    private static final int STATE_CONNECTIONS = 4;
    private static final int STATE_STEPS = 5;
    private static final int STATE_SOLUTION = 6;

    private int state;
    private Result result;

    @Override
    public Result generate(MultipartFile file) throws IOException {

        result = new Result();

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {

            switch (line) {
                case LABEL_INFO:
                    state = STATE_INFO;
                    processInfos(reader);
                    break;
                case LABEL_NODES:
                    state = STATE_NODES;
                    break;
                case LABEL_OPERATORS:
                    state = STATE_OPERATORS;
                    break;
                case LABEL_CONNECTIONS:
                    state = STATE_CONNECTIONS;
                    break;
                case LABEL_STEPS:
                    state = STATE_STEPS;
                    // the first line contains the start node id
                    result.getInfo().setStartNodeId(Integer.parseInt(reader.readLine()));
                    break;
                case LABEL_SOLUTION:
                    state = STATE_SOLUTION;
                    break;
                default:
                    processLine(line);
                    break;
            }

        }

        reader.close();

        return result;

    }

    private void processLine(String line) {

        switch (state) {
            case STATE_EMPTY:
                break;
            case STATE_INFO:
                break;
            case STATE_NODES:
                processNode(line);
                break;
            case STATE_OPERATORS:
                processOperator(line);
                break;
            case STATE_CONNECTIONS:
                processConnection(line);
                break;
            case STATE_STEPS:
                processSteps(line);
                break;
            case STATE_SOLUTION:
                processSolution(line);
                break;
        }

    }

    private void processInfos(BufferedReader reader) throws IOException {

        String searchAlgorithmName = reader.readLine();
        result.getInfo().setSearchAlgorithmName(searchAlgorithmName);

        String lowerCase = searchAlgorithmName.toLowerCase();
        if (lowerCase.contains("backtrack")) {
            result.getInfo().setSearchAlgorithmType("backtrack");
        } else {
            result.getInfo().setSearchAlgorithmType("tree");
        }

    }

    private void processNode(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Node node = new Node();
        node.setId(parts[0]);
        node.setInformation(parts[1]);

        result.getNodes().add(node);

    }

    private void processOperator(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Operator operator = new Operator();
        operator.setId(parts[0]);
        operator.setInformation(parts[1]);

        result.getOperators().add(operator);

    }

    private void processConnection(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        Connection connection = new Connection();
        connection.setSource(parts[0]);
        connection.setTarget(parts[1]);
        connection.setOperatorId(parts[2]);

        result.getConnections().add(connection);

    }

    private void processSteps(String line) {

        /*
        String[] parts = line.split(DELIMITER_SPACE);

        List<Integer> steps = Arrays.stream(parts).map(Integer::valueOf).collect(Collectors.toList());

        result.setSteps(steps);
        */

        // TODO: !!!!
        String searchAlgorithmType = result.getInfo().getSearchAlgorithmType();
        switch (searchAlgorithmType) {
            case "backtrack":
                processBacktrackStep(line);
                break;
            case "tree":
                processTreeStep(line);
                break;
        }

    }

    private void processBacktrackStep(String line) {

        String[] parts = line.split(DELIMITER_SPACE);

        BacktrackStep step = new BacktrackStep();

        if (parts.length == 2) {

            step.setBack(false);
            step.setOperatorId(parts[0]);
            step.setNodeId(parts[1]);

        } else if (parts.length == 3) {

            step.setBack(true);
            step.setOperatorId(parts[1]);
            step.setNodeId(parts[2]);

        }

        result.getSteps().add(step);

    }

    private void processTreeStep(String line) {

        String[] parts = line.split(DELIMITER_PIPE);

        TreeStep step = new TreeStep();

        if (!parts[0].equals("[]")) {
            step.setOpenedOperatorIds(Arrays.asList(parts[0].substring(1, parts[0].length() - 1).split(", ")));
        }
        if (!parts[1].equals("[]")) {
            step.setOpenedNodeIds(Arrays.asList(parts[1].substring(1, parts[1].length() - 1).split(", ")));
        }
        step.setOperatorId(parts[2]);
        step.setNodeId(parts[3]);

        result.getSteps().add(step);

    }

    private void processSolution(String line) {

        String[] parts = line.split(DELIMITER_SPACE);

        // List<Integer> solution = Arrays.stream(parts).map(Integer::valueOf).collect(Collectors.toList());

        result.setSolution(Arrays.asList(parts));

    }

}
