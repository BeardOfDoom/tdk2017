package hu.david.veres.graph.validator;

import hu.david.veres.graph.exception.result.ResultValidationException;
import hu.david.veres.graph.model.Result;
import org.springframework.stereotype.Component;

@Component
public class ResultValidatorImpl implements ResultValidator {

    @Override
    public void validate(Result result) throws ResultValidationException {

        /*
        if (result.getNodes().isEmpty()) {
            throw new EmptyNodeListException();
        }

        if (result.getConnections().isEmpty()) {
            throw new EmptyConnectionListException();
        }

        if (result.getSteps().isEmpty()) {
            throw new EmptyStepListException();
        }

        if (result.getSolution().isEmpty()) {
            throw new EmptySolutionListException();
        }

        if (!uniqueNodeIds(result.getNodes())) {
            throw new NotUniqueNodeIdsException();
        }

        if (!noLoopInConnections(result.getConnections())) {
            throw new LoopInConnectionsException();
        }

        if (!everyConnectionIsValid(result.getConnections(), result.getNodes())) {
            throw new InvalidConnectionException();
        }

        if (!everyStepIsValid(result.getSteps(), result.getNodes())) {
            throw new InvalidStepException();
        }

        if (!everySolutionStepIsValid(result.getSolution(), result.getNodes())) {
            throw new InvalidSolutionStepException();
        }
        */

    }

    /*
    private boolean uniqueNodeIds(List<Node> nodes) {

        List<Integer> idList = nodes.stream().map(Node::getId).collect(Collectors.toList());
        Set<Integer> idSet = new HashSet<>(idList);

        if (idList.size() != idSet.size()) return false;

        return true;

    }

    private boolean noLoopInConnections(List<Connection> connections) {

        for (Connection connection : connections) {
            if (connection.getSource() == connection.getTarget()) return false;
        }

        return true;

    }

    private boolean everyConnectionIsValid(List<Connection> connections, List<Node> nodes) {

        Set<Integer> connectionEndpointIds = new HashSet<>();
        for (Connection connection : connections) {
            connectionEndpointIds.add(connection.getSource());
            connectionEndpointIds.add(connection.getTarget());
        }

        Set<Integer> nodeIds = nodes.stream().map(Node::getId).collect(Collectors.toSet());

        for (Integer connectionEndpointId : connectionEndpointIds) {
            if (!nodeIds.contains(connectionEndpointId)) return false;
        }

        return true;

    }

    private boolean everyStepIsValid(List<Integer> steps, List<Node> nodes) {

        Set<Integer> nodeIds = nodes.stream().map(Node::getId).collect(Collectors.toSet());

        for (Integer step : steps) {
            if (!nodeIds.contains(step)) return false;
        }

        return true;

    }

    private boolean everySolutionStepIsValid(List<Integer> solution, List<Node> nodes) {

        Set<Integer> nodeIds = nodes.stream().map(Node::getId).collect(Collectors.toSet());

        for (Integer solutionStep : solution) {
            if (!nodeIds.contains(solutionStep)) return false;
        }

        return true;

    }
    */

}
