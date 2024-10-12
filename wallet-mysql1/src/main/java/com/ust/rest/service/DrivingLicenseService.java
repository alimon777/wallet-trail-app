package com.ust.rest.service;

import com.ust.rest.model.DrivingLicense;
import com.ust.rest.repository.DrivingLicenseRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrivingLicenseService {

    @Autowired
    private DrivingLicenseRepository drivingLicenseRepository;

    public List<DrivingLicense> getAllDrivingLicenses() {
        return drivingLicenseRepository.findAll();
    }

    public ResponseEntity<DrivingLicense> getDrivingLicenseById(long id) {
        Optional<DrivingLicense> drivingLicense = drivingLicenseRepository.findById(id);
        return drivingLicense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public DrivingLicense createDrivingLicense(DrivingLicense drivingLicense) {
        return drivingLicenseRepository.save(drivingLicense);
    }

    public ResponseEntity<DrivingLicense> updateDrivingLicense(long id, DrivingLicense drivingLicense) {
        if (!drivingLicenseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        drivingLicense.setId(id);
        return ResponseEntity.ok(drivingLicenseRepository.save(drivingLicense));
    }

    public ResponseEntity<Void> deleteDrivingLicense(long id) {
        if (!drivingLicenseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        drivingLicenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
