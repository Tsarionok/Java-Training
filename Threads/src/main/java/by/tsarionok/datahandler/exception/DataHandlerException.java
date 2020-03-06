package by.tsarionok.datahandler.exception;

public class DataHandlerException extends Exception {

    public DataHandlerException() {
        super();
    }

    public DataHandlerException(final String message) {
        super(message);
    }

    public DataHandlerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DataHandlerException(final Throwable cause) {
        super(cause);
    }
}
