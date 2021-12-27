package com.ratnikov.jdbcdemoexercise.dao;

import com.ratnikov.jdbcdemoexercise.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DAO для работы с персонами должно")
@JdbcTest
@Import(PersonDaoImpl.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PersonDaoImplTest {

    private static final int EXPECTED_PERSONS_COUNT = 3;
    private static final long MISHA_ID = 5L;
    private static final String MISHA_NAME = "misha";

    @Autowired
    private PersonDaoImpl personDao;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @DisplayName("Возвращать ожидаемое количество persons в БД")
    @Test
    void shouldReturnExpectedPersonCount() {
        int count = personDao.count();
        assertThat(count).isEqualTo(EXPECTED_PERSONS_COUNT);
    }

    @DisplayName("Добавлять person в БД")
    @Test
    void shouldInsertPerson() {
        Person expectedPerson = new Person(7, "kolya");
        personDao.insert(expectedPerson);
        Person actualPerson = personDao.getById(expectedPerson.getId());
        assertThat(actualPerson).isEqualTo(expectedPerson);
    }

    @DisplayName("Возвращать ожидаемого person по его id")
    @Test
    void shouldReturnExpectedPersonById() {
        Person actualPerson = personDao.getById(MISHA_ID);
        assertThat(actualPerson)
                .hasFieldOrPropertyWithValue("id", MISHA_ID)
                .hasFieldOrPropertyWithValue("name", MISHA_NAME);
    }
}