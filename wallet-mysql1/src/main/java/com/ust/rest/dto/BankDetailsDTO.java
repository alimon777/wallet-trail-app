package com.ust.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetailsDTO {
    private long id;
    private String accountNumber;
    private String bankName;
    private String holderName;
    private String ifscCode;
    private String branch;
}
