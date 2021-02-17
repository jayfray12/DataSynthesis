package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.PhoneNumber;
import com.redhat.idaas.datasynthesis.models.DataGeneratedPhoneNumberEntity;

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
        List<DataGeneratedPhoneNumberEntity> phonenumberList = new ArrayList<DataGeneratedPhoneNumberEntity>(
                (int) generationCounter);
        Random phoneNumberRandomizer = new Random();
        int upperBound1 = 999;
        int upperBound2 = 9999;

        for (int i = 0; i < generationCounter; i++)
        {
            StringBuilder phonenumber = new StringBuilder();
            // Create the first 3 phone number digits
            phonenumber.append(StringUtils.leftPad(String.valueOf(phoneNumberRandomizer.nextInt(upperBound1)), 3, "0")).append('-')
                    // Create thelast four name and make sure length is correct
                    .append(StringUtils.leftPad(String.valueOf(phoneNumberRandomizer.nextInt(upperBound2)), 4, "0"))

            DataGeneratedPhoneNumberEntity phoneNumberEntity = DataGeneratedPhoneNumberEntity
                    .findByPhoneNumber(phonenumber.toString());
            if (phoneNumberEntity == null) {
                phonenumberEntity = new DataGeneratedPhoneNumberEntity();
                phoneNumberEntity.setPhoneNumberValue(phonenumber.toString());
                DataGeneratedSocialSecurityNumberEntity.persist(phoneNumberEntity);
            }

            phonenumberList.add(phoneNumberEntity);
        }

        return phonenumberList;
    }


    // Persist to Data Tier
    public List<PhoneNumber> retrieveRandomPhoneNumbers(int count) {
        Set<DataGeneratedPhoneNumberEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new PhoneNumber(e.getPhoneNumberValue())).collect(Collectors.toList());
    }
}
