/**
 * Created by Samrat on 11/7/16.
 */
public class WrongNumberOfQueriesException extends Exception {
    public WrongNumberOfQueriesException() {
    }

    public WrongNumberOfQueriesException(String message) {
        super(message);
    }

    public WrongNumberOfQueriesException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNumberOfQueriesException(Throwable cause) {
        super(cause);
    }

    public WrongNumberOfQueriesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
