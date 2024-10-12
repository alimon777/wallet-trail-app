package com.ust.rest.repository;

import com.ust.rest.model.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Long> {
    // Additional query methods can be defined here if needed
}
