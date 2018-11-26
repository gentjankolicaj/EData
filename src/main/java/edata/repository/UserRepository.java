package edata.repository;

import edata.common.domain.Country;
import edata.common.domain.Gender;
import edata.common.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByPassword(String password);

    List<User> findUsersByUsernameLike(String username);
    List<User> findUsersByEmailLike(String email);
    List<User> findUsersByFirstNameLike(String firstName);
    List<User> findUsersByLastNameLike(String lastName);
    List<User> findUsersByGenderLike(Gender gender);
    List<User> findUsersByCountryLike(Country country);

}
