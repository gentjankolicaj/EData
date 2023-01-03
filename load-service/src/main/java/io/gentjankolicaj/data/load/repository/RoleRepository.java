package io.gentjankolicaj.data.load.repository;

import io.gentjankolicaj.data.load.common.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}