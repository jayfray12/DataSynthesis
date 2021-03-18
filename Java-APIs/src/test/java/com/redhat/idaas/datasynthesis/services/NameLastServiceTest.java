package com.redhat.idaas.datasynthesis.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataExistingNameLastEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class NameLastServiceTest {
    @Inject
    NameLastService service;

    @Test
    @Transactional
    public void testInsertLastHappy() throws DataSynthesisException {
        DefaultApplication.seed();
        Assertions.assertTrue(service.insertNameLast("name1"));
        Assertions.assertTrue(service.insertNameLast("name2"));
        Assertions.assertEquals(2, DataExistingNameLastEntity.count());
    }

    @Test
    @Transactional
    public void testInsertLastDuplicate() throws DataSynthesisException {
        DefaultApplication.seed();
        Assertions.assertTrue(service.insertNameLast("name1"));
        Assertions.assertFalse(service.insertNameLast("name1"));
        Assertions.assertEquals(1, DataExistingNameLastEntity.count());
    }

    @Test
    @Transactional
    public void testInertLastNoSeed() {
        Assertions.assertThrows(DataSynthesisException.class, () -> {
            service.insertNameLast("name1");
        });
    }
}
