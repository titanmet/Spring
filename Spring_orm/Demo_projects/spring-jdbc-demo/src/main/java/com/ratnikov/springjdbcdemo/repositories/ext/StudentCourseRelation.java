package com.ratnikov.springjdbcdemo.repositories.ext;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentCourseRelation {
    private final long studentId;
    private final long courseId;
}