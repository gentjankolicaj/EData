package io.gentjankolicaj.data.load.repository;

import io.gentjankolicaj.data.commons.domain.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, String> {
}
