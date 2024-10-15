package com.ust.rest.repository;

import com.ust.rest.model.InsuranceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceDetailsRepository extends JpaRepository<InsuranceDetails, Long> {
    // Additional query methods can be defined here if needed
}
