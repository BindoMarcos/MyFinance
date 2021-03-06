package com.example.myfinance.services;

import com.example.myfinance.models.Card;
import com.example.myfinance.models.OutMessage;
import com.example.myfinance.repositories.CardRepo;

import com.example.myfinance.utils.MathUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepo cardRepo;

    public Iterable<Card> getCardsByDni(Long ownerId) {
        return cardRepo.getCards(ownerId);
    }

    public Iterable<Card> getAllCards() {
        return cardRepo.getAllCards();
    }

    public OutMessage postCard(Card card) {
        long id = MathUtil.getRandomId();

        if (cardRepo.existsByCBU(card.getCBU())) {
            return new OutMessage("Error", "Existing CBU!");
        } else if (cardRepo.existsByAlias(card.getAlias())) {
            return new OutMessage("Error", "Existing Alias!");
        } else {
            while (cardRepo.exists(Long.valueOf(id))) {
                id = MathUtil.getRandomId();
            }
            card.setCardId(id);
            return new OutMessage("Created Successfuly!", cardRepo.saveCard(card));
        }
    }

    public OutMessage deleteCard(Long ownerId, Long CBU) {
        boolean valid = false;
        Long foundId = -1L;

        Iterable<Card> ownerCards = cardRepo.getCards(ownerId);
        for (Card card : ownerCards) {
            if (card.getCBU().equals(CBU)) {
                valid = true;
                foundId = card.getCardId();
                break;
            }
        }
        if (valid) {
            cardRepo.deleteById(foundId);
            return new OutMessage("Ok", "Card erased!");
        } else
            return new OutMessage("Error", "The CBU doesn't exist o doesn't belong to you!");
    }
}
