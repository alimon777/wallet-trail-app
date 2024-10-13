package com.ust.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDetailsDTO {
    private long id;
    private String policyNumber;
    private String providerName;  
    private String insuranceType;
    private LocalDate startDate; 
    private LocalDate endDate; 
}
