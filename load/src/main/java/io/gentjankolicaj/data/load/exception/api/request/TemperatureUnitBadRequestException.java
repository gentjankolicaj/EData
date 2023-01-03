package io.gentjankolicaj.data.load.exception.api.request;

public class TemperatureUnitBadRequestException extends RuntimeException {

    public TemperatureUnitBadRequestException() {
    }

    public TemperatureUnitBadRequestException(String message) {
        super(message);
    }

    public TemperatureUnitBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemperatureUnitBadRequestException(Throwable cause) {
        super(cause);
    }
}
