package edata.exception.api.request;

public class PressureUnitBadRequestException extends RuntimeException {

    public PressureUnitBadRequestException() {
    }

    public PressureUnitBadRequestException(String message) {
        super(message);
    }

    public PressureUnitBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PressureUnitBadRequestException(Throwable cause) {
        super(cause);
    }
}
