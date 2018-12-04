package edata.repository;

import edata.common.domain.Information;
import org.springframework.data.repository.CrudRepository;

public interface InformationRepository extends CrudRepository<Information,Long> {
}
