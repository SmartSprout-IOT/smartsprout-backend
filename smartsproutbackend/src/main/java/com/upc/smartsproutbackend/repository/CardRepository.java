package com.upc.smartsproutbackend.repository;

import com.upc.smartsproutbackend.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByUserId(Long user_id);
    boolean existsByCardNumber(String card_number);
    List<Card> findByUserId(Long user_id);
    Card findByUserIdAndCardMain (Long user_id, boolean card_main);
}