package com.ust.rest.service;

import com.ust.rest.model.BankDetails;
import com.ust.rest.repository.BankDetailsRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    public ResponseEntity<BankDetails> getBankDetailsById(long id) {
        Optional<BankDetails> bankDetails = bankDetailsRepository.findById(id);
        return bankDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public BankDetails createBankDetails(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    public ResponseEntity<BankDetails> updateBankDetails(long id, BankDetails bankDetails) {
        if (!bankDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bankDetails.setId(id);
        return ResponseEntity.ok(bankDetailsRepository.save(bankDetails));
    }

    public ResponseEntity<Void> deleteBankDetails(long id) {
        if (!bankDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bankDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
