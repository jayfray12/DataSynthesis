package com.redhat.idaas.datasynthesis.services;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.idaas.datasynthesis.dtos.DLN;
import com.redhat.idaas.datasynthesis.models.DataGeneratedDriversLicensesEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class DriversLicenseNumberService extends RandomizerService<DataGeneratedDriversLicensesEntity, DLN> {

    @Override
    protected long count(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedDriversLicensesEntity.count();
        }
        return DataGeneratedDriversLicensesEntity.count((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected PanacheQuery<DataGeneratedDriversLicensesEntity> findAll(Object... queryOpts) {
        if (queryOpts.length <= 1) {
            return DataGeneratedDriversLicensesEntity.findAll();
        }
        return DataGeneratedDriversLicensesEntity.find((String)queryOpts[0], Arrays.copyOfRange(queryOpts, 1, queryOpts.length));
    }

    @Override
    protected DLN mapEntityToDTO(DataGeneratedDriversLicensesEntity entity) {
        return new DLN(entity.getCompleteDriversLicenseNumber(), entity.getState().getStateDescription(), entity.getCompleteDriversLicenseNumber());
    }

    // Existing Code

    /*
    foreach (var stateCode in stateCodes)
            {
                var randomGenerator = new Random();
                int numberLength;
                int numberLength2;

                string driversLicenseNumber = null;

                // variables for code
                Int64 rtrnNumber;
                string rtrnChar = null;

                for (int ctr = 1; ctr <= generationCount; ctr++)
                {
                    switch (stateCode)
                    {
                        case "AL":
                            numberLength = 7;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("AL" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("AL" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "AK":
                            numberLength = 7;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("AK" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("AK" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "AZ":
                            numberLength = 9;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("AZ" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("AZ" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "AR":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("AR" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("AR" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "CA":
                            numberLength = 9;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("CA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("CA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "CO":
                            numberLength = 6;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("CO" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("CO" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "CT":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("CT" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("CT" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "DE":
                            numberLength = 7;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("DE" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("DE" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "DC":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("DC" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("DC" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "FL":
                            numberLength = 12;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("FL" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("FL" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "GA":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("GA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("GA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "HI":
                            numberLength = 8;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("HI" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("HI" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "ID":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("ID" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("ID" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "IL":
                            numberLength = 11;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 10));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("IL" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("IL" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "IN":
                            numberLength = 9;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("IN" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("IN" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "IA":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("IA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("IA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "KS":
                            numberLength = 8;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("KS" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("KS" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "KY":
                            numberLength = 9;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("KY" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("KY" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "LA":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("LA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("LA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "ME":
                            numberLength = 7;
                            rtrnNumber = rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000001));
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            driversLicenseNumber =
                                Convert.ToString(rtrnNumber).PadLeft(numberLength, '0') + "" + rtrnChar;
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("ME" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("ME" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MD":
                            numberLength = 12;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MD" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MD" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MA":
                            numberLength = 8;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MI":
                            numberLength = 10;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MI" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MI" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MN":
                            numberLength = 12;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MN" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MN" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MS":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MS" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MS" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MO":
                            numberLength = 9;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MO" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MO" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "MT":
                            numberLength = 8;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("MT" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("MT" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NE":
                            numberLength = 8;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NE" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NE" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NV":
                            numberLength = 8;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000000));
                            driversLicenseNumber = "X" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NV" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NV" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NH":
                            numberLength = 2;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            string rtrnCharNH1 = GenerateRandomData.generateAlphaCharacter();
                            string rtrnCharNH2 = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100));
                            Int64 rtrnNumberNH1 = Convert.ToInt64(randomGenerator.Next(1, 10001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0') + "" +
                                                   rtrnChar + "" + rtrnCharNH1 + "" + rtrnCharNH2 + "" +
                                                   Convert.ToString(rtrnNumberNH1).PadLeft(5, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NH" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NH" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NJ":
                            numberLength = 14;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 1001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NJ" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NJ" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NM":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NM" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NM" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NY":
                            numberLength = 18;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NY" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NY" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "NC":
                            numberLength = 12;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 101));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("NC" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("NC" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "ND":
                            numberLength = 6;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            string rtrnCharND1 = GenerateRandomData.generateAlphaCharacter();
                            string rtrnCharND2 = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100001));
                            driversLicenseNumber = rtrnChar + "" + rtrnCharND1 + "" + rtrnCharND2 + "" +
                                                   Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("ND" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("ND" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "OH":
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            numberLength = 8;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000000));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("OH" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("OH" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "OK":
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("OK" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("OK" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "OR":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("OR" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("OR" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "PA":
                            numberLength = 8;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("PA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("PA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "RI":
                            numberLength = 6;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("RI" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("RI" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "SC":
                            numberLength = 11;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("SC" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("SC" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "SD":
                            numberLength = 12;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 1000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("SD" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("SD" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "TN":
                            numberLength = 8;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("TN" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("TN" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "TX":
                            numberLength = 8;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 10000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("TX" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("TX" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "UT":
                            numberLength = 10;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("UT" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("UT" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "VT":
                            numberLength = 10;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 1000000001));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("VT" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("VT" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "VA":
                            numberLength = 11;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("VA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("VA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "WV":
                            numberLength = 6;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("WV" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("WV" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "WA":
                            numberLength = 11;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 100));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("WA" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("WA" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "WI":
                            numberLength = 12;
                            rtrnChar = GenerateRandomData.generateAlphaCharacter();
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000001));
                            rtrnNumber = rtrnNumber + Convert.ToInt64(randomGenerator.Next(1, 101));
                            driversLicenseNumber =
                                rtrnChar + "" + Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("WI" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("WI" + "|" + driversLicenseNumber);
                            }

                            break;
                        case "WY":
                            numberLength = 9;
                            rtrnNumber = Convert.ToInt64(randomGenerator.Next(1, 100000000));
                            driversLicenseNumber = Convert.ToString(rtrnNumber).PadLeft(numberLength, '0');
                            // Check if Array Doesnt contain the value, if it doesnt add it
                            if (!dlnList.Contains("WY" + "|" + driversLicenseNumber))
                            {
                                dlnList.Add("WY" + "|" + driversLicenseNumber);
                            }

                            break;
                        default:
                            break;
                    }
                }
            }
     */
}
