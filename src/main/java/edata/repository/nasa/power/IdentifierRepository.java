package edata.repository.nasa.power;

import edata.common.domain.nasa.power.Identifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends CrudRepository<Identifier,String> {
}
