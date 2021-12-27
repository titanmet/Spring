package com.ratnikov.jdbcdemoexercise;

import com.ratnikov.jdbcdemoexercise.model.Person;
import org.h2.tools.Console;
import com.ratnikov.jdbcdemoexercise.dao.PersonDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JdbcDemoExerciseApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(JdbcDemoExerciseApplication.class);

        PersonDao dao = context.getBean(PersonDao.class);
        System.out.println("Persons count: " + dao.count());
        Person sergey = new Person(2L, "Sergey");
        dao.insert(sergey);
        Person semen = new Person(3L, "Semen");
        dao.insert(semen);
        System.out.println(semen.getId() + " " + semen.getName());
        dao.update(new Person(3L, "semen - 3"));
        System.out.println("Persons count: " + dao.count());
        dao.getById(1L);
        List<Person> all = dao.getAll();
        System.out.println(all);
        Person person = dao.getById(1L);
        System.out.println("Person by id 1: " + person);
        System.out.println("Persons list: \n" + all.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n")));
        dao.deleteDyId(3L);
        System.out.println("Persons count delete by id: "+ dao.count());
        System.out.println(dao.getAll());
        Console.main(args);
    }

}
