package io.gentjankolicaj.data.transform.http.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.HttpConnection;

import java.net.SocketTimeoutException;

@Slf4j
public class CustomExceptionListener implements org.apache.hc.core5.http.ExceptionListener {
    @Override
    public void onError(Exception ex) {
        log.error("HttpServer error", ex);
    }

    @Override
    public void onError(HttpConnection connection, Exception ex) {
        if (ex instanceof SocketTimeoutException) {
            log.error("Socket timeout.", ex);
        } else if (ex instanceof ConnectionClosedException) {
            log.error("Connection closed.", ex);
        } else {
            log.error("HttpServer error ", ex);
        }
    }
}
