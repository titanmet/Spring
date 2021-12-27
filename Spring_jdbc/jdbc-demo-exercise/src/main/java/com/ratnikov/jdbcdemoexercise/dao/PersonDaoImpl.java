package com.ratnikov.jdbcdemoexercise.dao;

import com.ratnikov.jdbcdemoexercise.model.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
public class PersonDaoImpl implements PersonDao {
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public PersonDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public int count() {
        return namedParameterJdbcOperations.getJdbcOperations().queryForObject("select count(*) from persons",
                Integer.class);
    }

    @Override
    public void insert(Person person) {
        namedParameterJdbcOperations.update("insert into persons (id, name) values (:id, :name)",
                Map.of("id", person.getId(), "name", person.getName()));
    }

    @Override
    public void update(Person person) {
        namedParameterJdbcOperations.update("update persons set name=:name where id=:id",
                Map.of("id", person.getId(), "name", person.getName()));
    }

    @Override
    public void deleteDyId(Long id) {
        namedParameterJdbcOperations.update("delete from persons where id=:id",  Map.of("id", id));
    }

    @Override
    public Person getById(Long id) {
        return namedParameterJdbcOperations.queryForObject("select * from persons where id=:id",
                Map.of("id", id),
                new PersonMapper());
    }

    @Override
    public List<Person> getAll() {
        return namedParameterJdbcOperations.query("select * from persons", new PersonMapper());
    }


    private static class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(rs.getLong("id"), rs.getString("name"));
        }
    }
}
