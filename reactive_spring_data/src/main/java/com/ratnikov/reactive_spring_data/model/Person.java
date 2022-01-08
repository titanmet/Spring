package com.ratnikov.reactive_spring_data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Person {
    @Id
    private String id;

    @JsonProperty("name")
    @Field("name")
    private String lastName;

    private int age;

    public Person(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
}
