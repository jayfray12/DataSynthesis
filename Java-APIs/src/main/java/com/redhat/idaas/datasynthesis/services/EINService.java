package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedEinEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class EINService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedEinEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedEinEntity> findAll() {
        return DataGeneratedEinEntity.findAll();
    }

    public List<EIN> retrieveRandomEINs(int count) {
        Set<DataGeneratedEinEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new EIN(e.getEinValue())).collect(Collectors.toList());
    }
}
