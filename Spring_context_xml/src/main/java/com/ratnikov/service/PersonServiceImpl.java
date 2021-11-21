package com.ratnikov.service;

import com.ratnikov.dao.PersonDao;
import com.ratnikov.domain.Person;

public class PersonServiceImpl implements PersonService {
    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
