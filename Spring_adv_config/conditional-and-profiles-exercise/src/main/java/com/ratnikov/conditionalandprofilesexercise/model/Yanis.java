package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "condition.yanis-exists", havingValue = "true")
@Component
public class Yanis extends Friend {
    @Override
    public String getName() {
        return "Янис";
    }
}