package com.ratnikov.springjdbcdemo.repositories;

import com.ratnikov.springjdbcdemo.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseRepositoryJdbcImpl implements CourseRepositoryJdbc {

    @Autowired
    private final JdbcOperations jdbcOperations;

    @Override
    public List<Course> findAllUsed() {
        return jdbcOperations.query("select c.id, c.name " +
                        "from courses c inner join student_courses sc on c.id = sc.course_id " +
                        "group by c.id, c.name order by c.name",
                new CourseRowMapper());
    }

    private class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Course(rs.getLong(1), rs.getString(2));
        }
    }
}
