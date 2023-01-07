package io.gentjankolicaj.data.transform.http.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.IOException;

@Slf4j
public class PingRequestHandler implements HttpRequestHandler {
    @Override
    public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context) throws HttpException, IOException {
        log.info("HttpRequest received.{}", request);
        response.setCode(200);
        response.setEntity(new StringEntity("Successful request."));
    }
}
