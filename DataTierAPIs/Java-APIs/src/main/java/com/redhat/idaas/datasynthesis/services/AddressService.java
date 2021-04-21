package com.redhat.idaas.datasynthesis.services;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.Address;
import com.redhat.idaas.datasynthesis.models.DataGeneratedAddressesEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class AddressService extends RandomizerService<DataGeneratedAddressesEntity, Address> {

    @Override
    protected long count(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedAddressesEntity.count();
        }
        return DataGeneratedAddressesEntity.count((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected PanacheQuery<DataGeneratedAddressesEntity> findAll(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedAddressesEntity.findAll();
        }
        return DataGeneratedAddressesEntity.find((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected Address mapEntityToDTO(DataGeneratedAddressesEntity entity) {
        return new Address(entity.getAddressStreet());
    }

    
    // Existing Code
    // This code constructs
    /*
        // Create List for return
            List<DataSynthesis.Data.Business.Models.genRefData.Addresses> addressesList = new List<DataSynthesis.Data.Business.Models.genRefData.Addresses>();
            // Build Response ArrayList Value
            ArrayList completeStreetNameArray = new ArrayList();
            string completeStreetNameValue = null;

            // Build Array Lists of Values
            ArrayList streetLocationName = new ArrayList();
            streetLocationName.Add("N");
            streetLocationName.Add("S");
            streetLocationName.Add("E");
            streetLocationName.Add("W");
            streetLocationName.Add("NW");
            streetLocationName.Add("NE");
            streetLocationName.Add("SW");
            streetLocationName.Add("SE");

            ArrayList streetTypeName = new ArrayList();
            streetTypeName.Add("Way");
            streetTypeName.Add("Ave");
            streetTypeName.Add("Lane");
            streetTypeName.Add("Street");
            streetTypeName.Add("Court");
            streetTypeName.Add("Place");
            streetTypeName.Add("Walk");
            streetTypeName.Add("Pike");
            streetTypeName.Add("Run");

            //Create a local random number object
            var randomGenerator = new Random();
            // For Loop To Test
            for (int ctr = 1; ctr <= generationCount; ctr++)
            {
                //Enumerate through a set of last names which we will use for street names.
                //foreach (var lastName in NameGenerator.GetLastName(generationCount))
                //{
                Random rndmGen = new Random();
                Random rndmGen2 = new Random();
                Random rndmGen3 = new Random();
                Random rndmGen4 = new Random();
                Random rndmGen5 = new Random();

                // House Number
                int hNmbr = rndmGen2.Next(1, 10000);
                string houseNmbr = hNmbr.ToString();
                houseNmbr = houseNmbr.PadLeft(4, '0');

                // Street Location Name
                int n = rndmGen.Next(0, streetLocationName.Count);
                string strLocationName = streetLocationName[n].ToString().Trim();

                //Name
                // From the List of Last Names
                //int lastNameNumber = rndmGen5.Next(1, tableCount);
                //string lastName = NameGenerator.GetLastNameByID(lastNameNumber);
                string lastName = null;

                // Street Name Ending
                int n3 = rndmGen3.Next(0, streetTypeName.Count);
                string strNameEnd = streetTypeName[n3].ToString().Trim();

                int n4 = rndmGen4.Next(1, 3);
                if (n4 == 1)
                {
                    //Return a concatenation of the street direction, house number, street namem and street type
                    //yield return $"{(StreetDirection)randomStreetDirection} {Convert.ToString(randomHouseNumber)} {lastName} {(StreetType)randomStreetType}";
                    //yield return houseNmbr + " " + strLocationName + " "+ lastName.ToString().Trim()+" "+strNameEnd;
                    completeStreetNameValue = houseNmbr + " " + strLocationName + " " + lastName.ToString().Trim() + " " + strNameEnd;
                    // Check if Array Doesnt contain the value, if it doesnt add it
                    if (!completeStreetNameArray.Contains(completeStreetNameValue))
                    {
                        completeStreetNameArray.Add(completeStreetNameValue);
                    }
                    // Reset Values to Ensure unique random numbers
                    hNmbr = 0;
                    n = 0;
                    n3 = 0;
                    n4 = 0;
                }
                else
                {
                    completeStreetNameValue = houseNmbr + " " + lastName.ToString().Trim() + " " + strNameEnd;
                    if (!completeStreetNameArray.Contains(completeStreetNameValue))
                    {
                        completeStreetNameArray.Add(completeStreetNameValue);
                    }
                    // Reset Values to Ensure unique random numbers
                    hNmbr = 0;
                    n = 0;
                    n3 = 0;
                    n4 = 0;
                    //yield return houseNmbr + " " + lastName.ToString().Trim() + " " + strNameEnd;
                }
                // end of foreach loop to build names
                //}
            }

            // loop thru and populate liST and populate Address Structure
            foreach (var item in completeStreetNameArray)
            {
                addressesList.Add(new DataSynthesis.Data.Business.Models.genRefData.Addresses()
                {
                    address1 = item.ToString()
                });
            }
            return addressesList;
        }
     */

}
