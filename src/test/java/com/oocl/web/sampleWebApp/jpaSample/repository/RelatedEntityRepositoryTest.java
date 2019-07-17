package com.oocl.web.sampleWebApp.jpaSample.repository;


import com.oocl.web.sampleWebApp.jpaSample.entity.RelatedEntity;
import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RelatedEntityRepositoryTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Autowired
    private RelatedEntityRepository relatedEntityRepository;

    @Test
    public void test_should_return_related_entity_when_the_related_entity_exist() {
        //given
        SingleEntity singleEntity = new SingleEntity();
        singleEntity.setName("test");
        RelatedEntity relatedEntity = new RelatedEntity();
        relatedEntity.setName("test2");
        relatedEntity.setSingleEntity(singleEntity);


        //when
        relatedEntityRepository.save(relatedEntity);
        List<RelatedEntity> relatedEntities = relatedEntityRepository.findAll();

        //then
        Assertions.assertEquals(1, relatedEntities.size());
        Assertions.assertEquals("test2", relatedEntities.get(0).getName());
        Assertions.assertEquals("test", singleEntity.getName());
    }

    @Test
    public void test_should_throw_exception_when_the_single_entity_is_exist() {
        //given
        RelatedEntity relatedEntity = new RelatedEntity();
        relatedEntity.setName("test2");

        //then
        assertThrows(Exception.class, () -> {
            relatedEntityRepository.saveAndFlush(relatedEntity);
        });

    }

}


