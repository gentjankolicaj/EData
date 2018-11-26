package edata.exception.api.request;

public class CountryBadRequestException extends RuntimeException {

    public CountryBadRequestException() {
    }

    public CountryBadRequestException(String message) {
        super(message);
    }

    public CountryBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryBadRequestException(Throwable cause) {
        super(cause);
    }
}
