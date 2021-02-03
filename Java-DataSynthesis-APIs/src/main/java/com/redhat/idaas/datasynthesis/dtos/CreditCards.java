package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CreditCards {

    public String CreditCardNumber;
    public String CreditCardName;

    //Getters and Setters
    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return CreditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        CreditCardName = creditCardName;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
