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
 * This class is a wrapper for {@link SampleCollection}.
 * </p>
 *
 * @author suyama
 * @see SampleCollection
 * @generated
 */
public class SampleCollectionWrapper implements SampleCollection,
	ModelWrapper<SampleCollection> {
	public SampleCollectionWrapper(SampleCollection sampleCollection) {
		_sampleCollection = sampleCollection;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollection.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("sampleCollectionId", getSampleCollectionId());
		attributes.put("acronym", getAcronym());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("consentTemplate", getConsentTemplate());
		attributes.put("reuseOfSamples", getReuseOfSamples());
		attributes.put("materialTransferAgreement",
			getMaterialTransferAgreement());
		attributes.put("accreditation", getAccreditation());
		attributes.put("qualityControl", getQualityControl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		String sampleCollectionId = (String)attributes.get("sampleCollectionId");

		if (sampleCollectionId != null) {
			setSampleCollectionId(sampleCollectionId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean consentTemplate = (Boolean)attributes.get("consentTemplate");

		if (consentTemplate != null) {
			setConsentTemplate(consentTemplate);
		}

		Boolean reuseOfSamples = (Boolean)attributes.get("reuseOfSamples");

		if (reuseOfSamples != null) {
			setReuseOfSamples(reuseOfSamples);
		}

		Boolean materialTransferAgreement = (Boolean)attributes.get(
				"materialTransferAgreement");

		if (materialTransferAgreement != null) {
			setMaterialTransferAgreement(materialTransferAgreement);
		}

		Boolean accreditation = (Boolean)attributes.get("accreditation");

		if (accreditation != null) {
			setAccreditation(accreditation);
		}

		Boolean qualityControl = (Boolean)attributes.get("qualityControl");

		if (qualityControl != null) {
			setQualityControl(qualityControl);
		}
	}

	/**
	* Returns the primary key of this sample collection.
	*
	* @return the primary key of this sample collection
	*/
	@Override
	public long getPrimaryKey() {
		return _sampleCollection.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample collection.
	*
	* @param primaryKey the primary key of this sample collection
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sampleCollection.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample collection db ID of this sample collection.
	*
	* @return the sample collection db ID of this sample collection
	*/
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollection.getSampleCollectionDbId();
	}

	/**
	* Sets the sample collection db ID of this sample collection.
	*
	* @param sampleCollectionDbId the sample collection db ID of this sample collection
	*/
	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollection.setSampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the sample collection ID of this sample collection.
	*
	* @return the sample collection ID of this sample collection
	*/
	@Override
	public java.lang.String getSampleCollectionId() {
		return _sampleCollection.getSampleCollectionId();
	}

	/**
	* Sets the sample collection ID of this sample collection.
	*
	* @param sampleCollectionId the sample collection ID of this sample collection
	*/
	@Override
	public void setSampleCollectionId(java.lang.String sampleCollectionId) {
		_sampleCollection.setSampleCollectionId(sampleCollectionId);
	}

	/**
	* Returns the acronym of this sample collection.
	*
	* @return the acronym of this sample collection
	*/
	@Override
	public java.lang.String getAcronym() {
		return _sampleCollection.getAcronym();
	}

	/**
	* Sets the acronym of this sample collection.
	*
	* @param acronym the acronym of this sample collection
	*/
	@Override
	public void setAcronym(java.lang.String acronym) {
		_sampleCollection.setAcronym(acronym);
	}

	/**
	* Returns the name of this sample collection.
	*
	* @return the name of this sample collection
	*/
	@Override
	public java.lang.String getName() {
		return _sampleCollection.getName();
	}

	/**
	* Sets the name of this sample collection.
	*
	* @param name the name of this sample collection
	*/
	@Override
	public void setName(java.lang.String name) {
		_sampleCollection.setName(name);
	}

	/**
	* Returns the description of this sample collection.
	*
	* @return the description of this sample collection
	*/
	@Override
	public java.lang.String getDescription() {
		return _sampleCollection.getDescription();
	}

	/**
	* Sets the description of this sample collection.
	*
	* @param description the description of this sample collection
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_sampleCollection.setDescription(description);
	}

	/**
	* Returns the consent template of this sample collection.
	*
	* @return the consent template of this sample collection
	*/
	@Override
	public boolean getConsentTemplate() {
		return _sampleCollection.getConsentTemplate();
	}

	/**
	* Returns <code>true</code> if this sample collection is consent template.
	*
	* @return <code>true</code> if this sample collection is consent template; <code>false</code> otherwise
	*/
	@Override
	public boolean isConsentTemplate() {
		return _sampleCollection.isConsentTemplate();
	}

	/**
	* Sets whether this sample collection is consent template.
	*
	* @param consentTemplate the consent template of this sample collection
	*/
	@Override
	public void setConsentTemplate(boolean consentTemplate) {
		_sampleCollection.setConsentTemplate(consentTemplate);
	}

	/**
	* Returns the reuse of samples of this sample collection.
	*
	* @return the reuse of samples of this sample collection
	*/
	@Override
	public boolean getReuseOfSamples() {
		return _sampleCollection.getReuseOfSamples();
	}

	/**
	* Returns <code>true</code> if this sample collection is reuse of samples.
	*
	* @return <code>true</code> if this sample collection is reuse of samples; <code>false</code> otherwise
	*/
	@Override
	public boolean isReuseOfSamples() {
		return _sampleCollection.isReuseOfSamples();
	}

	/**
	* Sets whether this sample collection is reuse of samples.
	*
	* @param reuseOfSamples the reuse of samples of this sample collection
	*/
	@Override
	public void setReuseOfSamples(boolean reuseOfSamples) {
		_sampleCollection.setReuseOfSamples(reuseOfSamples);
	}

	/**
	* Returns the material transfer agreement of this sample collection.
	*
	* @return the material transfer agreement of this sample collection
	*/
	@Override
	public boolean getMaterialTransferAgreement() {
		return _sampleCollection.getMaterialTransferAgreement();
	}

	/**
	* Returns <code>true</code> if this sample collection is material transfer agreement.
	*
	* @return <code>true</code> if this sample collection is material transfer agreement; <code>false</code> otherwise
	*/
	@Override
	public boolean isMaterialTransferAgreement() {
		return _sampleCollection.isMaterialTransferAgreement();
	}

	/**
	* Sets whether this sample collection is material transfer agreement.
	*
	* @param materialTransferAgreement the material transfer agreement of this sample collection
	*/
	@Override
	public void setMaterialTransferAgreement(boolean materialTransferAgreement) {
		_sampleCollection.setMaterialTransferAgreement(materialTransferAgreement);
	}

	/**
	* Returns the accreditation of this sample collection.
	*
	* @return the accreditation of this sample collection
	*/
	@Override
	public boolean getAccreditation() {
		return _sampleCollection.getAccreditation();
	}

	/**
	* Returns <code>true</code> if this sample collection is accreditation.
	*
	* @return <code>true</code> if this sample collection is accreditation; <code>false</code> otherwise
	*/
	@Override
	public boolean isAccreditation() {
		return _sampleCollection.isAccreditation();
	}

	/**
	* Sets whether this sample collection is accreditation.
	*
	* @param accreditation the accreditation of this sample collection
	*/
	@Override
	public void setAccreditation(boolean accreditation) {
		_sampleCollection.setAccreditation(accreditation);
	}

	/**
	* Returns the quality control of this sample collection.
	*
	* @return the quality control of this sample collection
	*/
	@Override
	public boolean getQualityControl() {
		return _sampleCollection.getQualityControl();
	}

	/**
	* Returns <code>true</code> if this sample collection is quality control.
	*
	* @return <code>true</code> if this sample collection is quality control; <code>false</code> otherwise
	*/
	@Override
	public boolean isQualityControl() {
		return _sampleCollection.isQualityControl();
	}

	/**
	* Sets whether this sample collection is quality control.
	*
	* @param qualityControl the quality control of this sample collection
	*/
	@Override
	public void setQualityControl(boolean qualityControl) {
		_sampleCollection.setQualityControl(qualityControl);
	}

	@Override
	public boolean isNew() {
		return _sampleCollection.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sampleCollection.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sampleCollection.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleCollection.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleCollection.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sampleCollection.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sampleCollection.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sampleCollection.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sampleCollection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sampleCollection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sampleCollection.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleCollectionWrapper((SampleCollection)_sampleCollection.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.SampleCollection sampleCollection) {
		return _sampleCollection.compareTo(sampleCollection);
	}

	@Override
	public int hashCode() {
		return _sampleCollection.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.SampleCollection> toCacheModel() {
		return _sampleCollection.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollection toEscapedModel() {
		return new SampleCollectionWrapper(_sampleCollection.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollection toUnescapedModel() {
		return new SampleCollectionWrapper(_sampleCollection.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleCollection.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleCollection.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sampleCollection.persist();
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeLists() {
		return _sampleCollection.getSampleCollectionAttributeLists();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionWrapper)) {
			return false;
		}

		SampleCollectionWrapper sampleCollectionWrapper = (SampleCollectionWrapper)obj;

		if (Validator.equals(_sampleCollection,
					sampleCollectionWrapper._sampleCollection)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SampleCollection getWrappedSampleCollection() {
		return _sampleCollection;
	}

	@Override
	public SampleCollection getWrappedModel() {
		return _sampleCollection;
	}

	@Override
	public void resetOriginalValues() {
		_sampleCollection.resetOriginalValues();
	}

	private SampleCollection _sampleCollection;
}