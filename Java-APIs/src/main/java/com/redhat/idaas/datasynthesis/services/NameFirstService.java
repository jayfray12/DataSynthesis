package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.NameFirst;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataExistingNameFirstEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class NameFirstService extends RandomizerService<DataExistingNameFirstEntity> {

    @Override
    protected long count() {
        return DataExistingNameFirstEntity.count();
    }

    @Override
    protected PanacheQuery<DataExistingNameFirstEntity> findAll() {
        return DataExistingNameFirstEntity.findAll();
    }

    @Transactional
    public boolean insertNameFirst(String firstName, String gender) throws DataSynthesisException {
        DataExistingNameFirstEntity entity = new DataExistingNameFirstEntity(firstName, gender);
        entity.setRegisteredApp(getRegisteredApp());
        entity.setStatus(getDefaultStatus());
        return entity.safePersist();
    }

    public List<NameFirst> retrieveNameFirsts(int count) {
        Set<DataExistingNameFirstEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new NameFirst(e.getFirstName(), e.getGender())).collect(Collectors.toList());
    }
}
