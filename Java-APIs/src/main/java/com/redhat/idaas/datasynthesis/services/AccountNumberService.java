package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.AccountNumber;
import com.redhat.idaas.datasynthesis.models.DataGeneratedAccountNumbersEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class AccountNumberService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedAccountNumbersEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedAccountNumbersEntity> findAll() {
        return DataGeneratedAccountNumbersEntity.findAll();
    }

    public List<AccountNumber> retrieveRandomAccountNumbers(int count) {
        Set<DataGeneratedAccountNumbersEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new AccountNumber(e.getAccountNumberValue())).collect(Collectors.toList());
    }
}
