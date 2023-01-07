package io.gentjankolicaj.data.transform.http.request;

import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.commons.util.JsonUtils;
import io.gentjankolicaj.data.transform.cache.Cacheable;
import io.gentjankolicaj.data.transform.cache.LocalCachePool;
import io.gentjankolicaj.data.transform.yaml.HttpPathConfigYaml;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.ehcache.Cache;

import java.io.IOException;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
public final class JobHttpRequestHandler implements HttpRequestHandler {

    private final HttpPathConfigYaml httpPathConfigYaml;
    private final Cache<Long, List<? extends Cacheable>> cache;

    public JobHttpRequestHandler(final HttpPathConfigYaml httpPathConfigYaml) {
        this.httpPathConfigYaml = httpPathConfigYaml;
        this.cache = LocalCachePool.getInstance().getCache(httpPathConfigYaml.getCacheKey());
    }

    @Override
    public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context) throws HttpException, IOException {
        if (isNull(cache)) {
            log.info("Http request received & not cached.{}", request);
        } else {
            try {
                if (!request.getMethod().equalsIgnoreCase(httpPathConfigYaml.getMethod())) {
                    log.warn("Http request received & method not impl.");
                } else {
                    if (request.getUri().getPath().equals("/api/v1/nasa/temperature")) {
                        PowerTemperature powerTemperature = JsonUtils.readAsString(EntityUtils.toString(request.getEntity()), PowerTemperature.class);
                        log.info("Http request received & cached.{} , {}", request, powerTemperature);
                    } else if (request.getUri().getPath().equals("/api/v1/nasa/pressure")) {
                        PowerPressure powerPressure = JsonUtils.readAsString(EntityUtils.toString(request.getEntity()), PowerPressure.class);
                        log.info("Http request received & cached.{} , {}", request, powerPressure);
                    }
                }
            } catch (Exception e) {
                log.error("Http request handle error.", e);
            }
        }
    }
}
