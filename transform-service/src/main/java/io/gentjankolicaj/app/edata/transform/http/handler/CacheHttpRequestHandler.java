package io.gentjankolicaj.app.edata.transform.http.handler;

import io.gentjankolicaj.app.edata.commons.cache.Cacheable;
import io.gentjankolicaj.app.edata.transform.cache.LocalCachePool;
import io.gentjankolicaj.app.edata.transform.http.HttpConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.ehcache.Cache;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j
public class CacheHttpRequestHandler implements HttpRequestHandler {
    private LocalCachePool localCachePool;

    public CacheHttpRequestHandler() {
        this.localCachePool = LocalCachePool.getInstance();
    }

    @Override
    public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context) throws HttpException, IOException {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            String cacheKey = "";
            Header header = request.getHeader(HttpConstants.CACHE_HEADER.getValue());
            if (nonNull(header)) {
                cacheKey = header.getValue();
            }
            log.info("Cache key : {}", cacheKey);
            Cache<String, List<Cacheable>> cache = localCachePool.getCache(cacheKey);
            if (nonNull(cache)) {
                for (Iterator<Cache.Entry<String, List<Cacheable>>> it = cache.iterator(); it.hasNext(); ) {
                    Cache.Entry<String, List<Cacheable>> entry = it.next();
                    log.info("Cache key : {} | value : {}", entry.getKey(), entry.getValue());
                }
            }
        } else {
            log.warn("Not handled : {}", request);
        }
    }
}
