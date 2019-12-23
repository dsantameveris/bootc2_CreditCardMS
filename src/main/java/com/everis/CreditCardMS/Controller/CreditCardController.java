package com.everis.CreditCardMS.Controller;

import com.everis.CreditCardMS.DTO.CreditCardDTO;
import com.everis.CreditCardMS.Model.CreditCard;
import com.everis.CreditCardMS.Service.Impl.CreditCardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController
{
    //Service Instance
    @Autowired
    private CreditCardServiceImpl service;

    //Get all CreditCards
    @GetMapping("/all")
    public Flux<CreditCard> getAllCards()
    {
        return service.findAllCreditCards();
    }

    //Get all CreditCards (DTO)
    @GetMapping("/alldto")
    public Flux<CreditCardDTO> getAllCardsDTO()
    {
        return service.findAllCreditCardsDTO();
    }

    //Get card by number
    @GetMapping("/number/{number}")
    public Mono<CreditCard> getCardByNumber(@PathVariable String number)
    {
        return service.findCardByNumber(number);
    }

    //Get card by number (DTO)
    @GetMapping("/numberdto/{number}")
    public Mono<CreditCardDTO> getCardByNumberDTO(@PathVariable String number)
    {
        return service.findCardByNumberDTO(number);
    }

    //Get card by owner DNI
    @GetMapping("/owner/{dni}")
    public Mono<CreditCard> getCardByOwner(@PathVariable String dni)
    {
        return service.findCardByOwnerDni(dni);
    }

    //Get card by owner DNI (DTO)
    @GetMapping("/ownerdto/{dni}")
    public Mono<CreditCardDTO> getCardByOwnerDTO(@PathVariable String dni)
    {
        return service.findCardByOwnerDniDTO(dni);
    }

    //Create creditcard data
    @PostMapping
    public Mono<CreditCard> createCreditCard(@RequestBody CreditCard card)
    {
        return service.addCreditCard(card);
    }

    //Update creditcard data
    @PutMapping("/edit/{number}")
    public Mono<CreditCard> editCreditCard(@RequestBody CreditCard card,@PathVariable String number)
    {
        return service.findCardByNumber(number)
                        .flatMap(cc -> 
                        {
                            cc.setMax(card.getMax());
                            return service.addCreditCard(cc);
                        });
    }

    //Delete client data on db
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCreditCard(@PathVariable String number)
    {        
        return service.findCardByNumber(number)
                        .flatMap(card -> service.delCard(card));
    }
}