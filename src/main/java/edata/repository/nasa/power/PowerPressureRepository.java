package edata.repository.nasa.power;

import edata.common.domain.DataFormat;
import edata.common.domain.PressureUnit;
import edata.common.domain.User;
import edata.common.domain.nasa.power.Identifier;
import edata.common.domain.nasa.power.PowerPressure;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PowerPressureRepository extends CrudRepository<PowerPressure,Long> {

    List<PowerPressure> findPowerPressuresByValueLessThan(Float value);
    List<PowerPressure> findPowerPressuresByValueGreaterThan(Float value);
    List<PowerPressure> findPowerPressuresByPressureUnit(PressureUnit pressureUnit);

    List<PowerPressure>  findPowerPressuresByUser(User user);
    List<PowerPressure> findPowerPressuresByStartDateAfter(Date startDate);
    List<PowerPressure> findPowerPressuresByEndDateBefore(Date endDate);
    List<PowerPressure> findPowerPressuresByUrlLike(String url);
    List<PowerPressure> findPowerPressuresByIdentifier(Identifier identifier);
    List<PowerPressure> findPowerPressuresByRawDataFormat(DataFormat dataFormat);

}
