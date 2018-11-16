package edata.repository;

import edata.common.domain.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,String> {
}
