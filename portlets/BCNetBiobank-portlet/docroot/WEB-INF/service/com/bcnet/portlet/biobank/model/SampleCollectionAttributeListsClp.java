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
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suyama
 */
public class SampleCollectionAttributeListsClp extends BaseModelImpl<SampleCollectionAttributeLists>
	implements SampleCollectionAttributeLists {
	public SampleCollectionAttributeListsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionAttributeLists.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionAttributeLists.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sampleCollectionAttributeListsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleCollectionAttributeListsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleCollectionAttributeListsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionAttributeListsId",
			getSampleCollectionAttributeListsId());
		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionAttributeListsId = (Long)attributes.get(
				"sampleCollectionAttributeListsId");

		if (sampleCollectionAttributeListsId != null) {
			setSampleCollectionAttributeListsId(sampleCollectionAttributeListsId);
		}

		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		String attributeListName = (String)attributes.get("attributeListName");

		if (attributeListName != null) {
			setAttributeListName(attributeListName);
		}

		String attributeListValue = (String)attributes.get("attributeListValue");

		if (attributeListValue != null) {
			setAttributeListValue(attributeListValue);
		}
	}

	@Override
	public long getSampleCollectionAttributeListsId() {
		return _sampleCollectionAttributeListsId;
	}

	@Override
	public void setSampleCollectionAttributeListsId(
		long sampleCollectionAttributeListsId) {
		_sampleCollectionAttributeListsId = sampleCollectionAttributeListsId;

		if (_sampleCollectionAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionAttributeListsId",
						long.class);

				method.invoke(_sampleCollectionAttributeListsRemoteModel,
					sampleCollectionAttributeListsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;

		if (_sampleCollectionAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionDbId",
						long.class);

				method.invoke(_sampleCollectionAttributeListsRemoteModel,
					sampleCollectionDbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttributeListName() {
		return _attributeListName;
	}

	@Override
	public void setAttributeListName(String attributeListName) {
		_attributeListName = attributeListName;

		if (_sampleCollectionAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListName",
						String.class);

				method.invoke(_sampleCollectionAttributeListsRemoteModel,
					attributeListName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttributeListValue() {
		return _attributeListValue;
	}

	@Override
	public void setAttributeListValue(String attributeListValue) {
		_attributeListValue = attributeListValue;

		if (_sampleCollectionAttributeListsRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListValue",
						String.class);

				method.invoke(_sampleCollectionAttributeListsRemoteModel,
					attributeListValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleCollectionAttributeListsRemoteModel() {
		return _sampleCollectionAttributeListsRemoteModel;
	}

	public void setSampleCollectionAttributeListsRemoteModel(
		BaseModel<?> sampleCollectionAttributeListsRemoteModel) {
		_sampleCollectionAttributeListsRemoteModel = sampleCollectionAttributeListsRemoteModel;
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

		Class<?> remoteModelClass = _sampleCollectionAttributeListsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sampleCollectionAttributeListsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleCollectionAttributeListsLocalServiceUtil.addSampleCollectionAttributeLists(this);
		}
		else {
			SampleCollectionAttributeListsLocalServiceUtil.updateSampleCollectionAttributeLists(this);
		}
	}

	@Override
	public SampleCollectionAttributeLists toEscapedModel() {
		return (SampleCollectionAttributeLists)ProxyUtil.newProxyInstance(SampleCollectionAttributeLists.class.getClassLoader(),
			new Class[] { SampleCollectionAttributeLists.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleCollectionAttributeListsClp clone = new SampleCollectionAttributeListsClp();

		clone.setSampleCollectionAttributeListsId(getSampleCollectionAttributeListsId());
		clone.setSampleCollectionDbId(getSampleCollectionDbId());
		clone.setAttributeListName(getAttributeListName());
		clone.setAttributeListValue(getAttributeListValue());

		return clone;
	}

	@Override
	public int compareTo(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		int value = 0;

		if (getSampleCollectionDbId() < sampleCollectionAttributeLists.getSampleCollectionDbId()) {
			value = -1;
		}
		else if (getSampleCollectionDbId() > sampleCollectionAttributeLists.getSampleCollectionDbId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getAttributeListName()
					.compareTo(sampleCollectionAttributeLists.getAttributeListName());

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

		if (!(obj instanceof SampleCollectionAttributeListsClp)) {
			return false;
		}

		SampleCollectionAttributeListsClp sampleCollectionAttributeLists = (SampleCollectionAttributeListsClp)obj;

		long primaryKey = sampleCollectionAttributeLists.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{sampleCollectionAttributeListsId=");
		sb.append(getSampleCollectionAttributeListsId());
		sb.append(", sampleCollectionDbId=");
		sb.append(getSampleCollectionDbId());
		sb.append(", attributeListName=");
		sb.append(getAttributeListName());
		sb.append(", attributeListValue=");
		sb.append(getAttributeListValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sampleCollectionAttributeListsId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionAttributeListsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionDbId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeListName</column-name><column-value><![CDATA[");
		sb.append(getAttributeListName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeListValue</column-name><column-value><![CDATA[");
		sb.append(getAttributeListValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sampleCollectionAttributeListsId;
	private long _sampleCollectionDbId;
	private String _attributeListName;
	private String _attributeListValue;
	private BaseModel<?> _sampleCollectionAttributeListsRemoteModel;
}