package edata.exception.api.request;

public class UserBadRequestException extends RuntimeException {

    public UserBadRequestException() {
    }

    public UserBadRequestException(String message) {
        super(message);
    }

    public UserBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserBadRequestException(Throwable cause) {
        super(cause);
    }
}
