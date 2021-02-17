package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedEinEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class EINService extends RandomizerService<DataGeneratedEinEntity> {

    @Override
    protected long count() {
        return DataGeneratedEinEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedEinEntity> findAll() {
        return DataGeneratedEinEntity.findAll();
    }

    // Generate Data
    @Transactional
    public List<DataGeneratedEinEntity> generateEinNumber(long generationCounter) {
        List<DataGeneratedEinEntity> einnumberList = new ArrayList<DataGeneratedEinEntity>(
                (int) generationCounter);
        Random einRandomizer = new Random();
        int upperBound1 = 99;
        int upperBound2 = 9999999;

        for (int i = 0; i < generationCounter; i++)
        {
            StringBuilder einnumber = new StringBuilder();
            // Create the first 3 phone number digits
            einnumber.append(StringUtils.leftPad(String.valueOf(einRandomizer.nextInt(upperBound1)), 2, "0")).append('-')
            // Create thelast four name and make sure length is correct
            .append(StringUtils.leftPad(String.valueOf(einRandomizer.nextInt(upperBound2)), 7, "0"))

            DataGeneratedEinEntity einNumberEntity = DataGeneratedEinEntity
                    .findByEinNumber(einnumber.toString());
            if (einNumberEntity == null) {
                einNumberEntity = new DataGeneratedEinEntity();
                einNumberEntity.setEinNumberValue(einnumber.toString());
                DataGeneratedEinNumberEntity.persist(einNumberEntity);
            }

            einnumberList.add(phoneNumberEntity);
        }

        return einnumberList;
    }

    // Persist Data
    public List<EIN> retrieveRandomEINs(int count) {
        Set<DataGeneratedEinEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new EIN(e.getEinValue())).collect(Collectors.toList());
    }
}
