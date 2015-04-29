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
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleCollectionAttributeListsMasterServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleCollectionAttributeListsMasterServiceSoap
 * @generated
 */
public class SampleCollectionAttributeListsMasterSoap implements Serializable {
	public static SampleCollectionAttributeListsMasterSoap toSoapModel(
		SampleCollectionAttributeListsMaster model) {
		SampleCollectionAttributeListsMasterSoap soapModel = new SampleCollectionAttributeListsMasterSoap();

		soapModel.setSampleCollectionAttributeListsMasterId(model.getSampleCollectionAttributeListsMasterId());
		soapModel.setAttributeListName(model.getAttributeListName());
		soapModel.setAttributeListValue(model.getAttributeListValue());

		return soapModel;
	}

	public static SampleCollectionAttributeListsMasterSoap[] toSoapModels(
		SampleCollectionAttributeListsMaster[] models) {
		SampleCollectionAttributeListsMasterSoap[] soapModels = new SampleCollectionAttributeListsMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionAttributeListsMasterSoap[][] toSoapModels(
		SampleCollectionAttributeListsMaster[][] models) {
		SampleCollectionAttributeListsMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleCollectionAttributeListsMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleCollectionAttributeListsMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionAttributeListsMasterSoap[] toSoapModels(
		List<SampleCollectionAttributeListsMaster> models) {
		List<SampleCollectionAttributeListsMasterSoap> soapModels = new ArrayList<SampleCollectionAttributeListsMasterSoap>(models.size());

		for (SampleCollectionAttributeListsMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleCollectionAttributeListsMasterSoap[soapModels.size()]);
	}

	public SampleCollectionAttributeListsMasterSoap() {
	}

	public long getPrimaryKey() {
		return _sampleCollectionAttributeListsMasterId;
	}

	public void setPrimaryKey(long pk) {
		setSampleCollectionAttributeListsMasterId(pk);
	}

	public long getSampleCollectionAttributeListsMasterId() {
		return _sampleCollectionAttributeListsMasterId;
	}

	public void setSampleCollectionAttributeListsMasterId(
		long sampleCollectionAttributeListsMasterId) {
		_sampleCollectionAttributeListsMasterId = sampleCollectionAttributeListsMasterId;
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

	private long _sampleCollectionAttributeListsMasterId;
	private String _attributeListName;
	private String _attributeListValue;
}