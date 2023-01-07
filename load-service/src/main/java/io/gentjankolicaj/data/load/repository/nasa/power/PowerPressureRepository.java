package io.gentjankolicaj.data.load.repository.nasa.power;

import io.gentjankolicaj.data.commons.domain.PressureUnit;
import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.commons.domain.nasa.power.Identifier;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerPressureRepository extends CrudRepository<PowerPressure, Long> {

    List<PowerPressure> findPowerPressuresByValueLessThan(Float value);

    List<PowerPressure> findPowerPressuresByValueGreaterThan(Float value);

    List<PowerPressure> findPowerPressuresByPressureUnit(PressureUnit pressureUnit);

    List<PowerPressure> findPowerPressuresByUser(User user);

    List<PowerPressure> findPowerPressuresByUrlLike(String url);

    List<PowerPressure> findPowerPressuresByIdentifier(Identifier identifier);


}