package hu.david.veres.graph.exception.result;

public class EmptyConnectionListException extends ResultValidationException {

    public EmptyConnectionListException() {
    }

    public EmptyConnectionListException(String message) {
        super(message);
    }

}
