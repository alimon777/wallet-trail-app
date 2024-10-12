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
public class CardDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Card number is required")
    private String cardNumber;

    private String cardHolderName;

    private String expiryDate; // Consider using LocalDate

    private String cardType; // e.g., Credit, Debit

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private BankDetails bankDetails; // Linking card details to bank
}
