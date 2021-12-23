package com.ratnikov.testconfigurationexercise1.family.parents;

import com.ratnikov.testconfigurationexercise1.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component
public class Father extends FamilyMember {
    @Override
    public String getName() {
        return "Папа";
    }
}