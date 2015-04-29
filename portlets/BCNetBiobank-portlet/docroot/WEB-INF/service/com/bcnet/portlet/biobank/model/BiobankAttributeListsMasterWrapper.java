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
 * This class is a wrapper for {@link BiobankAttributeListsMaster}.
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeListsMaster
 * @generated
 */
public class BiobankAttributeListsMasterWrapper
	implements BiobankAttributeListsMaster,
		ModelWrapper<BiobankAttributeListsMaster> {
	public BiobankAttributeListsMasterWrapper(
		BiobankAttributeListsMaster biobankAttributeListsMaster) {
		_biobankAttributeListsMaster = biobankAttributeListsMaster;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankAttributeListsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankAttributeListsMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankAttributeListsMasterId",
			getBiobankAttributeListsMasterId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankAttributeListsMasterId = (Long)attributes.get(
				"biobankAttributeListsMasterId");

		if (biobankAttributeListsMasterId != null) {
			setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);
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
	* Returns the primary key of this biobank attribute lists master.
	*
	* @return the primary key of this biobank attribute lists master
	*/
	@Override
	public long getPrimaryKey() {
		return _biobankAttributeListsMaster.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank attribute lists master.
	*
	* @param primaryKey the primary key of this biobank attribute lists master
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobankAttributeListsMaster.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank attribute lists master ID of this biobank attribute lists master.
	*
	* @return the biobank attribute lists master ID of this biobank attribute lists master
	*/
	@Override
	public long getBiobankAttributeListsMasterId() {
		return _biobankAttributeListsMaster.getBiobankAttributeListsMasterId();
	}

	/**
	* Sets the biobank attribute lists master ID of this biobank attribute lists master.
	*
	* @param biobankAttributeListsMasterId the biobank attribute lists master ID of this biobank attribute lists master
	*/
	@Override
	public void setBiobankAttributeListsMasterId(
		long biobankAttributeListsMasterId) {
		_biobankAttributeListsMaster.setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);
	}

	/**
	* Returns the attribute list name of this biobank attribute lists master.
	*
	* @return the attribute list name of this biobank attribute lists master
	*/
	@Override
	public java.lang.String getAttributeListName() {
		return _biobankAttributeListsMaster.getAttributeListName();
	}

	/**
	* Sets the attribute list name of this biobank attribute lists master.
	*
	* @param attributeListName the attribute list name of this biobank attribute lists master
	*/
	@Override
	public void setAttributeListName(java.lang.String attributeListName) {
		_biobankAttributeListsMaster.setAttributeListName(attributeListName);
	}

	/**
	* Returns the attribute list value of this biobank attribute lists master.
	*
	* @return the attribute list value of this biobank attribute lists master
	*/
	@Override
	public java.lang.String getAttributeListValue() {
		return _biobankAttributeListsMaster.getAttributeListValue();
	}

	/**
	* Sets the attribute list value of this biobank attribute lists master.
	*
	* @param attributeListValue the attribute list value of this biobank attribute lists master
	*/
	@Override
	public void setAttributeListValue(java.lang.String attributeListValue) {
		_biobankAttributeListsMaster.setAttributeListValue(attributeListValue);
	}

	@Override
	public boolean isNew() {
		return _biobankAttributeListsMaster.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankAttributeListsMaster.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankAttributeListsMaster.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankAttributeListsMaster.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankAttributeListsMaster.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankAttributeListsMaster.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankAttributeListsMaster.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankAttributeListsMaster.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankAttributeListsMaster.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankAttributeListsMaster.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankAttributeListsMaster.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankAttributeListsMasterWrapper((BiobankAttributeListsMaster)_biobankAttributeListsMaster.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster biobankAttributeListsMaster) {
		return _biobankAttributeListsMaster.compareTo(biobankAttributeListsMaster);
	}

	@Override
	public int hashCode() {
		return _biobankAttributeListsMaster.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster> toCacheModel() {
		return _biobankAttributeListsMaster.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster toEscapedModel() {
		return new BiobankAttributeListsMasterWrapper(_biobankAttributeListsMaster.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster toUnescapedModel() {
		return new BiobankAttributeListsMasterWrapper(_biobankAttributeListsMaster.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankAttributeListsMaster.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankAttributeListsMaster.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankAttributeListsMaster.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankAttributeListsMasterWrapper)) {
			return false;
		}

		BiobankAttributeListsMasterWrapper biobankAttributeListsMasterWrapper = (BiobankAttributeListsMasterWrapper)obj;

		if (Validator.equals(_biobankAttributeListsMaster,
					biobankAttributeListsMasterWrapper._biobankAttributeListsMaster)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankAttributeListsMaster getWrappedBiobankAttributeListsMaster() {
		return _biobankAttributeListsMaster;
	}

	@Override
	public BiobankAttributeListsMaster getWrappedModel() {
		return _biobankAttributeListsMaster;
	}

	@Override
	public void resetOriginalValues() {
		_biobankAttributeListsMaster.resetOriginalValues();
	}

	private BiobankAttributeListsMaster _biobankAttributeListsMaster;
}