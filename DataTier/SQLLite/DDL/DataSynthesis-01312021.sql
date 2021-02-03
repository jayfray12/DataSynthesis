create table datamodel_datatables
(
	TableName varchar(64) not null
		PRIMARY KEY,
	TableInformation varchar(249) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null
);

CREATE INDEX IDX_datamodel_datatables
	on datamodel_datatables (TableName, TableInformation, StatusID, CreatedDate);

create table refdata_status
(
	StatusID INTEGER PRIMARY KEY AUTOINCREMENT,
	StatusDescription varchar(45) not null,
	CreatedDate timestamp null,
	CreatedUser varchar(20) null
);

create table auditing_datarequest
(
	DataRequestID INTEGER PRIMARY KEY AUTOINCREMENT,
	DataRequestDate datetime(3) null,
	CreatedByUser varchar(20) null,
	Organizaton varchar(38) null,
	Application varchar(38) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null,
	constraint FK_platform_datarequest_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IDX_platform_datarequest
	on auditing_datarequest (DataRequestID, DataRequestDate, CreatedByUser, Organizaton, Application, StatusID, CreatedDate);

create table platform_rulesets
(
	RuleID INTEGER PRIMARY KEY AUTOINCREMENT,
	RuleName varchar(65) null,
	CreatedUser varchar(20) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	ExpirationDate timestamp null,
	constraint FK_platform_rulesets_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PlatformRuleSets
	on platform_rulesets (RuleID, RuleName, CreatedUser, CreatedDate, ExpirationDate, StatusID);

create table platform_rulesetsattributes
(
	RulesetAttributeID INTEGER PRIMARY KEY AUTOINCREMENT,
	RuleSetAttributeDesc varchar(75) null,
	CreatedDate timestamp  not null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_platform_rulesetsattributes_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IDX_PlatformRuleSetsAttributes
	on platform_rulesetsattributes (RuleSetAttributeDesc, CreatedDate, StatusID);

create table refdata_addressformattype
(
	AddressFormatTypeID INTEGER PRIMARY KEY AUTOINCREMENT,
	AddressFormatTypeDesc varchar(35) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_AddressFormatType_Status
		foreign key (StatusId) references refdata_status (StatusID)
);

create index IDX_refdata_addressformattype_AddressFormatTypeID
	on refdata_addressformattype (AddressFormatTypeID, AddressFormatTypeDesc, CreatedDate, StatusId);

create index IX_AddressFormatType
	on refdata_addressformattype (AddressFormatTypeID, AddressFormatTypeDesc, CreatedDate, StatusId);

create table refdata_countries
(
	CountryID INTEGER PRIMARY KEY AUTOINCREMENT,
	IDD varchar(5) null,
	CountryName varchar(59) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_Countries_Status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_Countries
	on refdata_countries (CountryID, IDD, CountryName, CreatedDate, StatusID);

create table refdata_industrystd
(
	IndustryStd varchar(6) not null
		PRIMARY KEY,
	IndustryStdDesc varchar(30) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_refdata_industrystd_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_IndustryStd
	on refdata_industrystd (IndustryStd, IndustryStdDesc, CreatedDate, StatusID);

create table refdata_operationtype
(
	OperationTypeID varchar(7) not null
		PRIMARY KEY,
	OperationTypeName varchar(60) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_refdata_operationtype_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_OperationType
	on refdata_operationtype (OperationTypeID, OperationTypeName, StatusID, CreatedDate);

create table refdata_sensitivityflag
(
	SensitiveFlagID INTEGER PRIMARY KEY AUTOINCREMENT,
	SensitiveFlagDesc varchar(30) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_refdata_sensitivityflag_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table refdata_codeset
(
	CodeSetsID INTEGER PRIMARY KEY AUTOINCREMENT,
	CodeSetName varchar(50) null,
	IndustryStd varchar(6) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null,
	CreatedUser varchar(20) null,
	CodesetGUID char(38) null,
	FieldMapping varchar(20) null,
	SensitivityFlagID smallint null,
	constraint FK_refdata_codeset_industrystd
		foreign key (IndustryStd) references refdata_industrystd (IndustryStd),
	constraint FK_refdata_codeset_sensitivityflag
		foreign key (SensitivityFlagID) references refdata_sensitivityflag (SensitiveFlagID),
	constraint FK_refdata_codesets_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_RefData_CodeSets
	on refdata_codeset (CodeSetsID, CodeSetName, IndustryStd, CreatedDate, StatusID, CreatedUser, CodesetGUID, FieldMapping, SensitivityFlagID);

create index IX_SensitivityFlag
	on refdata_sensitivityflag (SensitiveFlagID, SensitiveFlagDesc, StatusID, CreatedDate);

create index IX_RefStatus
	on refdata_status (StatusID, StatusDescription, CreatedDate, CreatedUser);

create table refdata_timezones
(
	TimeZoneValue varchar(3) not null
		PRIMARY KEY,
	TimeZoneDesc varchar(25) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	constraint FK_TimeZones_Status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_TimeZones
	on refdata_timezones (TimeZoneValue, TimeZoneDesc, CreatedDate, StatusID);

create table refdata_usstates
(
	StateID varchar(2) not null
		PRIMARY KEY,
	StateDescription varchar(65) null,
	Lattitude varchar(12) null,
	Longitude varchar(12) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	constraint FK_USStates_Status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table refdata_legalentity
(
	LegalEntityGUID char(38) not null
		PRIMARY KEY,
	LocationName varchar(50) null,
	Address varchar(75) null,
	City varchar(60) null,
	StateID varchar(2) null,
	ZipCode varchar(12) null,
	CreatedUser varchar(20) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp  not null,
	LocationURL varchar(99) null,
	LocationPhone varchar(12) null,
	constraint FK_refdata_location_states
		foreign key (StateID) references refdata_usstates (StateID),
	constraint FK_refdata_location_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table refdata_organization
(
	OrganizationGUID char(38) not null
		PRIMARY KEY,
	OrganizationInternalCode varchar(10) null,
	OrganizationInternalID varchar(10) null,
	OrganizationName varchar(50) null,
	Address varchar(75) null,
	City varchar(60) null,
	StateID varchar(2) null,
	ZipCode varchar(12) null,
	CreatedUser varchar(20) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp  not null,
	LegalEntityGUID varchar(38) null,
	constraint FK_refdata_organization_legalentity
		foreign key (LegalEntityGUID) references refdata_legalentity (LegalEntityGUID),
	constraint FK_refdata_organization_states
		foreign key (StateID) references refdata_usstates (StateID),
	constraint FK_refdata_organization_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table platform_appsetting
(
	AppSettingsID INTEGER PRIMARY KEY AUTOINCREMENT,
	AppSettingName varchar(50) null,
	AppSettingValue varchar(199) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_platform_appsettings_registeredapp
		foreign key (RegisteredApp) references refdata_organization (OrganizationGUID),
	constraint FK_refdata_appsettings_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_RefDataAppSettings
	on platform_appsetting (AppSettingsID, AppSettingName, AppSettingValue, CreatedDate, StatusID, RegisteredApp);

create index IX_RefData_Organization
	on refdata_organization (OrganizationGUID, OrganizationName, Address, City, StateID, ZipCode, CreatedDate, StatusID, CreatedUser, OrganizationInternalCode, OrganizationInternalID, LegalEntityGUID);

create index IX_USStates
	on refdata_usstates (StateID, StateDescription, Lattitude, Longitude, CreatedDate, StatusID, CreatedUser);

create table refdata_vendor
(
	VendorID INTEGER PRIMARY KEY AUTOINCREMENT,
	VendorName varchar(50) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	VendorGUID char(38) null,
	constraint FK_refdata_vendors_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table refdata_application
(
	AppGUID char(38) not null
		PRIMARY KEY,
	ApplicationCustomCode varchar(15) null,
	ApplicationDesc varchar(50) null,
	CreatedUser varchar(20) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	VendorID int null,
	constraint FK_refdata_application_status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_refdata_application_vendors
		foreign key (VendorID) references refdata_vendor (VendorID)
);

create table databuilt_address
(
	CompleteAddressID INTEGER PRIMARY KEY AUTOINCREMENT,
	Address1 varchar(99) null,
	City varchar(70) null,
	StateID varchar(2) null,
	ZipCode varchar(10) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_address_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_databuilt_address_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IDX_databuilt_completeaddress
	on databuilt_address (CompleteAddressID, Address1, City, StateID, ZipCode, CreatedDate, StatusID, RegisteredApp);

create table databuilt_bankaccount
(
	DataBuiltBankAccountsID INTEGER PRIMARY KEY AUTOINCREMENT,
	BankAccountNumber varchar(12) null,
	BankAccountName varchar(75) null,
	BankRoutingID varchar(9) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_bankaccount_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint fk_databuilt_bankAccounts_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_databuilt_bankAccounts
	on databuilt_bankaccount (DataBuiltBankAccountsID, BankAccountName, BankAccountNumber, BankRoutingID, StatusID, CreatedDate, RegisteredApp);

create table databuilt_corporations
(
	DataBuiltCorporationID INTEGER PRIMARY KEY AUTOINCREMENT,
	CorporationName varchar(99) null,
	Address1 varchar(99) null,
	City varchar(70) null,
	StateID varchar(2) null,
	ZipCode varchar(10) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_corporations_resiteredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_databuilt_corporations_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IDX_databuilt_corporations
	on databuilt_corporations (DataBuiltCorporationID, CorporationName, Address1, City, StateID, ZipCode, CreatedDate, StatusID, RegisteredApp);

create table databuilt_names
(
	DataBuiltNamesID INTEGER PRIMARY KEY AUTOINCREMENT,
	CompleteName varchar(100) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_completenames_status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_databuilt_names_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_databuilt_names_databuiltnamesid
	on databuilt_names (DataBuiltNamesID, CompleteName, CreatedDate, StatusID, RegisteredApp);

create table databuilt_phonenumbers
(
	DataBuiltPhoneNumbersID INTEGER PRIMARY KEY AUTOINCREMENT,
	AreaCode varchar(3) null,
	PhoneNumber varchar(8) null,
	CompletePhoneNumber varchar(14) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_phonenumbers_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint IDX_databuilt_phonenumbers_status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_databuilt_phonenumbers_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_databuilt_phonenumbers
	on databuilt_phonenumbers (DataBuiltPhoneNumbersID, AreaCode, PhoneNumber, CompletePhoneNumber, StatusID, CreatedDate, RegisteredApp);

create table databuilt_products
(
	DatabuiltProductsID INTEGER PRIMARY KEY AUTOINCREMENT,
	ProductID varchar(20) null,
	ProductName varchar(99) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp varchar(38) null,
	constraint FK_databuilt_products_regsiteredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_databuilt_products_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IDX_databuilt_products
	on databuilt_products (DatabuiltProductsID, ProductID, ProductName, CreatedDate, StatusID, RegisteredApp);

create table dataexisting_ababanking
(
	ABABankingID INTEGER PRIMARY KEY AUTOINCREMENT,
	RoutingNumber varchar(9) null,
	TelegraphicName varchar(20) null,
	CustomerName varchar(36) null,
	City varchar(20) null,
	State varchar(2) null,
	ZipCode varchar(5) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_ababanking_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_ababanking_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_ABABanking
	on dataexisting_ababanking (ABABankingID, RoutingNumber, TelegraphicName, CustomerName, City, State, ZipCode, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_areacode
(
	AreaCodeID INTEGER PRIMARY KEY AUTOINCREMENT,
	AreaCodeValue varchar(3) not null,
	TimeZone varchar(3) null,
	StateCode varchar(2) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_areacode_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_areacode_USStates
		foreign key (StateCode) references refdata_usstates (StateID),
	constraint FK_dataexisting_areacode_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_dataexisting_areacode_timezones
		foreign key (TimeZone) references refdata_timezones (TimeZoneValue)
);

create index IX_AreaCode
	on dataexisting_areacode (AreaCodeValue, TimeZone, StateCode, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_areacodeintl
(
	IDDCode varchar(5) not null
		PRIMARY KEY,
	CountryID smallint null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_areacodeintl_Countries
		foreign key (CountryID) references refdata_countries (CountryID),
	constraint FK_dataexisting_areacodeintl_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_areacodeintl_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_AreaCodeIntl
	on dataexisting_areacodeintl (IDDCode, CountryID, CreatedDate, StatusID, RegisteredApp);

create table dataexisting_companies
(
	CompaniesID INTEGER PRIMARY KEY AUTOINCREMENT,
	CompanyName varchar(79) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_companies_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_companies_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_Companies
	on dataexisting_companies (CompaniesID, CompanyName, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_namefirst
(
	FirstNameID INTEGER PRIMARY KEY AUTOINCREMENT,
	FirstName varchar(39) null,
	Gender varchar(1) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_NameFirst
		unique (FirstName, RegisteredApp),
	constraint FK_dataexisting_namefirst_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_namefirst_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_NameFirst
	on dataexisting_namefirst (FirstNameID, FirstName, Gender, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_namelast
(
	LastNameID INTEGER PRIMARY KEY AUTOINCREMENT,
	LastName varchar(69) null,
	StatusID smallint default 1 not null,
	CreatedDate timestamp null,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_NameLast
		unique (LastName, RegisteredApp),
	constraint FK_dataexisting_namelast_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_namelast_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_NameLast
	on dataexisting_namelast (LastNameID, LastName, StatusID, CreatedDate, CreatedUser, RegisteredApp);

create table dataexisting_upccodes
(
	UPCCodeID INTEGER PRIMARY KEY AUTOINCREMENT,
	UPCCodeName varchar(15) null,
	UPCProductName varchar(150) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_upccodes_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_upccodes_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_UPCCodes
	on dataexisting_upccodes (UPCCodeID, UPCCodeName, UPCProductName, CreatedDate, StatusID, RegisteredApp);

create table dataexisting_zipcodeintl
(
	ZipCodeIntnlID INTEGER PRIMARY KEY AUTOINCREMENT,
	ZipCode char(10) not null,
	ZipCodeType varchar(15) null,
	City varchar(75) null,
	Country smallint null,
	Lattitude varchar(10) null,
	Longitude varchar(10) null,
	Location varchar(99) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_zipcodeIntl_Countries
		foreign key (Country) references refdata_countries (CountryID),
	constraint FK_dataexisting_zipcodeIntl_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_zipcodeintl_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_ZipcodeIntl
	on dataexisting_zipcodeintl (ZipCodeIntnlID, ZipCode, ZipCodeType, Country, City, Lattitude, Longitude, Location, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table dataexisting_zipcodeus
(
	ZipCodeID INTEGER PRIMARY KEY AUTOINCREMENT,
	ZipCode char(5) not null,
	ZipCodeType varchar(15) null,
	City varchar(75) null,
	State varchar(2) null,
	Lattitude varchar(10) null,
	Longitude varchar(10) null,
	Location varchar(99) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_dataexisting_zipcodeUS_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_dataexisting_zipcodeus_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IDX_dataexisting_zipcodeus
	on dataexisting_zipcodeus (ZipCodeID, ZipCode, ZipCodeType, City, State, Lattitude, Longitude, Location, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_accountnumbers
(
	AccountNumbersID INTEGER PRIMARY KEY AUTOINCREMENT,
	AccountNumberValue varchar(20) null,
	CreatedDate timestamp null,
	CreatedUser varchar(20) null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp char(38) null,
	constraint IX_Unqiue_AccountNumbers
		unique (AccountNumberValue, RegisteredApp),
	constraint FK_datagenerated_accountnumbers_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_accountnumbers_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index FK_datagenerated_accountnumbers_status
	on datagenerated_accountnumbers (StatusID);

create index IX_AccountNumbers
	on datagenerated_accountnumbers (AccountNumbersID, AccountNumberValue, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_addresses
(
	AddressID INTEGER PRIMARY KEY AUTOINCREMENT,
	AddressStreet varchar(99) null,
	AddressStreet2 varchar(59) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	AddressFormatTypeId smallint default 1 null,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_Addresses
		unique (AddressStreet, AddressStreet2, RegisteredApp),
	constraint FK_datagenerated_addresses_AddressFormatType
		foreign key (AddressFormatTypeId) references refdata_addressformattype (AddressFormatTypeID),
	constraint FK_datagenerated_addresses_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_datagenerated_addresses_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_Addresses
	on datagenerated_addresses (AddressID, AddressStreet, AddressStreet2, AddressFormatTypeId, StatusID, CreatedDate, CreatedUser, RegisteredApp);

create table datagenerated_bankaccount
(
	BankAccountsID INTEGER PRIMARY KEY AUTOINCREMENT,
	BankAccountValue varchar(17) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unqiue_BankAccounts
		unique (BankAccountValue, RegisteredApp),
	constraint FK_datagenerated_bankaccount_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_bankaccount_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_BankAccounts
	on datagenerated_bankaccount (BankAccountsID, BankAccountValue, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_creditcard
(
	CreditCardID INTEGER PRIMARY KEY AUTOINCREMENT,
	CreditCardNumber varchar(20) null,
	CreditCardName varchar(10) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_datagenerated_creditcard_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_creditcard_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_CreditCard
	on datagenerated_creditcard (CreditCardID, CreditCardNumber, CreditCardName, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_dateofbirth
(
	DateofBirthsID INTEGER PRIMARY KEY AUTOINCREMENT,
	DateOfBirth varchar(12) null,
	DateOfBirthDate date null,
	Age int null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_DateOfBirths
		unique (DateOfBirth, DateOfBirthDate, RegisteredApp),
	constraint FK_datagenerated_dateofbirth_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_dateofbirth_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_DateOfBirths
	on datagenerated_dateofbirth (DateofBirthsID, DateOfBirth, DateOfBirthDate, Age, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_driverslicenses
(
	DriversLicensesID INTEGER PRIMARY KEY AUTOINCREMENT,
	DLN varchar(25) null,
	StateCode varchar(2) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CompleteDriversLicenseNumber varchar(30) null,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_DriversLicenses
		unique (DLN, StateCode, CompleteDriversLicenseNumber, RegisteredApp),
	constraint FK_datagenerated_driverslicenses_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_driverslicenses_USStates
		foreign key (StateCode) references refdata_usstates (StateID),
	constraint FK_datagenerated_driverslicenses_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_DriversLicenses
	on datagenerated_driverslicenses (DriversLicensesID, CreatedDate, DLN, StateCode, StatusID, CompleteDriversLicenseNumber, CreatedUser, RegisteredApp);

create table datagenerated_ein
(
	EINID INTEGER PRIMARY KEY AUTOINCREMENT,
	EINValue varchar(10) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_EIN
		unique (EINValue, RegisteredApp),
	constraint FK_datagenerated_ein_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_ein_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_EIN
	on datagenerated_ein (EINID, EINValue, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_phonenumber
(
	PhoneNumberID INTEGER PRIMARY KEY AUTOINCREMENT,
	PhoneNumberValue varchar(8) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_PhoneNumbers
		unique (PhoneNumberValue, RegisteredApp),
	constraint FK_datagenerated_phonenumber_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_datagenerated_phonenumbers_Status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PhoneNumbers
	on datagenerated_phonenumber (PhoneNumberID, PhoneNumberValue, RegisteredApp, CreatedUser, CreatedDate, StatusID);

create table datagenerated_phonenumbersintl
(
	PhoneNumberIntlID INTEGER PRIMARY KEY AUTOINCREMENT,
	PhoneNumberValue varchar(12) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CountryId smallint null,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint FK_datagenerated_phonenumbersintl_Country
		foreign key (CountryId) references refdata_countries (CountryID),
	constraint FK_datagenerated_phonenumbersintl_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_phonenumbersintl_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_PhoneNumbersIntl
	on datagenerated_phonenumbersintl (PhoneNumberIntlID, PhoneNumberValue, CountryId, CreatedDate, CreatedUser, StatusID, RegisteredApp);

create table datagenerated_socialsecuritynumber
(
	SocialSecurityNumberID INTEGER PRIMARY KEY AUTOINCREMENT,
	SocialSecurityNumberValue varchar(11) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	RegisteredApp char(38) null,
	constraint IX_Unique_SocialSecurityNumbers
		unique (SocialSecurityNumberValue, RegisteredApp),
	constraint FK_datagenerated_socialsecuritynumber_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_socialsecuritynumber_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_SocialSecurityNumber
	on datagenerated_socialsecuritynumber (SocialSecurityNumberID, SocialSecurityNumberValue, CreatedDate, StatusID, CreatedUser, RegisteredApp);

create table datagenerated_useridentities
(
	UserIdentitiesID INTEGER PRIMARY KEY AUTOINCREMENT,
	UserIdentityValue varchar(20) null,
	UserDomain varchar(20) null,
	AdditionalAttributes varchar(40) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	RegisteredApp char(38) null,
	constraint IX_Unique_UserIdentities
		unique (UserIdentityValue, UserDomain, RegisteredApp),
	constraint FK_datagenerated_useridentities_Status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_datagenerated_useridentities_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID)
);

create index IX_UserIdentities
	on datagenerated_useridentities (UserIdentitiesID, UserIdentityValue, UserDomain, CreatedDate, StatusID, AdditionalAttributes, RegisteredApp);

create table platform_dataattributes
(
	PlatformDataAttributesID INTEGER PRIMARY KEY AUTOINCREMENT,
	DataAttributeName varchar(50) null,
	SensitivityFlagID smallint null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	PlatformDataAttributeGUID char(38) null,
	RegisteredApp char(38) null,
	constraint FK_platform_dataattributes_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_platformdataattributes_sensitivtyflag
		foreign key (SensitivityFlagID) references refdata_sensitivityflag (SensitiveFlagID),
	constraint FK_platformdataattributes_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create table auditing_datarequestdetail
(
	DataRequestDetailID INTEGER PRIMARY KEY AUTOINCREMENT,
	DataRequestID bigint null,
	DataAttributeID smallint null,
	RecCount bigint null,
	RecordFormatDetails varchar(75) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null,
	constraint FK_platform_datarequestdetail
		foreign key (StatusID) references refdata_status (StatusID),
	constraint FK_platform_datarequestdetail_dataattributes
		foreign key (DataAttributeID) references platform_dataattributes (PlatformDataAttributesID),
	constraint FK_platform_datarequestdetail_datarequest
		foreign key (DataRequestID) references auditing_datarequest (DataRequestID)
);

create index IDX_platform_datarequestdetail
	on auditing_datarequestdetail (DataRequestDetailID, DataRequestID, DataAttributeID, RecCount, RecordFormatDetails, StatusID, CreatedDate);

create table platform_config_datagen
(
	DataGenConfigID INTEGER PRIMARY KEY AUTOINCREMENT,
	DataTypeGenConfigName varchar(25) null,
	DataAttributeID smallint null,
	SpecialInstructions varchar(99) null,
	RunQuantity int null,
	MinuteInterval smallint null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	ApplicationID varchar(38) null,
	constraint FK_platform_datagenconfig_dataattributes
		foreign key (DataAttributeID) references platform_dataattributes (PlatformDataAttributesID),
	constraint FK_platform_datagenconfig_registeredapp
		foreign key (ApplicationID) references refdata_application (AppGUID),
	constraint FK_platform_datagenconfig_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PlatformDataGenConfig
	on platform_config_datagen (DataGenConfigID, DataAttributeID, DataTypeGenConfigName, RunQuantity, MinuteInterval, SpecialInstructions, CreatedDate, CreatedUser, StatusID, ApplicationID);

create index IX_PlatformDataAttributes
	on platform_dataattributes (PlatformDataAttributesID, DataAttributeName, SensitivityFlagID, CreatedDate, StatusID, CreatedUser, PlatformDataAttributeGUID, RegisteredApp);

create table platform_datastructures
(
	PlatformDataStructuresID INTEGER PRIMARY KEY AUTOINCREMENT,
	DataStructureName varchar(50) null,
	SensitivityFlagID smallint null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	PlatformDataStructuresGUID char(38) null,
	RegisteredApp varchar(38) null,
	constraint FK_platform_datastructures__registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_platform_datastructures_sensitivityflag
		foreign key (SensitivityFlagID) references refdata_sensitivityflag (SensitiveFlagID),
	constraint FK_platform_datastructures_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PlatformDataStructures
	on platform_datastructures (PlatformDataStructuresID, DataStructureName, SensitivityFlagID, CreatedDate, StatusID, CreatedUser, PlatformDataStructuresGUID, RegisteredApp);

create table platform_datastructurestodataattributes
(
	PlatformDataStructuresToDataAttributesID INTEGER PRIMARY KEY AUTOINCREMENT,
	PlatformDataStructuresID smallint null,
	CompositeDataStructureName varchar(50) null,
	SensitivityFlagID smallint default 1 null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	PlatformDataStructuresToDataAttributesGUID char(38) null,
	RegisteredApp varchar(38) null,
	PlatformDataAttributesID smallint null,
	constraint FK_platform_datastructurestodataattributes_dataattributes
		foreign key (PlatformDataAttributesID) references platform_dataattributes (PlatformDataAttributesID),
	constraint FK_platform_datastructurestodataattributes_datastructure
		foreign key (PlatformDataStructuresID) references platform_datastructures (PlatformDataStructuresID),
	constraint FK_platform_datastructurestodataattributes_registeredapp
		foreign key (RegisteredApp) references refdata_application (AppGUID),
	constraint FK_platform_datastructurestodataattributes_sensitivityflag
		foreign key (SensitivityFlagID) references refdata_sensitivityflag (SensitiveFlagID),
	constraint FK_platform_datastructurestodataattributes_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PlatformDataStructuresToDataAttributes
	on platform_datastructurestodataattributes (PlatformDataStructuresToDataAttributesID, PlatformDataStructuresToDataAttributesGUID, PlatformDataStructuresID, CompositeDataStructureName, SensitivityFlagID, CreatedDate, StatusID, CreatedUser, RegisteredApp, PlatformDataAttributesID);

create table platform_rulesetsdefinitions
(
	RulesetDefinitionsID char(38) not null
		PRIMARY KEY,
	RulesetDefinitionName varchar(50) null,
	RuleSetID bigint null,
	StepOrderID smallint null,
	OperationTypeID varchar(7) null,
	RulesetDefValue char(40) null,
	StatusID INTEGER DEFAULT 1,
	CreatedDate timestamp null,
	EffectiveDate timestamp null,
	ApplicationID varchar(38) null,
	constraint FK_platform_rulesetsdefinitions_operationtype
		foreign key (OperationTypeID) references refdata_operationtype (OperationTypeID),
	constraint FK_platform_rulesetsdefinitions_registeredapp
		foreign key (ApplicationID) references refdata_application (AppGUID),
	constraint FK_platform_rulesetsdefinitions_ruleset
		foreign key (RuleSetID) references platform_rulesets (RuleID),
	constraint FK_platform_rulesetsdefinitions_status
		foreign key (StatusID) references refdata_status (StatusID)
);

create index IX_PlatformRulesetsDefinitions
	on platform_rulesetsdefinitions (RulesetDefinitionsID, RuleSetID, RulesetDefinitionName, StepOrderID, OperationTypeID, RulesetDefValue, CreatedDate, EffectiveDate, StatusID, ApplicationID);

create index IX_RefData_Application
	on refdata_application (AppGUID, ApplicationCustomCode, ApplicationDesc, CreatedUser, CreatedDate, StatusID, VendorID);

create index IX_RefData_Vendors
	on refdata_vendor (VendorID, VendorName, StatusID, VendorGUID, CreatedDate, CreatedUser);

create table terms_codesetstoapplication
(
	CodeSetToApplicationID INTEGER PRIMARY KEY AUTOINCREMENT,
	CodeSetsID bigint not null,
	Domain varchar(50) null,
	IndustryStd varchar(6) null,
	SpecificDetails varchar(99) null,
	CreatedDate timestamp null,
	StatusID INTEGER DEFAULT 1,
	CreatedUser varchar(20) null,
	OrganizationID varchar(38) null,
	ApplicationID varchar(38) null,
	VendorID int null,
	CodeValue varchar(20) null,
	CodeDesc varchar(129) null,
	SensitiveFlagID smallint null,
	constraint FK_terms_codesetstoapplication_Application
		foreign key (ApplicationID) references refdata_application (AppGUID),
	constraint FK_terms_codesetstoapplication_Org
		foreign key (OrganizationID) references refdata_organization (OrganizationGUID),
	constraint FK_terms_codesetstoapplication_industrystd
		foreign key (IndustryStd) references refdata_industrystd (IndustryStd),
	constraint FK_terms_codesetstoapplication_sensitiveflag
		foreign key (SensitiveFlagID) references refdata_sensitivityflag (SensitiveFlagID),
	constraint FK_terms_codesetstoapplication_status
		foreign key (StatusID) references refdata_status (StatusID),
	constraint terms_codesetstoapplication_Vendor
		foreign key (VendorID) references refdata_vendor (VendorID),
	constraint terms_codesetstoapplication_codeset
		foreign key (CodeSetsID) references refdata_codeset (CodeSetsID)
);

create index IX_Terms_CodeSetsToApplication
	on terms_codesetstoapplication (CodeSetToApplicationID, CodeSetsID, Domain, IndustryStd, SpecificDetails, CreatedDate, CreatedUser, OrganizationID, ApplicationID, StatusID, VendorID, SensitiveFlagID);

