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

import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleCollectionContactServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleCollectionContactServiceSoap
 * @generated
 */
public class SampleCollectionContactSoap implements Serializable {
	public static SampleCollectionContactSoap toSoapModel(
		SampleCollectionContact model) {
		SampleCollectionContactSoap soapModel = new SampleCollectionContactSoap();

		soapModel.setSampleCollectionDbId(model.getSampleCollectionDbId());
		soapModel.setUserId(model.getUserId());
		soapModel.setMainContact(model.getMainContact());
		soapModel.setSampleCollectionOwner(model.getSampleCollectionOwner());
		soapModel.setSampleCollectionEditor(model.getSampleCollectionEditor());

		return soapModel;
	}

	public static SampleCollectionContactSoap[] toSoapModels(
		SampleCollectionContact[] models) {
		SampleCollectionContactSoap[] soapModels = new SampleCollectionContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionContactSoap[][] toSoapModels(
		SampleCollectionContact[][] models) {
		SampleCollectionContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleCollectionContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleCollectionContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionContactSoap[] toSoapModels(
		List<SampleCollectionContact> models) {
		List<SampleCollectionContactSoap> soapModels = new ArrayList<SampleCollectionContactSoap>(models.size());

		for (SampleCollectionContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleCollectionContactSoap[soapModels.size()]);
	}

	public SampleCollectionContactSoap() {
	}

	public SampleCollectionContactPK getPrimaryKey() {
		return new SampleCollectionContactPK(_sampleCollectionDbId, _userId);
	}

	public void setPrimaryKey(SampleCollectionContactPK pk) {
		setSampleCollectionDbId(pk.sampleCollectionDbId);
		setUserId(pk.userId);
	}

	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public boolean getMainContact() {
		return _mainContact;
	}

	public boolean isMainContact() {
		return _mainContact;
	}

	public void setMainContact(boolean mainContact) {
		_mainContact = mainContact;
	}

	public boolean getSampleCollectionOwner() {
		return _sampleCollectionOwner;
	}

	public boolean isSampleCollectionOwner() {
		return _sampleCollectionOwner;
	}

	public void setSampleCollectionOwner(boolean sampleCollectionOwner) {
		_sampleCollectionOwner = sampleCollectionOwner;
	}

	public boolean getSampleCollectionEditor() {
		return _sampleCollectionEditor;
	}

	public boolean isSampleCollectionEditor() {
		return _sampleCollectionEditor;
	}

	public void setSampleCollectionEditor(boolean sampleCollectionEditor) {
		_sampleCollectionEditor = sampleCollectionEditor;
	}

	private long _sampleCollectionDbId;
	private long _userId;
	private boolean _mainContact;
	private boolean _sampleCollectionOwner;
	private boolean _sampleCollectionEditor;
}