package com.everis.CreditCardMS.Service;

import com.everis.CreditCardMS.Model.CreditCard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService
{
    //Get all CreditCards from DB
    public Flux<CreditCard> findAllCreditCards();

    //Get creditcard by Number
    public Mono<CreditCard> findCardByNumber(String number);

    //Get credicard by Owner
    public Mono<CreditCard> findCardByOwner(String owner);

    //Create creditcard data
    public Mono<CreditCard> addCreditCard(CreditCard card);

    //Update creditcard data

    //Delete creditcard data
    public Mono<Void> delCard(CreditCard card);


}