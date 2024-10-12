package com.ust.rest.controller;

import com.ust.rest.model.AadharDetails;
import com.ust.rest.service.AadharDetailsService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aadhar")
public class AadharDetailsController {

    @Autowired
    private AadharDetailsService aadharDetailsService;

    @GetMapping
    public List<AadharDetails> getAllAadharDetails() {
        return aadharDetailsService.getAllAadharDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AadharDetails> getAadharDetailsById(@PathVariable long id) {
        return aadharDetailsService.getAadharDetailsById(id);
    }

    @PostMapping
    public AadharDetails createAadharDetails(@RequestBody AadharDetails aadharDetails) {
        return aadharDetailsService.createAadharDetails(aadharDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AadharDetails> updateAadharDetails(@PathVariable long id, @RequestBody AadharDetails aadharDetails) {
        return aadharDetailsService.updateAadharDetails(id, aadharDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAadharDetails(@PathVariable long id) {
        return aadharDetailsService.deleteAadharDetails(id);
    }
}
