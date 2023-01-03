package io.gentjankolicaj.data.load.repository;

import io.gentjankolicaj.data.load.common.domain.Country;
import io.gentjankolicaj.data.load.common.domain.Gender;
import io.gentjankolicaj.data.load.common.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByPassword(String password);
    Optional<User> findUserByEmailAndPassword(String email,String password);

    List<User> findUsersByUsernameLike(String username);
    List<User> findUsersByEmailLike(String email);
    List<User> findUsersByFirstNameLike(String firstName);
    List<User> findUsersByLastNameLike(String lastName);
    List<User> findUsersByGenderLike(Gender gender);
    List<User> findUsersByCountryLike(Country country);

}
