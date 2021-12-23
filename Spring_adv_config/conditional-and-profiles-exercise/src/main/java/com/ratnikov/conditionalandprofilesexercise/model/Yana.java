package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import com.ratnikov.conditionalandprofilesexercise.model.conditions.YanaConditions;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Conditional(YanaConditions.class)
@Component
public class Yana extends Friend {
    @Override
    public String getName() {
        return "Яна";
    }
}