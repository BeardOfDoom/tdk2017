package hu.david.veres.graph.exception.result;

public class NotUniqueNodeIdsException extends ResultValidationException {

    public NotUniqueNodeIdsException() {
    }

    public NotUniqueNodeIdsException(String message) {
        super(message);
    }

}
