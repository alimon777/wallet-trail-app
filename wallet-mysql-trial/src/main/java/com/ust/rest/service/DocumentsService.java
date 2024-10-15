package com.ust.rest.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.BankDetails;
import com.ust.rest.model.CardDetails;
import com.ust.rest.model.Certificate;
import com.ust.rest.model.GovtId;
import com.ust.rest.model.InsuranceDetails;
import com.ust.rest.model.Person;
import com.ust.rest.model.VisaDetails;
import com.ust.rest.repository.PersonRepository;

@Service
public class DocumentsService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person getAllDocsById(Long personId) {
		Person person = personRepository.findById(personId).get();
		if (person==null) {
            throw new RuntimeException("Person not found with ID: " + personId);
        }
		return person;
	}
	
	public List<GovtId> getAllGovtIdsById(Long personId) {
	    return getDocumentsById(personId, Person::getGovtIds);
	}

	public List<Certificate> getAllCertificatesById(Long personId) {
	    return getDocumentsById(personId, Person::getCertificates);
	}
	
	public List<InsuranceDetails> getAllInsuranceDetailsById(Long personId) {
	    return getDocumentsById(personId, Person::getInsuranceDetails);
	}

	public List<VisaDetails> getAllVisasById(Long personId) {
	    return getDocumentsById(personId, Person::getVisaDetails);
	}
	
	public List<BankDetails> getAllBankDetailsById(Long personId) {
	    return getDocumentsById(personId, Person::getBankDetails);
	}
	public List<CardDetails> getAllCardDetailsByPersonAndBankId(Long personId, Long bankId) {
	    return getAllBankDetailsById(personId).stream()
	        .filter(bank -> bank.getId() == bankId) 
	        .flatMap(bank -> bank.getCardDetails().stream()) 
	        .toList(); 
	}
	
	public <T> List<T> getDocumentsById(Long personId, Function<Person, List<T>> documentGetter) {
	    Person person = getAllDocsById(personId);
	    
	    List<T> documents = documentGetter.apply(person);
	    if (documents.isEmpty()) {
	        throw new RuntimeException("No documents found for person with ID: " + personId);
	    }
	    return documents;
	}
	
	//Post service functions
	public List<GovtId> addGovtIdForPersonWithId(Long personId, GovtId govtId) {
		Person person = getAllDocsById(personId);
		List<GovtId> govtIds = person.getGovtIds();
		govtIds.add(govtId);
		person.setGovtIds(govtIds);
    	return personRepository.save(person).getGovtIds();
    }
}

