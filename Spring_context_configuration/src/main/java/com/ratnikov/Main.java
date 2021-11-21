package com.ratnikov;

import com.ratnikov.domain.Person;
import com.ratnikov.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class  Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        PersonService service = context.getBean(PersonService.class);

        Person kola = service.getByName("Kola");
        System.out.println("name: " + kola.getName() + " age: " + kola.getAge());
    }
}