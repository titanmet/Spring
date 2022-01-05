package com.ratnikov.spring_boot_mvc_view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
