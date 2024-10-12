package com.ust.rest.service;

import com.ust.rest.model.CardDetails;
import com.ust.rest.repository.CardDetailsRepository; // Assume this repository is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardDetailsService {

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    public List<CardDetails> getAllCardDetails() {
        return cardDetailsRepository.findAll();
    }

    public ResponseEntity<CardDetails> getCardDetailsById(long id) {
        Optional<CardDetails> cardDetails = cardDetailsRepository.findById(id);
        return cardDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public CardDetails createCardDetails(CardDetails cardDetails) {
        return cardDetailsRepository.save(cardDetails);
    }

    public ResponseEntity<CardDetails> updateCardDetails(long id, CardDetails cardDetails) {
        if (!cardDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cardDetails.setId(id);
        return ResponseEntity.ok(cardDetailsRepository.save(cardDetails));
    }

    public ResponseEntity<Void> deleteCardDetails(long id) {
        if (!cardDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cardDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
