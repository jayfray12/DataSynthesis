package com.redhat.idaas.datasynthesis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.redhat.idaas.datasynthesis.dtos.SSN;

import org.apache.commons.lang3.StringUtils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class SSNService extends RandomizerService {

    @Override
	protected long count() {
		return DataGeneratedSocialSecurityNumberEntity.count();
	}

	@Override
	protected PanacheQuery<DataGeneratedSocialSecurityNumberEntity> findAll() {
		return DataGeneratedSocialSecurityNumberEntity.findAll();
	}

    @Transactional
    public List<DataGeneratedSocialSecurityNumberEntity> generateSSN(long generationCounter) {
        List<DataGeneratedSocialSecurityNumberEntity> ssnList = new ArrayList<DataGeneratedSocialSecurityNumberEntity>(
                (int) generationCounter);
        Random ssnRandomizer = new Random();
        int upperBound1 = 999;
        int upperBound2 = 99;
        int upperBound3 = 9999;

        for (int i = 0; i < generationCounter; i++)
        {
            StringBuilder ssn = new StringBuilder();
            // Create the first 3 random SSN numbers while padding to the correct length
            ssn.append(StringUtils.leftPad(String.valueOf(ssnRandomizer.nextInt(upperBound1)), 3, "0")).append('-')
                    // Create the middle 2 random SSN numbers while padding to the correct length
                    .append(StringUtils.leftPad(String.valueOf(ssnRandomizer.nextInt(upperBound2)), 2, "0")).append('-')
                    // Create the ending 4 random SSN numbers while padding to the correct length
                    .append(StringUtils.leftPad(String.valueOf(ssnRandomizer.nextInt(upperBound3)), 4, "0"));

            DataGeneratedSocialSecurityNumberEntity ssnEntity = DataGeneratedSocialSecurityNumberEntity
                    .findBySSN(ssn.toString());
            if (ssnEntity == null) {
                ssnEntity = new DataGeneratedSocialSecurityNumberEntity();
                ssnEntity.setSocialSecurityNumberValue(ssn.toString());
                DataGeneratedSocialSecurityNumberEntity.persist(ssnEntity);
            }

            ssnList.add(ssnEntity);
        }

        return ssnList;
    }

    public List<SSN> retrieveRandomSSNs(int count) {
        Set<DataGeneratedSocialSecurityNumberEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new SSN(e.getSocialSecurityNumberValue())).collect(Collectors.toList());
    }

}
