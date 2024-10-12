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
public class BirthCertificate {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Certificate number is required")
    private String certificateNumber;

    private String name; // Name on the certificate

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Establishing relationship with Person
}
