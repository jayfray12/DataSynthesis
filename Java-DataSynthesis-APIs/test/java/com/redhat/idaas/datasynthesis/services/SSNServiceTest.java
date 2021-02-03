package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.redhat.idaas.datasynthesis.dtos.SSN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedSocialSecurityNumberEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.panache.mock.PanacheMock.InvokeRealMethodException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SSNServiceTest {

    @Inject
    SSNService service;

    @Test
    public void testSSNGenerationHappyPath() throws InvokeRealMethodException {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findBySSN(Mockito.anyString())).thenReturn(null);

        List<DataGeneratedSocialSecurityNumberEntity> list = service.generateSSN(10);
        Assertions.assertEquals(10, list.size());
        PanacheMock.verify(DataGeneratedSocialSecurityNumberEntity.class, Mockito.times(0)).persist();
    }

    @Test
    public void testSSNGenerationWithExisting() {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findBySSN(Mockito.anyString())).thenAnswer(invocation -> new DataGeneratedSocialSecurityNumberEntity(invocation.getArgument(0)));

        List<DataGeneratedSocialSecurityNumberEntity> list = service.generateSSN(10);
        Assertions.assertEquals(10, list.size());
        PanacheMock.verify(DataGeneratedSocialSecurityNumberEntity.class, Mockito.times(0)).persist();
        PanacheMock.verify(DataGeneratedSocialSecurityNumberEntity.class, Mockito.times(10)).findBySSN(Mockito.anyString());
    }

    @Test
    public void testSSNRandomizerHappyPath() throws Exception {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.count()).thenReturn(500000l);
        PanacheQuery allQuery = Mockito.mock(PanacheQuery.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findAll()).thenReturn(allQuery);
        Mockito.when(allQuery.page(Mockito.anyInt(), Mockito.anyInt())).thenReturn(allQuery);
        Mockito.when(allQuery.firstResult()).thenAnswer(invocation -> {
            Random r = new Random();
            DataGeneratedSocialSecurityNumberEntity entity = new DataGeneratedSocialSecurityNumberEntity();
            entity.setSocialSecurityNumberId(r.nextLong());
            return entity;
        });
        
        List<SSN> randomSSNs = service.retrieveRandomSSNs(1534);
        Assertions.assertEquals(1534, randomSSNs.size());
    }

    @Test
    public void testSSNRandomizerMaxOut() throws Exception {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.count()).thenReturn(500000l);
        PanacheQuery allQuery = Mockito.mock(PanacheQuery.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findAll()).thenReturn(allQuery);
        Mockito.when(allQuery.page(Mockito.anyInt(), Mockito.anyInt())).thenReturn(allQuery);
        Mockito.when(allQuery.firstResult()).thenAnswer(invocation -> {
            Random r = new Random();
            DataGeneratedSocialSecurityNumberEntity entity = new DataGeneratedSocialSecurityNumberEntity();
            entity.setSocialSecurityNumberId(r.nextLong());
            return entity;
        });
        
        List<SSN> randomSSNs = service.retrieveRandomSSNs(10000);
        Assertions.assertEquals(5000, randomSSNs.size());
    }

    @Test
    public void testSSNRandomizerLowRecordCount() throws Exception {
        PanacheMock.mock(DataGeneratedSocialSecurityNumberEntity.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.count()).thenReturn(50L);
        PanacheQuery allQuery = Mockito.mock(PanacheQuery.class);
        Mockito.when(DataGeneratedSocialSecurityNumberEntity.findAll()).thenReturn(allQuery);
        Mockito.when(allQuery.page(Mockito.anyInt(), Mockito.anyInt())).thenReturn(allQuery);
        Mockito.when(allQuery.firstResult()).thenAnswer(invocation -> {
            Random r = new Random();
            DataGeneratedSocialSecurityNumberEntity entity = new DataGeneratedSocialSecurityNumberEntity();
            entity.setSocialSecurityNumberId(r.nextLong());
            return entity;
        });
        
        List<SSN> randomSSNs = service.retrieveRandomSSNs(4321);
        Assertions.assertEquals(50, randomSSNs.size());
    }
}
