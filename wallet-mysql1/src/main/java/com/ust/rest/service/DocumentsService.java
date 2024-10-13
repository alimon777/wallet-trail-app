package com.ust.rest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.dto.BankDetailsDTO;
import com.ust.rest.dto.CertificateDTO;
import com.ust.rest.dto.GovtIdDTO;
import com.ust.rest.dto.InsuranceDetailsDTO;
import com.ust.rest.dto.PersonBasicDetailsDTO;
import com.ust.rest.dto.PersonDocumentDetailsDTO;
import com.ust.rest.dto.VisaDetailsDTO;
import com.ust.rest.model.Person;
import com.ust.rest.repository.PersonRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Service
public class DocumentsService {
	@Autowired
	private PersonRepository personRepository;
	
	public PersonDocumentDetailsDTO getAllDocsById(Long personId) {
		
		Person person = personRepository.findById(personId).get();
		
		if (person!=null) {
            throw new RuntimeException("Person not found with ID: " + personId);
        }
		
		PersonDocumentDetailsDTO dto = new PersonDocumentDetailsDTO();

	    // Reuse the existing basic details DTO conversion
	    PersonBasicDetailsDTO basicDetailsDTO = new PersonBasicDetailsDTO();
	    basicDetailsDTO.setId(person.getId());
	    basicDetailsDTO.setFirstName(person.getFirstName());
	    basicDetailsDTO.setLastName(person.getLastName());
	    basicDetailsDTO.setDateOfBirth(person.getDateOfBirth());
	    basicDetailsDTO.setGender(person.getGender());
	    basicDetailsDTO.setEmail(person.getEmail());
	    basicDetailsDTO.setPhoneNumber(person.getPhoneNumber());
	    basicDetailsDTO.setAddress(person.getAddress());

	    dto.setPersonBasicDetails(basicDetailsDTO);

	    // Set GovtId details
	    List<GovtIdDTO> govtIdDTOs = person.getGovtId().stream()
	        .map(govtId -> new GovtIdDTO(
	            govtId.getId(), govtId.getIdType(), govtId.getIdNumber(),
	            govtId.getName(), govtId.getIssueDate(), govtId.getExpiryDate()))
	        .collect(Collectors.toList());
	    dto.setGovtIds(govtIdDTOs);

	    // Set BankDetails
	    List<BankDetailsDTO> bankDetailsDTOs = person.getBankDetails().stream()
	        .map(bank -> new BankDetailsDTO(
	            bank.getId(), bank.getAccountNumber(), bank.getBankName(),
	            bank.getHolderName(), bank.getIfscCode(), bank.getBranch()))
	        .collect(Collectors.toList());
	    dto.setBankDetails(bankDetailsDTOs);

	    // Set VisaDetails
	    List<VisaDetailsDTO> visaDetailsDTOs = person.getVisaDetails().stream()
	        .map(visa -> new VisaDetailsDTO(
	            visa.getId(), visa.getVisaType(), visa.getVisaNumber(),
	            visa.getCountryOfIssue(), visa.getIssueDate(), visa.getExpiryDate()))
	        .collect(Collectors.toList());
	    dto.setVisaDetails(visaDetailsDTOs);

	    // Set InsuranceDetails
	    List<InsuranceDetailsDTO> insuranceDTOs = person.getInsuranceDetails().stream()
	        .map(insurance -> new InsuranceDetailsDTO(
	            insurance.getId(), insurance.getPolicyNumber(), insurance.getProviderName(),
	            insurance.getInsuranceType(), insurance.getStartDate(), insurance.getEndDate()
	           ))
	        .collect(Collectors.toList());
	    dto.setInsuranceDetails(insuranceDTOs);

	    // Set Certificates
	    List<CertificateDTO> certificateDTOs = person.getCertificates().stream()
	        .map(certificate -> new CertificateDTO(
	            certificate.getId(), certificate.getCertificateNumber(),
	            certificate.getCertificateName(), certificate.getIssuingAuthority(),
	            certificate.getIssueDate(),certificate.getExpiryDate()))
	        .collect(Collectors.toList());
	    dto.setCertificates(certificateDTOs);

	    return dto;
	}
	private String providerName; // Name of the insurance provider

    @NotBlank(message = "Policy number is required")
    private String policyNumber; // Insurance policy number

    @NotNull(message = "Policy start date is required")
    private LocalDate startDate; // Policy start date

    @NotNull(message = "Policy end date is required")
    private LocalDate endDate; // Policy end date

    @NotBlank(message = "Insurance type is required")
    private String insuranceType;
}
