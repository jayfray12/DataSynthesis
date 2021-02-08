package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.PhoneNumber;
import com.redhat.idaas.datasynthesis.models.DataGeneratedPhoneNumberEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class PhoneNumberService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedPhoneNumberEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedPhoneNumberEntity> findAll() {
        return DataGeneratedPhoneNumberEntity.findAll();
    }

    public List<PhoneNumber> retrieveRandomPhoneNumbers(int count) {
        Set<DataGeneratedPhoneNumberEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new PhoneNumber(e.getPhoneNumberValue())).collect(Collectors.toList());
    }
}
