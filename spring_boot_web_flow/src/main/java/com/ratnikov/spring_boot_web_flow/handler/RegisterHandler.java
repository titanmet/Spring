package com.ratnikov.spring_boot_web_flow.handler;

import com.ratnikov.spring_boot_web_flow.model.BillingInfo;
import com.ratnikov.spring_boot_web_flow.model.PersonalInfo;
import com.ratnikov.spring_boot_web_flow.model.RegisterModel;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addPersonalInfo(RegisterModel registerModel, PersonalInfo personalInfo) {
        registerModel.setPersonalInfo(personalInfo);
    }

    public void addBillingInfo(RegisterModel registerModel, BillingInfo billingInfo) {
        registerModel.setBillingInfo(billingInfo);
    }

    public String saveAll(RegisterModel registerModel, MessageContext error) {
        String transitionValue = "success";

        // XXX Save model in database or somewhere else...
        error.addMessage(new MessageBuilder(). //
                error() //
                .source("registration") //
                .defaultText( //
                        String.format("Couldn't register user with username: %s!",
                                registerModel.getPersonalInfo().getUsername())) //
                .build());
        transitionValue = "failure";

        return transitionValue;
    }

    public String validatePersonalInfo(PersonalInfo personalInfo, MessageContext error) {
        String transitionValue = "success";

        // Checking that username is not equal to 'titanmet' :d XXX do whatever you want!
        if (personalInfo.getUsername().equalsIgnoreCase("titanmet")) {
            error.addMessage(new MessageBuilder(). //
                    error() //
                    .source("username") //
                    .defaultText("You are not allowed to use titanmet as the username!") //
                    .build());

            transitionValue = "failure";
        }

        // Checking if password matched the confirm password
        if (!personalInfo.getPassword().equals(personalInfo.getConfirmPassword())) {
            error.addMessage(new MessageBuilder(). //
                    error() //
                    .source("confirmPassword") //
                    .defaultText("Password doesn't match up the confirm password!") //
                    .build());

            transitionValue = "failure";
        }
        return transitionValue;
    }
}
