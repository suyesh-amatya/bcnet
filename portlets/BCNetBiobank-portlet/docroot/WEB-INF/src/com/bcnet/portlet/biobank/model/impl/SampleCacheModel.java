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
		StringBundler sb = new StringBundler(45);

		sb.append("{sampleId=");
		sb.append(sampleId);
		sb.append(", sampleCollectionDbId=");
		sb.append(sampleCollectionDbId);
		sb.append(", biobankDbId=");
		sb.append(biobankDbId);
		sb.append(", hashedSampleId=");
		sb.append(hashedSampleId);
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
		sb.append(", anatomicalPartDescription=");
		sb.append(anatomicalPartDescription);
		sb.append(", anatomicalPartFreeText=");
		sb.append(anatomicalPartFreeText);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", ageHigh=");
		sb.append(ageHigh);
		sb.append(", ageLow=");
		sb.append(ageLow);
		sb.append(", ageUnit=");
		sb.append(ageUnit);
		sb.append(", diseaseOntology=");
		sb.append(diseaseOntology);
		sb.append(", diseaseOntologyVersion=");
		sb.append(diseaseOntologyVersion);
		sb.append(", diseaseOntologyCode=");
		sb.append(diseaseOntologyCode);
		sb.append(", diseaseDescription=");
		sb.append(diseaseDescription);
		sb.append(", diseaseFreeText=");
		sb.append(diseaseFreeText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sample toEntityModel() {
		SampleImpl sampleImpl = new SampleImpl();

		sampleImpl.setSampleId(sampleId);
		sampleImpl.setSampleCollectionDbId(sampleCollectionDbId);
		sampleImpl.setBiobankDbId(biobankDbId);

		if (hashedSampleId == null) {
			sampleImpl.setHashedSampleId(StringPool.BLANK);
		}
		else {
			sampleImpl.setHashedSampleId(hashedSampleId);
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

		if (anatomicalPartDescription == null) {
			sampleImpl.setAnatomicalPartDescription(StringPool.BLANK);
		}
		else {
			sampleImpl.setAnatomicalPartDescription(anatomicalPartDescription);
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

		sampleImpl.setAgeHigh(ageHigh);
		sampleImpl.setAgeLow(ageLow);

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

		if (diseaseDescription == null) {
			sampleImpl.setDiseaseDescription(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseDescription(diseaseDescription);
		}

		if (diseaseFreeText == null) {
			sampleImpl.setDiseaseFreeText(StringPool.BLANK);
		}
		else {
			sampleImpl.setDiseaseFreeText(diseaseFreeText);
		}

		sampleImpl.resetOriginalValues();

		return sampleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sampleId = objectInput.readLong();
		sampleCollectionDbId = objectInput.readLong();
		biobankDbId = objectInput.readLong();
		hashedSampleId = objectInput.readUTF();
		materialType = objectInput.readUTF();
		container = objectInput.readUTF();
		storageTemperature = objectInput.readUTF();
		sampledTime = objectInput.readLong();
		anatomicalPartOntology = objectInput.readUTF();
		anatomicalPartOntologyVersion = objectInput.readUTF();
		anatomicalPartOntologyCode = objectInput.readUTF();
		anatomicalPartDescription = objectInput.readUTF();
		anatomicalPartFreeText = objectInput.readUTF();
		sex = objectInput.readUTF();
		ageHigh = objectInput.readLong();
		ageLow = objectInput.readLong();
		ageUnit = objectInput.readUTF();
		diseaseOntology = objectInput.readUTF();
		diseaseOntologyVersion = objectInput.readUTF();
		diseaseOntologyCode = objectInput.readUTF();
		diseaseDescription = objectInput.readUTF();
		diseaseFreeText = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sampleId);
		objectOutput.writeLong(sampleCollectionDbId);
		objectOutput.writeLong(biobankDbId);

		if (hashedSampleId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hashedSampleId);
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

		if (anatomicalPartDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(anatomicalPartDescription);
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

		objectOutput.writeLong(ageHigh);
		objectOutput.writeLong(ageLow);

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

		if (diseaseDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseDescription);
		}

		if (diseaseFreeText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseaseFreeText);
		}
	}

	public long sampleId;
	public long sampleCollectionDbId;
	public long biobankDbId;
	public String hashedSampleId;
	public String materialType;
	public String container;
	public String storageTemperature;
	public long sampledTime;
	public String anatomicalPartOntology;
	public String anatomicalPartOntologyVersion;
	public String anatomicalPartOntologyCode;
	public String anatomicalPartDescription;
	public String anatomicalPartFreeText;
	public String sex;
	public long ageHigh;
	public long ageLow;
	public String ageUnit;
	public String diseaseOntology;
	public String diseaseOntologyVersion;
	public String diseaseOntologyCode;
	public String diseaseDescription;
	public String diseaseFreeText;
}