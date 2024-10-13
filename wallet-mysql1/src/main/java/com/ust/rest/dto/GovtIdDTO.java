// GovtIdDTO.java
package com.ust.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GovtIdDTO {
    private long id;
    private String idType;
    private String idNumber;
    private String name;
    private LocalDate issueDate;
    private LocalDate expiryDate;
}
