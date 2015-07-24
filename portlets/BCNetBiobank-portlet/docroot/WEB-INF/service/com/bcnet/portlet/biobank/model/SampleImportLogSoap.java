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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleImportLogServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleImportLogServiceSoap
 * @generated
 */
public class SampleImportLogSoap implements Serializable {
	public static SampleImportLogSoap toSoapModel(SampleImportLog model) {
		SampleImportLogSoap soapModel = new SampleImportLogSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setImportId(model.getImportId());
		soapModel.setFileName(model.getFileName());
		soapModel.setUserId(model.getUserId());
		soapModel.setDateOfImport(model.getDateOfImport());

		return soapModel;
	}

	public static SampleImportLogSoap[] toSoapModels(SampleImportLog[] models) {
		SampleImportLogSoap[] soapModels = new SampleImportLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleImportLogSoap[][] toSoapModels(
		SampleImportLog[][] models) {
		SampleImportLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleImportLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleImportLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleImportLogSoap[] toSoapModels(
		List<SampleImportLog> models) {
		List<SampleImportLogSoap> soapModels = new ArrayList<SampleImportLogSoap>(models.size());

		for (SampleImportLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleImportLogSoap[soapModels.size()]);
	}

	public SampleImportLogSoap() {
	}

	public long getPrimaryKey() {
		return _importId;
	}

	public void setPrimaryKey(long pk) {
		setImportId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getImportId() {
		return _importId;
	}

	public void setImportId(long importId) {
		_importId = importId;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getDateOfImport() {
		return _dateOfImport;
	}

	public void setDateOfImport(Date dateOfImport) {
		_dateOfImport = dateOfImport;
	}

	private String _uuid;
	private long _importId;
	private String _fileName;
	private long _userId;
	private Date _dateOfImport;
}