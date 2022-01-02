package com.ratnikov.spring_data_jpa;

import com.ratnikov.spring_data_jpa.model.Email;
import com.ratnikov.spring_data_jpa.model.Person;
import com.ratnikov.spring_data_jpa.repository.EmailRepository;
import com.ratnikov.spring_data_jpa.repository.PersonRepository;
import com.ratnikov.spring_data_jpa.repository.PersonRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        Email emailA = new Email("alex@mail.ru");
        emailRepository.save(emailA);
        Email emailM = new Email("michail@mail.ru");
        emailRepository.save(emailM);
        Email emailB = new Email("bruce@mail.ru");
        emailRepository.save(emailB);

        personRepository.save(new Person("Smith", emailA));
        personRepository.save(new Person("Jordan",emailM));
        personRepository.customSaveMethod(new Person("Bruce", emailB));

        System.out.println("--------");
        System.out.println(personRepository.findByName("Smith"));
        System.out.println("--------");
        System.out.println(emailRepository.findAll());
        System.out.println("--------");
        System.out.println(emailRepository.findByEmail("alex@mail.ru"));
        System.out.println("--------");
        System.out.println(personRepository.findByEmail_Email("alex@mail.ru"));
        System.out.println("--------");
        System.out.println(personRepository.findByName("Bruce Lee"));
        System.out.println("--------");
    }

}
