package com.ust.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String ifscCode; // IFSC code
    private String branch; // Branch name

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Link to Person

    @OneToMany(mappedBy = "bankDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardDetails> cardDetails; // Linking card details to bank

}
