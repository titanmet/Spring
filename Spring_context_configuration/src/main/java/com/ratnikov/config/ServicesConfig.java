package com.ratnikov.config;

import com.ratnikov.dao.PersonDao;
import com.ratnikov.service.PersonService;
import com.ratnikov.service.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
