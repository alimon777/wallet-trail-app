package com.ust.rest.repository;

import com.ust.rest.model.VisaDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaDetailsRepository extends JpaRepository<VisaDetails, Long> {
    // Additional query methods can be defined here if needed
}
