package edata.repository.nasa.power;

import edata.common.domain.nasa.power.PowerTemperature;
import org.springframework.data.repository.CrudRepository;

public interface PowerTemperatureRepository extends CrudRepository<PowerTemperature,Long> {
}
