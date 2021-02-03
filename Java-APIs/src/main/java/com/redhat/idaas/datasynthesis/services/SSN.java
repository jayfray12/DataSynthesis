package com.redhat.idaas.datasynthesis.services;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SSN {

    public static List<com.redhat.idaas.datasynthesis.dtos.SSN> generateSSN(long generationCounter)
    {
        // Create List for return
        List<com.redhat.idaas.datasynthesis.dtos.SSN> ssnList;
        ssnList = new ArrayList<com.redhat.idaas.datasynthesis.dtos.SSN>();
        // Create variable ArrayList for return
        ArrayList ssnArray = new ArrayList();
        Date createdDateVal = LocalDate.Now;
        //Create a local random object
        Random ssnRandomizer = new Random();
        int upperBound1 = 999;
        int upperBound2 = 99;
        int upperBound3 = 9999;
        //Loop per generationCount iteration
        for (int i = 0; i <= generationCounter; i++)
        {
            //Create the first 3 random SSN numbers while padding to the correct length
            Integer ssnPt1 = ssnRandomizer.nextInt(upperBound1);
            String SSN1 = ssnPt1.toString();
            StringUtils.leftPad(SSN1, 3, "0");

            //Create the middle 2 random SSN numbers while padding to the correct length
            Integer ssnPt2 = ssnRandomizer.nextInt(upperBound2);
            String SSN2 = ssnPt2.toString();
            StringUtils.leftPad(SSN2, 2, "0");

            //Create the ending 4 random SSN numbers while padding to the correct length
            Integer ssnPt3 = ssnRandomizer.nextInt(upperBound2);
            String SSN3 = ssnPt3.toString();
            StringUtils.leftPad(SSN3, 4, "0");

             // Return the SSN in the format 123-45-6789
            // sSSN1 + "-" + sSSN2 + "-" + sSSN3;
            String ssnComplete = SSN1 + "-" + SSN2 + "-" + SSN3;
            // Check to only add unique items to the output array
            if (!ssnArray.contains(ssnComplete))
            {
                ssnArray.add(ssnComplete);
            }
        }
        // loop thru and populate liST and populate SSN Structure
        for (int i=0; i<ssnArray.size(); i++)
        {
            int finalI = i;
            ssnList.add(new com.redhat.idaas.datasynthesis.dtos.SSN()
            {
               @Override
               public void setSocialSecurityNumberValue(com.redhat.idaas.datasynthesis.dtos.SSN socialSecurityNumber) {
                   super.setSocialSecurityNumberValue(ssnList.get(finalI));
               }
                //CreatedDate = createdDateVal
            });
        }
        return ssnList;
    }

}
