package io.gentjankolicaj.app.edata.load.repository;

import io.gentjankolicaj.app.edata.commons.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, String> {
}
