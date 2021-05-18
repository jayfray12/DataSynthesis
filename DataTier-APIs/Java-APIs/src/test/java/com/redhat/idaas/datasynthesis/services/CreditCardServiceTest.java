package com.redhat.idaas.datasynthesis.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataGeneratedCreditCardEntity;
import com.redhat.idaas.datasynthesis.models.PlatformDataAttributesEntity;
import com.redhat.idaas.datasynthesis.models.RefDataDataGenTypesEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class CreditCardServiceTest {
    @Inject
    CreditCardService service;

    private final static String VISA_FORMAT = "^4[0-9]{12}(?:[0-9]{3})?$";
    private final static String MASTER_FORMAT = "^5[1-5][0-9]{14}$";

    private void initDB() {
        com.redhat.idaas.datasynthesis.services.Common.seed();
        PlatformDataAttributesEntity dataAttribute = new PlatformDataAttributesEntity();
        dataAttribute.setDataAttributeName("Credit Cards");
        dataAttribute.persist();

        RefDataDataGenTypesEntity dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("Visa");
        dataType.setDefinition(VISA_FORMAT);
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();

        dataType = new RefDataDataGenTypesEntity();
        dataType.setDataGenTypeDescription("Master");
        dataType.setDefinition(MASTER_FORMAT);
        dataType.setDataAttribute(dataAttribute);
        dataType.persist();
    }

    @Test
    @Transactional
    public void testRandomGenerateAndRetrieve() throws DataSynthesisException {
        initDB();
        service.generateCreditCards(10, null);
        Assertions.assertEquals(10, DataGeneratedCreditCardEntity.count());

        List<CreditCard> cards = service.retrieveRandomCreditCards(8, null);
        for(CreditCard card : cards) {
            com.redhat.idaas.datasynthesis.services.Common.validatePattern(card.name.equals("Visa") ? VISA_FORMAT : MASTER_FORMAT, card.number);
        }
    }

    @Test
    @Transactional
    public void testRandomGenerateAndRetrievePerType() throws DataSynthesisException {
        initDB();
        service.generateCreditCards(10, "Visa");
        service.generateCreditCards(10, "Master");

        List<CreditCard> cards = service.retrieveRandomCreditCards(20, "Visa");
        Assertions.assertEquals(10, cards.size());
        for(CreditCard card : cards) {
            Assertions.assertEquals("Visa", card.name);
        }
    }
}
