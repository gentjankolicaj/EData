package io.gentjankolicaj.data.transform.redis;

import io.gentjankolicaj.data.commons.exception.YamlException;
import io.gentjankolicaj.data.transform.yaml.RedisConfigYml;
import io.lettuce.core.RedisClient;
import org.apache.commons.lang3.StringUtils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RedisManager {

    private static final RedisManager INSTANCE = new RedisManager();
    private RedisClient redisClient;


    private RedisManager() {
    }

    public static RedisManager getInstance() {
        return INSTANCE;
    }

    static RedisUriBuilder urlBuilder() {
        return new RedisUriBuilder();
    }

    public void initClient(RedisConfigYml redisConfigYml) throws YamlException {
        if (isNull(redisConfigYml))
            throw new YamlException("Error YAML redis config.");
        if (isNull(redisClient)) {
            this.redisClient = RedisClient.create(urlBuilder().redisConfigYml(redisConfigYml).build());
        }
    }

    public void close(RedisConfigYml redisConfigYml) {
        if (nonNull(redisClient)) {
            this.redisClient.close();
        }
    }

    public RedisClient getRedisClient() {
        return redisClient;
    }

    static class RedisUriBuilder {
        private RedisConfigYml redisConfigYml;

        RedisUriBuilder() {
        }

        public RedisUriBuilder redisConfigYml(RedisConfigYml redisConfigYml) {
            this.redisConfigYml = redisConfigYml;
            return this;
        }

        public String build() {
            StringBuilder sb = new StringBuilder();
            sb.append(redisConfigYml.isUseSSL() ? "rediss://" : "redis://");
            sb.append(StringUtils.isNotEmpty(redisConfigYml.getPassword()) ? redisConfigYml.getPassword() : "");
            sb.append(StringUtils.isNotEmpty(redisConfigYml.getHost()) ? redisConfigYml.getHost() : "");
            sb.append(":").append(redisConfigYml.getPort());
            sb.append("/").append(redisConfigYml.getDatabaseNumber());
            return sb.toString();
        }
    }
}
