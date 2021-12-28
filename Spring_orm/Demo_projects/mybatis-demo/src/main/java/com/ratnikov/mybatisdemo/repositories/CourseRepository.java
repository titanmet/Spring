package com.ratnikov.mybatisdemo.repositories;

import com.ratnikov.mybatisdemo.model.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("select * from student_courses sc left join courses c on sc.course_id = c.id where sc.student_id = #{studentId}")
    List<Course> getCoursesByStudentId(long studentId);

}