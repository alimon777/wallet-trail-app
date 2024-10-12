package com.ust.rest.controller;

import com.ust.rest.model.CardDetails;
import com.ust.rest.service.CardDetailsService; // Assume this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardDetailsController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @GetMapping
    public List<CardDetails> getAllCardDetails() {
        return cardDetailsService.getAllCardDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDetails> getCardDetailsById(@PathVariable long id) {
        return cardDetailsService.getCardDetailsById(id);
    }

    @PostMapping
    public CardDetails createCardDetails(@RequestBody CardDetails cardDetails) {
        return cardDetailsService.createCardDetails(cardDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDetails> updateCardDetails(@PathVariable long id, @RequestBody CardDetails cardDetails) {
        return cardDetailsService.updateCardDetails(id, cardDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardDetails(@PathVariable long id) {
        return cardDetailsService.deleteCardDetails(id);
    }
}
