package com.fitness.mvc.controller;

import com.fitness.entity.Person;
import com.fitness.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/persons")
    public List<Person> getAllPersons() {
        return personService.findByAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person getPersonById(@PathVariable("id") long id) {
        return personService.getById(id);
    }

    @PostMapping(value = "/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping(value = "/person/{id}")
    public Person updatePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping(value = "/person/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return "Person with ID :" + id + " is deleted";
    }
}

