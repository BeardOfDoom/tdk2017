package hu.david.veres.graph.exception.file;

public abstract class FileValidationException extends Exception {

    public FileValidationException() {
    }

    public FileValidationException(String message) {
        super(message);
    }

    public abstract String getErrorMessage();

}
