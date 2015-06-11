create table bcnetcountry (
	countryCode VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table biobank (
	biobankDbId LONG not null primary key,
	biobankId VARCHAR(75) null,
	acronym VARCHAR(75) null,
	url VARCHAR(75) null,
	juristicPersonId LONG,
	countryCode VARCHAR(75) null,
	description VARCHAR(75) null,
	backup BOOLEAN,
	trainingCourses BOOLEAN
);

create table biobankattributelists (
	biobankAttributeListsId LONG not null primary key,
	biobankDbId LONG,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table biobankattributelistsmaster (
	biobankAttributeListsMasterId LONG not null primary key,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table biobankcontact (
	biobankDbId LONG not null,
	contactId LONG not null,
	primary key (biobankDbId, contactId)
);

create table contact (
	contactId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	zip VARCHAR(75) null,
	city VARCHAR(75) null,
	countryCode VARCHAR(75) null,
	juristicPersonId LONG,
	department VARCHAR(75) null,
	orcId VARCHAR(75) null
);

create table country (
	countryCode VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table juristicperson (
	juristicPersonId LONG not null primary key,
	name VARCHAR(75) null,
	url VARCHAR(75) null,
	address VARCHAR(75) null
);

create table sample (
	sampleId LONG not null primary key,
	sampleCollectionDbId LONG,
	biobankDbId LONG,
	hashedSampleId VARCHAR(75) null,
	materialType VARCHAR(75) null,
	container VARCHAR(75) null,
	storageTemperature VARCHAR(75) null,
	sampledTime DATE null,
	anatomicalPartOntology VARCHAR(75) null,
	anatomicalPartOntologyVersion VARCHAR(75) null,
	anatomicalPartOntologyCode VARCHAR(75) null,
	anatomicalPartDescription VARCHAR(75) null,
	anatomicalPartFreeText VARCHAR(75) null,
	sex VARCHAR(75) null,
	ageHigh LONG,
	ageLow LONG,
	ageUnit VARCHAR(75) null,
	diseaseOntology VARCHAR(75) null,
	diseaseOntologyVersion VARCHAR(75) null,
	diseaseOntologyCode VARCHAR(75) null,
	diseaseDescription VARCHAR(75) null,
	diseaseFreeText VARCHAR(75) null
);

create table samplecollection (
	sampleCollectionDbId LONG not null primary key,
	sampleCollectionId VARCHAR(75) null,
	acronym VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	consentTemplate BOOLEAN,
	reuseOfSamples BOOLEAN,
	materialTransferAgreement BOOLEAN,
	accreditation BOOLEAN,
	qualityControl BOOLEAN
);

create table samplecollectionattributelists (
	sampleCollectionAttributeListsId LONG not null primary key,
	sampleCollectionDbId LONG,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table samplecollectionattributelistsmaster (
	sampleCollectionAttributeListsMasterId LONG not null primary key,
	attributeListName VARCHAR(75) null,
	attributeListValue VARCHAR(75) null
);

create table samplecollectioncontact (
	sampleCollectionDbId LONG not null,
	userId LONG not null,
	mainContact BOOLEAN,
	sampleCollectionOwner BOOLEAN,
	sampleCollectionEditor BOOLEAN,
	primary key (sampleCollectionDbId, userId)
);