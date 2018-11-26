package edata.repository.nasa.power;

import edata.common.domain.DataFormat;
import edata.common.domain.TemperatureUnit;
import edata.common.domain.User;
import edata.common.domain.nasa.power.Identifier;
import edata.common.domain.nasa.power.PowerTemperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PowerTemperatureRepository extends CrudRepository<PowerTemperature,Long> {

    List<PowerTemperature> findPowerTemperaturesByValueLessThan(Float value);
    List<PowerTemperature> findPowerTemperaturesByValueGreaterThan(Float value);
    List<PowerTemperature> findPowerTemperaturesByTemperatureUnit(TemperatureUnit temperatureUnit);

    List<PowerTemperature> findPowerTemperaturesByUser(User user);
    List<PowerTemperature> findPowerTemperaturesByStartDateAfter(Date startDate);
    List<PowerTemperature> findPowerTemperaturesByEndDateBefore(Date endDate);
    List<PowerTemperature> findPowerTemperaturesByUrlLike(String url);
    List<PowerTemperature> findPowerTemperaturesByIdentifier(Identifier identifier);
    List<PowerTemperature> findPowerTemperaturesByRawDataFormat(DataFormat dataFormat);
}
