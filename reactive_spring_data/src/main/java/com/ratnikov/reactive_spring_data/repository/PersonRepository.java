package com.ratnikov.reactive_spring_data.repository;

import com.ratnikov.reactive_spring_data.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findAll();

    Mono<Person> findById(String id);

    Mono<Person> save(Mono<Person> person);

    Flux<Person> findAllByLastName(String lastName);

    Flux<Person> findAllByAge(int age);
}
