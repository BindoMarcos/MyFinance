package com.example.myfinance.controllers;

import com.example.myfinance.models.Card;
import com.example.myfinance.models.OutMessage;
import com.example.myfinance.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService service;

    @GetMapping(value = {"/{ownerId}","/{ownerId}/"})
    public Iterable<Card> getCards(@PathVariable Long ownerId) {
        return service.getCardsByDni(ownerId);
    }

    @GetMapping(value = {"/all","/all/"})
    public Iterable<Card> getCards() {
        return service.getAllCards();
    }

    @PostMapping(value = {"/save","/save/"})
    public OutMessage postCard(@RequestBody Card card) {
        return service.postCard(card);
    }

    @DeleteMapping(value = {"/delete","/delete/"})
    public OutMessage deleteCard(@RequestParam Long ownerId, @RequestParam Long CBU) {
       return service.deleteCard(ownerId, CBU);
    }
}