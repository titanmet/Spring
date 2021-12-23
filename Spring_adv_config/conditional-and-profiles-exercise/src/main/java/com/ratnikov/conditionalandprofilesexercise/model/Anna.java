package com.ratnikov.conditionalandprofilesexercise.model;

import com.ratnikov.conditionalandprofilesexercise.model.base.Friend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@ConditionalOnBean(Alexey.class)
@Component
public class Anna extends Friend {
    @Override
    public String getName() {
        return "Аня";
    }
}
