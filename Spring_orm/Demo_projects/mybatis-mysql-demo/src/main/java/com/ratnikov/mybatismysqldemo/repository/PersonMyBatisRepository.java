package com.ratnikov.mybatismysqldemo.repository;

import com.ratnikov.mybatismysqldemo.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMyBatisRepository {
    @Select("select * from persons")
    public List<Person> findAll();

    @Select("SELECT * FROM persons WHERE id = #{id}")
    public Person findById(long id);

    @Delete("DELETE FROM persons WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO persons(id, first_name, last_name,email_address) " +
            " VALUES (#{id}, #{firstName}, #{lastName}, #{emailId})")
    public int insert(Person person);

    @Update("Update persons set first_name=#{firstName}, " +
            " last_name=#{lastName}, email_address=#{emailId} where id=#{id}")
    public int update(Person person);
}
