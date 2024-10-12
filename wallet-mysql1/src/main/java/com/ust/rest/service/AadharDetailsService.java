package com.ust.rest.service;

import com.ust.rest.model.AadharDetails;
import com.ust.rest.repository.AadharDetailsRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AadharDetailsService {

    @Autowired
    private AadharDetailsRepository aadharDetailsRepository;

    public List<AadharDetails> getAllAadharDetails() {
        return aadharDetailsRepository.findAll();
    }

    public ResponseEntity<AadharDetails> getAadharDetailsById(long id) {
        Optional<AadharDetails> aadharDetails = aadharDetailsRepository.findById(id);
        return aadharDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public AadharDetails createAadharDetails(AadharDetails aadharDetails) {
        return aadharDetailsRepository.save(aadharDetails);
    }

    public ResponseEntity<AadharDetails> updateAadharDetails(long id, AadharDetails aadharDetails) {
        if (!aadharDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aadharDetails.setId(id);
        return ResponseEntity.ok(aadharDetailsRepository.save(aadharDetails));
    }

    public ResponseEntity<Void> deleteAadharDetails(long id) {
        if (!aadharDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aadharDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
