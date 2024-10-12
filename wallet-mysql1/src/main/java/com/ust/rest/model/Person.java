package com.ust.rest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    private String gender; // Consider using an Enum for gender

    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String phoneNumber;

    private String address; // Optional additional detail

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private AadharDetails aadharDetails;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private PanDetails panDetails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DrivingLicense> drivingLicenses;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private BirthCertificate birthCertificate;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoterIdDetails> voterIdDetails;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankDetails> bankDetails;
}
