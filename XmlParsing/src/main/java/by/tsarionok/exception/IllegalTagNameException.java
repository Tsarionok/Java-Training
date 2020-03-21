package by.tsarionok.exception;

public class IllegalTagNameException extends Exception {
    public IllegalTagNameException() {
        super();
    }

    public IllegalTagNameException(String message) {
        super(message);
    }

    public IllegalTagNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTagNameException(Throwable cause) {
        super(cause);
    }
}
