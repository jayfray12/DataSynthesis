-- we don't know how to generate root <with-no-name> (class Root) :(
create table datamodel_datatables
(
	TableName varchar(64) not null
		primary key,
	TableInformation varchar(249),
	StatusID INTEGER default 1,
	CreatedDate timestamp
);

create index IDX_datamodel_datatables
	on datamodel_datatables (TableName, TableInformation, StatusID, CreatedDate);

create table refdata_status
(
	StatusID INTEGER
		primary key autoincrement,
	StatusDescription varchar(45) not null,
	CreatedDate timestamp,
	CreatedUser varchar(20)
);

create table auditing_dataplatform
(
	DataPlatformID INTEGER
		primary key autoincrement,
	DataProcessingDate datetime(3),
	CreatedByUser varchar(20),
	Organizaton varchar(38),
	Application varchar(38),
	StatusID smallint default 1
		constraint FK_platform_dataplatform_status
			references refdata_status,
	CreatedDate timestamp,
	RecCount int,
	Component varchar(20),
	ActionName varchar(20),
	DurationToRun int,
	ActivityDetail varchar(75)
);

create table auditing_datarequest
(
	DataRequestID INTEGER
		primary key autoincrement,
	DataRequestDate datetime(3),
	CreatedByUser varchar(20),
	Organizaton varchar(38),
	Application varchar(38),
	StatusID INTEGER default 1
		constraint FK_platform_datarequest_status
			references refdata_status,
	CreatedDate timestamp,
	RecCount int,
	RecordDataRequest varchar(400)
);

create table platform_rulesets
(
	RuleID INTEGER
		primary key autoincrement,
	RuleName varchar(65),
	CreatedUser varchar(20),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_platform_rulesets_status
			references refdata_status,
	ExpirationDate timestamp
);

create table platform_rulesetsattributes
(
	RulesetAttributeID INTEGER
		primary key autoincrement,
	RuleSetAttributeDesc varchar(75),
	CreatedDate timestamp not null,
	StatusID INTEGER default 1
		constraint FK_platform_rulesetsattributes_status
			references refdata_status
);

create index IDX_PlatformRuleSetsAttributes
	on platform_rulesetsattributes (RuleSetAttributeDesc, CreatedDate, StatusID);

create table refdata_addressformattype
(
	AddressFormatTypeID INTEGER
		primary key autoincrement,
	AddressFormatTypeDesc varchar(35),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_AddressFormatType_Status
			references refdata_status
);

create index IX_AddressFormatType
	on refdata_addressformattype (AddressFormatTypeID, AddressFormatTypeDesc, CreatedDate, StatusID);

create table refdata_countries
(
	CountryID INTEGER
		primary key autoincrement,
	IDD varchar(5),
	CountryName varchar(59),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_Countries_Status
			references refdata_status
);

create table refdata_industrystd
(
	IndustryStd varchar(6) not null
		primary key,
	IndustryStdDesc varchar(30),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_industrystd_status
			references refdata_status
);

create index IX_IndustryStd
	on refdata_industrystd (IndustryStd, IndustryStdDesc, CreatedDate, StatusID);

create table refdata_operationtype
(
	OperationTypeID varchar(7) not null
		primary key,
	OperationTypeName varchar(60),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_operationtype_status
			references refdata_status
);

create index IX_OperationType
	on refdata_operationtype (OperationTypeID, OperationTypeName, StatusID, CreatedDate);

create table refdata_sensitivityflag
(
	SensitiveFlagID INTEGER
		primary key autoincrement,
	SensitiveFlagDesc varchar(30),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_sensitivityflag_status
			references refdata_status
);

create table refdata_codeset
(
	CodeSetsID INTEGER
		primary key autoincrement,
	CodeSetName varchar(50),
	IndustryStd varchar(6)
		constraint FK_refdata_codeset_industrystd
			references refdata_industrystd,
	StatusID INTEGER default 1
		constraint FK_refdata_codesets_status
			references refdata_status,
	CreatedDate timestamp,
	CreatedUser varchar(20),
	CodesetGUID char(38),
	FieldMapping varchar(20),
	SensitivityFlagID smallint
		constraint FK_refdata_codeset_sensitivityflag
			references refdata_sensitivityflag
);

create table refdata_timezones
(
	TimeZoneValue varchar(3) not null
		primary key,
	TimeZoneDesc varchar(25),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_TimeZones_Status
			references refdata_status
);

create index IX_TimeZones
	on refdata_timezones (TimeZoneValue, TimeZoneDesc, CreatedDate, StatusID);

create table refdata_usstates
(
	StateID varchar(2) not null
		primary key,
	StateDescription varchar(65),
	Lattitude varchar(12),
	Longitude varchar(12),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_USStates_Status
			references refdata_status,
	CreatedUser varchar(20)
);

create table refdata_legalentity
(
	LegalEntityGUID char(38) not null
		primary key,
	LocationName varchar(50),
	Address varchar(75),
	City varchar(60),
	StateID varchar(2)
		constraint FK_refdata_location_states
			references refdata_usstates,
	ZipCode varchar(12),
	CreatedUser varchar(20),
	StatusID INTEGER default 1
		constraint FK_refdata_location_status
			references refdata_status,
	CreatedDate timestamp not null,
	LocationURL varchar(99),
	LocationPhone varchar(12)
);

create table refdata_organization
(
	OrganizationGUID char(38) not null
		primary key,
	OrganizationInternalCode varchar(10),
	OrganizationInternalID varchar(10),
	OrganizationName varchar(50),
	Address varchar(75),
	City varchar(60),
	StateID varchar(2)
		constraint FK_refdata_organization_states
			references refdata_usstates,
	ZipCode varchar(12),
	CreatedUser varchar(20),
	StatusID INTEGER default 1
		constraint FK_refdata_organization_status
			references refdata_status,
	CreatedDate timestamp not null,
	LegalEntityGUID varchar(38)
		constraint FK_refdata_organization_legalentity
			references refdata_legalentity
);

create table platform_appsetting
(
	AppSettingsID INTEGER
		primary key autoincrement,
	AppSettingName varchar(50),
	AppSettingValue varchar(199),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_appsettings_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_platform_appsettings_registeredapp
			references refdata_organization
);

create index IX_RefData_Organization
	on refdata_organization (OrganizationGUID, OrganizationName, Address, City, StateID, ZipCode, CreatedDate, StatusID, CreatedUser, OrganizationInternalCode, OrganizationInternalID, LegalEntityGUID);

create index IX_USStates
	on refdata_usstates (StateID, StateDescription, Lattitude, Longitude, CreatedDate, StatusID, CreatedUser);

create table refdata_vendor
(
	VendorID INTEGER
		primary key autoincrement,
	VendorName varchar(50),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_vendors_status
			references refdata_status,
	CreatedUser varchar(20),
	VendorGUID char(38)
);

create table refdata_application
(
	AppGUID char(38) not null
		primary key,
	ApplicationCustomCode varchar(15),
	ApplicationDesc varchar(50),
	CreatedUser varchar(20),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_refdata_application_status
			references refdata_status,
	VendorID int
		constraint FK_refdata_application_vendors
			references refdata_vendor
);

create table databuilt_address
(
	CompleteAddressID INTEGER
		primary key autoincrement,
	Address1 varchar(99),
	City varchar(70),
	StateID varchar(2),
	ZipCode varchar(10),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_databuilt_address_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_address_registeredapp
			references refdata_application
);

create table databuilt_bankaccount
(
	DataBuiltBankAccountsID INTEGER
		primary key autoincrement,
	BankAccountNumber varchar(12),
	BankAccountName varchar(75),
	BankRoutingID varchar(9),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint fk_databuilt_bankAccounts_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_bankaccount_registeredapp
			references refdata_application
);

create table databuilt_corporations
(
	DataBuiltCorporationID INTEGER
		primary key autoincrement,
	CorporationName varchar(99),
	Address1 varchar(99),
	City varchar(70),
	StateID varchar(2),
	ZipCode varchar(10),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_databuilt_corporations_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_corporations_resiteredapp
			references refdata_application
);

create table databuilt_names
(
	DataBuiltNamesID INTEGER
		primary key autoincrement,
	CompleteName varchar(100),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_databuilt_completenames_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_names_registeredapp
			references refdata_application
);

create table databuilt_phonenumbers
(
	DataBuiltPhoneNumbersID INTEGER
		primary key autoincrement,
	AreaCode varchar(3),
	PhoneNumber varchar(8),
	CompletePhoneNumber varchar(14),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_databuilt_phonenumbers_status
			references refdata_status
		constraint IDX_databuilt_phonenumbers_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_phonenumbers_registeredapp
			references refdata_application
);

create table databuilt_products
(
	DatabuiltProductsID INTEGER
		primary key autoincrement,
	ProductID varchar(20),
	ProductName varchar(99),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_databuilt_products_status
			references refdata_status,
	RegisteredApp varchar(38)
		constraint FK_databuilt_products_regsiteredapp
			references refdata_application
);

create table dataexisting_ababanking
(
	ABABankingID INTEGER
		primary key autoincrement,
	RoutingNumber varchar(9),
	TelegraphicName varchar(20),
	CustomerName varchar(36),
	City varchar(20),
	State varchar(2),
	ZipCode varchar(5),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_ababanking_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_ababanking_registeredapp
			references refdata_application
);

create table dataexisting_areacode
(
	AreaCodeID INTEGER
		primary key autoincrement,
	AreaCodeValue varchar(3) not null,
	TimeZone varchar(3)
		constraint FK_dataexisting_areacode_timezones
			references refdata_timezones,
	StateCode varchar(2)
		constraint FK_dataexisting_areacode_USStates
			references refdata_usstates,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_areacode_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_areacode_registeredapp
			references refdata_application
);

create index IX_AreaCode
	on dataexisting_areacode (AreaCodeValue, TimeZone, StateCode, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_areacodeintl
(
	IDDCode varchar(5) not null
		primary key,
	CountryID smallint
		constraint FK_dataexisting_areacodeintl_Countries
			references refdata_countries,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_areacodeintl_Status
			references refdata_status,
	RegisteredApp char(38)
		constraint FK_dataexisting_areacodeintl_registeredapp
			references refdata_application
);

create index IX_AreaCodeIntl
	on dataexisting_areacodeintl (IDDCode, CountryID, CreatedDate, StatusID, RegisteredApp);

create table dataexisting_companies
(
	CompaniesID INTEGER
		primary key autoincrement,
	CompanyName varchar(79),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_companies_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_companies_registeredapp
			references refdata_application
);

create table dataexisting_namefirst
(
	FirstNameID INTEGER
		primary key autoincrement,
	FirstName varchar(39),
	Gender varchar(1),
	StatusID INTEGER default 1
		constraint FK_dataexisting_namefirst_Status
			references refdata_status,
	CreatedDate timestamp,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_namefirst_registeredapp
			references refdata_application,
	constraint IX_Unique_NameFirst
		unique (FirstName, RegisteredApp)
);

create table dataexisting_namelast
(
	LastNameID INTEGER
		primary key autoincrement,
	LastName varchar(69),
	StatusID smallint default 1 not null
		constraint FK_dataexisting_namelast_Status
			references refdata_status,
	CreatedDate timestamp,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_namelast_registeredapp
			references refdata_application,
	constraint IX_Unique_NameLast
		unique (LastName, RegisteredApp)
);

create table dataexisting_upccodes
(
	UPCCodeID INTEGER
		primary key autoincrement,
	UPCCodeName varchar(15),
	UPCProductName varchar(150),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_upccodes_Status
			references refdata_status,
	RegisteredApp char(38)
		constraint FK_dataexisting_upccodes_registeredapp
			references refdata_application
);

create table dataexisting_zipcodeintl
(
	ZipCodeIntnlID INTEGER
		primary key autoincrement,
	ZipCode char(10) not null,
	ZipCodeType varchar(15),
	City varchar(75),
	Country smallint
		constraint FK_dataexisting_zipcodeIntl_Countries
			references refdata_countries,
	Lattitude varchar(10),
	Longitude varchar(10),
	Location varchar(99),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_zipcodeIntl_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_zipcodeintl_registeredapp
			references refdata_application
);

create table dataexisting_zipcodeus
(
	ZipCodeID INTEGER
		primary key autoincrement,
	ZipCode char(5) not null,
	ZipCodeType varchar(15),
	City varchar(75),
	State varchar(2),
	Lattitude varchar(10),
	Longitude varchar(10),
	Location varchar(99),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_dataexisting_zipcodeUS_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_dataexisting_zipcodeus_registeredapp
			references refdata_application
);

create table datagenerated_accountnumbers
(
	AccountNumbersID INTEGER
		primary key autoincrement,
	AccountNumberValue varchar(20),
	CreatedDate timestamp,
	CreatedUser varchar(20),
	StatusID INTEGER default 1
		constraint FK_datagenerated_accountnumbers_Status
			references refdata_status,
	RegisteredApp char(38)
		constraint FK_datagenerated_accountnumbers_registeredapp
			references refdata_application,
	constraint IX_Unqiue_AccountNumbers
		unique (AccountNumberValue, RegisteredApp)
);

create index FK_datagenerated_accountnumbers_status
	on datagenerated_accountnumbers (StatusID);

create table datagenerated_addresses
(
	AddressID INTEGER
		primary key autoincrement,
	AddressStreet varchar(99),
	AddressStreet2 varchar(59),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_addresses_status
			references refdata_status,
	AddressFormatTypeId smallint default 1
		constraint FK_datagenerated_addresses_AddressFormatType
			references refdata_addressformattype,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_addresses_registeredapp
			references refdata_application,
	constraint IX_Unique_Addresses
		unique (AddressStreet, AddressStreet2, RegisteredApp)
);

create table datagenerated_bankaccount
(
	BankAccountsID INTEGER
		primary key autoincrement,
	BankAccountValue varchar(17),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_bankaccount_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_bankaccount_registeredapp
			references refdata_application,
	constraint IX_Unqiue_BankAccounts
		unique (BankAccountValue, RegisteredApp)
);

create table datagenerated_creditcard
(
	CreditCardID INTEGER
		primary key autoincrement,
	CreditCardNumber varchar(20),
	CreditCardName varchar(10),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_creditcard_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_creditcard_registeredapp
			references refdata_application
);

create table datagenerated_dateofbirth
(
	DateofBirthsID INTEGER
		primary key autoincrement,
	DateOfBirth varchar(12),
	DateOfBirthDate date,
	Age int,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_dateofbirth_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_dateofbirth_registeredapp
			references refdata_application,
	constraint IX_Unique_DateOfBirths
		unique (DateOfBirth, DateOfBirthDate, RegisteredApp)
);

create table datagenerated_driverslicenses
(
	DriversLicensesID INTEGER
		primary key autoincrement,
	DLN varchar(25),
	StateCode varchar(2)
		constraint FK_datagenerated_driverslicenses_USStates
			references refdata_usstates,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_driverslicenses_Status
			references refdata_status,
	CompleteDriversLicenseNumber varchar(30),
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_driverslicenses_registeredapp
			references refdata_application,
	constraint IX_Unique_DriversLicenses
		unique (DLN, StateCode, CompleteDriversLicenseNumber, RegisteredApp)
);

create table datagenerated_ein
(
	EINID INTEGER
		primary key autoincrement,
	EINValue varchar(10),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_ein_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_ein_registeredapp
			references refdata_application,
	constraint IX_Unique_EIN
		unique (EINValue, RegisteredApp)
);

create table datagenerated_phonenumber
(
	PhoneNumberID INTEGER
		primary key autoincrement,
	PhoneNumberValue varchar(8),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_phonenumbers_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_phonenumber_registeredapp
			references refdata_application,
	constraint IX_Unique_PhoneNumbers
		unique (PhoneNumberValue, RegisteredApp)
);

create table datagenerated_phonenumbersintl
(
	PhoneNumberIntlID INTEGER
		primary key autoincrement,
	PhoneNumberValue varchar(12),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_phonenumbersintl_Status
			references refdata_status,
	CountryId smallint
		constraint FK_datagenerated_phonenumbersintl_Country
			references refdata_countries,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_phonenumbersintl_registeredapp
			references refdata_application
);

create table datagenerated_socialsecuritynumber
(
	SocialSecurityNumberID INTEGER
		primary key autoincrement,
	SocialSecurityNumberValue varchar(11),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_socialsecuritynumber_Status
			references refdata_status,
	CreatedUser varchar(20),
	RegisteredApp char(38)
		constraint FK_datagenerated_socialsecuritynumber_registeredapp
			references refdata_application,
	constraint IX_Unique_SocialSecurityNumbers
		unique (SocialSecurityNumberValue, RegisteredApp)
);

create table datagenerated_useridentities
(
	UserIdentitiesID INTEGER
		primary key autoincrement,
	UserIdentityValue varchar(20),
	UserDomain varchar(20),
	AdditionalAttributes varchar(40),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_datagenerated_useridentities_Status
			references refdata_status,
	RegisteredApp char(38)
		constraint FK_datagenerated_useridentities_registeredapp
			references refdata_application,
	constraint IX_Unique_UserIdentities
		unique (UserIdentityValue, UserDomain, RegisteredApp)
);

create table platform_dataattributes
(
	PlatformDataAttributesID INTEGER
		primary key autoincrement,
	DataAttributeName varchar(50),
	SensitivityFlagID smallint
		constraint FK_platformdataattributes_sensitivtyflag
			references refdata_sensitivityflag,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_platformdataattributes_status
			references refdata_status,
	CreatedUser varchar(20),
	PlatformDataAttributeGUID char(38),
	RegisteredApp char(38)
		constraint FK_platform_dataattributes_registeredapp
			references refdata_application
);

create table platform_config_datagen
(
	DataGenConfigID INTEGER
		primary key autoincrement,
	DataTypeGenConfigName varchar(25),
	DataAttributeID smallint
		constraint FK_platform_datagenconfig_dataattributes
			references platform_dataattributes,
	SpecialInstructions varchar(99),
	RunQuantity int,
	MinuteInterval smallint,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_platform_datagenconfig_status
			references refdata_status,
	CreatedUser varchar(20),
	ApplicationID varchar(38)
		constraint FK_platform_datagenconfig_registeredapp
			references refdata_application
);

create table platform_datastructures
(
	PlatformDataStructuresID INTEGER
		primary key autoincrement,
	DataStructureName varchar(50),
	SensitivityFlagID smallint
		constraint FK_platform_datastructures_sensitivityflag
			references refdata_sensitivityflag,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_platform_datastructures_status
			references refdata_status,
	CreatedUser varchar(20),
	PlatformDataStructuresGUID char(38),
	RegisteredApp varchar(38)
		constraint FK_platform_datastructures__registeredapp
			references refdata_application
);

create table platform_datastructurestodataattributes
(
	PlatformDataStructuresToDataAttributesID INTEGER
		primary key autoincrement,
	PlatformDataStructuresID smallint
		constraint FK_platform_datastructurestodataattributes_datastructure
			references platform_datastructures,
	CompositeDataStructureName varchar(50),
	SensitivityFlagID smallint default 1
		constraint FK_platform_datastructurestodataattributes_sensitivityflag
			references refdata_sensitivityflag,
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_platform_datastructurestodataattributes_status
			references refdata_status,
	CreatedUser varchar(20),
	PlatformDataStructuresToDataAttributesGUID char(38),
	RegisteredApp varchar(38)
		constraint FK_platform_datastructurestodataattributes_registeredapp
			references refdata_application,
	PlatformDataAttributesID smallint
		constraint FK_platform_datastructurestodataattributes_dataattributes
			references platform_dataattributes
);

create table platform_rulesetsdefinitions
(
	RulesetDefinitionsID char(38) not null
		primary key,
	RulesetDefinitionName varchar(50),
	RuleSetID bigint
		constraint FK_platform_rulesetsdefinitions_ruleset
			references platform_rulesets,
	StepOrderID smallint,
	OperationTypeID varchar(7)
		constraint FK_platform_rulesetsdefinitions_operationtype
			references refdata_operationtype,
	RulesetDefValue char(40),
	StatusID INTEGER default 1
		constraint FK_platform_rulesetsdefinitions_status
			references refdata_status,
	CreatedDate timestamp,
	EffectiveDate timestamp,
	ApplicationID varchar(38)
		constraint FK_platform_rulesetsdefinitions_registeredapp
			references refdata_application
);

create index IX_PlatformRulesetsDefinitions
	on platform_rulesetsdefinitions (RulesetDefinitionsID, RuleSetID, RulesetDefinitionName, StepOrderID, OperationTypeID, RulesetDefValue, CreatedDate, EffectiveDate, StatusID, ApplicationID);

create index IX_RefData_Application
	on refdata_application (AppGUID, ApplicationCustomCode, ApplicationDesc, CreatedUser, CreatedDate, StatusID, VendorID);

create table terms_codesetstoapplication
(
	CodeSetToApplicationID INTEGER
		primary key autoincrement,
	CodeSetsID bigint not null
		constraint terms_codesetstoapplication_codeset
			references refdata_codeset,
	Domain varchar(50),
	IndustryStd varchar(6)
		constraint FK_terms_codesetstoapplication_industrystd
			references refdata_industrystd,
	SpecificDetails varchar(99),
	CreatedDate timestamp,
	StatusID INTEGER default 1
		constraint FK_terms_codesetstoapplication_status
			references refdata_status,
	CreatedUser varchar(20),
	OrganizationID varchar(38)
		constraint FK_terms_codesetstoapplication_Org
			references refdata_organization,
	ApplicationID varchar(38)
		constraint FK_terms_codesetstoapplication_Application
			references refdata_application,
	VendorID int
		constraint terms_codesetstoapplication_Vendor
			references refdata_vendor,
	CodeValue varchar(20),
	CodeDesc varchar(129),
	SensitiveFlagID smallint
		constraint FK_terms_codesetstoapplication_sensitiveflag
			references refdata_sensitivityflag
);

