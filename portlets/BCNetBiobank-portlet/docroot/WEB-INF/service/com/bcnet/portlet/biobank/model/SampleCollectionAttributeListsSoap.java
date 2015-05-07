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
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleCollectionAttributeListsServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleCollectionAttributeListsServiceSoap
 * @generated
 */
public class SampleCollectionAttributeListsSoap implements Serializable {
	public static SampleCollectionAttributeListsSoap toSoapModel(
		SampleCollectionAttributeLists model) {
		SampleCollectionAttributeListsSoap soapModel = new SampleCollectionAttributeListsSoap();

		soapModel.setSampleCollectionAttributeListsId(model.getSampleCollectionAttributeListsId());
		soapModel.setSampleCollectionDbId(model.getSampleCollectionDbId());
		soapModel.setAttributeListName(model.getAttributeListName());
		soapModel.setAttributeListValue(model.getAttributeListValue());

		return soapModel;
	}

	public static SampleCollectionAttributeListsSoap[] toSoapModels(
		SampleCollectionAttributeLists[] models) {
		SampleCollectionAttributeListsSoap[] soapModels = new SampleCollectionAttributeListsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionAttributeListsSoap[][] toSoapModels(
		SampleCollectionAttributeLists[][] models) {
		SampleCollectionAttributeListsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleCollectionAttributeListsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleCollectionAttributeListsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionAttributeListsSoap[] toSoapModels(
		List<SampleCollectionAttributeLists> models) {
		List<SampleCollectionAttributeListsSoap> soapModels = new ArrayList<SampleCollectionAttributeListsSoap>(models.size());

		for (SampleCollectionAttributeLists model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleCollectionAttributeListsSoap[soapModels.size()]);
	}

	public SampleCollectionAttributeListsSoap() {
	}

	public long getPrimaryKey() {
		return _sampleCollectionAttributeListsId;
	}

	public void setPrimaryKey(long pk) {
		setSampleCollectionAttributeListsId(pk);
	}

	public long getSampleCollectionAttributeListsId() {
		return _sampleCollectionAttributeListsId;
	}

	public void setSampleCollectionAttributeListsId(
		long sampleCollectionAttributeListsId) {
		_sampleCollectionAttributeListsId = sampleCollectionAttributeListsId;
	}

	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;
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

	private long _sampleCollectionAttributeListsId;
	private long _sampleCollectionDbId;
	private String _attributeListName;
	private String _attributeListValue;
}