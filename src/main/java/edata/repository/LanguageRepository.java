package edata.repository;

import edata.common.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language,String> {
}
