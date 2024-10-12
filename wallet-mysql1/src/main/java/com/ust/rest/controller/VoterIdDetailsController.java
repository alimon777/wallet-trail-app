package com.ust.rest.controller;

import com.ust.rest.model.VoterIdDetails;
import com.ust.rest.service.VoterIdDetailsService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voter-ids")
public class VoterIdDetailsController {

    @Autowired
    private VoterIdDetailsService voterIdDetailsService;

    @GetMapping
    public List<VoterIdDetails> getAllVoterIdDetails() {
        return voterIdDetailsService.getAllVoterIdDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoterIdDetails> getVoterIdDetailsById(@PathVariable long id) {
        return voterIdDetailsService.getVoterIdDetailsById(id);
    }

    @PostMapping
    public VoterIdDetails createVoterIdDetails(@RequestBody VoterIdDetails voterIdDetails) {
        return voterIdDetailsService.createVoterIdDetails(voterIdDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoterIdDetails> updateVoterIdDetails(@PathVariable long id, @RequestBody VoterIdDetails voterIdDetails) {
        return voterIdDetailsService.updateVoterIdDetails(id, voterIdDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoterIdDetails(@PathVariable long id) {
        return voterIdDetailsService.deleteVoterIdDetails(id);
    }
}
