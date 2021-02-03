package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class EIN {
    public String EinNumber;

    //Getters and Setters
    public String getEinNumber() {
        return EinNumber;
    }

    public void setEinNumber(String einNumber) {
        EinNumber = einNumber;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
