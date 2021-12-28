package com.ratnikov.springjdbcdemo.repositories;

import com.ratnikov.springjdbcdemo.model.Course;
import com.ratnikov.springjdbcdemo.model.Student;
import com.ratnikov.springjdbcdemo.repositories.ext.StudentCourseRelation;
import com.ratnikov.springjdbcdemo.repositories.ext.StudentResultSetExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryJdbcImpl implements StudentRepositoryJdbc {

    private final JdbcOperations jdbcOperations;
    private final CourseRepositoryJdbc courseRepositoryJdbc;

    @Override
    public List<Student> findAllWithAllInfo() {
        List<Course> courses = courseRepositoryJdbc.findAllUsed();
        List<StudentCourseRelation> relations = getAllRelations();
        Map<Long, Student> students = jdbcOperations.query("select os.id, os.name, a.id avatar_id, a.photo_url, e.id email_id, e.email " +
                        "from (students os left join avatars a on " +
                        "os.avatar_id = a.id) left join emails e on os.id = e.student_id",
                new StudentResultSetExtractor());

        mergeStudentsInfo(students, courses, relations);
        return new ArrayList<>(Objects.requireNonNull(students).values());
    }

    private List<StudentCourseRelation> getAllRelations() {
        return jdbcOperations.query("select student_id, course_id from student_courses sc order by student_id, course_id",
                (rs, i) -> new StudentCourseRelation(rs.getLong(1), rs.getLong(2)));
    }

    private void mergeStudentsInfo(Map<Long, Student> students, List<Course> courses, List<StudentCourseRelation> relations) {
        Map<Long, Course> coursesMap = courses.stream().collect(Collectors.toMap(Course::getId, c -> c));
        relations.forEach(r -> {
            if (students.containsKey(r.getStudentId()) && coursesMap.containsKey(r.getCourseId())) {
                students.get(r.getStudentId()).getCourses().add(coursesMap.get(r.getCourseId()));
            }
        });
    }
}
