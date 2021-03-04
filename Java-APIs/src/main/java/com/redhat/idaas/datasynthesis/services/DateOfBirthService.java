package com.redhat.idaas.datasynthesis.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.BirthDate;
import com.redhat.idaas.datasynthesis.models.DataGeneratedDateOfBirthEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class DateOfBirthService extends RandomizerService<DataGeneratedDateOfBirthEntity> {

    @Override
    protected long count() {
        return DataGeneratedDateOfBirthEntity.count();
    }

    @Override
    protected PanacheQuery<DataGeneratedDateOfBirthEntity> findAll() {
        return DataGeneratedDateOfBirthEntity.findAll();
    }
    // Create Generated Data

    // Existing Code

    /* // Create List for return
            List<DataSynthesis.Data.Business.Models.genRefData.BirthDates> birthDateList = new List<DataSynthesis.Data.Business.Models.genRefData.BirthDates>();
            // Create age limit variable
            int maximumage = 100;
            // ArrayList
            ArrayList dobArray = new ArrayList();

            var birthdateRandomizer = new Random();
            for (int i = 0; i <= generationCount; i++)
            {

                // Create a general Birthdate randomizer

                var birthdateRandomizer2 = new Random();
                var birthdateRandomizer3 = new Random();
                int year = System.DateTime.Today.Year;
                // Calculate Maximum Age years
                int maximumageCalc = year - maximumage;
                var birthYear = birthdateRandomizer.Next(maximumageCalc, year);
                // Create the month
                var birthMonth = birthdateRandomizer.Next(1, 13);
                // Create the day
                int daysInMonth = System.DateTime.DaysInMonth(birthYear, birthMonth);
                var birthDay = birthdateRandomizer.Next(1, daysInMonth);
                // Ensure value isnt in array
                if (!dobArray.Contains(birthMonth + "/" + birthDay + "/" + birthYear))
                {
                    dobArray.Add(birthMonth + "/" + birthDay + "/" + birthYear);
                }

            }
            // loop thru and populate liST and populate Date Of Borth  Structure
            foreach (var item in dobArray)
            {
                string dobStringValue = item.ToString();
                dobStringValue = dobStringValue.Replace('/', '');
                birthDateList.Add(new DataSynthesis.Data.Business.Models.genRefData.BirthDates()
                {
                    DateOfBirth = dobStringValue,
                    DateOfBirthDate = Convert.ToDateTime(item.ToString())
                });
            }

            return birthDateList;
        }
        */

    // Persist to Data Tier
    public List<BirthDate> retrieveRandomBirthDates(int count) {
        Set<DataGeneratedDateOfBirthEntity> entities = findRandomRows(count);
        return entities.stream().map(e -> new BirthDate(e.getDateOfBirth(), e.getDateOfBirthDate(), e.getAge())).collect(Collectors.toList());
    }
}
