package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BankAccount {

    public String bankAccount;

    public BankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
