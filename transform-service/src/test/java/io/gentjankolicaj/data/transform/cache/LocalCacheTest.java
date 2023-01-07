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

class LocalCacheTest {

    static LocalCache localCache;

    @BeforeAll
    static void setup() {
        localCache = LocalCache.getInstance();
    }

    @Test
    void initCaches() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCache.initCaches(applicationConfigYaml.getCaches());

    }

    @Test
    void clearCaches() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCache.initCaches(applicationConfigYaml.getCaches());
        localCache.clearCaches();
    }

    @Test
    void close() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        localCache.initCaches(applicationConfigYaml.getCaches());
        localCache.closePool();
    }

    @Test
    void get() throws Exception {
        ApplicationConfigYaml applicationConfigYaml = Application.getConfigurationYaml();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(applicationConfigYaml.getCaches()));
        String nasaCacheKey = "nasa-cache";
        localCache.initCaches(applicationConfigYaml.getCaches());

        Cache<String, Cacheable> nasaCache = localCache.getCache(nasaCacheKey);
        String sValue = "Hello World";
        Double dValue = Double.valueOf(3.14);
        Long lValue = Long.valueOf(1);

        nasaCache.put("String", new CacheableString(sValue));
        nasaCache.put("Long", new CacheableLong(lValue));
        nasaCache.put("Double", new CacheableDouble(dValue));

        Assertions.assertTrue(nasaCache.get("String").getValue() == sValue);
        Assertions.assertTrue(nasaCache.get("Double").getValue() == dValue);
        Assertions.assertTrue(nasaCache.get("Long").getValue() == lValue);

        localCache.closePool();
    }
}