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

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SampleCollectionAttributeLists in entity cache.
 *
 * @author suyama
 * @see SampleCollectionAttributeLists
 * @generated
 */
public class SampleCollectionAttributeListsCacheModel implements CacheModel<SampleCollectionAttributeLists>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{sampleCollectionAttributeListsId=");
		sb.append(sampleCollectionAttributeListsId);
		sb.append(", sampleCollectionDbId=");
		sb.append(sampleCollectionDbId);
		sb.append(", attributeListName=");
		sb.append(attributeListName);
		sb.append(", attributeListValue=");
		sb.append(attributeListValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleCollectionAttributeLists toEntityModel() {
		SampleCollectionAttributeListsImpl sampleCollectionAttributeListsImpl = new SampleCollectionAttributeListsImpl();

		sampleCollectionAttributeListsImpl.setSampleCollectionAttributeListsId(sampleCollectionAttributeListsId);
		sampleCollectionAttributeListsImpl.setSampleCollectionDbId(sampleCollectionDbId);

		if (attributeListName == null) {
			sampleCollectionAttributeListsImpl.setAttributeListName(StringPool.BLANK);
		}
		else {
			sampleCollectionAttributeListsImpl.setAttributeListName(attributeListName);
		}

		if (attributeListValue == null) {
			sampleCollectionAttributeListsImpl.setAttributeListValue(StringPool.BLANK);
		}
		else {
			sampleCollectionAttributeListsImpl.setAttributeListValue(attributeListValue);
		}

		sampleCollectionAttributeListsImpl.resetOriginalValues();

		return sampleCollectionAttributeListsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sampleCollectionAttributeListsId = objectInput.readLong();
		sampleCollectionDbId = objectInput.readLong();
		attributeListName = objectInput.readUTF();
		attributeListValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sampleCollectionAttributeListsId);
		objectOutput.writeLong(sampleCollectionDbId);

		if (attributeListName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attributeListName);
		}

		if (attributeListValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attributeListValue);
		}
	}

	public long sampleCollectionAttributeListsId;
	public long sampleCollectionDbId;
	public String attributeListName;
	public String attributeListValue;
}