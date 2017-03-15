package hu.david.veres.graph.exception.result;

public abstract class ResultValidationException extends Exception {

    public ResultValidationException() {
    }

    public ResultValidationException(String message) {
        super(message);
    }

}
