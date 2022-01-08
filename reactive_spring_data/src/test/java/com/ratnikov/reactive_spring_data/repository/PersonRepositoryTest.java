package com.ratnikov.reactive_spring_data.repository;

import com.ratnikov.reactive_spring_data.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldSetIdOnSave() {
        Mono<Person> personMono = personRepository.save(new Person("Bill", 12));

        StepVerifier
                .create(personMono)
                .assertNext(person -> assertNotNull(person.getId()))
                .expectComplete()
                .verify();
    }

    @Test
    public void shouldFindByAge() {
        personRepository.save(new Person("Pushkin", 18)).subscribe();

        StepVerifier.create(
                personRepository.findAllByAge(18)
        )
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}