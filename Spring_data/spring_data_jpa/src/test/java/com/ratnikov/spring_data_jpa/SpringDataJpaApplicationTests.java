package com.ratnikov.spring_data_jpa;

import com.ratnikov.spring_data_jpa.model.Email;
import com.ratnikov.spring_data_jpa.model.Person;
import com.ratnikov.spring_data_jpa.repository.EmailRepository;
import com.ratnikov.spring_data_jpa.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест Jean Claude Van Dame")
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class SpringDataJpaApplicationTests {
    @Autowired private PersonRepository personRepository;
    @Autowired private EmailRepository emailRepository;

    @DisplayName("Jean Claude Van Dame добавлен")
    @Test
    public void addPerson() throws Exception {
        Email emailJ = new Email("VanDame@mail.ru");
        emailRepository.save(emailJ);
        personRepository.save(new Person("Jean Claude Van Dame",emailJ));
        Person person = personRepository.findByName("Jean Claude Van Dame");
        assertThat(person.getName().equalsIgnoreCase("Jean Claude Van Dame"));
    }

}
