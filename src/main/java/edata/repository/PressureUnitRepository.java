package edata.repository;

import edata.common.domain.PressureUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PressureUnitRepository extends CrudRepository<PressureUnit,String> {

    List<PressureUnit> findPressureUnitByUnitNameLike(String unitName);
}
