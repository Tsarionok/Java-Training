package by.tsarionok.exception;

public class FileIsEmptyException extends Exception {
    public FileIsEmptyException() {
    }

    public FileIsEmptyException(String message) {
        super(message);
    }

    public FileIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIsEmptyException(Throwable cause) {
        super(cause);
    }
}
