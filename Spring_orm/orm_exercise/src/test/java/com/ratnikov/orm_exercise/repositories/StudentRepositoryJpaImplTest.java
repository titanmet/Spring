package com.ratnikov.orm_exercise.repositories;

import com.ratnikov.orm_exercise.model.Avatar;
import com.ratnikov.orm_exercise.model.Course;
import com.ratnikov.orm_exercise.model.EMail;
import com.ratnikov.orm_exercise.model.Student;
import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе Jpa для работы со студентами ")
@DataJpaTest
@Import(StudentRepositoryJpaImpl.class)
class StudentRepositoryJpaImplTest {
    private static final int EXPECTED_NUMBER_OF_STUDENTS = 10;
    private static final long FIRST_STUDENT_ID = 1L;
    private static final String FIRST_STUDENT_NAME = "student_01";

    private static final int EXPECTED_QUERIES_COUNT = 21;

    private static final String STUDENT_AVATAR_URL = "где-то там";
    private static final String STUDENT_EMAIL = "any@mail.com";
    private static final String COURSE_NAME = "Spring";
    private static final String STUDENT_NAME = "Вася";

    @Autowired
    private StudentRepositoryJpaImpl repositoryJpa;

    @Autowired
    private TestEntityManager em;

    @DisplayName(" должен загружать информацию о нужном студенте по его id")
    @Test
    void shouldFindExpectedStudentById() {
        val optionalActualStudent = repositoryJpa.findById(FIRST_STUDENT_ID);
        val expectedStudent = em.find(Student.class, FIRST_STUDENT_ID);
        assertThat(optionalActualStudent).isPresent().get()
                .isEqualToComparingFieldByField(expectedStudent);
    }

    @DisplayName("должен загружать список всех студентов с полной информацией о них")
    @Test
    void shouldReturnCorrectStudentsListWithAllInfo() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        System.out.println("\n\n\n\n----------------------------------------------------------------------------------------------------------");
        val students = repositoryJpa.findAll();
        assertThat(students).isNotNull().hasSize(EXPECTED_NUMBER_OF_STUDENTS)
                .allMatch(s -> !s.getName().equals(""))
                .allMatch(s -> s.getCourses() != null && s.getCourses().size() > 0)
                .allMatch(s -> s.getAvatar() != null)
                .allMatch(s -> s.getEmails() != null && s.getEmails().size() > 0);
        System.out.println("----------------------------------------------------------------------------------------------------------\n\n\n\n");
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);
    }

    @DisplayName(" должен корректно сохранять всю информацию о студенте")
    @Test
    void shouldSaveAllStudentInfo() {
        val avatar = new Avatar(0, STUDENT_AVATAR_URL);
        val email = new EMail(0, STUDENT_EMAIL);
        val emails = Collections.singletonList(email);

        val course = new Course(0, COURSE_NAME);
        val courses = Collections.singletonList(course);


        val vasya = new Student(0, STUDENT_NAME, avatar, emails, courses);
        repositoryJpa.save(vasya);
        assertThat(vasya.getId()).isGreaterThan(0);

        val actualStudent = em.find(Student.class, vasya.getId());
        assertThat(actualStudent).isNotNull().matches(s -> !s.getName().equals(""))
                .matches(s -> s.getCourses() != null && s.getCourses().size() > 0 && s.getCourses().get(0).getId() > 0)
                .matches(s -> s.getAvatar() != null)
                .matches(s -> s.getEmails() != null && s.getEmails().size() > 0);
    }

    @DisplayName(" должен загружать информацию о нужном студенте по его имени")
    @Test
    void shouldFindExpectedStudentByName() {
        val firstStudent = em.find(Student.class, FIRST_STUDENT_ID);
        List<Student> students = repositoryJpa.findByName(FIRST_STUDENT_NAME);
        assertThat(students).containsOnlyOnce(firstStudent);
    }

    @DisplayName(" должен изменять имя заданного студента по его id")
    @Test
    void shouldUpdateStudentNameById() {
        val firstStudent = em.find(Student.class, FIRST_STUDENT_ID);
        String oldName = firstStudent.getName();
        em.detach(firstStudent);

        repositoryJpa.updateNameById(FIRST_STUDENT_ID, STUDENT_NAME);
        val updatedStudent = em.find(Student.class, FIRST_STUDENT_ID);

        assertThat(updatedStudent.getName()).isNotEqualTo(oldName).isEqualTo(STUDENT_NAME);
    }

    @DisplayName(" должен удалять заданного студента по его id")
    @Test
    void shouldDeleteStudentNameById() {
        val firstStudent = em.find(Student.class, FIRST_STUDENT_ID);
        assertThat(firstStudent).isNotNull();
        em.detach(firstStudent);

        repositoryJpa.deleteById(FIRST_STUDENT_ID);
        val deletedStudent = em.find(Student.class, FIRST_STUDENT_ID);

        assertThat(deletedStudent).isNull();
    }
}