package com.ust.rest.controller;

import com.ust.rest.model.Person;
import com.ust.rest.service.PersonService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable long id) {
        return personService.deletePerson(id);
    }
}
