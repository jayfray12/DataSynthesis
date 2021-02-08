package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AccountNumber {
    public String accountNumber;

    public AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
