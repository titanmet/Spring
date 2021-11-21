package com.ratnikov.dao;

import com.ratnikov.domain.Person;

public interface PersonDao {
    Person findByName(String name);
}