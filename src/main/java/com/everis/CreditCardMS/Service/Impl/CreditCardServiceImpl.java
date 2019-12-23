package com.everis.CreditCardMS.Service.Impl;

import com.everis.CreditCardMS.DTO.CreditCardDTO;
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

    //Get All Credit Cards (DTO)
    @Override
    public Flux<CreditCardDTO> findAllCreditCardsDTO() {
        return repo.findAll().map(card -> new CreditCardDTO(card.getNumber(), card.getMax()));
    }

    //Get card by Number
    @Override
    public Mono<CreditCard> findCardByNumber(String number) {
        return repo.findByNumber(number);
    }

    //Get card by Number (DTO)
    @Override
    public Mono<CreditCardDTO> findCardByNumberDTO(String number) {
        return repo.findByNumber(number).map(card -> new CreditCardDTO(card.getNumber(), card.getMax()));
    }

    //Get card by Owner Dni 
    @Override
    public Mono<CreditCard> findCardByOwnerDni(String dni) {
        return repo.findByOwner_Dni(dni);
    }

    //Get card by Owner Dni (DTO)
    @Override
    public Mono<CreditCardDTO> findCardByOwnerDniDTO(String dni) {
        return repo.findByOwner_Dni(dni).map(card -> new CreditCardDTO(card.getNumber(), card.getMax()));
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