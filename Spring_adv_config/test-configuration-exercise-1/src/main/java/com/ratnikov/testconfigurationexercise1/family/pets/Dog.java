package com.ratnikov.testconfigurationexercise1.family.pets;

import com.ratnikov.testconfigurationexercise1.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component
public class Dog extends FamilyMember {

    @Override
    public String getName() {
        return "Собака";
    }
}