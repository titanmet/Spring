package com.ratnikov.testconfigurationexercise2.family.pets;

import com.ratnikov.testconfigurationexercise2.family.FamilyMember;
import org.springframework.stereotype.Component;

@Component("cat")
public class Cat extends FamilyMember {

    @Override
    public String getName() {
        return "Кошка";
    }
}
