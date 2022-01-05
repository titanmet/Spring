package com.ratnikov.spring_boot_mvc.rest;

import com.ratnikov.spring_boot_mvc.model.Person;
import com.ratnikov.spring_boot_mvc.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public @ResponseBody
    PersonDto create(@RequestBody PersonDto dto) {
        Person account = PersonDto.toDomainObject(dto);
        Person accountWithId = personRepository.save(account);
        return PersonDto.toDto(accountWithId);
    }

    @DeleteMapping(value = "/person/{id}")
    public void delete(@PathVariable("id") long id) {
        personRepository.deleteById(id);
    }

    @PutMapping(value = "/person/{id}/holder")
    public void changeName(@PathVariable("id") long id, @RequestParam("name") String name) {
        Person person = personRepository.findById(id).orElseThrow(NotFoundException::new);
        person.setName(name);
        personRepository.save(person);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
//        return ResponseEntity.badRequest().body("Not found");
//    }

}
