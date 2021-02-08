package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PhoneNumber {
    public String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
