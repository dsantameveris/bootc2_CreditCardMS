package com.everis.CreditCardMS.Service;

import com.everis.CreditCardMS.DTO.CreditCardDTO;
import com.everis.CreditCardMS.Model.CreditCard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService
{
    //Get all CreditCards
    public Flux<CreditCard> findAllCreditCards();

    //Get all CreditCards (DTO)
    public Flux<CreditCardDTO> findAllCreditCardsDTO();

    //Get creditcard by Number
    public Mono<CreditCard> findCardByNumber(String number);

    //Get creditcard by Number (DTO)
    public Mono<CreditCardDTO> findCardByNumberDTO(String number);

    //Get credicard by DNI
    public Mono<CreditCard> findCardByOwnerDni(String dni);

    //Get credicard by DNI (DTO)
    public Mono<CreditCardDTO> findCardByOwnerDniDTO(String dni);

    //Create creditcard data
    public Mono<CreditCard> addCreditCard(CreditCard card);

    //Delete creditcard data
    public Mono<Void> delCard(CreditCard card);
}