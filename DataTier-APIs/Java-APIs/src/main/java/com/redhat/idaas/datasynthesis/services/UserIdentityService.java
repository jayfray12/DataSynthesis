package com.redhat.idaas.datasynthesis.services;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.UserIdentity;
import com.redhat.idaas.datasynthesis.models.DataGeneratedUserIdentitiesEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class UserIdentityService extends RandomizerService<DataGeneratedUserIdentitiesEntity, UserIdentity> {

    @Override
    protected long count(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedUserIdentitiesEntity.count();
        }
        return DataGeneratedUserIdentitiesEntity.count((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected PanacheQuery<DataGeneratedUserIdentitiesEntity> findAll(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedUserIdentitiesEntity.findAll();
        }
        return DataGeneratedUserIdentitiesEntity.find((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected UserIdentity mapEntityToDTO(DataGeneratedUserIdentitiesEntity e) {
        return new UserIdentity(e.getUserIdentityValue(), e.getUserDomain(), e.getAdditionalAttributes());
    }
}
