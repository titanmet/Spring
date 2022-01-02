package com.ratnikov.spring_data_jpa.repository;

import com.ratnikov.spring_data_jpa.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Integer> {
    List<Email> findAll();

    @Query("select e from Email e where e.email = :email")
    Email findByEmail(@Param("email") String email);
}
