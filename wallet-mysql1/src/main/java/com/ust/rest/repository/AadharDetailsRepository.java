package com.ust.rest.repository;

import com.ust.rest.model.AadharDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadharDetailsRepository extends JpaRepository<AadharDetails, Long> {
    // Additional query methods can be defined here if needed
}
