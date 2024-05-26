package com.upc.smartsproutbackend.service;

import com.upc.smartsproutbackend.dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto createCard(CardDto cardDto);
    List<CardDto> getAllCards();
    CardDto getCardById(Long id);
}
