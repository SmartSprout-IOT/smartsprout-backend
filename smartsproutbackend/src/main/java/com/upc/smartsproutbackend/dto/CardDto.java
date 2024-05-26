package com.upc.smartsproutbackend.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CardDto {
    private String cardNumber;
    private String cardholderName;
    private LocalDate expiryDate;
    private String cvv;
    private LocalDate createdAt;
}
