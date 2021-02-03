package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SSN {
    public String SocialSecurityNumberValue;

    //Getters and Setters
    public String getSocialSecurityNumberValue() {
        return SocialSecurityNumberValue;
    }

    public void setSocialSecurityNumberValue(SSN socialSecurityNumber) {
        SocialSecurityNumberValue = socialSecurityNumber;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
