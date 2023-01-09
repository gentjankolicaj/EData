package io.gentjankolicaj.app.edata.transform.dao;

import io.gentjankolicaj.app.edata.commons.domain.nasa.power.PowerPressure;

public interface PowerPressureDao extends RedisDao<Long, PowerPressure> {
}
