package com.ratnikov.jdbcdemoexercise.dao;

import com.ratnikov.jdbcdemoexercise.model.Person;

import java.util.List;

public interface PersonDao {
    int count();
    void insert(Person person);
    void update(Person person);
    void deleteDyId(Long id);
    Person getById(Long id);
    List<Person> getAll();
}
