package com.ratnikov.testconfigurationexercise2;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В SpringBootTestWithExternalLimitationDemoTest семья должна ")
@SpringBootTest(classes = TestSpringBootConfiguration.class)
public class SpringBootTestWithExternalLimitationDemoTest {
    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать маму, папу, сына и дочь")
    @Test
    void shouldContainAllFamilyExceptFather() {
        assertThat(family).containsOnlyKeys("father", "mother", "son", "daughter");
    }
}
