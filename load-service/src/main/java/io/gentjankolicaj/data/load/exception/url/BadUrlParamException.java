package io.gentjankolicaj.data.load.exception.url;

public class BadUrlParamException extends RuntimeException {

    public BadUrlParamException() {
    }

    public BadUrlParamException(String message) {
        super(message);
    }

    public BadUrlParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadUrlParamException(Throwable cause) {
        super(cause);
    }
}
