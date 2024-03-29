package io.gentjankolicaj.app.edata.load.repository;

import io.gentjankolicaj.app.edata.commons.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}
