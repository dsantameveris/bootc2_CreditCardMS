package com.everis.CreditCardMS.Controller;

import com.everis.CreditCardMS.Model.CreditCard;
import com.everis.CreditCardMS.Service.Impl.CreditCardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CreditCardController
{
    //Service Instance
    @Autowired
    private CreditCardServiceImpl service;

    //Create Account
    @PostMapping("/creditcard/create")
    public Mono<CreditCard> createAccount(CreditCard card)
    {
        return service.addAccount(card);
    }

    //Delete Card
    @DeleteMapping("/creditcard/delete")
    public Mono<Void> deleteAccount(CreditCard card)
    {
        return service.delAccount(card);
    }

    //Get all CreditCards
    @GetMapping("/creditcard/all")
    public Flux<CreditCard> getAllAccounts()
    {
        return service.findAllAccounts();
    }
}