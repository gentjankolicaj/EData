package io.gentjankolicaj.data.transform.cache;


import io.gentjankolicaj.data.commons.exception.YamlException;
import io.gentjankolicaj.data.transform.exception.LocalCacheException;
import io.gentjankolicaj.data.transform.yaml.CacheConfigYaml;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public final class LocalCachePool {

    private static final LocalCachePool INSTANCE = new LocalCachePool();
    private final CacheManager cacheManager;
    private Map<String, Cache<String, Cacheable>> cacheMap;

    private LocalCachePool() {
        this.cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        this.cacheManager.init();
    }

    public static LocalCachePool getInstance() {
        return INSTANCE;
    }

    public void initCaches(List<CacheConfigYaml> cacheConfigYamls) throws YamlException, LocalCacheException {
        if (CollectionUtils.isEmpty(cacheConfigYamls)) {
            throw new YamlException("Error cache YAML .Yaml empty");
        } else {
            if (MapUtils.isNotEmpty(this.cacheMap)) {
                throw new YamlException("Caches are already created.You have to close and re init again");
            }
            this.cacheMap = new ConcurrentHashMap<>();
            for (CacheConfigYaml cacheConfigYaml : cacheConfigYamls) {
                if (!this.cacheMap.containsKey(cacheConfigYaml.getKey())) {
                    try {
                        Cache<String, Cacheable> cache = cacheManager.createCache(cacheConfigYaml.getKey(), CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Cacheable.class, ResourcePoolsBuilder.heap(cacheConfigYaml.getSize()).build()).build());
                        this.cacheMap.put(cacheConfigYaml.getKey(), cache);
                        log.info("Cache '{}' details : {}", cacheConfigYaml.getKey(), cacheConfigYaml);
                    } catch (Exception e) {
                        log.error("Failed to create cache '{}' details : {}", cacheConfigYaml.getKey(), cacheConfigYaml, e);
                    }
                }
            }
        }
    }

    public void clearCaches() {
        this.cacheMap.forEach((k, v) -> v.clear());

    }

    public Cache<String, Cacheable> getCache(String key) {
        log.info("Getting cache '{}'", key);
        return this.cacheMap.get(key);
    }

    public void closePool() {
        clearCaches();
        cacheManager.close();
        log.info("Closed cache manager.");
    }
}
