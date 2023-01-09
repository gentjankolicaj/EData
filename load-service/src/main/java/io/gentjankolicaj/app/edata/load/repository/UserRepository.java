package io.gentjankolicaj.app.edata.load.repository;

import io.gentjankolicaj.app.edata.commons.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmailAndPassword(String email, String password);


}
