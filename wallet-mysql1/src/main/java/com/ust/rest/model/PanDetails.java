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
public class PanDetails {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "PAN number is required")
    private String panNumber;

    private String name; // Name as per PAN

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person; // Establishing relationship with Person
}
