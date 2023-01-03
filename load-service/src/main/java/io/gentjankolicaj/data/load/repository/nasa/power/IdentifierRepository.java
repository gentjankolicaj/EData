package io.gentjankolicaj.data.load.repository.nasa.power;

import io.gentjankolicaj.data.load.common.domain.nasa.power.Identifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends CrudRepository<Identifier, String> {
}
