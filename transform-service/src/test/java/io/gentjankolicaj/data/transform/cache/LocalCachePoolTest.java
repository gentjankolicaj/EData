package io.gentjankolicaj.data.transform.cache;

import io.gentjankolicaj.data.transform.Application;
import io.gentjankolicaj.data.transform.cache.types.CacheableDouble;
import io.gentjankolicaj.data.transform.cache.types.CacheableLong;
import io.gentjankolicaj.data.transform.cache.types.CacheableString;
import io.gentjankolicaj.data.transform.yaml.ApplicationConfigYaml;
import org.apache.commons.collections4.CollectionUtils;
import org.ehcache.Cache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class LocalCachePoolTest {

    static LocalCachePool localCachePool;

    @BeforeAll
    static void setup() {
        localCachePool = LocalCachePool.getInstance();
    }

    @Test
    void initCaches() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCachePool.initCaches(applicationConfigYaml.getCaches());

    }

    @Test
    void clearCaches() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCachePool.initCaches(applicationConfigYaml.getCaches());
        localCachePool.clearCaches();
    }

    @Test
    void close() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCachePool.initCaches(applicationConfigYaml.getCaches());
        localCachePool.closePool();
    }

    @Test
    void get() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        String nasaCacheKey = "nasa-cache";
        localCachePool.initCaches(applicationConfigYaml.getCaches());

        Cache<Long, List<? extends Cacheable>> nasaCache = localCachePool.getCache(nasaCacheKey);
        String sValue = "Hello World";
        Double dValue = Double.valueOf(3.14);
        Long lValue = Long.valueOf(1);

        nasaCache.put(1L, List.of(new CacheableString(sValue)));
        nasaCache.put(2L, List.of(new CacheableLong(lValue)));
        nasaCache.put(3L, List.of(new CacheableDouble(dValue)));

        Assertions.assertTrue(nasaCache.get(1L).get(1).getValue() == sValue);
        Assertions.assertTrue(nasaCache.get(2L).get(1).getValue() == lValue);
        Assertions.assertTrue(nasaCache.get(3L).get(1).getValue() == dValue);

        localCachePool.closePool();
    }
}