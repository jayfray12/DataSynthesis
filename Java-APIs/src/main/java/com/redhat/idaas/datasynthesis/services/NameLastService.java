package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.NameLast;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataExistingNameLastEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class NameLastService extends RandomizerService<DataExistingNameLastEntity> {

    @Override
    protected long count() {
        return DataExistingNameLastEntity.count();
    }

    @Override
    protected PanacheQuery<DataExistingNameLastEntity> findAll() {
        return DataExistingNameLastEntity.findAll();
    }

    @Transactional
    public boolean insertNameLast(String lastName) throws DataSynthesisException {
        DataExistingNameLastEntity entity = new DataExistingNameLastEntity(lastName);
        entity.setRegisteredApp(getRegisteredApp());
        entity.setStatus(getDefaultStatus());
        return entity.safePersist();
    }

    public List<NameLast> retrieveNameLasts(int count) {
        Set<DataExistingNameLastEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new NameLast(e.getLastName())).collect(Collectors.toList());
    }
}
