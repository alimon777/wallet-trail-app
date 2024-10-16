package com.ust.rest.controller;

import com.ust.rest.dto.PersonBasicDetailsDTO;
import com.ust.rest.model.BankDetails;
import com.ust.rest.model.CardDetails;
import com.ust.rest.model.Certificate;
import com.ust.rest.model.GovtId;
import com.ust.rest.model.InsuranceDetails;
import com.ust.rest.model.Person;
import com.ust.rest.model.VisaDetails;
import com.ust.rest.service.DocumentsService;
import com.ust.rest.service.PersonalDetailsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonalDetailsService detailsService;
    
    @Autowired
    private DocumentsService documentService;

    @GetMapping("/basic-details")
    public List<PersonBasicDetailsDTO> getAllPersonsBasicDetails() {
        return detailsService.getAllPersonsBasicDetails();
    }
    
    @GetMapping("/{id}/basic-details")
    public PersonBasicDetailsDTO getDocumentsOfPersonById(@PathVariable Long id) {
        return detailsService.getPersonBasicDetailsById(id);
    }
    
    @GetMapping("/{id}/all-details")
    public Person getAllDocumentsOfPersonById(@PathVariable Long id) {
        return documentService.getAllDocsById(id);
    }
    
    @GetMapping("/{id}/govtIds")
    public List<GovtId> getAllGovtIdsOfPersonById(@PathVariable Long id) {
        return documentService.getAllGovtIdsById(id);
    }
    
    @GetMapping("/{id}/certificates")
    public List<Certificate> getAllCertificatesById(@PathVariable Long id) {
        return documentService.getAllCertificatesById(id);
    }
    
    @GetMapping("/{id}/insurance-details")
    public List<InsuranceDetails> getAllInsuranceDetailsById(@PathVariable Long id) {
        return documentService.getAllInsuranceDetailsById(id);
    }
    
    @GetMapping("/{id}/visa-details")
    public List<VisaDetails> getAllVisasById(@PathVariable Long id) {
        return documentService.getAllVisasById(id);
    }
    
    @GetMapping("/{id}/bank-details")
    public List<BankDetails> getAllBankDetailsById(@PathVariable Long id) {
        return documentService.getAllBankDetailsById(id);
    }
    

    @GetMapping("/{personId}/{bankId}/card-details")
    public List<CardDetails> getAllCardDetailsByPersonAndBankId(@PathVariable Long personId,@PathVariable Long bankId) {
        return documentService.getAllCardDetailsByPersonAndBankId(personId,bankId);
    }
    
    @PostMapping("/{id}/govtIds/add")
    public List<GovtId> addGovtIdForPersonById(@PathVariable Long id, @RequestBody GovtId govtId) {
        return documentService.addGovtIdForPersonWithId(id, govtId);
    }

    // Add a Certificate to a person
    @PostMapping("/{id}/certificates/add")
    public List<Certificate> addCertificateForPersonById(@PathVariable Long id, @RequestBody Certificate certificate) {
        return documentService.addCertificatesForPersonWithId(id, certificate);
    }

    // Add an InsuranceDetail to a person
    @PostMapping("/{id}/insurance-details/add")
    public List<InsuranceDetails> addInsuranceDetailsForPersonById(@PathVariable Long id, @RequestBody InsuranceDetails insuranceDetails) {
        return documentService.addInsuranceDetailsForPersonWithId(id, insuranceDetails);
    }

    // Add a VisaDetail to a person
    @PostMapping("/{id}/visa-details/add")
    public List<VisaDetails> addVisaDetailsForPersonById(@PathVariable Long id, @RequestBody VisaDetails visaDetails) {
        return documentService.addVisaDetailsForPersonWithId(id, visaDetails);
    }

    // Add a BankDetail to a person
    @PostMapping("/{id}/bank-details/add")
    public List<BankDetails> addBankDetailsForPersonById(@PathVariable Long id, @RequestBody BankDetails bankDetails) {
        return documentService.addBankDetailsForPersonWithId(id, bankDetails);
    }

    // Add CardDetails for a specific person and bank
    @PostMapping("/{personId}/{bankId}/card-details/add")
    public BankDetails addCardDetailsForPersonAndBankId(@PathVariable Long personId, @PathVariable Long bankId, @RequestBody CardDetails cardDetails) {
        return documentService.addCardDetailsForPersonWithId(personId, bankId, cardDetails);
    }
}
