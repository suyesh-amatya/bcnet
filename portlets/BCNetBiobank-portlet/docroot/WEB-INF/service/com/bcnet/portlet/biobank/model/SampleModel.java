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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Sample service. Represents a row in the &quot;sample&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bcnet.portlet.biobank.model.impl.SampleImpl}.
 * </p>
 *
 * @author suyama
 * @see Sample
 * @see com.bcnet.portlet.biobank.model.impl.SampleImpl
 * @see com.bcnet.portlet.biobank.model.impl.SampleModelImpl
 * @generated
 */
public interface SampleModel extends BaseModel<Sample> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sample model instance should use the {@link Sample} interface instead.
	 */

	/**
	 * Returns the primary key of this sample.
	 *
	 * @return the primary key of this sample
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sample.
	 *
	 * @param primaryKey the primary key of this sample
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid_ of this sample.
	 *
	 * @return the uuid_ of this sample
	 */
	@AutoEscape
	public String getUuid_();

	/**
	 * Sets the uuid_ of this sample.
	 *
	 * @param uuid_ the uuid_ of this sample
	 */
	public void setUuid_(String uuid_);

	/**
	 * Returns the sample db ID of this sample.
	 *
	 * @return the sample db ID of this sample
	 */
	public long getSampleDbId();

	/**
	 * Sets the sample db ID of this sample.
	 *
	 * @param sampleDbId the sample db ID of this sample
	 */
	public void setSampleDbId(long sampleDbId);

	/**
	 * Returns the sample collection ID of this sample.
	 *
	 * @return the sample collection ID of this sample
	 */
	@AutoEscape
	public String getSampleCollectionId();

	/**
	 * Sets the sample collection ID of this sample.
	 *
	 * @param sampleCollectionId the sample collection ID of this sample
	 */
	public void setSampleCollectionId(String sampleCollectionId);

	/**
	 * Returns the biobank ID of this sample.
	 *
	 * @return the biobank ID of this sample
	 */
	@AutoEscape
	public String getBiobankId();

	/**
	 * Sets the biobank ID of this sample.
	 *
	 * @param biobankId the biobank ID of this sample
	 */
	public void setBiobankId(String biobankId);

	/**
	 * Returns the hashed sample ID of this sample.
	 *
	 * @return the hashed sample ID of this sample
	 */
	@AutoEscape
	public String getHashedSampleId();

	/**
	 * Sets the hashed sample ID of this sample.
	 *
	 * @param hashedSampleId the hashed sample ID of this sample
	 */
	public void setHashedSampleId(String hashedSampleId);

	/**
	 * Returns the hashed individual ID of this sample.
	 *
	 * @return the hashed individual ID of this sample
	 */
	@AutoEscape
	public String getHashedIndividualId();

	/**
	 * Sets the hashed individual ID of this sample.
	 *
	 * @param hashedIndividualId the hashed individual ID of this sample
	 */
	public void setHashedIndividualId(String hashedIndividualId);

	/**
	 * Returns the material type of this sample.
	 *
	 * @return the material type of this sample
	 */
	@AutoEscape
	public String getMaterialType();

	/**
	 * Sets the material type of this sample.
	 *
	 * @param materialType the material type of this sample
	 */
	public void setMaterialType(String materialType);

	/**
	 * Returns the container of this sample.
	 *
	 * @return the container of this sample
	 */
	@AutoEscape
	public String getContainer();

	/**
	 * Sets the container of this sample.
	 *
	 * @param container the container of this sample
	 */
	public void setContainer(String container);

	/**
	 * Returns the storage temperature of this sample.
	 *
	 * @return the storage temperature of this sample
	 */
	@AutoEscape
	public String getStorageTemperature();

	/**
	 * Sets the storage temperature of this sample.
	 *
	 * @param storageTemperature the storage temperature of this sample
	 */
	public void setStorageTemperature(String storageTemperature);

	/**
	 * Returns the sampled time of this sample.
	 *
	 * @return the sampled time of this sample
	 */
	public Date getSampledTime();

	/**
	 * Sets the sampled time of this sample.
	 *
	 * @param sampledTime the sampled time of this sample
	 */
	public void setSampledTime(Date sampledTime);

	/**
	 * Returns the anatomical part ontology of this sample.
	 *
	 * @return the anatomical part ontology of this sample
	 */
	@AutoEscape
	public String getAnatomicalPartOntology();

	/**
	 * Sets the anatomical part ontology of this sample.
	 *
	 * @param anatomicalPartOntology the anatomical part ontology of this sample
	 */
	public void setAnatomicalPartOntology(String anatomicalPartOntology);

	/**
	 * Returns the anatomical part ontology version of this sample.
	 *
	 * @return the anatomical part ontology version of this sample
	 */
	@AutoEscape
	public String getAnatomicalPartOntologyVersion();

	/**
	 * Sets the anatomical part ontology version of this sample.
	 *
	 * @param anatomicalPartOntologyVersion the anatomical part ontology version of this sample
	 */
	public void setAnatomicalPartOntologyVersion(
		String anatomicalPartOntologyVersion);

	/**
	 * Returns the anatomical part ontology code of this sample.
	 *
	 * @return the anatomical part ontology code of this sample
	 */
	@AutoEscape
	public String getAnatomicalPartOntologyCode();

	/**
	 * Sets the anatomical part ontology code of this sample.
	 *
	 * @param anatomicalPartOntologyCode the anatomical part ontology code of this sample
	 */
	public void setAnatomicalPartOntologyCode(String anatomicalPartOntologyCode);

	/**
	 * Returns the anatomical part ontology description of this sample.
	 *
	 * @return the anatomical part ontology description of this sample
	 */
	@AutoEscape
	public String getAnatomicalPartOntologyDescription();

	/**
	 * Sets the anatomical part ontology description of this sample.
	 *
	 * @param anatomicalPartOntologyDescription the anatomical part ontology description of this sample
	 */
	public void setAnatomicalPartOntologyDescription(
		String anatomicalPartOntologyDescription);

	/**
	 * Returns the anatomical part free text of this sample.
	 *
	 * @return the anatomical part free text of this sample
	 */
	@AutoEscape
	public String getAnatomicalPartFreeText();

	/**
	 * Sets the anatomical part free text of this sample.
	 *
	 * @param anatomicalPartFreeText the anatomical part free text of this sample
	 */
	public void setAnatomicalPartFreeText(String anatomicalPartFreeText);

	/**
	 * Returns the sex of this sample.
	 *
	 * @return the sex of this sample
	 */
	@AutoEscape
	public String getSex();

	/**
	 * Sets the sex of this sample.
	 *
	 * @param sex the sex of this sample
	 */
	public void setSex(String sex);

	/**
	 * Returns the age high of this sample.
	 *
	 * @return the age high of this sample
	 */
	public long getAgeHigh();

	/**
	 * Sets the age high of this sample.
	 *
	 * @param ageHigh the age high of this sample
	 */
	public void setAgeHigh(long ageHigh);

	/**
	 * Returns the age low of this sample.
	 *
	 * @return the age low of this sample
	 */
	public long getAgeLow();

	/**
	 * Sets the age low of this sample.
	 *
	 * @param ageLow the age low of this sample
	 */
	public void setAgeLow(long ageLow);

	/**
	 * Returns the age unit of this sample.
	 *
	 * @return the age unit of this sample
	 */
	@AutoEscape
	public String getAgeUnit();

	/**
	 * Sets the age unit of this sample.
	 *
	 * @param ageUnit the age unit of this sample
	 */
	public void setAgeUnit(String ageUnit);

	/**
	 * Returns the disease ontology of this sample.
	 *
	 * @return the disease ontology of this sample
	 */
	@AutoEscape
	public String getDiseaseOntology();

	/**
	 * Sets the disease ontology of this sample.
	 *
	 * @param diseaseOntology the disease ontology of this sample
	 */
	public void setDiseaseOntology(String diseaseOntology);

	/**
	 * Returns the disease ontology version of this sample.
	 *
	 * @return the disease ontology version of this sample
	 */
	@AutoEscape
	public String getDiseaseOntologyVersion();

	/**
	 * Sets the disease ontology version of this sample.
	 *
	 * @param diseaseOntologyVersion the disease ontology version of this sample
	 */
	public void setDiseaseOntologyVersion(String diseaseOntologyVersion);

	/**
	 * Returns the disease ontology code of this sample.
	 *
	 * @return the disease ontology code of this sample
	 */
	@AutoEscape
	public String getDiseaseOntologyCode();

	/**
	 * Sets the disease ontology code of this sample.
	 *
	 * @param diseaseOntologyCode the disease ontology code of this sample
	 */
	public void setDiseaseOntologyCode(String diseaseOntologyCode);

	/**
	 * Returns the disease ontology description of this sample.
	 *
	 * @return the disease ontology description of this sample
	 */
	@AutoEscape
	public String getDiseaseOntologyDescription();

	/**
	 * Sets the disease ontology description of this sample.
	 *
	 * @param diseaseOntologyDescription the disease ontology description of this sample
	 */
	public void setDiseaseOntologyDescription(String diseaseOntologyDescription);

	/**
	 * Returns the disease free text of this sample.
	 *
	 * @return the disease free text of this sample
	 */
	@AutoEscape
	public String getDiseaseFreeText();

	/**
	 * Sets the disease free text of this sample.
	 *
	 * @param diseaseFreeText the disease free text of this sample
	 */
	public void setDiseaseFreeText(String diseaseFreeText);

	/**
	 * Returns the country of origin of this sample.
	 *
	 * @return the country of origin of this sample
	 */
	@AutoEscape
	public String getCountryOfOrigin();

	/**
	 * Sets the country of origin of this sample.
	 *
	 * @param countryOfOrigin the country of origin of this sample
	 */
	public void setCountryOfOrigin(String countryOfOrigin);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.bcnet.portlet.biobank.model.Sample sample);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.bcnet.portlet.biobank.model.Sample> toCacheModel();

	@Override
	public com.bcnet.portlet.biobank.model.Sample toEscapedModel();

	@Override
	public com.bcnet.portlet.biobank.model.Sample toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}