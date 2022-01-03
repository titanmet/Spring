package com.ratnikov.spring_data_keyvalue.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@Data
@KeySpace("email")
public class Email {
    @Id
    private int id;
    private String email;

    public Email(String email) {
        this.email = email;
    }
}