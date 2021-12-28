package com.ratnikov.springjdbcdemo.repositories;

import com.ratnikov.springjdbcdemo.model.Student;

import java.util.List;

public interface StudentRepositoryJdbc {
    List<Student> findAllWithAllInfo();
}
