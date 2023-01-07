package io.gentjankolicaj.data.transform.dao.impl;

import io.gentjankolicaj.data.commons.domain.TemperatureUnit;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerTemperature;
import io.gentjankolicaj.data.commons.exception.YamlException;
import io.gentjankolicaj.data.transform.dao.PowerTemperatureDao;
import io.gentjankolicaj.data.transform.redis.RedisManager;
import io.gentjankolicaj.data.transform.yaml.RedisConfigYml;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDate;


@Testcontainers
class PowerTemperatureDaoImplTest {

    @Container
    public GenericContainer redisContainer = new GenericContainer(DockerImageName.parse("redis:7.0.7")).withExposedPorts(6379);

    PowerTemperatureDao powerTemperatureDao;

    @BeforeEach
    void setUp() throws YamlException {
        RedisManager.getInstance().initClient(new RedisConfigYml(redisContainer.getHost(), redisContainer.getFirstMappedPort(), null, false, null, 1000));
        powerTemperatureDao = new PowerTemperatureDaoImpl();
    }

    @AfterEach
    void tearDown() {
        RedisManager.getInstance().closeClient();
    }

    @Test
    void find() {
        PowerTemperature powerTemperature = powerTemperatureDao.find(1L);
        Assertions.assertThat(powerTemperature).isNull();
    }

    @Test
    void save() {
        PowerTemperature writePowerTemperature = new PowerTemperature(101L, 3.14f, new TemperatureUnit("C", "Celsius", "Temperature unit"), LocalDate.now(), "object");
        Assertions.assertThat(powerTemperatureDao.save(101L, writePowerTemperature)).isEqualTo(1);

        Assertions.assertThat(powerTemperatureDao.delete(101L)).isEqualTo(1);

        PowerTemperature powerTemperature = powerTemperatureDao.find(101L);
        Assertions.assertThat(powerTemperature).isNull();
    }

    @Test
    void delete() {
    }
}