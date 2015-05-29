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

package com.bcnet.portlet.biobank.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleServiceSoap
 * @generated
 */
public class SampleSoap implements Serializable {
	public static SampleSoap toSoapModel(Sample model) {
		SampleSoap soapModel = new SampleSoap();

		soapModel.setSampleId(model.getSampleId());
		soapModel.setSampleCollectionDbId(model.getSampleCollectionDbId());
		soapModel.setBiobankDbId(model.getBiobankDbId());
		soapModel.setHashedSampleId(model.getHashedSampleId());
		soapModel.setMaterialType(model.getMaterialType());
		soapModel.setContainer(model.getContainer());
		soapModel.setStorageTemperature(model.getStorageTemperature());
		soapModel.setSampledTime(model.getSampledTime());
		soapModel.setAnatomicalPartOntology(model.getAnatomicalPartOntology());
		soapModel.setAnatomicalPartOntologyVersion(model.getAnatomicalPartOntologyVersion());
		soapModel.setAnatomicalPartOntologyCode(model.getAnatomicalPartOntologyCode());
		soapModel.setAnatomicalPartDescription(model.getAnatomicalPartDescription());
		soapModel.setAnatomicalPartFreeText(model.getAnatomicalPartFreeText());
		soapModel.setSex(model.getSex());
		soapModel.setAgeHigh(model.getAgeHigh());
		soapModel.setAgeLow(model.getAgeLow());
		soapModel.setAgeUnit(model.getAgeUnit());
		soapModel.setDiseaseOntology(model.getDiseaseOntology());
		soapModel.setDiseaseOntologyVersion(model.getDiseaseOntologyVersion());
		soapModel.setDiseaseOntologyCode(model.getDiseaseOntologyCode());
		soapModel.setDiseaseDescription(model.getDiseaseDescription());
		soapModel.setDiseaseFreeText(model.getDiseaseFreeText());

		return soapModel;
	}

	public static SampleSoap[] toSoapModels(Sample[] models) {
		SampleSoap[] soapModels = new SampleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleSoap[][] toSoapModels(Sample[][] models) {
		SampleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleSoap[] toSoapModels(List<Sample> models) {
		List<SampleSoap> soapModels = new ArrayList<SampleSoap>(models.size());

		for (Sample model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleSoap[soapModels.size()]);
	}

	public SampleSoap() {
	}

	public long getPrimaryKey() {
		return _sampleId;
	}

	public void setPrimaryKey(long pk) {
		setSampleId(pk);
	}

	public long getSampleId() {
		return _sampleId;
	}

	public void setSampleId(long sampleId) {
		_sampleId = sampleId;
	}

	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;
	}

	public long getBiobankDbId() {
		return _biobankDbId;
	}

	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;
	}

	public String getHashedSampleId() {
		return _hashedSampleId;
	}

	public void setHashedSampleId(String hashedSampleId) {
		_hashedSampleId = hashedSampleId;
	}

	public String getMaterialType() {
		return _materialType;
	}

	public void setMaterialType(String materialType) {
		_materialType = materialType;
	}

	public String getContainer() {
		return _container;
	}

	public void setContainer(String container) {
		_container = container;
	}

	public String getStorageTemperature() {
		return _storageTemperature;
	}

	public void setStorageTemperature(String storageTemperature) {
		_storageTemperature = storageTemperature;
	}

	public String getSampledTime() {
		return _sampledTime;
	}

	public void setSampledTime(String sampledTime) {
		_sampledTime = sampledTime;
	}

	public String getAnatomicalPartOntology() {
		return _anatomicalPartOntology;
	}

	public void setAnatomicalPartOntology(String anatomicalPartOntology) {
		_anatomicalPartOntology = anatomicalPartOntology;
	}

	public String getAnatomicalPartOntologyVersion() {
		return _anatomicalPartOntologyVersion;
	}

	public void setAnatomicalPartOntologyVersion(
		String anatomicalPartOntologyVersion) {
		_anatomicalPartOntologyVersion = anatomicalPartOntologyVersion;
	}

	public String getAnatomicalPartOntologyCode() {
		return _anatomicalPartOntologyCode;
	}

	public void setAnatomicalPartOntologyCode(String anatomicalPartOntologyCode) {
		_anatomicalPartOntologyCode = anatomicalPartOntologyCode;
	}

	public String getAnatomicalPartDescription() {
		return _anatomicalPartDescription;
	}

	public void setAnatomicalPartDescription(String anatomicalPartDescription) {
		_anatomicalPartDescription = anatomicalPartDescription;
	}

	public String getAnatomicalPartFreeText() {
		return _anatomicalPartFreeText;
	}

	public void setAnatomicalPartFreeText(String anatomicalPartFreeText) {
		_anatomicalPartFreeText = anatomicalPartFreeText;
	}

	public String getSex() {
		return _sex;
	}

	public void setSex(String sex) {
		_sex = sex;
	}

	public long getAgeHigh() {
		return _ageHigh;
	}

	public void setAgeHigh(long ageHigh) {
		_ageHigh = ageHigh;
	}

	public long getAgeLow() {
		return _ageLow;
	}

	public void setAgeLow(long ageLow) {
		_ageLow = ageLow;
	}

	public String getAgeUnit() {
		return _ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		_ageUnit = ageUnit;
	}

	public String getDiseaseOntology() {
		return _diseaseOntology;
	}

	public void setDiseaseOntology(String diseaseOntology) {
		_diseaseOntology = diseaseOntology;
	}

	public String getDiseaseOntologyVersion() {
		return _diseaseOntologyVersion;
	}

	public void setDiseaseOntologyVersion(String diseaseOntologyVersion) {
		_diseaseOntologyVersion = diseaseOntologyVersion;
	}

	public String getDiseaseOntologyCode() {
		return _diseaseOntologyCode;
	}

	public void setDiseaseOntologyCode(String diseaseOntologyCode) {
		_diseaseOntologyCode = diseaseOntologyCode;
	}

	public String getDiseaseDescription() {
		return _diseaseDescription;
	}

	public void setDiseaseDescription(String diseaseDescription) {
		_diseaseDescription = diseaseDescription;
	}

	public String getDiseaseFreeText() {
		return _diseaseFreeText;
	}

	public void setDiseaseFreeText(String diseaseFreeText) {
		_diseaseFreeText = diseaseFreeText;
	}

	private long _sampleId;
	private long _sampleCollectionDbId;
	private long _biobankDbId;
	private String _hashedSampleId;
	private String _materialType;
	private String _container;
	private String _storageTemperature;
	private String _sampledTime;
	private String _anatomicalPartOntology;
	private String _anatomicalPartOntologyVersion;
	private String _anatomicalPartOntologyCode;
	private String _anatomicalPartDescription;
	private String _anatomicalPartFreeText;
	private String _sex;
	private long _ageHigh;
	private long _ageLow;
	private String _ageUnit;
	private String _diseaseOntology;
	private String _diseaseOntologyVersion;
	private String _diseaseOntologyCode;
	private String _diseaseDescription;
	private String _diseaseFreeText;
}