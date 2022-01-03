package com.ratnikov.spring_data_keyvalue.repository;

import com.ratnikov.spring_data_keyvalue.model.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> findAll();
    Email save(Email email);
}
