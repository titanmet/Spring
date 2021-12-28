package com.ratnikov.springjdbcdemo.repositories;

import com.ratnikov.springjdbcdemo.model.Course;

import java.util.List;

public interface CourseRepositoryJdbc {
    List<Course> findAllUsed();
}
