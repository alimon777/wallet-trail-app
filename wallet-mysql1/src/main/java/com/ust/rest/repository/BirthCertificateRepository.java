package com.ust.rest.repository;

import com.ust.rest.model.BirthCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthCertificateRepository extends JpaRepository<BirthCertificate, Long> {
    // Additional query methods can be defined here if needed
}
