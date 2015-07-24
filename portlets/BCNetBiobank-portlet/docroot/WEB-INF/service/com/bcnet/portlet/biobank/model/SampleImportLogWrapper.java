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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SampleImportLog}.
 * </p>
 *
 * @author suyama
 * @see SampleImportLog
 * @generated
 */
public class SampleImportLogWrapper implements SampleImportLog,
	ModelWrapper<SampleImportLog> {
	public SampleImportLogWrapper(SampleImportLog sampleImportLog) {
		_sampleImportLog = sampleImportLog;
	}

	@Override
	public Class<?> getModelClass() {
		return SampleImportLog.class;
	}

	@Override
	public String getModelClassName() {
		return SampleImportLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importId", getImportId());
		attributes.put("fileName", getFileName());
		attributes.put("userId", getUserId());
		attributes.put("dateOfImport", getDateOfImport());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importId = (Long)attributes.get("importId");

		if (importId != null) {
			setImportId(importId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date dateOfImport = (Date)attributes.get("dateOfImport");

		if (dateOfImport != null) {
			setDateOfImport(dateOfImport);
		}
	}

	/**
	* Returns the primary key of this sample import log.
	*
	* @return the primary key of this sample import log
	*/
	@Override
	public long getPrimaryKey() {
		return _sampleImportLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample import log.
	*
	* @param primaryKey the primary key of this sample import log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sampleImportLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this sample import log.
	*
	* @return the uuid of this sample import log
	*/
	@Override
	public java.lang.String getUuid() {
		return _sampleImportLog.getUuid();
	}

	/**
	* Sets the uuid of this sample import log.
	*
	* @param uuid the uuid of this sample import log
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_sampleImportLog.setUuid(uuid);
	}

	/**
	* Returns the import ID of this sample import log.
	*
	* @return the import ID of this sample import log
	*/
	@Override
	public long getImportId() {
		return _sampleImportLog.getImportId();
	}

	/**
	* Sets the import ID of this sample import log.
	*
	* @param importId the import ID of this sample import log
	*/
	@Override
	public void setImportId(long importId) {
		_sampleImportLog.setImportId(importId);
	}

	/**
	* Returns the file name of this sample import log.
	*
	* @return the file name of this sample import log
	*/
	@Override
	public java.lang.String getFileName() {
		return _sampleImportLog.getFileName();
	}

	/**
	* Sets the file name of this sample import log.
	*
	* @param fileName the file name of this sample import log
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_sampleImportLog.setFileName(fileName);
	}

	/**
	* Returns the user ID of this sample import log.
	*
	* @return the user ID of this sample import log
	*/
	@Override
	public long getUserId() {
		return _sampleImportLog.getUserId();
	}

	/**
	* Sets the user ID of this sample import log.
	*
	* @param userId the user ID of this sample import log
	*/
	@Override
	public void setUserId(long userId) {
		_sampleImportLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sample import log.
	*
	* @return the user uuid of this sample import log
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this sample import log.
	*
	* @param userUuid the user uuid of this sample import log
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sampleImportLog.setUserUuid(userUuid);
	}

	/**
	* Returns the date of import of this sample import log.
	*
	* @return the date of import of this sample import log
	*/
	@Override
	public java.util.Date getDateOfImport() {
		return _sampleImportLog.getDateOfImport();
	}

	/**
	* Sets the date of import of this sample import log.
	*
	* @param dateOfImport the date of import of this sample import log
	*/
	@Override
	public void setDateOfImport(java.util.Date dateOfImport) {
		_sampleImportLog.setDateOfImport(dateOfImport);
	}

	@Override
	public boolean isNew() {
		return _sampleImportLog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sampleImportLog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sampleImportLog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sampleImportLog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sampleImportLog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sampleImportLog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sampleImportLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sampleImportLog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sampleImportLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sampleImportLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sampleImportLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleImportLogWrapper((SampleImportLog)_sampleImportLog.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.SampleImportLog sampleImportLog) {
		return _sampleImportLog.compareTo(sampleImportLog);
	}

	@Override
	public int hashCode() {
		return _sampleImportLog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.SampleImportLog> toCacheModel() {
		return _sampleImportLog.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog toEscapedModel() {
		return new SampleImportLogWrapper(_sampleImportLog.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog toUnescapedModel() {
		return new SampleImportLogWrapper(_sampleImportLog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sampleImportLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sampleImportLog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sampleImportLog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleImportLogWrapper)) {
			return false;
		}

		SampleImportLogWrapper sampleImportLogWrapper = (SampleImportLogWrapper)obj;

		if (Validator.equals(_sampleImportLog,
					sampleImportLogWrapper._sampleImportLog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SampleImportLog getWrappedSampleImportLog() {
		return _sampleImportLog;
	}

	@Override
	public SampleImportLog getWrappedModel() {
		return _sampleImportLog;
	}

	@Override
	public void resetOriginalValues() {
		_sampleImportLog.resetOriginalValues();
	}

	private SampleImportLog _sampleImportLog;
}