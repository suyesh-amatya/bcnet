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

/**
 * The base model interface for the JuristicPerson service. Represents a row in the &quot;juristicperson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonImpl}.
 * </p>
 *
 * @author suyama
 * @see JuristicPerson
 * @see com.bcnet.portlet.biobank.model.impl.JuristicPersonImpl
 * @see com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl
 * @generated
 */
public interface JuristicPersonModel extends BaseModel<JuristicPerson> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a juristic person model instance should use the {@link JuristicPerson} interface instead.
	 */

	/**
	 * Returns the primary key of this juristic person.
	 *
	 * @return the primary key of this juristic person
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this juristic person.
	 *
	 * @param primaryKey the primary key of this juristic person
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the juristic person ID of this juristic person.
	 *
	 * @return the juristic person ID of this juristic person
	 */
	public long getJuristicPersonId();

	/**
	 * Sets the juristic person ID of this juristic person.
	 *
	 * @param juristicPersonId the juristic person ID of this juristic person
	 */
	public void setJuristicPersonId(long juristicPersonId);

	/**
	 * Returns the name of this juristic person.
	 *
	 * @return the name of this juristic person
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this juristic person.
	 *
	 * @param name the name of this juristic person
	 */
	public void setName(String name);

	/**
	 * Returns the url of this juristic person.
	 *
	 * @return the url of this juristic person
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this juristic person.
	 *
	 * @param url the url of this juristic person
	 */
	public void setUrl(String url);

	/**
	 * Returns the address of this juristic person.
	 *
	 * @return the address of this juristic person
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this juristic person.
	 *
	 * @param address the address of this juristic person
	 */
	public void setAddress(String address);

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
	public int compareTo(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.bcnet.portlet.biobank.model.JuristicPerson> toCacheModel();

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson toEscapedModel();

	@Override
	public com.bcnet.portlet.biobank.model.JuristicPerson toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}