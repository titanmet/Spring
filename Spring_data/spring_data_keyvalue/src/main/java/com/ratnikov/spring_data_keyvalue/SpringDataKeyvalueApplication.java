package com.ratnikov.spring_data_keyvalue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
public class SpringDataKeyvalueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataKeyvalueApplication.class, args);
    }

}
