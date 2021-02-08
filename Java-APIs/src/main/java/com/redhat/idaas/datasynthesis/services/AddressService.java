package com.redhat.idaas.datasynthesis.services;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.models.DataGeneratedAddressesEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class AddressService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedAddressesEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedAddressesEntity> findAll() {
        return DataGeneratedAddressesEntity.findAll();
    }

}
