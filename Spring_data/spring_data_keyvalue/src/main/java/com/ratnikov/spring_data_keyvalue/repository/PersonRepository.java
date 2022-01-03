package com.ratnikov.spring_data_keyvalue.repository;

import com.ratnikov.spring_data_keyvalue.model.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.List;

public interface PersonRepository extends KeyValueRepository<Person, Integer> {
    List<Person> findAll();
}
