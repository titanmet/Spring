package com.ratnikov.springbootandreact.rest;

import com.ratnikov.springbootandreact.repository.PersonRepository;
import com.ratnikov.springbootandreact.rest.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/api/persons")
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(PersonDto::toDto)
                .collect(Collectors.toList());
    }
}
