use datasynthesis;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE refdata_status;
TRUNCATE TABLE refdata_timezones;
TRUNCATE TABLE refdata_usstates;
TRUNCATE TABLE refdata_organization;
TRUNCATE TABLE refdata_vendor;
TRUNCATE TABLE refdata_application;
TRUNCATE TABLE refdata_industrystd;
TRUNCATE TABLE refdata_codeset;
TRUNCATE TABLE refdata_addressformattype;
TRUNCATE TABLE refdata_countries;
TRUNCATE TABLE refdata_operationtype;
TRUNCATE TABLE refdata_sensitivityflag;
TRUNCATE TABLE refdata_codeset;
TRUNCATE TABLE refdata_legalentity;
TRUNCATE TABLE refdata_operationtype;
TRUNCATE TABLE refdata_platformparams;
TRUNCATE TABLE refdata_platformparamstodataattributes;
TRUNCATE TABLE refdata_sensitivityflag;
TRUNCATE TABLE datamodel_datatables;
TRUNCATE TABLE datastructure_address;
TRUNCATE TABLE datastructure_bankaccount;
TRUNCATE TABLE datastructure_corporations;
TRUNCATE TABLE datastructure_names;
TRUNCATE TABLE datastructure_persondemographics;
TRUNCATE TABLE datastructure_phonenumbers;
TRUNCATE TABLE datastructure_products;
TRUNCATE TABLE dataexisting_ababanking;
TRUNCATE TABLE dataexisting_areacode;
TRUNCATE TABLE dataexisting_areacodeintl;
TRUNCATE TABLE dataexisting_companies;
TRUNCATE TABLE dataexisting_namefirst;
TRUNCATE TABLE dataexisting_namelast;
TRUNCATE TABLE dataexisting_upccodes;
TRUNCATE TABLE dataexisting_zipcodeintl;
TRUNCATE TABLE dataexisting_zipcodeus;
TRUNCATE TABLE datagenerated_accountnumbers;
TRUNCATE TABLE datagenerated_addresses;
TRUNCATE TABLE datagenerated_bankaccount;
TRUNCATE TABLE datagenerated_creditcard;
TRUNCATE TABLE datagenerated_dateofbirth;
TRUNCATE TABLE datagenerated_driverslicenses;
TRUNCATE TABLE datagenerated_ein;
TRUNCATE TABLE datagenerated_phonenumber;
TRUNCATE TABLE datagenerated_phonenumbersintl;
TRUNCATE TABLE datagenerated_socialsecuritynumber;
TRUNCATE TABLE datagenerated_useridentities;
TRUNCATE TABLE platform_appsettings_general;
TRUNCATE TABLE platform_config_datagen;
TRUNCATE TABLE platform_dataattributes;
TRUNCATE TABLE platform_datastructures;
TRUNCATE TABLE platform_datastructurestodataattributes;
TRUNCATE TABLE platform_rulesets;
TRUNCATE TABLE platform_rulesetsdefinitions;
TRUNCATE TABLE terms_codesetstoapplication;
TRUNCATE TABLE terms_codesetstoapplicationvalues;
SET FOREIGN_KEY_CHECKS = 1;
source ./ReferenceData/1-refdata_status.sql
source ./ReferenceData/2-refdata_timezones.sql
source ./ReferenceData/3-refdata_usstates.sql
source ./ReferenceData/4-refdata_organization.sql
source ./ReferenceData/5-refdata_vendor.sql
source ./ReferenceData/6-refdata_application.sql
source ./ReferenceData/7-refdata_industrystd.sql
source ./ReferenceData/8-refdata_sensitivityflag.sql
source ./ReferenceData/9-refdata_codeset.sql
source ./ReferenceData/refdata_addressformattype.sql
source ./ReferenceData/refdata_countries.sql
source ./ReferenceData/refdata_operationtype.sql
source ./ReferenceData/refdata_sensitivityflag.sql
source ./Other/datasynthesis_datamodel_datatables.sql
source ./Platform/1-platform_dataattributes.sql
source ./Platform/2-platform_datastructures.sql
source ./Platform/3-platform_datastructurestodataattributes.sql
source ./Platform/platform_appsettings_dataattributes.sql
source ./Platform/platform_config_datagen.sql
source ./DataExisting/datasynthesis_dataexisting_ababanking.sql
source ./DataExisting/datasynthesis_dataexisting_areacode.sql
source ./DataExisting/datasynthesis_dataexisting_companies.sql
source ./DataExisting/datasynthesis_dataexisting_namefirst-01.sql
source ./DataExisting/datasynthesis_dataexisting_namefirst-02.sql
source ./DataExisting/datasynthesis_dataexisting_namefirst-03.sql
source ./DataExisting/datasynthesis_dataexisting_namefirst-04.sql
source ./DataExisting/datasynthesis_dataexisting_namefirst-05.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-01.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-02.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-03.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-04.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-05.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-06.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-07.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-08.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-09.sql
source ./DataExisting/datasynthesis_dataexisting_namelast-10.sql
source ./DataExisting/datasynthesis_dataexisting_upccodes.sql
source ./DataExisting/datasynthesis_dataexisting_zipcodeus.sql
source ./DataGenerated/datasynthesis_datagenerated_addresses.sql
source ./DataGenerated/datasynthesis_datagenerated_bankaccount.sql
source ./DataGenerated/datasynthesis_datagenerated_creditcard.sql
source ./DataGenerated/datasynthesis_datagenerated_dateofbirth.sql
source ./DataGenerated/datasynthesis_datagenerated_phonenumber.sql
source ./DataGenerated/datasynthesis_datagenerated_driverslicenses.sql
source ./DataGenerated/datasynthesis_datagenerated_socialsecuritynumber.sql