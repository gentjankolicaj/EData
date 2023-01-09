package io.gentjankolicaj.app.edata.load.repository.nasa.power;

import io.gentjankolicaj.app.edata.commons.domain.nasa.power.PowerPressure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerPressureRepository extends CrudRepository<PowerPressure, Long> {
}
