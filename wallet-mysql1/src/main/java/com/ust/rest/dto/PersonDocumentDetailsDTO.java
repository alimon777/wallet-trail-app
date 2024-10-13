package com.ust.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDocumentDetailsDTO {
	private PersonBasicDetailsDTO personBasicDetails;

    // Document Details
    private List<GovtIdDTO> govtIds;
    private List<BankDetailsDTO> bankDetails;
    private List<VisaDetailsDTO> visaDetails;
    private List<InsuranceDetailsDTO> insuranceDetails;
    private List<CertificateDTO> certificates;
}
