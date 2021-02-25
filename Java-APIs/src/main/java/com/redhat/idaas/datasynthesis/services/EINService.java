package com.redhat.idaas.datasynthesis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedEinEntity;

import org.apache.commons.lang3.StringUtils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class EINService extends RandomizerService<DataGeneratedEinEntity> {

    private Random einRandomizer = new Random();

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
        int upperBound1 = 99;
        int upperBound2 = 9999999;

        for (int i = 0; i < generationCounter; i++)
        {
            StringBuilder einnumber = new StringBuilder();
            // Create the first 3 phone number digits
            einnumber.append(StringUtils.leftPad(String.valueOf(einRandomizer.nextInt(upperBound1)), 2, "0")).append('-')
            // Create thelast four name and make sure length is correct
            .append(StringUtils.leftPad(String.valueOf(einRandomizer.nextInt(upperBound2)), 7, "0"));

            DataGeneratedEinEntity einNumberEntity = DataGeneratedEinEntity
                    .findByEinNumber(einnumber.toString());
            if (einNumberEntity == null) {
                einNumberEntity = new DataGeneratedEinEntity();
                einNumberEntity.setEinValue(einnumber.toString());
                DataGeneratedEinEntity.persist(einNumberEntity);
            }

            einnumberList.add(einNumberEntity);
        }

        return einnumberList;
    }

    // Persist Data
    public List<EIN> retrieveRandomEINs(int count) {
        Set<DataGeneratedEinEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new EIN(e.getEinValue())).collect(Collectors.toList());
    }
}
