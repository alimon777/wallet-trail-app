package com.ust.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Bank name is required")
    private String bankName;

    @NotBlank(message = "Account holder's name is required")
    private String holderName;

    @NotBlank(message = "IFSC code is required")
    private String ifscCode; // IFSC code
    
    @NotBlank(message = "Branch name is required")
    private String branch; // Branch name


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull(message = "Person association can't be null")
    private Person person; // Many GovtId records can belong to one person

    @OneToMany(mappedBy = "bankDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CardDetails> cardDetails; // Linking card details to bank
    
    @Column(name = "person_id", insertable = false, updatable = false)
    private Long personId;

    // Method to set person and automatically set personId
    public void setPerson(Person person) {
        this.person = person;
        this.personId = (person != null) ? person.getId() : null; // Set personId based on person
    }
}
