package com.redhat.idaas.datasynthesis.apis;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.idaas.datasynthesis.dtos.AccountNumber;
import com.redhat.idaas.datasynthesis.dtos.BirthDate;
import com.redhat.idaas.datasynthesis.dtos.CreditCard;
import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.dtos.PhoneNumber;
import com.redhat.idaas.datasynthesis.dtos.SSN;
import com.redhat.idaas.datasynthesis.dtos.UserIdentity;
import com.redhat.idaas.datasynthesis.services.AccountNumberService;
import com.redhat.idaas.datasynthesis.services.AddressService;
import com.redhat.idaas.datasynthesis.services.CreditCardService;
import com.redhat.idaas.datasynthesis.services.DateOfBirthService;
import com.redhat.idaas.datasynthesis.services.DriversLicenseNumberService;
import com.redhat.idaas.datasynthesis.services.EINService;
import com.redhat.idaas.datasynthesis.services.PhoneNumberService;
import com.redhat.idaas.datasynthesis.services.SSNService;
import com.redhat.idaas.datasynthesis.services.UserIdentityService;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataResource {

    @Inject
    SSNService ssnService;

    @Inject
    AccountNumberService accountNumberService;

    @Inject
    AddressService addressService;

    @Inject
    CreditCardService creditCardService;

    @Inject
    DateOfBirthService dobService;

    @Inject
    DriversLicenseNumberService dlnService;

    @Inject
    EINService einService;

    @Inject
    PhoneNumberService phoneNumberService;

    @Inject
    UserIdentityService userIdentityService;

    @GET
    @Path("ssn/{count}")
    public List<SSN> getSSNs(@PathParam int count) {
        return ssnService.retrieveRandomSSNs(count);
    }

    @GET
    @Path("accountnumber/{count}")
    public List<AccountNumber> getAccountNumbers(@PathParam int count) {
        return accountNumberService.retrieveRandomAccountNumbers(count);
    }

    @GET
    @Path("creditcard/{count}")
    public List<CreditCard> getCreditCards(@PathParam int count) {
        return creditCardService.retrieveRandomCreditCards(count);
    }

    @GET
    @Path("birthdate/{count}")
    public List<BirthDate> getBirthDates(@PathParam int count) {
        return dobService.retrieveRandomBirthDates(count);
    }

    @GET
    @Path("ein/{count}")
    public List<EIN> getEINs(@PathParam int count) {
        return einService.retrieveRandomEINs(count);
    }

    @GET
    @Path("phonenumber/{count}")
    public List<PhoneNumber> getPhoneNumbers(@PathParam int count) {
        return phoneNumberService.retrieveRandomPhoneNumbers(count);
    }

    @GET
    @Path("useridentity/{count}")
    public List<UserIdentity> getUserIdentities(@PathParam int count) {
        return userIdentityService.retrieveRandomUserIdentities(count);
    }
}
