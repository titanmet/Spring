package com.ratnikov.spring_boot_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@Data
@KeySpace("person")
@AllArgsConstructor
public class Person {

    @Id
    private long Id;
    private String name;

    public Person(String name) {
        this.name = name;
    }

}
