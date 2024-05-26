package com.upc.smartsproutbackend.controller;

import com.upc.smartsproutbackend.dto.CardDto;
import com.upc.smartsproutbackend.repository.CardRepository;
import com.upc.smartsproutbackend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/smartsprout/v1/card")
public class CardController {
    @Autowired
    private CardService cardService;
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    // URL: http://localhost:8080/api/smartsprout/v1/card
    // Method: POST
    @PostMapping("/addCard")
    public ResponseEntity<CardDto> create(@RequestBody CardDto cardDto) {
        CardDto createCard = cardService.createCard(cardDto);
        return ResponseEntity.ok().body(createCard);
    }

    /*
    @GetMapping
    public ResponseEntity<List<CardDto>> getAllCards() {
        List<CardDto> cards = cardService.getAllCards();
        return ResponseEntity.ok().body(cards);
    }

    //By id
    @GetMapping
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        CardDto card = cardService.getCardById(id);
        return ResponseEntity.ok().body(card);
    }
     */
}
