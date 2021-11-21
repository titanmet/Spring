package com.ratnikov.service;

import com.ratnikov.domain.Person;

public interface PersonService {
    Person getByName(String name);
}
