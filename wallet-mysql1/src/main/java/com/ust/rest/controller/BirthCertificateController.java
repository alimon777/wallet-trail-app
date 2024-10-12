package com.ust.rest.controller;

import com.ust.rest.model.BirthCertificate;
import com.ust.rest.service.BirthCertificateService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birth-certificates")
public class BirthCertificateController {

    @Autowired
    private BirthCertificateService birthCertificateService;

    @GetMapping
    public List<BirthCertificate> getAllBirthCertificates() {
        return birthCertificateService.getAllBirthCertificates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirthCertificate> getBirthCertificateById(@PathVariable long id) {
        return birthCertificateService.getBirthCertificateById(id);
    }

    @PostMapping
    public BirthCertificate createBirthCertificate(@RequestBody BirthCertificate birthCertificate) {
        return birthCertificateService.createBirthCertificate(birthCertificate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BirthCertificate> updateBirthCertificate(@PathVariable long id, @RequestBody BirthCertificate birthCertificate) {
        return birthCertificateService.updateBirthCertificate(id, birthCertificate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBirthCertificate(@PathVariable long id) {
        return birthCertificateService.deleteBirthCertificate(id);
    }
}
