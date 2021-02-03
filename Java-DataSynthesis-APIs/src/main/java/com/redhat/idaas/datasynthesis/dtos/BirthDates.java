package com.redhat.idaas.datasynthesis.dtos;

import java.util.Date;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BirthDates {
    public String DateOfBirth;
    public Date DateOfBirthDate;
    public int Age;
    //Getters and Setters
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirthDate() {
        return DateOfBirthDate;
    }

    public void setDateOfBirthDate(Date dateOfBirthDate) {
        DateOfBirthDate = dateOfBirthDate;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    //toString
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
