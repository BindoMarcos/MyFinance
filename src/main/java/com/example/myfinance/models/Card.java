package com.example.myfinance.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;

@Document
@Data
@AllArgsConstructor
public class Card {

    @Id
    private Long cardId;

    private Long ownerId;
    private String bankName;
    private String accountOwner;
    private Long CBU;
    private String alias;

}