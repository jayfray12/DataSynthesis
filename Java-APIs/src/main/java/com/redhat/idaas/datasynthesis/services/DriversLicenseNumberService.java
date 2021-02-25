package com.redhat.idaas.datasynthesis.services;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.models.DataGeneratedDriversLicensesEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class DriversLicenseNumberService extends RandomizerService<DataGeneratedDriversLicensesEntity> {

    @Override
    protected long count() {
        return PanacheEntityBase.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedDriversLicensesEntity> findAll() {
        return PanacheEntityBase.findAll();
    }
}
