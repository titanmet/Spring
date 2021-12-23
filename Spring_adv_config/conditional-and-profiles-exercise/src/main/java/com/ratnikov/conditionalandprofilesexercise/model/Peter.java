package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Peter")
@Component
public class Peter extends Friend {

    @Override
    public String getName() {
        return "Петр";
    }
}