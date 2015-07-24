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

import com.bcnet.portlet.biobank.model.SampleImportLog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleImportLog in entity cache.
 *
 * @author suyama
 * @see SampleImportLog
 * @generated
 */
public class SampleImportLogCacheModel implements CacheModel<SampleImportLog>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", importId=");
		sb.append(importId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", dateOfImport=");
		sb.append(dateOfImport);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleImportLog toEntityModel() {
		SampleImportLogImpl sampleImportLogImpl = new SampleImportLogImpl();

		if (uuid == null) {
			sampleImportLogImpl.setUuid(StringPool.BLANK);
		}
		else {
			sampleImportLogImpl.setUuid(uuid);
		}

		sampleImportLogImpl.setImportId(importId);

		if (fileName == null) {
			sampleImportLogImpl.setFileName(StringPool.BLANK);
		}
		else {
			sampleImportLogImpl.setFileName(fileName);
		}

		sampleImportLogImpl.setUserId(userId);

		if (dateOfImport == Long.MIN_VALUE) {
			sampleImportLogImpl.setDateOfImport(null);
		}
		else {
			sampleImportLogImpl.setDateOfImport(new Date(dateOfImport));
		}

		sampleImportLogImpl.resetOriginalValues();

		return sampleImportLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		importId = objectInput.readLong();
		fileName = objectInput.readUTF();
		userId = objectInput.readLong();
		dateOfImport = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(importId);

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(dateOfImport);
	}

	public String uuid;
	public long importId;
	public String fileName;
	public long userId;
	public long dateOfImport;
}