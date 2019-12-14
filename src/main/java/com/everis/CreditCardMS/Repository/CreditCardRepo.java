package com.everis.CreditCardMS.Repository;

import com.everis.CreditCardMS.Model.CreditCard;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCardRepo extends ReactiveMongoRepository<CreditCard, String>
{

}