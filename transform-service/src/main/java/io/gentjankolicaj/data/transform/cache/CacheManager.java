package io.gentjankolicaj.data.transform.cache;


import io.gentjankolicaj.data.commons.exception.YamlException;
import io.gentjankolicaj.data.transform.yaml.CacheConfigYaml;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class CacheManager {

    private static final CacheManager INSTANCE = new CacheManager();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return INSTANCE;
    }

    public void initCaches(List<CacheConfigYaml> cacheConfigYamls) throws YamlException {
        if (CollectionUtils.isEmpty(cacheConfigYamls)) {
            throw new YamlException("Error YAML cache config.Yaml empty");
        }
    }
}
