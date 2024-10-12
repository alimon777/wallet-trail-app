package com.ust.rest.service;

import com.ust.rest.model.BirthCertificate;
import com.ust.rest.repository.BirthCertificateRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirthCertificateService {

    @Autowired
    private BirthCertificateRepository birthCertificateRepository;

    public List<BirthCertificate> getAllBirthCertificates() {
        return birthCertificateRepository.findAll();
    }

    public ResponseEntity<BirthCertificate> getBirthCertificateById(long id) {
        Optional<BirthCertificate> birthCertificate = birthCertificateRepository.findById(id);
        return birthCertificate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public BirthCertificate createBirthCertificate(BirthCertificate birthCertificate) {
        return birthCertificateRepository.save(birthCertificate);
    }

    public ResponseEntity<BirthCertificate> updateBirthCertificate(long id, BirthCertificate birthCertificate) {
        if (!birthCertificateRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        birthCertificate.setId(id);
        return ResponseEntity.ok(birthCertificateRepository.save(birthCertificate));
    }

    public ResponseEntity<Void> deleteBirthCertificate(long id) {
        if (!birthCertificateRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        birthCertificateRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
