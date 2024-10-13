package com.ust.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaDetailsDTO {
    private long id;
    private String visaType;
    private String visaNumber;
    private String countryOfIssue;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}
