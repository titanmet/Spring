package com.ratnikov.mybatismysqldemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
