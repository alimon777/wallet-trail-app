package com.ust.rest.repository;

import com.ust.rest.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
    // Additional query methods can be defined here if needed
}
