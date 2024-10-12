package com.ust.rest.controller;

import com.ust.rest.model.DrivingLicense;
import com.ust.rest.service.DrivingLicenseService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driving-licenses")
public class DrivingLicenseController {

    @Autowired
    private DrivingLicenseService drivingLicenseService;

    @GetMapping
    public List<DrivingLicense> getAllDrivingLicenses() {
        return drivingLicenseService.getAllDrivingLicenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrivingLicense> getDrivingLicenseById(@PathVariable long id) {
        return drivingLicenseService.getDrivingLicenseById(id);
    }

    @PostMapping
    public DrivingLicense createDrivingLicense(@RequestBody DrivingLicense drivingLicense) {
        return drivingLicenseService.createDrivingLicense(drivingLicense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrivingLicense> updateDrivingLicense(@PathVariable long id, @RequestBody DrivingLicense drivingLicense) {
        return drivingLicenseService.updateDrivingLicense(id, drivingLicense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrivingLicense(@PathVariable long id) {
        return drivingLicenseService.deleteDrivingLicense(id);
    }
}
