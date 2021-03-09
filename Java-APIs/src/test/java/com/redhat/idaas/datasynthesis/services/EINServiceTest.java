package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedEinEntity;
import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;

import org.apache.http.util.Asserts;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.panache.mock.PanacheMock.InvokeRealMethodException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class EINServiceTest {
    @Inject
    EntityManager em;

    @Inject
    EINService service;

    @Test
    @Transactional
    public void testUnique() {
        RefDataApplicationEntity app = new RefDataApplicationEntity();
        app.setAppGuid("common");
        app.persist();

        DataGeneratedEinEntity ein = new DataGeneratedEinEntity();
        ein.setRegisteredApp(app);
        ein.setEinValue("einval");
        ein.persist();

        try {
            DataGeneratedEinEntity ein2 = new DataGeneratedEinEntity();
            ein2.setRegisteredApp(app);
            ein2.setEinValue("einval");
            ein2.persist();
        } catch (javax.persistence.PersistenceException ex) {
            if (!(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException)) {
                throw ex;
            } else {
                Session session = em.unwrap(Session.class);
                session.clear();
            }
        }

        Assertions.assertEquals(2, DataGeneratedEinEntity.count());
    }

    @Test
    public void testEINGenerationHappyPath() throws InvokeRealMethodException {
        PanacheMock.mock(DataGeneratedEinEntity.class);
        Mockito.when(DataGeneratedEinEntity.findByEinNumber(Mockito.anyString())).thenReturn(null);

        List<DataGeneratedEinEntity> list = service.generateEinNumber(10);
        Assertions.assertEquals(10, list.size());
        PanacheMock.verify(DataGeneratedEinEntity.class, Mockito.times(10)).persist(Mockito.any(DataGeneratedEinEntity.class));
        PanacheMock.verify(DataGeneratedEinEntity.class, Mockito.times(10)).findByEinNumber(Mockito.anyString());
    }

    @Test
    public void testEINGenerationWithExisting() {
        PanacheMock.mock(DataGeneratedEinEntity.class);
        Mockito.when(DataGeneratedEinEntity.findByEinNumber(Mockito.anyString())).thenAnswer(invocation -> new DataGeneratedEinEntity(invocation.getArgument(0)));

        List<DataGeneratedEinEntity> list = service.generateEinNumber(10);
        Assertions.assertEquals(10, list.size());
        PanacheMock.verify(DataGeneratedEinEntity.class, Mockito.times(0)).persist(Mockito.any(DataGeneratedEinEntity.class));
        PanacheMock.verify(DataGeneratedEinEntity.class, Mockito.times(10)).findByEinNumber(Mockito.anyString());
    }

    @Test
    public void testEINRandomizerHappyPath() throws Exception {
        testRandomizer(500000l, 1534, 1534);
    }

    @Test
    public void testEINRandomizerMaxOut() throws Exception {
        testRandomizer(500000l, 10000, 5000);
    }

    @Test
    public void testEINRandomizerLowRecordCount() throws Exception {
        testRandomizer(50L, 4321, 50);
    }

    private void testRandomizer(long databaseCount, int retrieveCount, int returnedCount) throws Exception {
        PanacheMock.mock(DataGeneratedEinEntity.class);
        Mockito.when(DataGeneratedEinEntity.count()).thenReturn(databaseCount);
        PanacheQuery allQuery = Mockito.mock(PanacheQuery.class);
        Mockito.when(DataGeneratedEinEntity.findAll()).thenReturn(allQuery);
        Mockito.when(allQuery.page(Mockito.anyInt(), Mockito.anyInt())).thenReturn(allQuery);
        Mockito.when(allQuery.firstResult()).thenAnswer(invocation -> {
            Random r = new Random();
            DataGeneratedEinEntity entity = new DataGeneratedEinEntity();
            entity.setEinid(r.nextLong());
            return entity;
        });
        
        List<EIN> randomEINs = service.retrieveRandomEINs(retrieveCount);
        Assertions.assertEquals(returnedCount, randomEINs.size());
    }
}
