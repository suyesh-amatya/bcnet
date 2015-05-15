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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.SampleCollectionContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SampleCollectionContact in entity cache.
 *
 * @author suyama
 * @see SampleCollectionContact
 * @generated
 */
public class SampleCollectionContactCacheModel implements CacheModel<SampleCollectionContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{sampleCollectionDbId=");
		sb.append(sampleCollectionDbId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", mainContact=");
		sb.append(mainContact);
		sb.append(", sampleCollectionOwner=");
		sb.append(sampleCollectionOwner);
		sb.append(", sampleCollectionEditor=");
		sb.append(sampleCollectionEditor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleCollectionContact toEntityModel() {
		SampleCollectionContactImpl sampleCollectionContactImpl = new SampleCollectionContactImpl();

		sampleCollectionContactImpl.setSampleCollectionDbId(sampleCollectionDbId);
		sampleCollectionContactImpl.setUserId(userId);
		sampleCollectionContactImpl.setMainContact(mainContact);
		sampleCollectionContactImpl.setSampleCollectionOwner(sampleCollectionOwner);
		sampleCollectionContactImpl.setSampleCollectionEditor(sampleCollectionEditor);

		sampleCollectionContactImpl.resetOriginalValues();

		return sampleCollectionContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sampleCollectionDbId = objectInput.readLong();
		userId = objectInput.readLong();
		mainContact = objectInput.readBoolean();
		sampleCollectionOwner = objectInput.readBoolean();
		sampleCollectionEditor = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sampleCollectionDbId);
		objectOutput.writeLong(userId);
		objectOutput.writeBoolean(mainContact);
		objectOutput.writeBoolean(sampleCollectionOwner);
		objectOutput.writeBoolean(sampleCollectionEditor);
	}

	public long sampleCollectionDbId;
	public long userId;
	public boolean mainContact;
	public boolean sampleCollectionOwner;
	public boolean sampleCollectionEditor;
}