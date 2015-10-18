/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.Sample;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sample in entity cache.
 *
 * @author suyama
 * @see Sample
 * @generated
 */
public class SampleCacheModel implements CacheModel<Sample>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid_=");
		sb.append(uuid_);
		sb.append(", sampleDbId=");
		sb.append(sampleDbId);
		sb.append(", sampleCollectionDbId=");
		sb.append(sampleCollectionDbId);
		sb.append(", biobankDbId=");
		sb.append(biobankDbId);
		sb.append(", hashedSampleId=");
		sb.append(hashedSampleId);
		sb.append(", hashedIndividualId=");
		sb.append(hashedIndividualId);
		sb.append(", materialType=");
		sb.append(materialType);
		sb.append(", container=");
		sb.append(container);
		sb.append(", storageTemperature=");
		sb.append(storageTemperature);
		sb.append(", sampledTime=");
		sb.append(sampledTime);
		sb.append(", anatomicalPartOntology=");
		sb.append(anatomicalPartOntology);
		sb.append(", anatomicalPartOntologyVersion=");
		sb.append(anatomicalPartOntologyVersion);
		sb.append(", anatomicalPartOntologyCode=");
		sb.append(anatomicalPartOntologyCode);
		sb.append(", anatomicalPartOntologyDescription=");
		sb.append(anatomicalPartOntologyDescription);
		sb.append(", anatomicalPartFreeText=");
		sb.append(anatomicalPartFreeText);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", ageLow=");
		sb.append(ageLow);
		sb.append(", ageHigh=");
		sb.append(ageHigh);
		sb.append(", ageUnit=");
		sb.append(ageUnit);
		sb.append(", diseaseOntology=");
		sb.append(diseaseOntology);
		sb.append(", diseaseOntologyVersion=");
		sb.append(diseaseOntologyVersion);
		sb.append(", diseaseOntologyCode=");
		sb.append(diseaseOntologyCode);
		sb.append(", diseaseOntologyDescription=");
		sb.append(diseaseOntologyDescription);
		sb.append(", diseaseFreeText=");
		sb.append(diseaseFreeText);
		sb.append(", countryOfOrigin=");
		sb.append(countryOfOrigin);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sample toEntityModel() {
		SampleImpl sampleImpl = new SampleImpl();

		if (uuid_ == null) {
			sampleImpl.setUuid_(StringPool.BLANK);
		}
		else {
			sampleImpl.setUuid_(uuid_);
		}

		sampleImpl.setSampleDbId(sampleDbId);
		sampleImpl.setSampleCollectionDbId(sampleCollectionDbId);
		sampleImpl.setBiobankDbId(biobankDbId);

		if (hashedSampleId == null) {
			sampleImpl.setHashedSampleId(StringPool.BLANK);
		}
		else {
			sampleImpl.setHashedSampleId(hashedSampleId);
		}

		if (hashedIndividualId == null) {
			sampleImpl.setHashedIndividualId(StringPool.BLANK);
		}
		else {
			sampleImpl.setHashedIndividualId(hashedIndividualId);
		}

		if (materialType == null) {
			sampleImpl.setMaterialType(StringPool.BLANK);
		}
		else {
			sampleImpl.setMaterialType(materialType);
		}

		if (container == null) {
			sampleImpl.setContainer(StringPool.BLANK);
		}
		else {
			sampleImpl.setContainer(container);
		}

		if (storageTemperature == null) {
			sampleImpl.setStorageTemperature(StringPool.BLANK);
		}
		else {
			sampleImpl.setStorageTemperature(storageTemperature);
		}

		if (sampledTime == Long.MIN_VALUE) {
			sampleImpl.setSampledTime(null);
		}
		else {
			sampleImpl.setSampledTime(new Date(sampledTime));
		}

		if (anatomicalPartOntology == null) {
			sampleImpl.setAnatomicalPartOntology(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartOntology(anatomicalPartOntology);
		}

		if (anatomicalPartOntologyVersion == null) {
			sampleImpl.setAnatomicalPartOntologyVersion(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);
		}

		if (anatomicalPartOntologyCode == null) {
			sampleImpl.setAnatomicalPartOntologyCode(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);
		}

		if (anatomicalPartOntologyDescription == null) {
			sampleImpl.setAnatomicalPartOntologyDescription(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartOntologyDescription(anatomicalPartOntologyDescription);
		}

		if (anatomicalPartFreeText == null) {
			sampleImpl.setAnatomicalPartFreeText(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartFreeText(anatomicalPartFreeText);
		}

		if (sex == null) {
			sampleImpl.setSex(StringPool.BLANK);
		}
		else {
			sampleImpl.setSex(sex);
		}

		sampleImpl.setAgeLow(ageLow);
		sampleImpl.setAgeHigh(ageHigh);

		if (ageUnit == null) {
			sampleImpl.setAgeUnit(StringPool.BLANK);
		}
		else {
			sampleImpl.setAgeUnit(ageUnit);
		}

		if (diseaseOntology == null) {
			sampleImpl.setDiseaseOntology(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseOntology(diseaseOntology);
		}

		if (diseaseOntologyVersion == null) {
			sampleImpl.setDiseaseOntologyVersion(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseOntologyVersion(diseaseOntologyVersion);
		}

		if (diseaseOntologyCode == null) {
			sampleImpl.setDiseaseOntologyCode(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseOntologyCode(diseaseOntologyCode);
		}

		if (diseaseOntologyDescription == null) {
			sampleImpl.setDiseaseOntologyDescription(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseOntologyDescription(diseaseOntologyDescription);
		}

		if (diseaseFreeText == null) {
			sampleImpl.setDiseaseFreeText(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseFreeText(diseaseFreeText);
		}

		if (countryOfOrigin == null) {
			sampleImpl.setCountryOfOrigin(StringPool.BLANK);
		}
		else {
			sampleImpl.setCountryOfOrigin(countryOfOrigin);
		}

		sampleImpl.resetOriginalValues();

		return sampleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid_ = objectInput.readUTF();
		sampleDbId = objectInput.readLong();
		sampleCollectionDbId = objectInput.readLong();
		biobankDbId = objectInput.readLong();
		hashedSampleId = objectInput.readUTF();
		hashedIndividualId = objectInput.readUTF();
		materialType = objectInput.readUTF();
		container = objectInput.readUTF();
		storageTemperature = objectInput.readUTF();
		sampledTime = objectInput.readLong();
		anatomicalPartOntology = objectInput.readUTF();
		anatomicalPartOntologyVersion = objectInput.readUTF();
		anatomicalPartOntologyCode = objectInput.readUTF();
		anatomicalPartOntologyDescription = objectInput.readUTF();
		anatomicalPartFreeText = objectInput.readUTF();
		sex = objectInput.readUTF();
		ageLow = objectInput.readLong();
		ageHigh = objectInput.readLong();
		ageUnit = objectInput.readUTF();
		diseaseOntology = objectInput.readUTF();
		diseaseOntologyVersion = objectInput.readUTF();
		diseaseOntologyCode = objectInput.readUTF();
		diseaseOntologyDescription = objectInput.readUTF();
		diseaseFreeText = objectInput.readUTF();
		countryOfOrigin = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid_ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid_);
		}

		objectOutput.writeLong(sampleDbId);
		objectOutput.writeLong(sampleCollectionDbId);
		objectOutput.writeLong(biobankDbId);

		if (hashedSampleId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hashedSampleId);
		}

		if (hashedIndividualId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hashedIndividualId);
		}

		if (materialType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(materialType);
		}

		if (container == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(container);
		}

		if (storageTemperature == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(storageTemperature);
		}

		objectOutput.writeLong(sampledTime);

		if (anatomicalPartOntology == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartOntology);
		}

		if (anatomicalPartOntologyVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartOntologyVersion);
		}

		if (anatomicalPartOntologyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartOntologyCode);
		}

		if (anatomicalPartOntologyDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartOntologyDescription);
		}

		if (anatomicalPartFreeText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartFreeText);
		}

		if (sex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sex);
		}

		objectOutput.writeLong(ageLow);
		objectOutput.writeLong(ageHigh);

		if (ageUnit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ageUnit);
		}

		if (diseaseOntology == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseOntology);
		}

		if (diseaseOntologyVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseOntologyVersion);
		}

		if (diseaseOntologyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseOntologyCode);
		}

		if (diseaseOntologyDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseOntologyDescription);
		}

		if (diseaseFreeText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseFreeText);
		}

		if (countryOfOrigin == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryOfOrigin);
		}
	}

	public String uuid_;
	public long sampleDbId;
	public long sampleCollectionDbId;
	public long biobankDbId;
	public String hashedSampleId;
	public String hashedIndividualId;
	public String materialType;
	public String container;
	public String storageTemperature;
	public long sampledTime;
	public String anatomicalPartOntology;
	public String anatomicalPartOntologyVersion;
	public String anatomicalPartOntologyCode;
	public String anatomicalPartOntologyDescription;
	public String anatomicalPartFreeText;
	public String sex;
	public long ageLow;
	public long ageHigh;
	public String ageUnit;
	public String diseaseOntology;
	public String diseaseOntologyVersion;
	public String diseaseOntologyCode;
	public String diseaseOntologyDescription;
	public String diseaseFreeText;
	public String countryOfOrigin;
}