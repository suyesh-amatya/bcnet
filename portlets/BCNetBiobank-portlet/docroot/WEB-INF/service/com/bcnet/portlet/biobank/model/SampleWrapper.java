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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Sample}.
 * </p>
 *
 * @author suyama
 * @see Sample
 * @generated
 */
public class SampleWrapper implements Sample, ModelWrapper<Sample> {
	public SampleWrapper(Sample sample) {
		_sample = sample;
	}

	@Override
	public Class<?> getModelClass() {
		return Sample.class;
	}

	@Override
	public String getModelClassName() {
		return Sample.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleId", getSampleId());
		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("hashedSampleId", getHashedSampleId());
		attributes.put("materialType", getMaterialType());
		attributes.put("container", getContainer());
		attributes.put("storageTemperature", getStorageTemperature());
		attributes.put("sampledTime", getSampledTime());
		attributes.put("anatomicalPartOntology", getAnatomicalPartOntology());
		attributes.put("anatomicalPartOntologyVersion",
			getAnatomicalPartOntologyVersion());
		attributes.put("anatomicalPartOntologyCode",
			getAnatomicalPartOntologyCode());
		attributes.put("anatomicalPartDescription",
			getAnatomicalPartDescription());
		attributes.put("anatomicalPartFreeText", getAnatomicalPartFreeText());
		attributes.put("sex", getSex());
		attributes.put("ageHigh", getAgeHigh());
		attributes.put("ageLow", getAgeLow());
		attributes.put("ageUnit", getAgeUnit());
		attributes.put("diseaseOntology", getDiseaseOntology());
		attributes.put("diseaseOntologyVersion", getDiseaseOntologyVersion());
		attributes.put("diseaseOntologyCode", getDiseaseOntologyCode());
		attributes.put("diseaseDescription", getDiseaseDescription());
		attributes.put("diseaseFreeText", getDiseaseFreeText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleId = (Long)attributes.get("sampleId");

		if (sampleId != null) {
			setSampleId(sampleId);
		}

		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String hashedSampleId = (String)attributes.get("hashedSampleId");

		if (hashedSampleId != null) {
			setHashedSampleId(hashedSampleId);
		}

		String materialType = (String)attributes.get("materialType");

		if (materialType != null) {
			setMaterialType(materialType);
		}

		String container = (String)attributes.get("container");

		if (container != null) {
			setContainer(container);
		}

		String storageTemperature = (String)attributes.get("storageTemperature");

		if (storageTemperature != null) {
			setStorageTemperature(storageTemperature);
		}

		String sampledTime = (String)attributes.get("sampledTime");

		if (sampledTime != null) {
			setSampledTime(sampledTime);
		}

		String anatomicalPartOntology = (String)attributes.get(
				"anatomicalPartOntology");

		if (anatomicalPartOntology != null) {
			setAnatomicalPartOntology(anatomicalPartOntology);
		}

		String anatomicalPartOntologyVersion = (String)attributes.get(
				"anatomicalPartOntologyVersion");

		if (anatomicalPartOntologyVersion != null) {
			setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);
		}

		String anatomicalPartOntologyCode = (String)attributes.get(
				"anatomicalPartOntologyCode");

		if (anatomicalPartOntologyCode != null) {
			setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);
		}

		String anatomicalPartDescription = (String)attributes.get(
				"anatomicalPartDescription");

		if (anatomicalPartDescription != null) {
			setAnatomicalPartDescription(anatomicalPartDescription);
		}

		String anatomicalPartFreeText = (String)attributes.get(
				"anatomicalPartFreeText");

		if (anatomicalPartFreeText != null) {
			setAnatomicalPartFreeText(anatomicalPartFreeText);
		}

		String sex = (String)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		Long ageHigh = (Long)attributes.get("ageHigh");

		if (ageHigh != null) {
			setAgeHigh(ageHigh);
		}

		Long ageLow = (Long)attributes.get("ageLow");

		if (ageLow != null) {
			setAgeLow(ageLow);
		}

		String ageUnit = (String)attributes.get("ageUnit");

		if (ageUnit != null) {
			setAgeUnit(ageUnit);
		}

		String diseaseOntology = (String)attributes.get("diseaseOntology");

		if (diseaseOntology != null) {
			setDiseaseOntology(diseaseOntology);
		}

		String diseaseOntologyVersion = (String)attributes.get(
				"diseaseOntologyVersion");

		if (diseaseOntologyVersion != null) {
			setDiseaseOntologyVersion(diseaseOntologyVersion);
		}

		String diseaseOntologyCode = (String)attributes.get(
				"diseaseOntologyCode");

		if (diseaseOntologyCode != null) {
			setDiseaseOntologyCode(diseaseOntologyCode);
		}

		String diseaseDescription = (String)attributes.get("diseaseDescription");

		if (diseaseDescription != null) {
			setDiseaseDescription(diseaseDescription);
		}

		String diseaseFreeText = (String)attributes.get("diseaseFreeText");

		if (diseaseFreeText != null) {
			setDiseaseFreeText(diseaseFreeText);
		}
	}

	/**
	* Returns the primary key of this sample.
	*
	* @return the primary key of this sample
	*/
	@Override
	public long getPrimaryKey() {
		return _sample.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample.
	*
	* @param primaryKey the primary key of this sample
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sample.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample ID of this sample.
	*
	* @return the sample ID of this sample
	*/
	@Override
	public long getSampleId() {
		return _sample.getSampleId();
	}

	/**
	* Sets the sample ID of this sample.
	*
	* @param sampleId the sample ID of this sample
	*/
	@Override
	public void setSampleId(long sampleId) {
		_sample.setSampleId(sampleId);
	}

	/**
	* Returns the sample collection db ID of this sample.
	*
	* @return the sample collection db ID of this sample
	*/
	@Override
	public long getSampleCollectionDbId() {
		return _sample.getSampleCollectionDbId();
	}

	/**
	* Sets the sample collection db ID of this sample.
	*
	* @param sampleCollectionDbId the sample collection db ID of this sample
	*/
	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sample.setSampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the biobank db ID of this sample.
	*
	* @return the biobank db ID of this sample
	*/
	@Override
	public long getBiobankDbId() {
		return _sample.getBiobankDbId();
	}

	/**
	* Sets the biobank db ID of this sample.
	*
	* @param biobankDbId the biobank db ID of this sample
	*/
	@Override
	public void setBiobankDbId(long biobankDbId) {
		_sample.setBiobankDbId(biobankDbId);
	}

	/**
	* Returns the hashed sample ID of this sample.
	*
	* @return the hashed sample ID of this sample
	*/
	@Override
	public java.lang.String getHashedSampleId() {
		return _sample.getHashedSampleId();
	}

	/**
	* Sets the hashed sample ID of this sample.
	*
	* @param hashedSampleId the hashed sample ID of this sample
	*/
	@Override
	public void setHashedSampleId(java.lang.String hashedSampleId) {
		_sample.setHashedSampleId(hashedSampleId);
	}

	/**
	* Returns the material type of this sample.
	*
	* @return the material type of this sample
	*/
	@Override
	public java.lang.String getMaterialType() {
		return _sample.getMaterialType();
	}

	/**
	* Sets the material type of this sample.
	*
	* @param materialType the material type of this sample
	*/
	@Override
	public void setMaterialType(java.lang.String materialType) {
		_sample.setMaterialType(materialType);
	}

	/**
	* Returns the container of this sample.
	*
	* @return the container of this sample
	*/
	@Override
	public java.lang.String getContainer() {
		return _sample.getContainer();
	}

	/**
	* Sets the container of this sample.
	*
	* @param container the container of this sample
	*/
	@Override
	public void setContainer(java.lang.String container) {
		_sample.setContainer(container);
	}

	/**
	* Returns the storage temperature of this sample.
	*
	* @return the storage temperature of this sample
	*/
	@Override
	public java.lang.String getStorageTemperature() {
		return _sample.getStorageTemperature();
	}

	/**
	* Sets the storage temperature of this sample.
	*
	* @param storageTemperature the storage temperature of this sample
	*/
	@Override
	public void setStorageTemperature(java.lang.String storageTemperature) {
		_sample.setStorageTemperature(storageTemperature);
	}

	/**
	* Returns the sampled time of this sample.
	*
	* @return the sampled time of this sample
	*/
	@Override
	public java.lang.String getSampledTime() {
		return _sample.getSampledTime();
	}

	/**
	* Sets the sampled time of this sample.
	*
	* @param sampledTime the sampled time of this sample
	*/
	@Override
	public void setSampledTime(java.lang.String sampledTime) {
		_sample.setSampledTime(sampledTime);
	}

	/**
	* Returns the anatomical part ontology of this sample.
	*
	* @return the anatomical part ontology of this sample
	*/
	@Override
	public java.lang.String getAnatomicalPartOntology() {
		return _sample.getAnatomicalPartOntology();
	}

	/**
	* Sets the anatomical part ontology of this sample.
	*
	* @param anatomicalPartOntology the anatomical part ontology of this sample
	*/
	@Override
	public void setAnatomicalPartOntology(
		java.lang.String anatomicalPartOntology) {
		_sample.setAnatomicalPartOntology(anatomicalPartOntology);
	}

	/**
	* Returns the anatomical part ontology version of this sample.
	*
	* @return the anatomical part ontology version of this sample
	*/
	@Override
	public java.lang.String getAnatomicalPartOntologyVersion() {
		return _sample.getAnatomicalPartOntologyVersion();
	}

	/**
	* Sets the anatomical part ontology version of this sample.
	*
	* @param anatomicalPartOntologyVersion the anatomical part ontology version of this sample
	*/
	@Override
	public void setAnatomicalPartOntologyVersion(
		java.lang.String anatomicalPartOntologyVersion) {
		_sample.setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);
	}

	/**
	* Returns the anatomical part ontology code of this sample.
	*
	* @return the anatomical part ontology code of this sample
	*/
	@Override
	public java.lang.String getAnatomicalPartOntologyCode() {
		return _sample.getAnatomicalPartOntologyCode();
	}

	/**
	* Sets the anatomical part ontology code of this sample.
	*
	* @param anatomicalPartOntologyCode the anatomical part ontology code of this sample
	*/
	@Override
	public void setAnatomicalPartOntologyCode(
		java.lang.String anatomicalPartOntologyCode) {
		_sample.setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);
	}

	/**
	* Returns the anatomical part description of this sample.
	*
	* @return the anatomical part description of this sample
	*/
	@Override
	public java.lang.String getAnatomicalPartDescription() {
		return _sample.getAnatomicalPartDescription();
	}

	/**
	* Sets the anatomical part description of this sample.
	*
	* @param anatomicalPartDescription the anatomical part description of this sample
	*/
	@Override
	public void setAnatomicalPartDescription(
		java.lang.String anatomicalPartDescription) {
		_sample.setAnatomicalPartDescription(anatomicalPartDescription);
	}

	/**
	* Returns the anatomical part free text of this sample.
	*
	* @return the anatomical part free text of this sample
	*/
	@Override
	public java.lang.String getAnatomicalPartFreeText() {
		return _sample.getAnatomicalPartFreeText();
	}

	/**
	* Sets the anatomical part free text of this sample.
	*
	* @param anatomicalPartFreeText the anatomical part free text of this sample
	*/
	@Override
	public void setAnatomicalPartFreeText(
		java.lang.String anatomicalPartFreeText) {
		_sample.setAnatomicalPartFreeText(anatomicalPartFreeText);
	}

	/**
	* Returns the sex of this sample.
	*
	* @return the sex of this sample
	*/
	@Override
	public java.lang.String getSex() {
		return _sample.getSex();
	}

	/**
	* Sets the sex of this sample.
	*
	* @param sex the sex of this sample
	*/
	@Override
	public void setSex(java.lang.String sex) {
		_sample.setSex(sex);
	}

	/**
	* Returns the age high of this sample.
	*
	* @return the age high of this sample
	*/
	@Override
	public long getAgeHigh() {
		return _sample.getAgeHigh();
	}

	/**
	* Sets the age high of this sample.
	*
	* @param ageHigh the age high of this sample
	*/
	@Override
	public void setAgeHigh(long ageHigh) {
		_sample.setAgeHigh(ageHigh);
	}

	/**
	* Returns the age low of this sample.
	*
	* @return the age low of this sample
	*/
	@Override
	public long getAgeLow() {
		return _sample.getAgeLow();
	}

	/**
	* Sets the age low of this sample.
	*
	* @param ageLow the age low of this sample
	*/
	@Override
	public void setAgeLow(long ageLow) {
		_sample.setAgeLow(ageLow);
	}

	/**
	* Returns the age unit of this sample.
	*
	* @return the age unit of this sample
	*/
	@Override
	public java.lang.String getAgeUnit() {
		return _sample.getAgeUnit();
	}

	/**
	* Sets the age unit of this sample.
	*
	* @param ageUnit the age unit of this sample
	*/
	@Override
	public void setAgeUnit(java.lang.String ageUnit) {
		_sample.setAgeUnit(ageUnit);
	}

	/**
	* Returns the disease ontology of this sample.
	*
	* @return the disease ontology of this sample
	*/
	@Override
	public java.lang.String getDiseaseOntology() {
		return _sample.getDiseaseOntology();
	}

	/**
	* Sets the disease ontology of this sample.
	*
	* @param diseaseOntology the disease ontology of this sample
	*/
	@Override
	public void setDiseaseOntology(java.lang.String diseaseOntology) {
		_sample.setDiseaseOntology(diseaseOntology);
	}

	/**
	* Returns the disease ontology version of this sample.
	*
	* @return the disease ontology version of this sample
	*/
	@Override
	public java.lang.String getDiseaseOntologyVersion() {
		return _sample.getDiseaseOntologyVersion();
	}

	/**
	* Sets the disease ontology version of this sample.
	*
	* @param diseaseOntologyVersion the disease ontology version of this sample
	*/
	@Override
	public void setDiseaseOntologyVersion(
		java.lang.String diseaseOntologyVersion) {
		_sample.setDiseaseOntologyVersion(diseaseOntologyVersion);
	}

	/**
	* Returns the disease ontology code of this sample.
	*
	* @return the disease ontology code of this sample
	*/
	@Override
	public java.lang.String getDiseaseOntologyCode() {
		return _sample.getDiseaseOntologyCode();
	}

	/**
	* Sets the disease ontology code of this sample.
	*
	* @param diseaseOntologyCode the disease ontology code of this sample
	*/
	@Override
	public void setDiseaseOntologyCode(java.lang.String diseaseOntologyCode) {
		_sample.setDiseaseOntologyCode(diseaseOntologyCode);
	}

	/**
	* Returns the disease description of this sample.
	*
	* @return the disease description of this sample
	*/
	@Override
	public java.lang.String getDiseaseDescription() {
		return _sample.getDiseaseDescription();
	}

	/**
	* Sets the disease description of this sample.
	*
	* @param diseaseDescription the disease description of this sample
	*/
	@Override
	public void setDiseaseDescription(java.lang.String diseaseDescription) {
		_sample.setDiseaseDescription(diseaseDescription);
	}

	/**
	* Returns the disease free text of this sample.
	*
	* @return the disease free text of this sample
	*/
	@Override
	public java.lang.String getDiseaseFreeText() {
		return _sample.getDiseaseFreeText();
	}

	/**
	* Sets the disease free text of this sample.
	*
	* @param diseaseFreeText the disease free text of this sample
	*/
	@Override
	public void setDiseaseFreeText(java.lang.String diseaseFreeText) {
		_sample.setDiseaseFreeText(diseaseFreeText);
	}

	@Override
	public boolean isNew() {
		return _sample.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sample.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sample.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sample.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sample.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sample.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sample.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sample.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sample.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sample.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sample.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleWrapper((Sample)_sample.clone());
	}

	@Override
	public int compareTo(com.bcnet.portlet.biobank.model.Sample sample) {
		return _sample.compareTo(sample);
	}

	@Override
	public int hashCode() {
		return _sample.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.Sample> toCacheModel() {
		return _sample.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.Sample toEscapedModel() {
		return new SampleWrapper(_sample.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.Sample toUnescapedModel() {
		return new SampleWrapper(_sample.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sample.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sample.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sample.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleWrapper)) {
			return false;
		}

		SampleWrapper sampleWrapper = (SampleWrapper)obj;

		if (Validator.equals(_sample, sampleWrapper._sample)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Sample getWrappedSample() {
		return _sample;
	}

	@Override
	public Sample getWrappedModel() {
		return _sample;
	}

	@Override
	public void resetOriginalValues() {
		_sample.resetOriginalValues();
	}

	private Sample _sample;
}