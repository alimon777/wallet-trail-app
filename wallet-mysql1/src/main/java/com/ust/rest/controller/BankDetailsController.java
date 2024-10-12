package com.ust.rest.controller;

import com.ust.rest.model.BankDetails;
import com.ust.rest.service.BankDetailsService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsService.getAllBankDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDetails> getBankDetailsById(@PathVariable long id) {
        return bankDetailsService.getBankDetailsById(id);
    }

    @PostMapping
    public BankDetails createBankDetails(@RequestBody BankDetails bankDetails) {
        return bankDetailsService.createBankDetails(bankDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDetails> updateBankDetails(@PathVariable long id, @RequestBody BankDetails bankDetails) {
        return bankDetailsService.updateBankDetails(id, bankDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankDetails(@PathVariable long id) {
        return bankDetailsService.deleteBankDetails(id);
    }
}
S