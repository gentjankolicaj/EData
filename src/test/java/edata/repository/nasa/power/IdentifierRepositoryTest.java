package edata.repository.nasa.power;

import edata.common.domain.nasa.power.Identifier;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IdentifierRepositoryTest {

    @Autowired
    private IdentifierRepository identifierRepository;

    @Test
    @Rollback
    public void create() throws Exception {
        Identifier identifier=new Identifier();
        identifier.setIdentifier("SINGLE_POINT");

       Identifier savedIdentifier= identifierRepository.save(identifier);

       assertEquals(identifier.getIdentifier(),savedIdentifier.getIdentifier());
    }

    @Test
    @Rollback
    public void createAll() throws Exception {
        Identifier singlePoint=new Identifier();
       singlePoint.setIdentifier("SINGLE_POINT");

        Identifier regional=new Identifier();
       regional.setIdentifier("REGIONAL");

       Identifier global=new Identifier();
       global.setIdentifier("GLOBAL");

       List<Identifier> list= Arrays.asList(singlePoint,regional,global);
       List<Identifier> returnedList=new ArrayList<>(list.size());

      Iterable<Identifier> savedIterable=identifierRepository.saveAll(list);

      for(Identifier identifier:savedIterable){
          returnedList.add(identifier);
      }

      assertEquals(list.size(),returnedList.size());
    }


    @Test
    @Rollback
    public void readById() throws Exception {

        String id="SINGLE_POINT";

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier(id);

        identifierRepository.save( singlePoint);

       Optional<Identifier> optional=identifierRepository.findById(id);

       if(!optional.isPresent()){
           throw new Exception("Identifier with id "+id+" not found.");
       }

    }

    @Test
    @Rollback
    public void readAll() throws Exception {
       Iterable<Identifier> iterable=identifierRepository.findAll();

       for(Identifier identifier:iterable){
           System.out.println(identifier.getIdentifier());
       }

    }

    @Test
    @Rollback
    public void update() throws Exception{


    }

    @Test
    @Rollback
    public void delete()throws Exception {

        String id="SINGLE_POINT";

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier(id);

        identifierRepository.save( singlePoint);

        identifierRepository.delete(singlePoint);

        Optional<Identifier> optional=identifierRepository.findById(id);

        if(optional.isPresent()){
            throw new Exception("Identifier with id "+id+" not deleted");
        }

    }

    @Test
    @Rollback
    public void deleteAll()throws Exception {

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        Identifier regional=new Identifier();
        regional.setIdentifier("REGIONAL");

        Identifier global=new Identifier();
        global.setIdentifier("GLOBAL");

        List<Identifier> list= Arrays.asList(singlePoint,regional,global);

        identifierRepository.deleteAll();

        Iterable<Identifier> iterable=identifierRepository.findAll();

       int i= IterableUtils.size(iterable);

        if(i!=0){
            throw new Exception("Records not deleted all.");
        }
    }
}