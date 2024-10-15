package com.ust.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Card number is required")
    private String cardNumber;
    
    @NotBlank(message = "Card number is required")
    private String cardHolderName;

    @NotBlank(message = "Card number is required")
    private String expiryDate; // Consider using LocalDate

    @NotBlank(message = "Card number is required")
    private String cardType; // e.g., Credit, Debit

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "bank_id", nullable = false)
    private BankDetails bankDetails; // Linking card details to bank
}
