package io.gentjankolicaj.data.load.exception.api.request;

public class PowerTemperatureBadRequestException extends RuntimeException {

    public PowerTemperatureBadRequestException() {
    }

    public PowerTemperatureBadRequestException(String message) {
        super(message);
    }

    public PowerTemperatureBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PowerTemperatureBadRequestException(Throwable cause) {
        super(cause);
    }
}
