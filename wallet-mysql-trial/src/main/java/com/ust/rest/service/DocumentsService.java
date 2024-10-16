package com.ust.rest.service;

import java.util.List;
import java.util.function.BiConsumer;
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
import com.ust.rest.repository.BankDetailsRepository;
import com.ust.rest.repository.PersonRepository;

@Service
public class DocumentsService {
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BankDetailsRepository bankRepository;
	
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
	
	public <T> List<T> addDocumentForPersonWithId(Long personId, T document, Function<Person, List<T>> getDocumentList, BiConsumer<Person, List<T>> setDocumentList) {
	    Person person = getAllDocsById(personId);           // Get the person object by ID
	    List<T> documents = getDocumentList.apply(person);  // Get the list of documents (GovtIds or Certificates)
	    documents.add(document);                            // Add the new document to the list
	    setDocumentList.accept(person, documents);          // Set the updated list in the person object
	    personRepository.save(person);                      // Save the updated person
	    return getDocumentList.apply(person);               // Return the updated list
	}

	// To add GovtId
	public List<GovtId> addGovtIdForPersonWithId(Long personId, GovtId govtId) {
	    return addDocumentForPersonWithId(personId, govtId, Person::getGovtIds, Person::setGovtIds);
	}

	// To add Certificate
	public List<Certificate> addCertificatesForPersonWithId(Long personId, Certificate certificate) {
	    return addDocumentForPersonWithId(personId, certificate, Person::getCertificates, Person::setCertificates);
	}
	
	public List<BankDetails> addBankDetailsForPersonWithId(Long personId, BankDetails bankDetail) {
	    return addDocumentForPersonWithId(personId, bankDetail, Person::getBankDetails, Person::setBankDetails);
	}
	
	public List<VisaDetails> addVisaDetailsForPersonWithId(Long personId, VisaDetails visaDetail) {
	    return addDocumentForPersonWithId(personId, visaDetail, Person::getVisaDetails, Person::setVisaDetails);
	}
	
	public List<InsuranceDetails> addInsuranceDetailsForPersonWithId(Long personId, InsuranceDetails insuranceDetail) {
	    return addDocumentForPersonWithId(personId, insuranceDetail, Person::getInsuranceDetails, Person::setInsuranceDetails);
	}
	
	public BankDetails addCardDetailsForPersonWithId(Long personId, Long bankId, CardDetails cardDetail) {
	    // Fetch the person
	    Person person = getAllDocsById(personId);

	    // Fetch the BankDetails by bankId from the person's bank details
	    BankDetails bankDetails = person.getBankDetails().stream()
	        .filter(bank -> bank.getId()==bankId)
	        .findFirst()
	        .orElseThrow(() -> new RuntimeException("Bank not found with ID: " + bankId));

	    // Set the bank details in the card before adding it
	    cardDetail.setBankDetails(bankDetails);

	    // Add the card details to the bank
	    bankDetails.getCardDetails().add(cardDetail);

	    // Save the updated bank details
	    bankRepository.save(bankDetails);

	    // Return the updated list of bank details
	    return person.getBankDetails().stream()
		        .filter(bank -> bank.getId()==bankId)
		        .findFirst()
		        .orElseThrow(() -> new RuntimeException("Bank not found with ID: " + bankId));
	}


}

