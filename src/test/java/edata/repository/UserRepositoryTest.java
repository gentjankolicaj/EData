package edata.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Test
    @Rollback
    public void create() throws Exception{
    }

    @Test
    public void createAll() throws Exception{
    }

    @Test
    public void readById()throws Exception {
    }

    @Test
    public void readAll() throws Exception{
    }

    @Test
    public void update() throws Exception{
    }

    @Test
    public void delete() throws Exception{
    }

    @Test
    @Rollback
    public void deleteAll() throws Exception{
    }

}