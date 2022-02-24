package com.fitness.mvc.service;


import com.fitness.entity.Person;

import java.util.List;

public interface PersonService {
    Person getById(Long id);

    List<Person> findByAll();

    Person savePerson(Person person);

    void deletePerson(Long id);
}
