package edata.repository.nasa.power;

import edata.common.domain.nasa.power.Identifier;
import org.springframework.data.repository.CrudRepository;

public interface IdentifierRepository extends CrudRepository<Identifier,String> {
}
