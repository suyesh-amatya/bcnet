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
 * This class is a wrapper for {@link SampleCollectionAttributeListsMaster}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMaster
 * @generated
 */
public class SampleCollectionAttributeListsMasterWrapper
	implements SampleCollectionAttributeListsMaster,
		ModelWrapper<SampleCollectionAttributeListsMaster> {
	public SampleCollectionAttributeListsMasterWrapper(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		_sampleCollectionAttributeListsMaster = sampleCollectionAttributeListsMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionAttributeListsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionAttributeListsMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionAttributeListsMasterId",
			getSampleCollectionAttributeListsMasterId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionAttributeListsMasterId = (Long)attributes.get(
				"sampleCollectionAttributeListsMasterId");

		if (sampleCollectionAttributeListsMasterId != null) {
			setSampleCollectionAttributeListsMasterId(sampleCollectionAttributeListsMasterId);
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
	* Returns the primary key of this sample collection attribute lists master.
	*
	* @return the primary key of this sample collection attribute lists master
	*/
	@Override
	public long getPrimaryKey() {
		return _sampleCollectionAttributeListsMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample collection attribute lists master.
	*
	* @param primaryKey the primary key of this sample collection attribute lists master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sampleCollectionAttributeListsMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample collection attribute lists master ID of this sample collection attribute lists master.
	*
	* @return the sample collection attribute lists master ID of this sample collection attribute lists master
	*/
	@Override
	public long getSampleCollectionAttributeListsMasterId() {
		return _sampleCollectionAttributeListsMaster.getSampleCollectionAttributeListsMasterId();
	}

	/**
	* Sets the sample collection attribute lists master ID of this sample collection attribute lists master.
	*
	* @param sampleCollectionAttributeListsMasterId the sample collection attribute lists master ID of this sample collection attribute lists master
	*/
	@Override
	public void setSampleCollectionAttributeListsMasterId(
		long sampleCollectionAttributeListsMasterId) {
		_sampleCollectionAttributeListsMaster.setSampleCollectionAttributeListsMasterId(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Returns the attribute list name of this sample collection attribute lists master.
	*
	* @return the attribute list name of this sample collection attribute lists master
	*/
	@Override
	public java.lang.String getAttributeListName() {
		return _sampleCollectionAttributeListsMaster.getAttributeListName();
	}

	/**
	* Sets the attribute list name of this sample collection attribute lists master.
	*
	* @param attributeListName the attribute list name of this sample collection attribute lists master
	*/
	@Override
	public void setAttributeListName(java.lang.String attributeListName) {
		_sampleCollectionAttributeListsMaster.setAttributeListName(attributeListName);
	}

	/**
	* Returns the attribute list value of this sample collection attribute lists master.
	*
	* @return the attribute list value of this sample collection attribute lists master
	*/
	@Override
	public java.lang.String getAttributeListValue() {
		return _sampleCollectionAttributeListsMaster.getAttributeListValue();
	}

	/**
	* Sets the attribute list value of this sample collection attribute lists master.
	*
	* @param attributeListValue the attribute list value of this sample collection attribute lists master
	*/
	@Override
	public void setAttributeListValue(java.lang.String attributeListValue) {
		_sampleCollectionAttributeListsMaster.setAttributeListValue(attributeListValue);
	}

	@Override
	public boolean isNew() {
		return _sampleCollectionAttributeListsMaster.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sampleCollectionAttributeListsMaster.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sampleCollectionAttributeListsMaster.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleCollectionAttributeListsMaster.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleCollectionAttributeListsMaster.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sampleCollectionAttributeListsMaster.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sampleCollectionAttributeListsMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sampleCollectionAttributeListsMaster.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sampleCollectionAttributeListsMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sampleCollectionAttributeListsMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sampleCollectionAttributeListsMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleCollectionAttributeListsMasterWrapper((SampleCollectionAttributeListsMaster)_sampleCollectionAttributeListsMaster.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		return _sampleCollectionAttributeListsMaster.compareTo(sampleCollectionAttributeListsMaster);
	}

	@Override
	public int hashCode() {
		return _sampleCollectionAttributeListsMaster.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> toCacheModel() {
		return _sampleCollectionAttributeListsMaster.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster toEscapedModel() {
		return new SampleCollectionAttributeListsMasterWrapper(_sampleCollectionAttributeListsMaster.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster toUnescapedModel() {
		return new SampleCollectionAttributeListsMasterWrapper(_sampleCollectionAttributeListsMaster.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleCollectionAttributeListsMaster.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleCollectionAttributeListsMaster.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sampleCollectionAttributeListsMaster.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionAttributeListsMasterWrapper)) {
			return false;
		}

		SampleCollectionAttributeListsMasterWrapper sampleCollectionAttributeListsMasterWrapper =
			(SampleCollectionAttributeListsMasterWrapper)obj;

		if (Validator.equals(_sampleCollectionAttributeListsMaster,
					sampleCollectionAttributeListsMasterWrapper._sampleCollectionAttributeListsMaster)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SampleCollectionAttributeListsMaster getWrappedSampleCollectionAttributeListsMaster() {
		return _sampleCollectionAttributeListsMaster;
	}

	@Override
	public SampleCollectionAttributeListsMaster getWrappedModel() {
		return _sampleCollectionAttributeListsMaster;
	}

	@Override
	public void resetOriginalValues() {
		_sampleCollectionAttributeListsMaster.resetOriginalValues();
	}

	private SampleCollectionAttributeListsMaster _sampleCollectionAttributeListsMaster;
}