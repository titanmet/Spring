package com.ratnikov.mainpackage;

import com.ratnikov.mainpackage.configs.AppProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//http://localhost:8080/actuator/health

@SpringBootApplication
@EnableConfigurationProperties(AppProps.class)
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}