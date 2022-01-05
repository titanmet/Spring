package com.ratnikov.spring_boot_mvc_view.repository;

import com.ratnikov.spring_boot_mvc_view.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
