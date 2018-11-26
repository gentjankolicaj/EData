package edata.repository;

import edata.common.domain.DataFormat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFormatRepository extends CrudRepository<DataFormat,String> {
}
