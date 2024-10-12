package com.ust.rest.service;

import com.ust.rest.model.PanDetails;
import com.ust.rest.repository.PanDetailsRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanDetailsService {

    @Autowired
    private PanDetailsRepository panDetailsRepository;

    public List<PanDetails> getAllPanDetails() {
        return panDetailsRepository.findAll();
    }

    public ResponseEntity<PanDetails> getPanDetailsById(long id) {
        Optional<PanDetails> panDetails = panDetailsRepository.findById(id);
        return panDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public PanDetails createPanDetails(PanDetails panDetails) {
        return panDetailsRepository.save(panDetails);
    }

    public ResponseEntity<PanDetails> updatePanDetails(long id, PanDetails panDetails) {
        if (!panDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        panDetails.setId(id);
        return ResponseEntity.ok(panDetailsRepository.save(panDetails));
    }

    public ResponseEntity<Void> deletePanDetails(long id) {
        if (!panDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        panDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
