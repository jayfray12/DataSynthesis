package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.BirthDate;
import com.redhat.idaas.datasynthesis.models.DataGeneratedDateOfBirthEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class DateOfBirthService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedDateOfBirthEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedDateOfBirthEntity> findAll() {
        return DataGeneratedDateOfBirthEntity.findAll();
    }

    public List<BirthDate> retrieveRandomBirthDates(int count) {
        Set<DataGeneratedDateOfBirthEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new BirthDate(e.getDateOfBirth(), e.getDateOfBirthDate(), e.getAge())).collect(Collectors.toList());
    }
}
