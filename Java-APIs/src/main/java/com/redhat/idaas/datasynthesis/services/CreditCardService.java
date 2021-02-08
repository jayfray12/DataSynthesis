package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.models.DataGeneratedCreditCardEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class CreditCardService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedCreditCardEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedCreditCardEntity> findAll() {
        return DataGeneratedCreditCardEntity.findAll();
    }

    public List<CreditCard> retrieveRandomCreditCards(int count) {
        Set<DataGeneratedCreditCardEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new CreditCard(e.getCreditCardNumber(), e.getCreditCardName())).collect(Collectors.toList());
    }
}
