package com.ratnikov.testconfigurationexercise2.family.parents;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component
public class Mother extends FamilyMember {
    @Override
    public String getName() {
        return "Мама";
    }
}