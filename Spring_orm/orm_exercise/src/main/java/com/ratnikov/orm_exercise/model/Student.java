package com.ratnikov.orm_exercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private long id;
    private String name;

    //private Avatar avatar;
    //private List<EMail> emails;
    //private List<Course> courses;
}