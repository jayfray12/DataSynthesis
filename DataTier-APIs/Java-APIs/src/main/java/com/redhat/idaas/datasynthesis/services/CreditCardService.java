package com.redhat.idaas.datasynthesis.services;

import java.sql.Timestamp;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.github.curiousoddman.rgxgen.RgxGen;
import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataGeneratedCreditCardEntity;
import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;
import com.redhat.idaas.datasynthesis.models.RefDataStatusEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class CreditCardService extends RandomizerService<DataGeneratedCreditCardEntity, CreditCard> {
    static final Map<String, String> FORMAT_MAP = Stream.of(new SimpleEntry<>("AMEX", "^3[47][0-9]{13}$"),
            new SimpleEntry<>("Discover",
                    "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$"),
            new SimpleEntry<>("Master", "^5[1-5][0-9]{14}$"), new SimpleEntry<>("Visa", "^4[0-9]{12}(?:[0-9]{3})?$"))
            .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

    private static final List<Map.Entry<String, String>> FORMAT_LIST = FORMAT_MAP.entrySet().stream()
            .collect(Collectors.toList());

    @Override
    protected long count(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedCreditCardEntity.count();
        }
        return DataGeneratedCreditCardEntity.count((String) queryOpts[0],
                Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected PanacheQuery<DataGeneratedCreditCardEntity> findAll(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedCreditCardEntity.findAll();
        }
        return DataGeneratedCreditCardEntity.find((String) queryOpts[0],
                Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected CreditCard mapEntityToDTO(DataGeneratedCreditCardEntity e) {
        return new CreditCard(e.getCreditCardNumber(), e.getCreditCardName());
    }

    
    public List<CreditCard> retrieveRandomCreditCards(int count, String cardName) {
        if (cardName == null) {
            return retrieveRandomData(count);
        } 
        
        return retrieveRandomData(count, "CreditCardName", cardName);
    }

    @Transactional
    public List<DataGeneratedCreditCardEntity> generateCreditCards(int count, String cardName)
            throws DataSynthesisException {
        List<DataGeneratedCreditCardEntity> ccnList = new ArrayList<DataGeneratedCreditCardEntity>(count);
        RefDataApplicationEntity app = getRegisteredApp();
        RefDataStatusEntity defaultStatus = getDefaultStatus();
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());

        RgxGen rgxGen = null;
        if (cardName != null) {
            rgxGen = new RgxGen(FORMAT_MAP.get(cardName));
        }

        for (int i = 0; i < count;) {
            DataGeneratedCreditCardEntity entity = new DataGeneratedCreditCardEntity();
            entity.setCreatedDate(createdDate);
            entity.setStatus(defaultStatus);
            entity.setRegisteredApp(app);
            if (cardName == null) {
                // generate a random cc number for a random card
                Entry<String, String> entry = FORMAT_LIST.get(rand.nextInt(FORMAT_LIST.size()));
                entity.setCreditCardName(entry.getKey());
                rgxGen = new RgxGen(entry.getValue());
                entity.setCreditCardNumber(rgxGen.generate(rand));
            } else {
                entity.setCreditCardName(cardName);
                entity.setCreditCardNumber(rgxGen.generate(rand));
            }
            if (entity.safePersist()) {
                ccnList.add(entity);
                i++;
            }
        }

        return ccnList;
    }
}
