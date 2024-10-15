package com.ust.rest.repository;

import com.ust.rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Additional query methods can be defined here if needed
}
