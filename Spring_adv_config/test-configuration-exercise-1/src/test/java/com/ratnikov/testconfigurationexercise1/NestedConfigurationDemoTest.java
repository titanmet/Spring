package com.ratnikov.testconfigurationexercise1;

import com.ratnikov.testconfigurationexercise1.family.FamilyMember;
import com.ratnikov.testconfigurationexercise1.family.pets.Cat;
import com.ratnikov.testconfigurationexercise1.family.pets.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В NestedConfigurationDemoTest семья должна ")
@SpringBootTest
public class NestedConfigurationDemoTest {

//    @ComponentScan("com.ratnikov.testconfigurationexercise1.family.pets")
    @Configuration
    static class NestedConfiguration {
        @Bean
        FamilyMember dog() {
            return new Dog();
        }

        @Bean
        FamilyMember cat() {
            return new Cat();
        }
    }

    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать только собаку и кошку ")
    @Test
    void shouldContainOnlyDog() {
        assertThat(family).containsOnlyKeys("dog","cat");
    }

}
