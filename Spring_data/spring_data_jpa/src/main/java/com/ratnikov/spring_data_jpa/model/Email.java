package com.ratnikov.spring_data_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue
    private long id;
    private String email;

    public Email(String email) {
        this.email = email;
    }
}
