package com.ratnikov.mybatismysqldemo;

import com.ratnikov.mybatismysqldemo.model.Person;
import com.ratnikov.mybatismysqldemo.repository.PersonMyBatisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisMysqlDemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonMyBatisRepository personMyBatisRepository;

    public static void main(String[] args) {
        SpringApplication.run(MybatisMysqlDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting -> {}", personMyBatisRepository.insert(new Person(1L, "kolya", "kola", "kolya@gmail.com")));
        logger.info("Inserting -> {}", personMyBatisRepository.insert(new Person(2L, "petya", "peta", "petya@gmail.com")));
        logger.info("Inserting -> {}", personMyBatisRepository.insert(new Person(3L, "sahsa", "saha", "sasha@gmail.com")));

        logger.info("Employee id 10011 -> {}", personMyBatisRepository.findById(1L));

        logger.info("Update 10003 -> {}", personMyBatisRepository.update(new Person(1L, "kolya1", "kola", "kolya123@gmail.com")));

        personMyBatisRepository.deleteById(3L);

        logger.info("All users -> {}", personMyBatisRepository.findAll());
    }
}
