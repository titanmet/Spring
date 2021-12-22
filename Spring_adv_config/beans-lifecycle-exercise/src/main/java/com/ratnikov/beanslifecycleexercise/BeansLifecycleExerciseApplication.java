package com.ratnikov.beanslifecycleexercise;

import com.ratnikov.beanslifecycleexercise.domain.Phone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeansLifecycleExerciseApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(BeansLifecycleExerciseApplication.class, args);
        try {
            Phone phone = ctx.getBean(Phone.class);
            phone.callFavoriteNumber();
        }catch (Exception e) {
        }
    }

}
