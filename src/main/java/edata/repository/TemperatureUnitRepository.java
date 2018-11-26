package edata.repository;

import edata.common.domain.TemperatureUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemperatureUnitRepository extends CrudRepository<TemperatureUnit,String> {

    List<TemperatureUnit> findTemperatureUnitByUnitNameLike(String unitName);
}
