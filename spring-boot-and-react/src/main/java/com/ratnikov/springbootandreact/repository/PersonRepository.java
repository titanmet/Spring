package com.ratnikov.springbootandreact.repository;

import com.ratnikov.springbootandreact.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
