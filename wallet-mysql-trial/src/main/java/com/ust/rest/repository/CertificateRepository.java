package com.ust.rest.repository;

import com.ust.rest.model.GovtId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<GovtId, Long> {
    // Additional query methods can be defined here if needed
}
