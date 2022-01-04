package com.ratnikov.spring_boot_mvc.repository;

import com.ratnikov.spring_boot_mvc.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findAll();
}
