package com.ratnikov.testconfigurationexercise2;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import com.ratnikov.testconfigurationexercise2.family.parents.Father;
import com.ratnikov.testconfigurationexercise2.family.pets.Cat;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@ComponentScan(value = "com.ratnikov.testconfigurationexercise2.family",
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Cat.class))
@ComponentScan({"com.ratnikov.testconfigurationexercise2.family.parents",
        "com.ratnikov.testconfigurationexercise2.family.childrens"})
@SpringBootConfiguration
public class TestSpringBootConfiguration {
    @Bean
    FamilyMember father() {
        return new Father();
    }
}
