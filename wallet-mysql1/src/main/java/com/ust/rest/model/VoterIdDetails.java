package com.ust.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VoterIdDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Voter ID number is required")
    private String voterIdNumber;

    private String name; // Name as per Voter ID

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Link to Bank Details
}
