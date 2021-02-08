package com.redhat.idaas.datasynthesis.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public abstract class RandomizerService {

    protected abstract long count();

    protected abstract <T extends PanacheEntityBase> PanacheQuery<T> findAll();

    public <T extends PanacheEntityBase> Set<T> findRandomRows(int count) {
        long recordCount = count();
        Random rand = new Random();
        int totalCount = Math.min(count, 5000);
        if (recordCount < totalCount) {
            totalCount = (int) recordCount;
        }

        Set<T> entities = new HashSet<T>(totalCount);
        // If they want more records than we have in the database
        // Just return the entire database
        if (recordCount < totalCount) {
            entities.addAll(findAll().list());
        } else {
            while (entities.size() < totalCount) {
                T record = findAll().page(rand.nextInt((int) recordCount), 1).firstResult();
                entities.add(record);
            }
        }
    
        return entities;
    }
}
