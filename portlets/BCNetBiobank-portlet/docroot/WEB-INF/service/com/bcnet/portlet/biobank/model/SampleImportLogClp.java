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

import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suyama
 */
public class SampleImportLogClp extends BaseModelImpl<SampleImportLog>
	implements SampleImportLog {
	public SampleImportLogClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SampleImportLog.class;
	}

	@Override
	public String getModelClassName() {
		return SampleImportLog.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _importId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importId", getImportId());
		attributes.put("fileName", getFileName());
		attributes.put("userId", getUserId());
		attributes.put("dateOfImport", getDateOfImport());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importId = (Long)attributes.get("importId");

		if (importId != null) {
			setImportId(importId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date dateOfImport = (Date)attributes.get("dateOfImport");

		if (dateOfImport != null) {
			setDateOfImport(dateOfImport);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_sampleImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _sampleImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_sampleImportLogRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImportId() {
		return _importId;
	}

	@Override
	public void setImportId(long importId) {
		_importId = importId;

		if (_sampleImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _sampleImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setImportId", long.class);

				method.invoke(_sampleImportLogRemoteModel, importId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_sampleImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _sampleImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_sampleImportLogRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_sampleImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _sampleImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_sampleImportLogRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getDateOfImport() {
		return _dateOfImport;
	}

	@Override
	public void setDateOfImport(Date dateOfImport) {
		_dateOfImport = dateOfImport;

		if (_sampleImportLogRemoteModel != null) {
			try {
				Class<?> clazz = _sampleImportLogRemoteModel.getClass();

				Method method = clazz.getMethod("setDateOfImport", Date.class);

				method.invoke(_sampleImportLogRemoteModel, dateOfImport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleImportLogRemoteModel() {
		return _sampleImportLogRemoteModel;
	}

	public void setSampleImportLogRemoteModel(
		BaseModel<?> sampleImportLogRemoteModel) {
		_sampleImportLogRemoteModel = sampleImportLogRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _sampleImportLogRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_sampleImportLogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleImportLogLocalServiceUtil.addSampleImportLog(this);
		}
		else {
			SampleImportLogLocalServiceUtil.updateSampleImportLog(this);
		}
	}

	@Override
	public SampleImportLog toEscapedModel() {
		return (SampleImportLog)ProxyUtil.newProxyInstance(SampleImportLog.class.getClassLoader(),
			new Class[] { SampleImportLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleImportLogClp clone = new SampleImportLogClp();

		clone.setUuid(getUuid());
		clone.setImportId(getImportId());
		clone.setFileName(getFileName());
		clone.setUserId(getUserId());
		clone.setDateOfImport(getDateOfImport());

		return clone;
	}

	@Override
	public int compareTo(SampleImportLog sampleImportLog) {
		long primaryKey = sampleImportLog.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleImportLogClp)) {
			return false;
		}

		SampleImportLogClp sampleImportLog = (SampleImportLogClp)obj;

		long primaryKey = sampleImportLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", importId=");
		sb.append(getImportId());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", dateOfImport=");
		sb.append(getDateOfImport());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.SampleImportLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>importId</column-name><column-value><![CDATA[");
		sb.append(getImportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfImport</column-name><column-value><![CDATA[");
		sb.append(getDateOfImport());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _importId;
	private String _fileName;
	private long _userId;
	private String _userUuid;
	private Date _dateOfImport;
	private BaseModel<?> _sampleImportLogRemoteModel;
}