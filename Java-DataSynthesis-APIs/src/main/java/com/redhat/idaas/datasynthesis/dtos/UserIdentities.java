package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UserIdentities {
    public String UserIdentity;
    public String DomainValue;
    public String AdditionalDetail;

    //Getters and Setters
    public String getUserIdentity() {
        return UserIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        UserIdentity = userIdentity;
    }

    public String getDomainValue() {
        return DomainValue;
    }

    public void setDomainValue(String domainValue) {
        DomainValue = domainValue;
    }

    public String getAdditionalDetail() {
        return AdditionalDetail;
    }

    public void setAdditionalDetail(String additionalDetail) {
        AdditionalDetail = additionalDetail;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
