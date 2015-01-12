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

package com.portlet.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portlet.sample.model.SampleEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SampleEntry in entity cache.
 *
 * @author Scalsysu5
 * @see SampleEntry
 * @generated
 */
public class SampleEntryCacheModel implements CacheModel<SampleEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleEntry toEntityModel() {
		SampleEntryImpl sampleEntryImpl = new SampleEntryImpl();

		if (uuid == null) {
			sampleEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			sampleEntryImpl.setUuid(uuid);
		}

		sampleEntryImpl.setEntryId(entryId);
		sampleEntryImpl.setCompanyId(companyId);
		sampleEntryImpl.setGroupId(groupId);
		sampleEntryImpl.setUserId(userId);

		if (userName == null) {
			sampleEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			sampleEntryImpl.setUserName(userName);
		}

		if (title == null) {
			sampleEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			sampleEntryImpl.setTitle(title);
		}

		if (content == null) {
			sampleEntryImpl.setContent(StringPool.BLANK);
		}
		else {
			sampleEntryImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			sampleEntryImpl.setCreateDate(null);
		}
		else {
			sampleEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sampleEntryImpl.setModifiedDate(null);
		}
		else {
			sampleEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		sampleEntryImpl.setStatus(status);

		sampleEntryImpl.resetOriginalValues();

		return sampleEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		entryId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readBoolean();
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

		objectOutput.writeLong(entryId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long entryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public String title;
	public String content;
	public long createDate;
	public long modifiedDate;
	public boolean status;
}