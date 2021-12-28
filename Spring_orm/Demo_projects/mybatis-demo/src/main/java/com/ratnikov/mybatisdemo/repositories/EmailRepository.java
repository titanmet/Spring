package com.ratnikov.mybatisdemo.repositories;

import com.ratnikov.mybatisdemo.model.EMail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmailRepository {

    @Select("select * from emails where student_id = #{studentId}")
    List<EMail> getEmailsByStudentId(long studentId);
}