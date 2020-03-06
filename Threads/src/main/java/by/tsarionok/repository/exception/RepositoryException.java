package by.tsarionok.repository.exception;

/**
 * The Repository Exception class indicates that abnormal condition had
 * occurred in the Data Access Object application layer.
 *
 * @author Sergey Tsarionok
 */
public class RepositoryException extends Exception {

    public RepositoryException() {
        super();
    }

    public RepositoryException(final String message) {
        super(message);
    }

    public RepositoryException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).
     */
    public RepositoryException(final Throwable cause) {
        super(cause);
    }
}
