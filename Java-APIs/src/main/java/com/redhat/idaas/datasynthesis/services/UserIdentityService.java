package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.UserIdentity;
import com.redhat.idaas.datasynthesis.models.DataGeneratedUserIdentitiesEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class UserIdentityService extends RandomizerService {

    @Override
    protected long count() {
        return DataGeneratedUserIdentitiesEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedUserIdentitiesEntity> findAll() {
        return DataGeneratedUserIdentitiesEntity.findAll();
    }

    public List<UserIdentity> retrieveRandomUserIdentities(int count) {
        Set<DataGeneratedUserIdentitiesEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new UserIdentity(e.getUserIdentityValue(), e.getUserDomain(), e.getAdditionalAttributes())).collect(Collectors.toList());
    }
}
