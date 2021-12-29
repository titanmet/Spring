package com.ratnikov.orm_exercise.repositories;

import com.ratnikov.orm_exercise.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class StudentRepositoryJpaImpl implements StudentRepositoryJpa {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student save(Student student) {
        if(student.getId() <= 0){
            entityManager.persist(student);
            return student;
        } else {
            return entityManager.merge(student);
        }
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(entityManager.find(Student.class,id));
    }

    @Override
    public List<Student> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Student> findByName(String name) {
        return Collections.emptyList();
    }

    @Override
    public void updateNameById(long id, String name) {

    }

    @Override
    public void deleteById(long id) {

    }
}
