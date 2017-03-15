package hu.david.veres.graph.exception.file;

public class FileIsEmptyException extends FileValidationException {

    private static final String ERROR_MESSAGE = "error.file.file.is.empty";

    public FileIsEmptyException() {
    }

    public FileIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
