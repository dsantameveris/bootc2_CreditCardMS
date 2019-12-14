package com.everis.CreditCardMS.Service;

import com.everis.CreditCardMS.Model.CreditCard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService
{
    //Create Credit Card
    public Mono<CreditCard> addAccount(CreditCard card);

    //Delete Credit Card
    public Mono<Void> delAccount(CreditCard card);

    //Get all CreditCards from DB
    public Flux<CreditCard> findAllAccounts();
}