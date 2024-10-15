package com.ust.rest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Certificate {
    @Id
    @GeneratedValue
    private long id;
    private String certificateNumber;
    @NotBlank(message = "Certificate name is required")
    private String certificateName;

    @NotBlank(message = "Certificate name is required")
    private String issuingAuthority; // New field for the name of the certificate

    private LocalDate issueDate; 
    private LocalDate expiryDate;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id", nullable = false)
    @NotBlank(message = "Person association is required")
    private Person person; // Relationship with Person entity
}
