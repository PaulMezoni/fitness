package com.fitness.mvc.service;

import com.fitness.entity.Person;
import com.fitness.mvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Person> findByAll() {
        return repository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
