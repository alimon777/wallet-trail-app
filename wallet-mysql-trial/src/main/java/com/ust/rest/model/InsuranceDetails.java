package com.ust.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InsuranceDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Insurance provider name is required")
    private String providerName; // Name of the insurance provider

    @NotBlank(message = "Policy number is required")
    private String policyNumber; // Insurance policy number

    @NotNull(message = "Policy start date is required")
    private LocalDate startDate; // Policy start date

    @NotNull(message = "Policy end date is required")
    private LocalDate endDate; // Policy end date

    @NotBlank(message = "Insurance type is required")
    private String insuranceType; // Type of insurance (e.g., health, life, auto)

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull(message = "Person association can't be null")
    private Person person; // Linking multiple insurance policies to a person
}
