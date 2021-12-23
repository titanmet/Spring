package com.ratnikov.conditionalandprofilesexercise.model.conditions;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ConfigurationCondition;

public class YanaConditions extends AnyNestedCondition {

    public YanaConditions() {
        super(ConfigurationCondition.ConfigurationPhase.PARSE_CONFIGURATION);
    }


    @ConditionalOnProperty(name = "condition.alexey-exists", havingValue = "false")
    static class AlexeyDoesNotExistsCondition {
    }

    @ConditionalOnProperty(name = "condition.yanis-exists", havingValue = "true")
    static class YanisExistsCondition {
    }
}