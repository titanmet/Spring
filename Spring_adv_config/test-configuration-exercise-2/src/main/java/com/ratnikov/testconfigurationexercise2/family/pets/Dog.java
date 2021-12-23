package com.ratnikov.testconfigurationexercise2.family.pets;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component("dog")
public class Dog extends FamilyMember {

    @Override
    public String getName() {
        return "Собака";
    }
}