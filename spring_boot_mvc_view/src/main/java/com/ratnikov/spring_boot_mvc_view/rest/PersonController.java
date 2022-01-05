package com.ratnikov.spring_boot_mvc_view.rest;

import com.ratnikov.spring_boot_mvc_view.model.Person;
import com.ratnikov.spring_boot_mvc_view.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String listPage(Model model) {
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("person", person);
        return "edit";
    }

    @PostMapping("/edit")
    public String savePerson(Person person, Model model) {
        Person saved = personRepository.save(person);
        model.addAttribute(saved);
        return "edit";
    }
}
