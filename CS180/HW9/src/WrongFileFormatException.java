/**
 * Created by Samrat on 11/7/16.
 */
public class WrongFileFormatException extends Exception {
    public WrongFileFormatException() {
    }

    public WrongFileFormatException(String message) {
        super(message);
    }

    public WrongFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongFileFormatException(Throwable cause) {
        super(cause);
    }

    public WrongFileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
