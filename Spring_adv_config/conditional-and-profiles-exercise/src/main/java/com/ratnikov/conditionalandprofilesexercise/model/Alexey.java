package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "condition.alexey-exists", havingValue = "true")
@Component
public class Alexey extends Friend {
    @Override
    public String getName() {
        return "Алексей";
    }
}