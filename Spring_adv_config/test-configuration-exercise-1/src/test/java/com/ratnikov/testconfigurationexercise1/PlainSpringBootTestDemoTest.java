package com.ratnikov.testconfigurationexercise1;


import com.ratnikov.testconfigurationexercise1.family.FamilyMember;
import com.ratnikov.testconfigurationexercise1.family.parents.Father;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В PlainSpringBootTestDemoTest семья должна ")
@SpringBootTest
public class PlainSpringBootTestDemoTest {

    @TestConfiguration
    static class PlainConfiguration {
        @Bean
        public FamilyMember father() {
            return new Father();
        }

    }

    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать маму,папу, сына, дочь и собаку с кошкой ")
    @Test
    void shouldContainAllFamilyExceptFather() {
        assertThat(family).containsOnlyKeys("mother", "father", "son", "daughter", "dog", "cat");
    }

}