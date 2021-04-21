package com.redhat.idaas.datasynthesis.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataGeneratedCreditCardEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class CreditCardServiceTest {
    @Inject
    CreditCardService service;

    @Test
    @Transactional
    public void testRandomGenerateAndRetrieve() throws DataSynthesisException {
        Common.seed();
        service.generateCreditCards(10, null);
        Assertions.assertEquals(10, DataGeneratedCreditCardEntity.count());

        List<CreditCard> cards = service.retrieveRandomCreditCards(8, null);
        for(CreditCard card : cards) {
            Common.validatePattern(CreditCardService.FORMAT_MAP.get(card.name), card.number);
        }
    }

    @Test
    @Transactional
    public void testRandomGenerateAndRetrievePerType() throws DataSynthesisException {
        Common.seed();
        service.generateCreditCards(10, "Visa");
        service.generateCreditCards(10, "Master");

        List<CreditCard> cards = service.retrieveRandomCreditCards(20, "Visa");
        Assertions.assertEquals(10, cards.size());
        for(CreditCard card : cards) {
            Assertions.assertEquals("Visa", card.name);
        }
    }
}
