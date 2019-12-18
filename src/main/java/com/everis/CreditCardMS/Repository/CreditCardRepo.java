package com.everis.CreditCardMS.Repository;

import com.everis.CreditCardMS.Model.CreditCard;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface CreditCardRepo extends ReactiveMongoRepository<CreditCard, String>
{
    Mono<CreditCard> findByNumber(String number);

    Mono<CreditCard> findByOwner(String owner);
}