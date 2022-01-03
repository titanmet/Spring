package com.ratnikov.spring_data_keyvalue.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@Data
@KeySpace("person")
public class Person {
    @Id
    private int id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}