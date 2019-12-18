package com.everis.CreditCardMS.Model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CreditCards")
public class CreditCard
{
    @Id
    private String Id;

    @NotBlank
    private String number;

    @NotBlank
    private String owner;

    // @NotBlank
    // private double balance;

    @NotBlank
    private double max;
}