package com.ratnikov.orm_exercise;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class OrmExerciseApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(OrmExerciseApplication.class, args);
        Console.main(args);
    }

}
