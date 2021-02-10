package com.redhat.idaas.datasynthesis.services;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class DriversLicenseNumberService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedDriversLicensesEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedDriversLicensesEntity> findAll() {
        return DataGeneratedDriversLicensesEntity.findAll();
    }
}
