package edata.exception.api.request;

public class PowerPressureBadRequestException extends RuntimeException {

    public PowerPressureBadRequestException() {
    }

    public PowerPressureBadRequestException(String message) {
        super(message);
    }

    public PowerPressureBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PowerPressureBadRequestException(Throwable cause) {
        super(cause);
    }
}
