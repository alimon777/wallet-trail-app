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
public class DrivingLicense {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "License number is required")
    private String licenseNumber;

    private String name; // Name as per License
    private String issuedBy; // Issuing authority

    @ElementCollection
    @CollectionTable(name = "vehicle_types", joinColumns = @JoinColumn(name = "driving_license_id"))
    @Column(name = "vehicle_type")
    private List<String> allowedVehicleTypes; // List of allowed vehicle types

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Establishing relationship with Person
}
