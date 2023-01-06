package io.gentjankolicaj.data.transform.dao;

import io.gentjankolicaj.data.transform.exception.RedisDaoException;
import io.gentjankolicaj.data.transform.redis.RedisManager;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;

public interface RedisDao<K, V> extends RedisCodec<K, V> {

    V find(K key) throws RedisDaoException;

    Long save(K key, V value) throws RedisDaoException;

    default StatefulRedisConnection<K, V> getConnection() {
        return RedisManager.getInstance().getRedisClient().connect(this);
    }
}
