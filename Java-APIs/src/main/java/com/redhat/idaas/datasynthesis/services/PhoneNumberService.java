package com.redhat.idaas.datasynthesis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.PhoneNumber;
import com.redhat.idaas.datasynthesis.models.DataGeneratedPhoneNumberEntity;

import org.apache.commons.lang3.StringUtils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PhoneNumberService extends RandomizerService<DataGeneratedPhoneNumberEntity> {
    @Override
    protected long count() {
        return DataGeneratedPhoneNumberEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedPhoneNumberEntity> findAll() {
        return DataGeneratedPhoneNumberEntity.findAll();
    }

    // Generate Data
    @Transactional
    public List<DataGeneratedPhoneNumberEntity> generatePhoneNumber(long generationCounter) {
        List<DataGeneratedPhoneNumberEntity> phoneNumberList = new ArrayList<DataGeneratedPhoneNumberEntity>((int) generationCounter);
        int upperBound1 = 999;
        int upperBound2 = 9999;

        for (int i = 0; i < generationCounter;)
        {
            StringBuilder phoneNumber = new StringBuilder();
            // Create the first 3 phone number digits
            phoneNumber.append(StringUtils.leftPad(String.valueOf(rand.nextInt(upperBound1 + 1)), 3, "0")).append('-')
                    // Create the last four name and make sure length is correct
                    .append(StringUtils.leftPad(String.valueOf(rand.nextInt(upperBound2 + 1)), 4, "0"));

            DataGeneratedPhoneNumberEntity phoneNumberEntity = new DataGeneratedPhoneNumberEntity(phoneNumber.toString());
            phoneNumberEntity.setRegisteredApp(getRegisteredApp());
            if (phoneNumberEntity.safePersist()) {
                phoneNumberList.add(phoneNumberEntity);
                i++;
            }
        }

        return phoneNumberList;
    }

    // Persist to Data Tier
    public List<PhoneNumber> retrieveRandomPhoneNumbers(int count) {
        Set<DataGeneratedPhoneNumberEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new PhoneNumber(e.getPhoneNumberValue())).collect(Collectors.toList());
    }
}
