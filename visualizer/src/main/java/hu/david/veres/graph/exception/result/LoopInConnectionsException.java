package hu.david.veres.graph.exception.result;

public class LoopInConnectionsException extends ResultValidationException {

    public LoopInConnectionsException() {
    }

    public LoopInConnectionsException(String message) {
        super(message);
    }

}
