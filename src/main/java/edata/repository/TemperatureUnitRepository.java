package edata.repository;

import edata.common.domain.TemperatureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperatureUnitRepository extends CrudRepository<TemperatureUnit,String> {

    List<TemperatureUnit> findTemperatureUnitByUnitNameLike(String unitName);
}
