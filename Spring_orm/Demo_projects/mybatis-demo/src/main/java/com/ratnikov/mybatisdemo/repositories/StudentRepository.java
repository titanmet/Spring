package com.ratnikov.mybatisdemo.repositories;

import com.ratnikov.mybatisdemo.model.Avatar;
import com.ratnikov.mybatisdemo.model.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("select * from students")
    @Results(id = "studentAllMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "avatar", column = "avatar_id", javaType = Avatar.class,
                    one = @One(select = "com.ratnikov.mybatisdemo.repositories.AvatarRepository.getAvatarById", fetchType = FetchType.EAGER)),
            @Result(property = "emails", column = "id", javaType = List.class,
                    many = @Many(select = "com.ratnikov.mybatisdemo.repositories.EmailRepository.getEmailsByStudentId", fetchType = FetchType.EAGER)),
            @Result(property = "courses", column = "id", javaType = List.class,
                    many = @Many(select = "com.ratnikov.mybatisdemo.repositories.CourseRepository.getCoursesByStudentId", fetchType = FetchType.EAGER))
    })
    List<Student> findAllWithAllInfo();

    @Select("select * from students where id = #{id}")
    @ResultMap("studentAllMap")
    Student findById(long id);

    @Select("select count(*) as students_count from students")
    long getStudentsCount();

    @Insert("insert into students(name, avatar_id) values (#{name}, #{avatar.id})")
    void insert(Student student);

    @Update("update students set name = #{name} where id = #{id}")
    void updateName(Student student);

    @Delete("delete from students where id = #{id}")
    void deleteById(long id);
}