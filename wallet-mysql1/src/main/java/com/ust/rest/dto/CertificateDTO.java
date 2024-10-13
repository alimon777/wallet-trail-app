package com.ust.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateDTO {
    private long id;
    private String certificateNumber;
    private String certificateName;
    private String issuingAuthority;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}

