package edata.repository;

import edata.common.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country,String> {

    List<Country> findCountriesByCountryNameLike(String countryName);
    List<Country>  findCountriesByPhonePrefixLike(String phonePrefix);
    List<Country>  findCountriesByIsoCodesLike(String isoCodes);
}
