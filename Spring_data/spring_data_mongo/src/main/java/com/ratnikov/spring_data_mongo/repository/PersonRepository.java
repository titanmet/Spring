package com.ratnikov.spring_data_mongo.repository;

import com.ratnikov.spring_data_mongo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findAll();
}
