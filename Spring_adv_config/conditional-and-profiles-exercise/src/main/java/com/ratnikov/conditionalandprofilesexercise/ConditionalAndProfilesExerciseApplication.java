package com.ratnikov.conditionalandprofilesexercise;

import com.ratnikov.conditionalandprofilesexercise.model.Party;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConditionalAndProfilesExerciseApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ConditionalAndProfilesExerciseApplication.class, args);
        Party party = ctx.getBean(Party.class);
        party.printPartyMembers();
    }

}
