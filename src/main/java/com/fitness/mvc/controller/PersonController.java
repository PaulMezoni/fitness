package com.fitness.mvc.controller;

import com.fitness.entity.Person;
import com.fitness.mvc.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;

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

    @PostMapping(value = "/persons")
    public Person addPerson(@RequestBody Person std) {
        return personService.savePerson(std);
    }

    @PutMapping(value = "/persons/{id}")
    public Person updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        return personService.savePerson(person);
    }

    @DeleteMapping(value = "/persons/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return "Person with ID :" + id + " is deleted";
    }
}



