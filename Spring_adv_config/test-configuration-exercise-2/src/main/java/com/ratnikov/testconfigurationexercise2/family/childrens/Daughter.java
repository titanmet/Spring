package com.ratnikov.testconfigurationexercise2.family.childrens;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component
public class Daughter extends FamilyMember {
    @Override
    public String getName() {
        return "Дочь";
    }
}
