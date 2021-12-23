package com.ratnikov.testconfigurationexercise2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ratnikov.testconfigurationexercise2.family")
@SpringBootApplication
class TestConfigurationExercise2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestConfigurationExercise2Application.class, args);
    }

}
