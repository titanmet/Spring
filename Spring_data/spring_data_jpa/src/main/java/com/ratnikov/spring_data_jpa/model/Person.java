package com.ratnikov.spring_data_jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne(targetEntity = Email.class)
    private Email email;

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }
}
