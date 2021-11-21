package com.ratnikov.config;

import com.ratnikov.dao.PersonDao;
import com.ratnikov.dao.PersonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }
}
