package com.redhat.idaas.datasynthesis.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataGeneratedDriversLicensesEntity;
import com.redhat.idaas.datasynthesis.models.PlatformDataAttributesEntity;
import com.redhat.idaas.datasynthesis.models.RefDataDataGenTypesEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class DriverLicenseNumberServiceTest {
    @Inject
    DriversLicenseNumberService service;

    private void initDB() {
        Common.seed();

        PlatformDataAttributesEntity dataAttribute = new PlatformDataAttributesEntity();
        dataAttribute.setDataAttributeName("Drivers License Number");
        dataAttribute.persist();

        RefDataDataGenTypesEntity dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("AL");
        dataType.setDefinition("^[0-9]{7,8}$");
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();

        dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("CA");
        dataType.setDefinition("^[A-Z]{1}[0-9]{7}$");
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();

        dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("HI");
        dataType.setDefinition("^H[0-9]{8}$");
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();

        dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("RI");
        dataType.setDefinition("(^V[0-9]{6}$)|(^[0-9]{7}$)");
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();
    }

    @Test
    @Transactional
    public void testALLicense() throws DataSynthesisException {
        initDB();
        List<DataGeneratedDriversLicensesEntity> dlns = service.generatedDriverLicenses(10, "AL");
        Assertions.assertEquals(10, DataGeneratedDriversLicensesEntity.count());
        for(DataGeneratedDriversLicensesEntity entity : dlns) {
            String num = entity.getDln();
            Assertions.assertTrue(num.length() == 7 || num.length() == 8);
            for(int i = 0; i < 7; i++) {
                char ch = num.charAt(i);
                Assertions.assertTrue( ch >= '0' && ch <= '9');
            }
            if (num.length() == 8) {
                char ch = num.charAt(7);
                Assertions.assertTrue( ch >= '0' && ch <= '9');
            }
        }
    }

    @Test
    @Transactional
    public void testCALicense() throws DataSynthesisException {
        initDB();
        List<DataGeneratedDriversLicensesEntity> dlns = service.generatedDriverLicenses(10, "CA");
        Assertions.assertEquals(10, DataGeneratedDriversLicensesEntity.count());
        for(DataGeneratedDriversLicensesEntity entity : dlns) {
            String num = entity.getDln();
            Assertions.assertEquals(8, num.length());
            char first = num.charAt(0);
            Assertions.assertTrue( first >= '0' && first <= '9' || first >= 'A' && first <= 'Z');
            for(int i = 1; i < 7; i++) {
                char ch = num.charAt(i);
                Assertions.assertTrue( ch >= '0' && ch <= '9');
            }
        }
    }

    @Test
    @Transactional
    public void testHILicense() throws DataSynthesisException {
        initDB();
        List<DataGeneratedDriversLicensesEntity> dlns = service.generatedDriverLicenses(10, "HI");
        Assertions.assertEquals(10, DataGeneratedDriversLicensesEntity.count());
        for(DataGeneratedDriversLicensesEntity entity : dlns) {
            String num = entity.getDln();
            Assertions.assertEquals(9, num.length());
            char first = num.charAt(0);
            Assertions.assertEquals('H', first);
            for(int i = 1; i < 8; i++) {
                char ch = num.charAt(i);
                Assertions.assertTrue( ch >= '0' && ch <= '9');
            }
        }
    }

    @Test
    @Transactional
    public void testRILicense() throws DataSynthesisException {
        initDB();
        List<DataGeneratedDriversLicensesEntity> dlns = service.generatedDriverLicenses(10, "RI");
        Assertions.assertEquals(10, DataGeneratedDriversLicensesEntity.count());
        for(DataGeneratedDriversLicensesEntity entity : dlns) {
            String num = entity.getDln();
            Assertions.assertEquals(7, num.length());
            char first = num.charAt(0);
            Assertions.assertTrue( first >= '0' && first <= '9' || first == 'V');
            for(int i = 1; i < 7; i++) {
                char ch = num.charAt(i);
                Assertions.assertTrue( ch >= '0' && ch <= '9');
            }
        }
    }
}
