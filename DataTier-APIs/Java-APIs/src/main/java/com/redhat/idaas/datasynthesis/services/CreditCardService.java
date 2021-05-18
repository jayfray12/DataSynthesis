package com.redhat.idaas.datasynthesis.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.github.curiousoddman.rgxgen.RgxGen;
import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.models.DataGeneratedCreditCardEntity;
import com.redhat.idaas.datasynthesis.models.PlatformDataAttributesEntity;
import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;
import com.redhat.idaas.datasynthesis.models.RefDataDataGenTypesEntity;
import com.redhat.idaas.datasynthesis.models.RefDataStatusEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class CreditCardService extends RandomizerService<DataGeneratedCreditCardEntity, CreditCard> {
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
        return new CreditCard(e.getCreditCardNumber(), e.getDataGenType().getDataGenTypeDescription());
    }

    
    public List<CreditCard> retrieveRandomCreditCards(int count, String cardName) {
        if (cardName == null) {
            return retrieveRandomData(count);
        } 
        
        PlatformDataAttributesEntity ccDataAttribute = PlatformDataAttributesEntity.findByDataAttributeName("Credit Cards");
        RefDataDataGenTypesEntity dataType = RefDataDataGenTypesEntity.find("dataAttribute = ?1 and dataGenTypeDescription = ?2", ccDataAttribute, cardName).firstResult();
        return retrieveRandomData(count, "DataGenTypeID", dataType);
    }

    @Transactional
    public List<DataGeneratedCreditCardEntity> generateCreditCards(int count, String cardName)
            throws DataSynthesisException {
        List<DataGeneratedCreditCardEntity> ccnList = new ArrayList<DataGeneratedCreditCardEntity>(count);
        RefDataApplicationEntity app = getRegisteredApp();
        RefDataStatusEntity defaultStatus = getDefaultStatus();
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());

        PlatformDataAttributesEntity ccDataAttribute = PlatformDataAttributesEntity.findByDataAttributeName("Credit Cards");
        List<RefDataDataGenTypesEntity> creditCardTypes = null;
        if (cardName != null) {
            RefDataDataGenTypesEntity dataType = RefDataDataGenTypesEntity.find("dataAttribute = ?1 and dataGenTypeDescription = ?2", ccDataAttribute, cardName).firstResult();
            creditCardTypes = new ArrayList<RefDataDataGenTypesEntity>();
            creditCardTypes.add(dataType);
        } else {
            creditCardTypes = RefDataDataGenTypesEntity.find("dataAttribute", ccDataAttribute).list();
        }
        RgxGen[] rgxGens = new RgxGen[creditCardTypes.size()];

        for (int i = 0; i < count;) {
            int selected = rand.nextInt(creditCardTypes.size());
            RefDataDataGenTypesEntity dataType = creditCardTypes.get(selected);
            RgxGen rgxGen = rgxGens[selected];
            if (rgxGen == null) {
                rgxGen = new RgxGen(dataType.getDefinition());
                rgxGens[selected] = rgxGen;
            }

            DataGeneratedCreditCardEntity entity = new DataGeneratedCreditCardEntity();
            entity.setCreatedDate(createdDate);
            entity.setStatus(defaultStatus);
            entity.setRegisteredApp(app);
            entity.setCreditCardNumber(rgxGen.generate(rand));
            entity.setDataGenType(dataType);
            if (entity.safePersist()) {
                ccnList.add(entity);
                i++;
            }
        }

        return ccnList;
    }
}
