package com.ratnikov.reactive_spring_data.rest;

import com.ratnikov.reactive_spring_data.model.Person;
import com.ratnikov.reactive_spring_data.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public Flux<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Mono<Person> byId(@PathVariable("id") String id) {
        return personRepository.findById(id);
    }

    @GetMapping("/person/byname")
    public Flux<Person> byName(@RequestParam("name") String lastName) {
        return personRepository.findAllByLastName(lastName);
    }

    @GetMapping("/person/byage")
    public Flux<Person> byAge(@RequestParam int age) {
        return personRepository.findAllByAge(age);
    }

    @PostMapping("/person")
    public Mono<Person> save(@RequestBody Mono<Person> dto) {
        return personRepository.save(dto);
    }
}
