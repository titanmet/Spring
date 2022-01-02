package com.ratnikov.spring_data_jpa.repository;

import com.ratnikov.spring_data_jpa.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer>, PersonRepositoryCustom {
    List<Person> findAll();

    Person findByName(String s);

    Person findByEmail_Email(String email);
}
