package com.ratnikov.testconfigurationexercise1.family.childrents;

import com.ratnikov.testconfigurationexercise1.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component
public class Daughter extends FamilyMember {
    @Override
    public String getName() {
        return "Дочь";
    }
}
