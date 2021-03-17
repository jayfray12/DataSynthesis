package com.redhat.idaas.datasynthesis.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataExistingNameFirstEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class NameFirstServiceTest {
    @Inject
    NameFirstService service;

    @Test
    @Transactional   
    public void testInsertFirstHappy() throws DataSynthesisException {
        DefaultApplication.seed();
        Assertions.assertTrue(service.insertNameFirst("name1", "F"));
        Assertions.assertTrue(service.insertNameFirst("name1", "M"));
        Assertions.assertEquals(2, DataExistingNameFirstEntity.count());
    }

    @Test
    @Transactional
    public void testInsertFirstDuplicate() throws DataSynthesisException {
        DefaultApplication.seed();
        Assertions.assertTrue(service.insertNameFirst("name1", "F"));
        Assertions.assertFalse(service.insertNameFirst("name1", "F"));
        Assertions.assertEquals(1, DataExistingNameFirstEntity.count());
    }

    @Test
    @Transactional
    public void testInertFirstNoSeed() {
        Assertions.assertThrows(DataSynthesisException.class, () -> {
            service.insertNameFirst("name1", "F");
        });
    }
}
