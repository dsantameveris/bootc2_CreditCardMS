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

    //Create Credit Card
    @Override
    public Mono<CreditCard> addAccount(CreditCard card) {
        return repo.save(card);
    }

    //Delete Card
    @Override
    public Mono<Void> delAccount(CreditCard card) {
        return repo.delete(card);
    }

    //Get All Credit Cards
    @Override
    public Flux<CreditCard> findAllAccounts() {
        return repo.findAll();
    }    
}