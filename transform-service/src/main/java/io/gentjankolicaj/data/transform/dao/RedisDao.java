package io.gentjankolicaj.data.transform.dao;

import io.gentjankolicaj.data.transform.exception.RedisDaoException;
import io.gentjankolicaj.data.transform.redis.RedisManager;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.RedisCodec;

public interface RedisDao<K, V> {

    V find(K key) throws RedisDaoException;

    Long save(K key, V value) throws RedisDaoException;

    Long delete(K key) throws RedisDaoException;

    default StatefulRedisConnection<K, V> getConnection(RedisCodec<K, V> codec) {
        return RedisManager.getInstance().getRedisClient().connect(codec);
    }
}
