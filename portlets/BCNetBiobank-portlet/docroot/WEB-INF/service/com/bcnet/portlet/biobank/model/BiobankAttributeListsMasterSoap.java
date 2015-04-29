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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.BiobankAttributeListsMasterServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.BiobankAttributeListsMasterServiceSoap
 * @generated
 */
public class BiobankAttributeListsMasterSoap implements Serializable {
	public static BiobankAttributeListsMasterSoap toSoapModel(
		BiobankAttributeListsMaster model) {
		BiobankAttributeListsMasterSoap soapModel = new BiobankAttributeListsMasterSoap();

		soapModel.setBiobankAttributeListsMasterId(model.getBiobankAttributeListsMasterId());
		soapModel.setAttributeListName(model.getAttributeListName());
		soapModel.setAttributeListValue(model.getAttributeListValue());

		return soapModel;
	}

	public static BiobankAttributeListsMasterSoap[] toSoapModels(
		BiobankAttributeListsMaster[] models) {
		BiobankAttributeListsMasterSoap[] soapModels = new BiobankAttributeListsMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiobankAttributeListsMasterSoap[][] toSoapModels(
		BiobankAttributeListsMaster[][] models) {
		BiobankAttributeListsMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiobankAttributeListsMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiobankAttributeListsMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiobankAttributeListsMasterSoap[] toSoapModels(
		List<BiobankAttributeListsMaster> models) {
		List<BiobankAttributeListsMasterSoap> soapModels = new ArrayList<BiobankAttributeListsMasterSoap>(models.size());

		for (BiobankAttributeListsMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiobankAttributeListsMasterSoap[soapModels.size()]);
	}

	public BiobankAttributeListsMasterSoap() {
	}

	public long getPrimaryKey() {
		return _biobankAttributeListsMasterId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankAttributeListsMasterId(pk);
	}

	public long getBiobankAttributeListsMasterId() {
		return _biobankAttributeListsMasterId;
	}

	public void setBiobankAttributeListsMasterId(
		long biobankAttributeListsMasterId) {
		_biobankAttributeListsMasterId = biobankAttributeListsMasterId;
	}

	public String getAttributeListName() {
		return _attributeListName;
	}

	public void setAttributeListName(String attributeListName) {
		_attributeListName = attributeListName;
	}

	public String getAttributeListValue() {
		return _attributeListValue;
	}

	public void setAttributeListValue(String attributeListValue) {
		_attributeListValue = attributeListValue;
	}

	private long _biobankAttributeListsMasterId;
	private String _attributeListName;
	private String _attributeListValue;
}