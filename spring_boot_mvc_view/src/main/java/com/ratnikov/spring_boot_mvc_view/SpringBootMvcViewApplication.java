package com.ratnikov.spring_boot_mvc_view;

import com.ratnikov.spring_boot_mvc_view.model.Person;
import com.ratnikov.spring_boot_mvc_view.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootMvcViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcViewApplication.class, args);
    }

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {
        personRepository.save(new Person("Razin"));
        personRepository.save(new Person("Pugachev"));
    }

}
