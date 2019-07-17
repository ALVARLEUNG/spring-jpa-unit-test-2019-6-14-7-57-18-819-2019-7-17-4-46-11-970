package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import com.oocl.web.sampleWebApp.jpaSample.entity.User;
import com.oocl.web.sampleWebApp.jpaSample.repository.UserRepository;
import org.h2.jdbc.JdbcSQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SingleEntityRepositoryTest {

    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @Test
    public void test_should_return_single_entity_when_the_single_entity_exist() {
        //given
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.setName("test");
        singleEntityRepository.save(singleEntity);

        //when
        List<SingleEntity> singleEntities = singleEntityRepository.findAll();

        //then
        Assertions.assertEquals(1, singleEntities.size());
        Assertions.assertEquals("test", singleEntities.get(0).getName());
    }

    @Test
    public void should_throw_exception_when_call_save_given_the_name_length_more_then_default_length () {

        //given
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.setName("test........................................................................" +
                ".........................................................................................." +
                "..........................................................................................." +
                ".............................................................................................");

        singleEntityRepository.save(singleEntity);
        assertThrows(Exception.class, () -> {
           singleEntityRepository.findAll();
        });


    }
}

