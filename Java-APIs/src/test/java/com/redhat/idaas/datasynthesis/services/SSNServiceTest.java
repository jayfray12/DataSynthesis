package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.SSN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedSocialSecurityNumberEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.panache.mock.PanacheMock.InvokeRealMethodException;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class SSNServiceTest {

    @Inject
    SSNService service;

    @Test
    @Transactional
    public void testSSNGeneration() throws InvokeRealMethodException {
        DefaultApplication.seed();
        List<DataGeneratedSocialSecurityNumberEntity> list = service.generateSSN(10);
        Assertions.assertEquals(10, list.size());

        Assertions.assertEquals(10, DataGeneratedSocialSecurityNumberEntity.count());
    }

    @Test
    public void testSSNRandomizerHappyPath() throws Exception {
        testRandomizer(500000l, 1534, 1534);
    }

    @Test
    public void testSSNRandomizerMaxOut() throws Exception {
        testRandomizer(500000l, 10000, 5000);
    }

    @Test
    public void testSSNRandomizerLowRecordCount() throws Exception {
        testRandomizer(50L, 4321, 50);
    }

    private void testRandomizer(long databaseCount, int retrieveCount, int returnedCount) throws Exception {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.count()).thenReturn(databaseCount);
        PanacheQuery allQuery = Mockito.mock(PanacheQuery.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findAll()).thenReturn(allQuery);
        Mockito.when(allQuery.page(Mockito.anyInt(), Mockito.anyInt())).thenReturn(allQuery);
        Mockito.when(allQuery.firstResult()).thenAnswer(invocation -> {
            Random r = new Random();
            DataGeneratedSocialSecurityNumberEntity entity = new DataGeneratedSocialSecurityNumberEntity();
            entity.setSocialSecurityNumberId(r.nextLong());
            return entity;
        });
        
        List<SSN> randomSSNs = service.retrieveRandomSSNs(retrieveCount);
        Assertions.assertEquals(returnedCount, randomSSNs.size());
    }
}
