package com.ratnikov.reactive_spring_data;

import com.ratnikov.reactive_spring_data.model.Person;
import com.ratnikov.reactive_spring_data.repository.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
public class ReactiveSpringDataApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(ReactiveSpringDataApplication.class, args);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        personRepository.saveAll(Arrays.asList(
                new Person("Pushkin", 22),
                new Person("Lermontov", 22),
                new Person("Tolstoy", 60)
        )).subscribe(p -> System.out.println(p.getLastName()));

    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(PersonRepository repository) {
        return route()
                .GET("/func/person", queryParam("name", StringUtils::isNotEmpty),
                        request -> request.queryParam("name")
                                .map(repository::findAllByLastName)
                                .map(persons -> ok().body(persons, Person.class))
                                .orElse(notFound().build())
                )
                .GET("/func/person", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(repository.findAll(), Person.class))
                .GET("/func/person/{id}", accept(APPLICATION_JSON),
                        request -> repository.findById(request.pathVariable("id"))
                                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                ).build();
    }
}
