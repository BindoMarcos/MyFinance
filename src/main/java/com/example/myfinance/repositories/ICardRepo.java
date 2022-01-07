package com.example.myfinance.repositories;

import com.example.myfinance.models.Card;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepo extends MongoRepository<Card, Long> {

    public Iterable<Card> findByOwnerId(Long ownerId);
    public Boolean existsByCBU(Long CBU);
    public Boolean existsByAlias(String alias);
}
