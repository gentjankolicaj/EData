package io.gentjankolicaj.data.load.repository.nasa.power;

import io.gentjankolicaj.data.commons.domain.TemperatureUnit;
import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.commons.domain.nasa.power.Identifier;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerTemperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerTemperatureRepository extends CrudRepository<PowerTemperature, Long> {

    List<PowerTemperature> findPowerTemperaturesByValueLessThan(Float value);

    List<PowerTemperature> findPowerTemperaturesByValueGreaterThan(Float value);

    List<PowerTemperature> findPowerTemperaturesByTemperatureUnit(TemperatureUnit temperatureUnit);

    List<PowerTemperature> findPowerTemperaturesByUser(User user);

    List<PowerTemperature> findPowerTemperaturesByUrlLike(String url);

    List<PowerTemperature> findPowerTemperaturesByIdentifier(Identifier identifier);


}
