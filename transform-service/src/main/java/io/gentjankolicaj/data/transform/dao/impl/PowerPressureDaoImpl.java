package io.gentjankolicaj.data.transform.dao.impl;

import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.transform.dao.RedisDao;
import io.gentjankolicaj.data.transform.exception.RedisDaoException;
import io.lettuce.core.api.StatefulRedisConnection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class PowerPressureDaoImpl implements RedisDao<Long, PowerPressure> {
    private StatefulRedisConnection<Long, PowerPressure> connection;

    public PowerPressureDaoImpl() {
        this.connection = getConnection();
    }

    @Override
    public PowerPressure find(Long key) throws RedisDaoException {
        return connection.sync().get(key);
    }

    @Override
    public Long save(Long key, PowerPressure value) throws RedisDaoException {
        return connection.sync().sadd(key, value);
    }

    @Override
    public Long decodeKey(ByteBuffer byteBuffer) {
        try {
            byte[] array = new byte[byteBuffer.remaining()];
            byteBuffer.get(array);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
            return ois.readLong();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PowerPressure decodeValue(ByteBuffer byteBuffer) {
        try {
            byte[] array = new byte[byteBuffer.remaining()];
            byteBuffer.get(array);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
            return (PowerPressure) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ByteBuffer encodeKey(Long aLong) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(aLong);
            return ByteBuffer.wrap(bos.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ByteBuffer encodeValue(PowerPressure powerPressure) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(powerPressure);
            return ByteBuffer.wrap(bos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
