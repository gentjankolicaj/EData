package io.gentjankolicaj.app.edata.transform.dao.impl;

import io.gentjankolicaj.app.edata.commons.domain.PressureUnit;
import io.gentjankolicaj.app.edata.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.app.edata.commons.exception.YamlException;
import io.gentjankolicaj.app.edata.transform.dao.PowerPressureDao;
import io.gentjankolicaj.app.edata.transform.redis.RedisManager;
import io.gentjankolicaj.app.edata.transform.yaml.RedisConfigYml;
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
class PowerPressureDaoImplTest {

    @Container
    public GenericContainer redisContainer = new GenericContainer(DockerImageName.parse("redis:7.0.7")).withExposedPorts(6379);

    PowerPressureDao powerPressureDao;

    @BeforeEach
    void setUp() throws YamlException {
        RedisManager.getInstance().initClient(new RedisConfigYml(redisContainer.getHost(), redisContainer.getFirstMappedPort(), null, false, null, 10000));
        powerPressureDao = new PowerPressureDaoImpl();
    }

    @AfterEach
    void tearDown() {
        RedisManager.getInstance().closeClient();
    }

    @Test
    void find() {
        PowerPressure powerPressure = powerPressureDao.find(1L);
        Assertions.assertThat(powerPressure).isNull();
    }

    @Test
    void save() {
        PowerPressure writePowerPressure = new PowerPressure(101L, 3.14f, new PressureUnit("PA", "pascal", "Pressure unit"), LocalDate.now(), "object");
        Assertions.assertThat(powerPressureDao.save(101L, writePowerPressure)).isEqualTo(1);

        Assertions.assertThat(powerPressureDao.delete(101L)).isEqualTo(1);

        PowerPressure powerPressure = powerPressureDao.find(101L);
        Assertions.assertThat(powerPressure).isNull();
    }

    @Test
    void delete() {
    }
}