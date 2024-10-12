package com.ust.rest.repository;

import com.ust.rest.model.VoterIdDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterIdDetailsRepository extends JpaRepository<VoterIdDetails, Long> {
    // Additional query methods can be defined here if needed
}
