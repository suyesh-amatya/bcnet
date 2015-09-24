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

package com.rdconnect.org.idcardmolgenis.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RDConnectIDCardMolgenis}.
 * </p>
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenis
 * @generated
 */
public class RDConnectIDCardMolgenisWrapper implements RDConnectIDCardMolgenis,
	ModelWrapper<RDConnectIDCardMolgenis> {
	public RDConnectIDCardMolgenisWrapper(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		_rdConnectIDCardMolgenis = rdConnectIDCardMolgenis;
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectIDCardMolgenis.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectIDCardMolgenis.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}
	}

	/**
	* Returns the primary key of this r d connect i d card molgenis.
	*
	* @return the primary key of this r d connect i d card molgenis
	*/
	@Override
	public long getPrimaryKey() {
		return _rdConnectIDCardMolgenis.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d connect i d card molgenis.
	*
	* @param primaryKey the primary key of this r d connect i d card molgenis
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdConnectIDCardMolgenis.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this r d connect i d card molgenis.
	*
	* @return the ID of this r d connect i d card molgenis
	*/
	@Override
	public long getId() {
		return _rdConnectIDCardMolgenis.getId();
	}

	/**
	* Sets the ID of this r d connect i d card molgenis.
	*
	* @param id the ID of this r d connect i d card molgenis
	*/
	@Override
	public void setId(long id) {
		_rdConnectIDCardMolgenis.setId(id);
	}

	@Override
	public boolean isNew() {
		return _rdConnectIDCardMolgenis.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdConnectIDCardMolgenis.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdConnectIDCardMolgenis.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdConnectIDCardMolgenis.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdConnectIDCardMolgenis.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdConnectIDCardMolgenis.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdConnectIDCardMolgenis.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdConnectIDCardMolgenis.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdConnectIDCardMolgenis.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdConnectIDCardMolgenis.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdConnectIDCardMolgenis.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDConnectIDCardMolgenisWrapper((RDConnectIDCardMolgenis)_rdConnectIDCardMolgenis.clone());
	}

	@Override
	public int compareTo(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		return _rdConnectIDCardMolgenis.compareTo(rdConnectIDCardMolgenis);
	}

	@Override
	public int hashCode() {
		return _rdConnectIDCardMolgenis.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> toCacheModel() {
		return _rdConnectIDCardMolgenis.toCacheModel();
	}

	@Override
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis toEscapedModel() {
		return new RDConnectIDCardMolgenisWrapper(_rdConnectIDCardMolgenis.toEscapedModel());
	}

	@Override
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis toUnescapedModel() {
		return new RDConnectIDCardMolgenisWrapper(_rdConnectIDCardMolgenis.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdConnectIDCardMolgenis.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdConnectIDCardMolgenis.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdConnectIDCardMolgenis.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDConnectIDCardMolgenisWrapper)) {
			return false;
		}

		RDConnectIDCardMolgenisWrapper rdConnectIDCardMolgenisWrapper = (RDConnectIDCardMolgenisWrapper)obj;

		if (Validator.equals(_rdConnectIDCardMolgenis,
					rdConnectIDCardMolgenisWrapper._rdConnectIDCardMolgenis)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDConnectIDCardMolgenis getWrappedRDConnectIDCardMolgenis() {
		return _rdConnectIDCardMolgenis;
	}

	@Override
	public RDConnectIDCardMolgenis getWrappedModel() {
		return _rdConnectIDCardMolgenis;
	}

	@Override
	public void resetOriginalValues() {
		_rdConnectIDCardMolgenis.resetOriginalValues();
	}

	private RDConnectIDCardMolgenis _rdConnectIDCardMolgenis;
}