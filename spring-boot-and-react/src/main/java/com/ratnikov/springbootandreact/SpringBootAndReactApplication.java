package com.ratnikov.springbootandreact;

import com.ratnikov.springbootandreact.model.Person;
import com.ratnikov.springbootandreact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootAndReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndReactApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {
        personRepository.save(new Person("Pushkin"));
        personRepository.save(new Person("Lermontov"));
    }
}
