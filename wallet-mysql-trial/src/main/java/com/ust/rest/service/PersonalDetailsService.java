package com.ust.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.dto.PersonBasicDetailsDTO;
import com.ust.rest.model.Person;
import com.ust.rest.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalDetailsService {

    @Autowired
    private PersonRepository personRepository; 
    
    public Person addPerson(Person person) {
    	return personRepository.save(person);
    }

    public List<PersonBasicDetailsDTO> getAllPersonsBasicDetails() {
        List<Person> persons = personRepository.findAll();

        List<PersonBasicDetailsDTO> personBasicDetailsList = new ArrayList<>();

        for (Person person : persons) {
            PersonBasicDetailsDTO dto = convertToDTO(person);
            personBasicDetailsList.add(dto);
        }

        return personBasicDetailsList; 
    }

    public PersonBasicDetailsDTO getPersonBasicDetailsById(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isEmpty()) {
            throw new RuntimeException("Person not found with ID: " + personId);
        }

        return convertToDTO(personOptional.get());
    }

    public Person getAllDocumentsOfPersonById(Long personId) {
    	Optional<Person> personOptional = personRepository.findById(personId);

    	if (personOptional.isEmpty()) {
    		throw new RuntimeException("Person not found with ID: " + personId);
    	}

    		return personOptional.get();
    }
    
    private PersonBasicDetailsDTO convertToDTO(Person person) {
        PersonBasicDetailsDTO dto = new PersonBasicDetailsDTO();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setDateOfBirth(person.getDateOfBirth());
        dto.setGender(person.getGender());
        dto.setEmail(person.getEmail());
        dto.setPhoneNumber(person.getPhoneNumber());
        dto.setAddress(person.getAddress());
        return dto;
    }
    
}
