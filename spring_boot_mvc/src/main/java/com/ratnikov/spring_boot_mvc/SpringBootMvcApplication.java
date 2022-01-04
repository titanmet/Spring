package com.ratnikov.spring_boot_mvc;

import com.ratnikov.spring_boot_mvc.model.Person;
import com.ratnikov.spring_boot_mvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import javax.annotation.PostConstruct;

@EnableMapRepositories
@SpringBootApplication
public class SpringBootMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcApplication.class, args);
    }

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {
        personRepository.save(new Person("Razin"));
    }

}
