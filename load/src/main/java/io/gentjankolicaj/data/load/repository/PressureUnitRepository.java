package io.gentjankolicaj.data.load.repository;

import io.gentjankolicaj.data.load.common.domain.PressureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PressureUnitRepository extends CrudRepository<PressureUnit,String> {

    List<PressureUnit> findPressureUnitByUnitNameLike(String unitName);
}
