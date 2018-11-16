package edata.repository.nasa.power;

import edata.common.domain.nasa.power.PowerPressure;
import org.springframework.data.repository.CrudRepository;

public interface PowerPressureRepository extends CrudRepository<PowerPressure,Long> {
}
