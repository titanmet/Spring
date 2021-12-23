package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Oleg")
@Component
public class Oleg extends Friend {
    @Override
    public String getName() {
        return "Олег";
    }
}