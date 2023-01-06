package io.gentjankolicaj.data.load.repository.nasa.power;

import io.gentjankolicaj.data.commons.domain.Gender;
import io.gentjankolicaj.data.commons.domain.PressureUnit;
import io.gentjankolicaj.data.commons.domain.User;
import io.gentjankolicaj.data.commons.domain.nasa.power.Identifier;
import io.gentjankolicaj.data.commons.domain.nasa.power.PowerPressure;
import io.gentjankolicaj.data.load.repository.PressureUnitRepository;
import io.gentjankolicaj.data.load.repository.UserRepository;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    public void create() throws Exception {
        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setValue(12f);
        powerPressure.setPressureUnit(pressureUnit);
        powerPressure.setRawDataFormat("json");
        powerPressureRepository.save(powerPressure);

        System.out.println(powerPressure);
    }


    @Test
    @Rollback
    public void createAll() throws Exception {
        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setValue(12f);


        powerPressure.setPressureUnit(pressureUnit);


        PowerPressure powerPressure2 = new PowerPressure();
        powerPressure.setValue(132f);

        powerPressure.setPressureUnit(pressureUnit);


        PowerPressure powerPressure3 = new PowerPressure();
        powerPressure.setValue(122f);

        powerPressure.setPressureUnit(pressureUnit);


        List<PowerPressure> list = Arrays.asList(powerPressure, powerPressure2, powerPressure3);
        powerPressureRepository.saveAll(list);
    }

    @Test
    @Rollback
    public void readById() throws Exception {
        Long id = 3L;

        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);


        powerPressure.setPressureUnit(pressureUnit);


        powerPressureRepository.save(powerPressure);

        Optional<PowerPressure> optional = powerPressureRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Power pressure  data with id" + id + " not found.");
        }
    }

    @Test
    @Rollback
    public void readAll() throws Exception {
        Long id = 3L;

        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setPressureUnit(pressureUnit);

        powerPressureRepository.save(powerPressure);
        Iterable<PowerPressure> iterable = powerPressureRepository.findAll();

        int i = IterableUtils.size(iterable);
        if (i <= 0) {
            throw new RuntimeException("List size returned not expected,should be more elements");
        }
    }

    @Test
    @Rollback
    public void update() throws Exception {
        Long id = 3L;

        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);

        powerPressure.setPressureUnit(pressureUnit);


        PowerPressure initialSave = powerPressureRepository.save(powerPressure);


        powerPressure.setValue(123f);

        PowerPressure secondarySave = powerPressureRepository.save(powerPressure);

        assertNotEquals(initialSave.getId(), secondarySave.getId());
    }

    @Test
    @Rollback
    public void delete() throws Exception {
        Long id = 3L;

        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setId(id);
        powerPressure.setValue(12f);
        powerPressure.setPressureUnit(pressureUnit);

        powerPressureRepository.save(powerPressure);
        Optional<PowerPressure> optional = powerPressureRepository.findById(id);

        if (optional.isPresent()) {
            throw new RuntimeException("Power pressure data with id " + id + " is found,it shouldn't be found because is deleted.");
        }
    }

    @Test
    @Rollback
    public void deleteAll() throws Exception {
        Identifier singlePoint = new Identifier();
        singlePoint.setIdentifier("SINGLE_POINT");

        PressureUnit pressureUnit = new PressureUnit();
        pressureUnit.setUnitCode("Pa");
        pressureUnit.setUnitName("Pascal");
        pressureUnit.setUnitDescription("Pascal unit used to measure pressure");

        User user = new User();
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

        PowerPressure powerPressure = new PowerPressure();
        powerPressure.setValue(12f);
        powerPressure.setPressureUnit(pressureUnit);

        PowerPressure powerPressure2 = new PowerPressure();
        powerPressure.setValue(132f);
        powerPressure.setPressureUnit(pressureUnit);

        PowerPressure powerPressure3 = new PowerPressure();
        powerPressure.setValue(122f);


        List<PowerPressure> list = Arrays.asList(powerPressure, powerPressure2, powerPressure3);

        powerPressureRepository.saveAll(list);

        powerPressureRepository.deleteAll();

        Iterable<PowerPressure> iterable = powerPressureRepository.findAll();

        int size = IterableUtils.size(iterable);

        if (size >= 1) {
            throw new RuntimeException("There should be not elements left because deleteAll() method is invoked.");
        }

    }

}