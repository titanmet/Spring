package com.ratnikov.spring_boot_mvc.rest;

import com.ratnikov.spring_boot_mvc.model.Person;
import com.ratnikov.spring_boot_mvc.repository.PersonRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<PersonDto> get() {
        return personRepository.findAll().stream()
                .map(PersonDto::toDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public PersonDto get(@PathVariable("id") long id) {
        Person person = personRepository.findById(id).orElseThrow(NotFoundException::new);
        return PersonDto.toDto(person);
    }

}
