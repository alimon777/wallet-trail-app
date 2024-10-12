package com.ust.rest.service;

import com.ust.rest.model.Person;
import com.ust.rest.repository.PersonRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public ResponseEntity<Person> updatePerson(long id, Person person) {
        if (!personRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        person.setId(id);
        return ResponseEntity.ok(personRepository.save(person));
    }

    public ResponseEntity<Void> deletePerson(long id) {
        if (!personRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
