package com.ratnikov.spring_data_jpa.repository;

import com.ratnikov.spring_data_jpa.model.Person;

public interface PersonRepositoryCustom {
    Person customSaveMethod(Person person);
}
