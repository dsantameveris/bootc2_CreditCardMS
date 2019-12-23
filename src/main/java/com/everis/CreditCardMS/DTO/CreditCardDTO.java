package com.everis.CreditCardMS.DTO;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreditCardDTO
{
    @NotBlank
    private String number;

    @NotBlank
    private double max;

    public CreditCardDTO()
    {

    }

    public CreditCardDTO(String number, double max)
    {
        this.number = number;
        this.max = max;
    }
}