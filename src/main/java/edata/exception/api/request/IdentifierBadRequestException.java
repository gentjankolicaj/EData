package edata.exception.api.request;

public class IdentifierBadRequestException extends RuntimeException {

    public IdentifierBadRequestException() {
    }

    public IdentifierBadRequestException(String message) {
        super(message);
    }

    public IdentifierBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdentifierBadRequestException(Throwable cause) {
        super(cause);
    }
}
