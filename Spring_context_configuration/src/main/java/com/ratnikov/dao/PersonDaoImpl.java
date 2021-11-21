package com.ratnikov.dao;

import com.ratnikov.domain.Person;

public class PersonDaoImpl implements PersonDao {
    public Person findByName(String name) {
        return new Person("Kola", 28);
    }
}
