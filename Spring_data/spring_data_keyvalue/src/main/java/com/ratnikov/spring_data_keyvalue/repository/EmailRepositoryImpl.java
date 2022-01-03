package com.ratnikov.spring_data_keyvalue.repository;

import com.ratnikov.spring_data_keyvalue.model.Email;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    private final KeyValueOperations keyValueOperations;

    public EmailRepositoryImpl(KeyValueOperations keyValueOperations) {
        this.keyValueOperations = keyValueOperations;
    }

    @Override
    public List<Email> findAll() {
        return (List<Email>) keyValueOperations.findAll(Email.class);
    }

    @Override
    public Email save(Email email) {
        return keyValueOperations.insert(email);
    }
}
