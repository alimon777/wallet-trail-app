package com.ust.rest.repository;

import com.ust.rest.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
    // Additional query methods can be defined here if needed
}
