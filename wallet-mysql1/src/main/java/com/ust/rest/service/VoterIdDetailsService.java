package com.ust.rest.service;

import com.ust.rest.model.VoterIdDetails;
import com.ust.rest.repository.VoterIdDetailsRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterIdDetailsService {

    @Autowired
    private VoterIdDetailsRepository voterIdDetailsRepository;

    public List<VoterIdDetails> getAllVoterIdDetails() {
        return voterIdDetailsRepository.findAll();
    }

    public ResponseEntity<VoterIdDetails> getVoterIdDetailsById(long id) {
        Optional<VoterIdDetails> voterIdDetails = voterIdDetailsRepository.findById(id);
        return voterIdDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public VoterIdDetails createVoterIdDetails(VoterIdDetails voterIdDetails) {
        return voterIdDetailsRepository.save(voterIdDetails);
    }

    public ResponseEntity<VoterIdDetails> updateVoterIdDetails(long id, VoterIdDetails voterIdDetails) {
        if (!voterIdDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        voterIdDetails.setId(id);
        return ResponseEntity.ok(voterIdDetailsRepository.save(voterIdDetails));
    }

    public ResponseEntity<Void> deleteVoterIdDetails(long id) {
        if (!voterIdDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        voterIdDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
