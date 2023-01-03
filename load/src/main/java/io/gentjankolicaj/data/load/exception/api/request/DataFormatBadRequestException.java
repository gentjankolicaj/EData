package io.gentjankolicaj.data.load.exception.api.request;

public class DataFormatBadRequestException extends RuntimeException {

    public DataFormatBadRequestException() {
    }

    public DataFormatBadRequestException(String message) {
        super(message);
    }

    public DataFormatBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatBadRequestException(Throwable cause) {
        super(cause);
    }
}
