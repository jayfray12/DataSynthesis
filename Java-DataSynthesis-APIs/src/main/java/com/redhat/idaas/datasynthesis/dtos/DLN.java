package com.redhat.idaas.datasynthesis.dtos;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DLN {
    public String DLNNumber;
    public String DLNState;
    public String CompleteDLN;

    //Getters and Setters
    public String getDLNNumber() {
        return DLNNumber;
    }

    public void setDLNNumber(String DLNNumber) {
        this.DLNNumber = DLNNumber;
    }

    public String getDLNState() {
        return DLNState;
    }

    public void setDLNState(String DLNState) {
        this.DLNState = DLNState;
    }

    public String getCompleteDLN() {
        return CompleteDLN;
    }

    public void setCompleteDLN(String completeDLN) {
        CompleteDLN = completeDLN;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
