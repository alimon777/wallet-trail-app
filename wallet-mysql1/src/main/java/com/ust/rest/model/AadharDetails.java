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
public class AadharDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Aadhar number is required")
    private String aadharNumber;

    private String name; // Name as per Aadhar
    private String address; // Address as per Aadhar

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Establishing relationship with Person
}
