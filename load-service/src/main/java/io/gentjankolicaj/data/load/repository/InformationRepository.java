package io.gentjankolicaj.data.load.repository;

import io.gentjankolicaj.data.load.common.domain.Information;
import org.springframework.data.repository.CrudRepository;

public interface InformationRepository extends CrudRepository<Information, Long> {
}
