package com.ratnikov.spring_data_mongo;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.ratnikov.spring_data_mongo.model.Person;
import com.ratnikov.spring_data_mongo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class SpringDataMongoApplication {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(SpringDataMongoApplication.class);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        personRepository.save(new Person("Dostoevsky"));

        Thread.sleep(3000);

        System.out.println("\n\n\n----------------------------------------------\n\n");
        System.out.println("Авторы в БД:");
        personRepository.findAll().forEach(p -> System.out.println(p.getName()));
        System.out.println("\n\n----------------------------------------------\n\n\n");
    }
}
