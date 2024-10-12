package com.ust.rest.controller;

import com.ust.rest.model.PanDetails;
import com.ust.rest.service.PanDetailsService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pan")
public class PanDetailsController {

    @Autowired
    private PanDetailsService panDetailsService;

    @GetMapping
    public List<PanDetails> getAllPanDetails() {
        return panDetailsService.getAllPanDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanDetails> getPanDetailsById(@PathVariable long id) {
        return panDetailsService.getPanDetailsById(id);
    }

    @PostMapping
    public PanDetails createPanDetails(@RequestBody PanDetails panDetails) {
        return panDetailsService.createPanDetails(panDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanDetails> updatePanDetails(@PathVariable long id, @RequestBody PanDetails panDetails) {
        return panDetailsService.updatePanDetails(id, panDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanDetails(@PathVariable long id) {
        return panDetailsService.deletePanDetails(id);
    }
}
