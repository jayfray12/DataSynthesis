package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserIdentity {
    public String userIdentity;
    public String domainValue;
    public String additionalDetail;

    public UserIdentity(String userIdentity, String domainValue, String additionalDetail) {
        this.userIdentity = userIdentity;
        this.domainValue = domainValue;
        this.additionalDetail = additionalDetail;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
