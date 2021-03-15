package com.redhat.idaas.datasynthesis.services;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.models.BaseEntity;
import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;
import com.redhat.idaas.datasynthesis.models.RefDataStatusEntity;

@ApplicationScoped
public abstract class BaseService {
    protected RefDataApplicationEntity getRegisteredApp() {
        // TODO: get application by login user's tenant
        return RefDataApplicationEntity.findByApplicationCustomCode("DSynth");
    }

    protected RefDataStatusEntity getDefaultStatus() {
        return RefDataStatusEntity.findByStatusDescription("Active");
    }

    // return false if entity cannot persist because of uniqueness constraint violation
    // raise exception for other errors
    public static boolean safePersist(BaseEntity entity) {
        if (entity == null) {
            return true;
        } else {
            return entity.safePersist();
        }
    }
}

