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
 * This class is a wrapper for {@link SampleCollectionContact}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionContact
 * @generated
 */
public class SampleCollectionContactWrapper implements SampleCollectionContact,
	ModelWrapper<SampleCollectionContact> {
	public SampleCollectionContactWrapper(
		SampleCollectionContact sampleCollectionContact) {
		_sampleCollectionContact = sampleCollectionContact;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionContact.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("userId", getUserId());
		attributes.put("mainContact", getMainContact());
		attributes.put("sampleCollectionOwner", getSampleCollectionOwner());
		attributes.put("sampleCollectionEditor", getSampleCollectionEditor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean mainContact = (Boolean)attributes.get("mainContact");

		if (mainContact != null) {
			setMainContact(mainContact);
		}

		Boolean sampleCollectionOwner = (Boolean)attributes.get(
				"sampleCollectionOwner");

		if (sampleCollectionOwner != null) {
			setSampleCollectionOwner(sampleCollectionOwner);
		}

		Boolean sampleCollectionEditor = (Boolean)attributes.get(
				"sampleCollectionEditor");

		if (sampleCollectionEditor != null) {
			setSampleCollectionEditor(sampleCollectionEditor);
		}
	}

	/**
	* Returns the primary key of this sample collection contact.
	*
	* @return the primary key of this sample collection contact
	*/
	@Override
	public com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK getPrimaryKey() {
		return _sampleCollectionContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample collection contact.
	*
	* @param primaryKey the primary key of this sample collection contact
	*/
	@Override
	public void setPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK primaryKey) {
		_sampleCollectionContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample collection db ID of this sample collection contact.
	*
	* @return the sample collection db ID of this sample collection contact
	*/
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionContact.getSampleCollectionDbId();
	}

	/**
	* Sets the sample collection db ID of this sample collection contact.
	*
	* @param sampleCollectionDbId the sample collection db ID of this sample collection contact
	*/
	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionContact.setSampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the user ID of this sample collection contact.
	*
	* @return the user ID of this sample collection contact
	*/
	@Override
	public long getUserId() {
		return _sampleCollectionContact.getUserId();
	}

	/**
	* Sets the user ID of this sample collection contact.
	*
	* @param userId the user ID of this sample collection contact
	*/
	@Override
	public void setUserId(long userId) {
		_sampleCollectionContact.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sample collection contact.
	*
	* @return the user uuid of this sample collection contact
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionContact.getUserUuid();
	}

	/**
	* Sets the user uuid of this sample collection contact.
	*
	* @param userUuid the user uuid of this sample collection contact
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sampleCollectionContact.setUserUuid(userUuid);
	}

	/**
	* Returns the main contact of this sample collection contact.
	*
	* @return the main contact of this sample collection contact
	*/
	@Override
	public boolean getMainContact() {
		return _sampleCollectionContact.getMainContact();
	}

	/**
	* Returns <code>true</code> if this sample collection contact is main contact.
	*
	* @return <code>true</code> if this sample collection contact is main contact; <code>false</code> otherwise
	*/
	@Override
	public boolean isMainContact() {
		return _sampleCollectionContact.isMainContact();
	}

	/**
	* Sets whether this sample collection contact is main contact.
	*
	* @param mainContact the main contact of this sample collection contact
	*/
	@Override
	public void setMainContact(boolean mainContact) {
		_sampleCollectionContact.setMainContact(mainContact);
	}

	/**
	* Returns the sample collection owner of this sample collection contact.
	*
	* @return the sample collection owner of this sample collection contact
	*/
	@Override
	public boolean getSampleCollectionOwner() {
		return _sampleCollectionContact.getSampleCollectionOwner();
	}

	/**
	* Returns <code>true</code> if this sample collection contact is sample collection owner.
	*
	* @return <code>true</code> if this sample collection contact is sample collection owner; <code>false</code> otherwise
	*/
	@Override
	public boolean isSampleCollectionOwner() {
		return _sampleCollectionContact.isSampleCollectionOwner();
	}

	/**
	* Sets whether this sample collection contact is sample collection owner.
	*
	* @param sampleCollectionOwner the sample collection owner of this sample collection contact
	*/
	@Override
	public void setSampleCollectionOwner(boolean sampleCollectionOwner) {
		_sampleCollectionContact.setSampleCollectionOwner(sampleCollectionOwner);
	}

	/**
	* Returns the sample collection editor of this sample collection contact.
	*
	* @return the sample collection editor of this sample collection contact
	*/
	@Override
	public boolean getSampleCollectionEditor() {
		return _sampleCollectionContact.getSampleCollectionEditor();
	}

	/**
	* Returns <code>true</code> if this sample collection contact is sample collection editor.
	*
	* @return <code>true</code> if this sample collection contact is sample collection editor; <code>false</code> otherwise
	*/
	@Override
	public boolean isSampleCollectionEditor() {
		return _sampleCollectionContact.isSampleCollectionEditor();
	}

	/**
	* Sets whether this sample collection contact is sample collection editor.
	*
	* @param sampleCollectionEditor the sample collection editor of this sample collection contact
	*/
	@Override
	public void setSampleCollectionEditor(boolean sampleCollectionEditor) {
		_sampleCollectionContact.setSampleCollectionEditor(sampleCollectionEditor);
	}

	@Override
	public boolean isNew() {
		return _sampleCollectionContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sampleCollectionContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sampleCollectionContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleCollectionContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleCollectionContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sampleCollectionContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sampleCollectionContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sampleCollectionContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sampleCollectionContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sampleCollectionContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sampleCollectionContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleCollectionContactWrapper((SampleCollectionContact)_sampleCollectionContact.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact) {
		return _sampleCollectionContact.compareTo(sampleCollectionContact);
	}

	@Override
	public int hashCode() {
		return _sampleCollectionContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.SampleCollectionContact> toCacheModel() {
		return _sampleCollectionContact.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionContact toEscapedModel() {
		return new SampleCollectionContactWrapper(_sampleCollectionContact.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionContact toUnescapedModel() {
		return new SampleCollectionContactWrapper(_sampleCollectionContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleCollectionContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleCollectionContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sampleCollectionContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionContactWrapper)) {
			return false;
		}

		SampleCollectionContactWrapper sampleCollectionContactWrapper = (SampleCollectionContactWrapper)obj;

		if (Validator.equals(_sampleCollectionContact,
					sampleCollectionContactWrapper._sampleCollectionContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SampleCollectionContact getWrappedSampleCollectionContact() {
		return _sampleCollectionContact;
	}

	@Override
	public SampleCollectionContact getWrappedModel() {
		return _sampleCollectionContact;
	}

	@Override
	public void resetOriginalValues() {
		_sampleCollectionContact.resetOriginalValues();
	}

	private SampleCollectionContact _sampleCollectionContact;
}