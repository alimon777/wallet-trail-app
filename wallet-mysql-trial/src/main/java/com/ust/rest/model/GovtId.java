package com.ust.rest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idType", "person_id"}, name = "UniqueGovtIdPerPerson")
})
public class GovtId {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "ID type can't be blank")
    private String idType; // Should be restricted to specific types like Aadhar, PAN, etc.

    @NotBlank(message = "ID number can't be blank")
    private String idNumber;

    @NotBlank(message = "Name in ID can't be blank")
    private String name;

    private LocalDate issueDate; // Optional

    private LocalDate expiryDate; // Optional

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull(message = "Person association can't be null")
    private Person person; // Many GovtId records can belong to one person
}
