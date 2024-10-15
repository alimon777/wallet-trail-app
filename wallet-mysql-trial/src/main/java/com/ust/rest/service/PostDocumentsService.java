package com.ust.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.GovtId;
import com.ust.rest.model.Person;
import com.ust.rest.repository.PersonRepository;

@Service
public class PostDocumentsService {
	@Autowired
	private PersonRepository personRepository;
	
	public GovtId addGovtIdForPersonWithId(Long personId) {
		Person person
    	return personRepository.save(person);
    }
}
