package io.gentjankolicaj.app.edata.load.repository;

import io.gentjankolicaj.app.edata.commons.domain.Information;
import org.springframework.data.repository.CrudRepository;

public interface InformationRepository extends CrudRepository<Information, Long> {
}
