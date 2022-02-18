package com.example.myfinance.repositories;

import com.example.myfinance.models.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepo {
    @Autowired
    private ICardRepo icardRepo;

    public Card saveCard(Card card) {
        return icardRepo.save(card);
    }

    public Iterable<Card> getCards(Long ownerId) {
        return icardRepo.findByOwnerId(ownerId);
    }

    public Iterable<Card> getAllCards() {
        return icardRepo.findAll();
    }

    public Boolean exists(Long cardId) {
        return icardRepo.existsById(cardId);
    }

    public Boolean existsByCBU(Long CBU) {
        return icardRepo.existsByCBU(CBU);
    }

    public Boolean existsByAlias(String alias) {
        return icardRepo.existsByAlias(alias);
    }

    public void deleteById(Long ownerId) {
        icardRepo.deleteById(ownerId);
    }

}
