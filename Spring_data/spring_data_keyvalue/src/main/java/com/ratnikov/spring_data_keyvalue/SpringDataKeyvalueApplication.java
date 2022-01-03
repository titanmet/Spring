package com.ratnikov.spring_data_keyvalue;

import com.ratnikov.spring_data_keyvalue.model.Email;
import com.ratnikov.spring_data_keyvalue.model.Person;
import com.ratnikov.spring_data_keyvalue.repository.EmailRepository;
import com.ratnikov.spring_data_keyvalue.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMapRepositories
public class SpringDataKeyvalueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataKeyvalueApplication.class, args);
    }

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        personRepository.save(new Person("Kafka"));
        System.out.println(personRepository.findAll());

        emailRepository.save(new Email("kafka@kafka.com"));
        System.out.println(emailRepository.findAll());
    }


}
