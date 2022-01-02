package com.ratnikov.spring_data_jpa.repository;

import com.ratnikov.spring_data_jpa.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person customSaveMethod(Person person) {
        if (person.getName().equals("Bruce")) {
            entityManager.persist(new Person(person.getName() + " Lee", person.getEmail()));
            return person;
        } else {
            entityManager.persist(new Person(person.getName(), person.getEmail()));
            return person;
        }
    }

}
