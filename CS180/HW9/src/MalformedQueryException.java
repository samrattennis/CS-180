/**
 * Created by Samrat on 11/7/16.
 */
public class MalformedQueryException extends Exception {
    public MalformedQueryException() {
    }

    public MalformedQueryException(String message) {
        super(message);
    }

    public MalformedQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedQueryException(Throwable cause) {
        super(cause);
    }

    public MalformedQueryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
