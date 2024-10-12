package com.ust.rest.repository;

import com.ust.rest.model.PanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanDetailsRepository extends JpaRepository<PanDetails, Long> {
    // Additional query methods can be defined here if needed
}
