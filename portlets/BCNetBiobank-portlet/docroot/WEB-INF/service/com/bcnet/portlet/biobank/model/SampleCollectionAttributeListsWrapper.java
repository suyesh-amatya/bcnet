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
 * This class is a wrapper for {@link SampleCollectionAttributeLists}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeLists
 * @generated
 */
public class SampleCollectionAttributeListsWrapper
	implements SampleCollectionAttributeLists,
		ModelWrapper<SampleCollectionAttributeLists> {
	public SampleCollectionAttributeListsWrapper(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		_sampleCollectionAttributeLists = sampleCollectionAttributeLists;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionAttributeLists.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionAttributeLists.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionAttributeListsId",
			getSampleCollectionAttributeListsId());
		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionAttributeListsId = (Long)attributes.get(
				"sampleCollectionAttributeListsId");

		if (sampleCollectionAttributeListsId != null) {
			setSampleCollectionAttributeListsId(sampleCollectionAttributeListsId);
		}

		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		String attributeListName = (String)attributes.get("attributeListName");

		if (attributeListName != null) {
			setAttributeListName(attributeListName);
		}

		String attributeListValue = (String)attributes.get("attributeListValue");

		if (attributeListValue != null) {
			setAttributeListValue(attributeListValue);
		}
	}

	/**
	* Returns the primary key of this sample collection attribute lists.
	*
	* @return the primary key of this sample collection attribute lists
	*/
	@Override
	public long getPrimaryKey() {
		return _sampleCollectionAttributeLists.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample collection attribute lists.
	*
	* @param primaryKey the primary key of this sample collection attribute lists
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sampleCollectionAttributeLists.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample collection attribute lists ID of this sample collection attribute lists.
	*
	* @return the sample collection attribute lists ID of this sample collection attribute lists
	*/
	@Override
	public long getSampleCollectionAttributeListsId() {
		return _sampleCollectionAttributeLists.getSampleCollectionAttributeListsId();
	}

	/**
	* Sets the sample collection attribute lists ID of this sample collection attribute lists.
	*
	* @param sampleCollectionAttributeListsId the sample collection attribute lists ID of this sample collection attribute lists
	*/
	@Override
	public void setSampleCollectionAttributeListsId(
		long sampleCollectionAttributeListsId) {
		_sampleCollectionAttributeLists.setSampleCollectionAttributeListsId(sampleCollectionAttributeListsId);
	}

	/**
	* Returns the sample collection db ID of this sample collection attribute lists.
	*
	* @return the sample collection db ID of this sample collection attribute lists
	*/
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionAttributeLists.getSampleCollectionDbId();
	}

	/**
	* Sets the sample collection db ID of this sample collection attribute lists.
	*
	* @param sampleCollectionDbId the sample collection db ID of this sample collection attribute lists
	*/
	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionAttributeLists.setSampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the attribute list name of this sample collection attribute lists.
	*
	* @return the attribute list name of this sample collection attribute lists
	*/
	@Override
	public java.lang.String getAttributeListName() {
		return _sampleCollectionAttributeLists.getAttributeListName();
	}

	/**
	* Sets the attribute list name of this sample collection attribute lists.
	*
	* @param attributeListName the attribute list name of this sample collection attribute lists
	*/
	@Override
	public void setAttributeListName(java.lang.String attributeListName) {
		_sampleCollectionAttributeLists.setAttributeListName(attributeListName);
	}

	/**
	* Returns the attribute list value of this sample collection attribute lists.
	*
	* @return the attribute list value of this sample collection attribute lists
	*/
	@Override
	public java.lang.String getAttributeListValue() {
		return _sampleCollectionAttributeLists.getAttributeListValue();
	}

	/**
	* Sets the attribute list value of this sample collection attribute lists.
	*
	* @param attributeListValue the attribute list value of this sample collection attribute lists
	*/
	@Override
	public void setAttributeListValue(java.lang.String attributeListValue) {
		_sampleCollectionAttributeLists.setAttributeListValue(attributeListValue);
	}

	@Override
	public boolean isNew() {
		return _sampleCollectionAttributeLists.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sampleCollectionAttributeLists.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sampleCollectionAttributeLists.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleCollectionAttributeLists.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleCollectionAttributeLists.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sampleCollectionAttributeLists.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sampleCollectionAttributeLists.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sampleCollectionAttributeLists.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sampleCollectionAttributeLists.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sampleCollectionAttributeLists.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sampleCollectionAttributeLists.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleCollectionAttributeListsWrapper((SampleCollectionAttributeLists)_sampleCollectionAttributeLists.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		return _sampleCollectionAttributeLists.compareTo(sampleCollectionAttributeLists);
	}

	@Override
	public int hashCode() {
		return _sampleCollectionAttributeLists.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> toCacheModel() {
		return _sampleCollectionAttributeLists.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists toEscapedModel() {
		return new SampleCollectionAttributeListsWrapper(_sampleCollectionAttributeLists.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists toUnescapedModel() {
		return new SampleCollectionAttributeListsWrapper(_sampleCollectionAttributeLists.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleCollectionAttributeLists.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleCollectionAttributeLists.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sampleCollectionAttributeLists.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionAttributeListsWrapper)) {
			return false;
		}

		SampleCollectionAttributeListsWrapper sampleCollectionAttributeListsWrapper =
			(SampleCollectionAttributeListsWrapper)obj;

		if (Validator.equals(_sampleCollectionAttributeLists,
					sampleCollectionAttributeListsWrapper._sampleCollectionAttributeLists)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SampleCollectionAttributeLists getWrappedSampleCollectionAttributeLists() {
		return _sampleCollectionAttributeLists;
	}

	@Override
	public SampleCollectionAttributeLists getWrappedModel() {
		return _sampleCollectionAttributeLists;
	}

	@Override
	public void resetOriginalValues() {
		_sampleCollectionAttributeLists.resetOriginalValues();
	}

	private SampleCollectionAttributeLists _sampleCollectionAttributeLists;
}