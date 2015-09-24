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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rdconnect.org.idcardmolgenis.service.http.RDConnectIDCardMolgenisServiceSoap}.
 *
 * @author suyeshamatya
 * @see com.rdconnect.org.idcardmolgenis.service.http.RDConnectIDCardMolgenisServiceSoap
 * @generated
 */
public class RDConnectIDCardMolgenisSoap implements Serializable {
	public static RDConnectIDCardMolgenisSoap toSoapModel(
		RDConnectIDCardMolgenis model) {
		RDConnectIDCardMolgenisSoap soapModel = new RDConnectIDCardMolgenisSoap();

		soapModel.setId(model.getId());

		return soapModel;
	}

	public static RDConnectIDCardMolgenisSoap[] toSoapModels(
		RDConnectIDCardMolgenis[] models) {
		RDConnectIDCardMolgenisSoap[] soapModels = new RDConnectIDCardMolgenisSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDConnectIDCardMolgenisSoap[][] toSoapModels(
		RDConnectIDCardMolgenis[][] models) {
		RDConnectIDCardMolgenisSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDConnectIDCardMolgenisSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDConnectIDCardMolgenisSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDConnectIDCardMolgenisSoap[] toSoapModels(
		List<RDConnectIDCardMolgenis> models) {
		List<RDConnectIDCardMolgenisSoap> soapModels = new ArrayList<RDConnectIDCardMolgenisSoap>(models.size());

		for (RDConnectIDCardMolgenis model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDConnectIDCardMolgenisSoap[soapModels.size()]);
	}

	public RDConnectIDCardMolgenisSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	private long _id;
}