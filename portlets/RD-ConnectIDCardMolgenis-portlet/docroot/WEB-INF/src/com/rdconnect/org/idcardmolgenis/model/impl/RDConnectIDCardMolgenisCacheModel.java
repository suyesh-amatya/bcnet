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

package com.rdconnect.org.idcardmolgenis.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RDConnectIDCardMolgenis in entity cache.
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenis
 * @generated
 */
public class RDConnectIDCardMolgenisCacheModel implements CacheModel<RDConnectIDCardMolgenis>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{id=");
		sb.append(id);

		return sb.toString();
	}

	@Override
	public RDConnectIDCardMolgenis toEntityModel() {
		RDConnectIDCardMolgenisImpl rdConnectIDCardMolgenisImpl = new RDConnectIDCardMolgenisImpl();

		rdConnectIDCardMolgenisImpl.setId(id);

		rdConnectIDCardMolgenisImpl.resetOriginalValues();

		return rdConnectIDCardMolgenisImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
	}

	public long id;
}