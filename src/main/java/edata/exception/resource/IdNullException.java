package edata.exception.resource;

public class IdNullException extends RuntimeException {

    public IdNullException() {
    }

    public IdNullException(String message) {
        super(message);
    }

    public IdNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdNullException(Throwable cause) {
        super(cause);
    }
}
