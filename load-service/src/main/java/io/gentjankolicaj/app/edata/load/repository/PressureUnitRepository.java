package io.gentjankolicaj.app.edata.load.repository;

import io.gentjankolicaj.app.edata.commons.domain.PressureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PressureUnitRepository extends CrudRepository<PressureUnit, String> {
    List<PressureUnit> findPressureUnitByUnitNameLike(String unitName);
}
