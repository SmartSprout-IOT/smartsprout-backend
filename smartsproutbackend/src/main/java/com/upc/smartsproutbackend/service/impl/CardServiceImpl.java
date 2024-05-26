package com.upc.smartsproutbackend.service.impl;

import com.upc.smartsproutbackend.dto.CardDto;
import com.upc.smartsproutbackend.models.Card;
import com.upc.smartsproutbackend.repository.CardRepository;
import com.upc.smartsproutbackend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardDto createCard(CardDto cardDto) {
        Card card = new Card();
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardholderName(cardDto.getCardholderName());
        card.setExpiryDate(cardDto.getExpiryDate());
        card.setCvv(cardDto.getCvv());
        card.setCreatedAt(cardDto.getCreatedAt());

        card = cardRepository.save(card);
        return mapToDto(card);
    }

    @Override
    public List<CardDto> getAllCards() {
        return cardRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CardDto getCardById(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
        return mapToDto(card);
    }

    private CardDto mapToDto(Card card) {
        return CardDto.builder()
                ///.id(card.getId())
                .cardNumber(card.getCardNumber())
                .cardholderName(card.getCardholderName())
                .expiryDate(card.getExpiryDate())
                .cvv(card.getCvv())
                .createdAt(card.getCreatedAt())
                .build();
    }
}
