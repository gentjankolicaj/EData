package edata.repository.nasa.power;

import edata.common.domain.DataFormat;
import edata.common.domain.Gender;
import edata.common.domain.PressureUnit;
import edata.common.domain.User;
import edata.common.domain.nasa.power.Identifier;
import edata.common.domain.nasa.power.PowerPressure;
import edata.repository.PressureUnitRepository;
import edata.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PowerPressureRepositoryTest {

    @Autowired
    private PowerPressureRepository powerPressureRepository;

    @Autowired
    private PressureUnitRepository pressureUnitRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback
    public void create() throws Exception{
        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);
        powerPressureRepository.save(powerPressure);

        System.out.println(powerPressure);
    }



    @Test
    @Rollback
    public void createAll() throws Exception{
        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

        PowerPressure powerPressure2=new PowerPressure();
        powerPressure.setValue(132f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("2https://localhost.com/");

        powerPressure2.setUser(user);

        PowerPressure powerPressure3=new PowerPressure();
        powerPressure.setValue(122f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("3333https://localhost.com/");

        powerPressure3.setUser(user);

        List<PowerPressure> list= Arrays.asList(powerPressure,powerPressure2,powerPressure3);

        powerPressureRepository.saveAll(list);

        System.out.println(powerPressure);
    }

    @Test
    @Rollback
    public void readById()throws Exception {
        Long id=3L;

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

        powerPressureRepository.save(powerPressure);

       Optional<PowerPressure> optional=powerPressureRepository.findById(id);
       if(!optional.isPresent()){
           throw new RuntimeException("Power pressure  data with id"+id+" not found.");
       }else{
           assertEquals(optional.get().getId(),powerPressure.getId());
       }
    }

    @Test
    @Rollback
    public void readAll() throws Exception{
        Long id=3L;

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

        powerPressureRepository.save(powerPressure);

      Iterable<PowerPressure> iterable=powerPressureRepository.findAll();

      int i= IterableUtils.size(iterable);
      if(i<=0){
          throw new RuntimeException("List size returned not expected,should be more elements");
      }
    }

    @Test
    @Rollback
    public void update() throws Exception{
        Long id=3L;

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

       PowerPressure initialSave= powerPressureRepository.save(powerPressure);

        powerPressure.setUser(user);
        powerPressure.setValue(123f);

        powerPressure.setDate(new Date());
        powerPressure.setRawDataFormat(new DataFormat("txt"));
        powerPressure.setUrl("https://localhost.org/");

        PowerPressure secondarySave=powerPressureRepository.save(powerPressure);

        assertNotEquals(initialSave.getId(),secondarySave.getId());
        assertNotEquals(initialSave.getUrl(),secondarySave.getUrl());
    }

    @Test
    @Rollback
    public void delete() throws Exception{
        Long id=3L;

        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

        powerPressureRepository.save(powerPressure);

       Optional<PowerPressure> optional=powerPressureRepository.findById(id);

       if(optional.isPresent()){
           throw new RuntimeException("Power pressure data with id "+id+" is found,it shouldn't be found because is deleted.");
       }
    }

    @Test
    @Rollback
    public void deleteAll() throws Exception{
        Identifier singlePoint=new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit=new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user=new User();
        user.setFirstName("James");
        user.setLastName("Bond");
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setBirthplace("London,UK");
        user.setEmail("jamesbond@m16.com");
        user.setGender(Gender.M);
        user.setRights("CREATE,UPDATE,DELETE,READ");
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        userRepository.save(user);

        PowerPressure powerPressure=new PowerPressure();
        powerPressure.setValue(12f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());

        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("https://localhost.com/");

        powerPressure.setUser(user);

        PowerPressure powerPressure2=new PowerPressure();
        powerPressure.setValue(132f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("2https://localhost.com/");

        powerPressure2.setUser(user);

        PowerPressure powerPressure3=new PowerPressure();
        powerPressure.setValue(122f);
        powerPressure.setIdentifier(singlePoint);
        powerPressure.setDate(new Date());
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat(new DataFormat("json"));
        powerPressure.setUrl("3333https://localhost.com/");

        powerPressure3.setUser(user);

        List<PowerPressure> list= Arrays.asList(powerPressure,powerPressure2,powerPressure3);

        powerPressureRepository.saveAll(list);

        powerPressureRepository.deleteAll();

       Iterable<PowerPressure> iterable=powerPressureRepository.findAll();

       int size=IterableUtils.size(iterable);

       if(size>=1){
           throw new RuntimeException("There should be not elements left because deleteAll() method is invoked.");
       }

    }

}