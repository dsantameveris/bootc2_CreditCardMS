package com.everis.CreditCardMS.Service.Impl;

import com.everis.CreditCardMS.Model.CreditCard;
import com.everis.CreditCardMS.Repository.CreditCardRepo;
import com.everis.CreditCardMS.Service.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardRepo repo;

    
    //Get All Credit Cards
    @Override
    public Flux<CreditCard> findAllCreditCards() {
        return repo.findAll();
    }

    //Get card by Number
    @Override
    public Mono<CreditCard> findCardByNumber(String number) {
        return repo.findByNumber(number);
    }

    //Get card by Owner
    @Override
    public Mono<CreditCard> findCardByOwner(String owner) {
        return repo.findByOwner(owner);
    }

    //Create Credit Card
    @Override
    public Mono<CreditCard> addCreditCard(CreditCard card) {
        return repo.save(card);
    }

    //Delete Card
    @Override
    public Mono<Void> delCard(CreditCard card) {
        return repo.delete(card);
    }
}