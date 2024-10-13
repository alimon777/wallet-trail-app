package com.ust.rest.controller;

import com.ust.rest.dto.PersonBasicDetailsDTO;
import com.ust.rest.dto.PersonDocumentDetailsDTO;
import com.ust.rest.model.Person;
import com.ust.rest.service.DocumentsService;
import com.ust.rest.service.PersonalDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public PersonDocumentDetailsDTO getAllDocumentsOfPersonById(@PathVariable Long id) {
        return documentService.getAllDocsById(id);
    }
}
