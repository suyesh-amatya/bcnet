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

package com.bcnet.portlet.biobank.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author suyama
 * @generated
 */
public class SampleCollectionContactPK implements Comparable<SampleCollectionContactPK>,
	Serializable {
	public long sampleCollectionDbId;
	public long userId;

	public SampleCollectionContactPK() {
	}

	public SampleCollectionContactPK(long sampleCollectionDbId, long userId) {
		this.sampleCollectionDbId = sampleCollectionDbId;
		this.userId = userId;
	}

	public long getSampleCollectionDbId() {
		return sampleCollectionDbId;
	}

	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		this.sampleCollectionDbId = sampleCollectionDbId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int compareTo(SampleCollectionContactPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (sampleCollectionDbId < pk.sampleCollectionDbId) {
			value = -1;
		}
		else if (sampleCollectionDbId > pk.sampleCollectionDbId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionContactPK)) {
			return false;
		}

		SampleCollectionContactPK pk = (SampleCollectionContactPK)obj;

		if ((sampleCollectionDbId == pk.sampleCollectionDbId) &&
				(userId == pk.userId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(sampleCollectionDbId) + String.valueOf(userId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("sampleCollectionDbId");
		sb.append(StringPool.EQUAL);
		sb.append(sampleCollectionDbId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}