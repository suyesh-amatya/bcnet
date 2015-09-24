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
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil;

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
public class SampleCollectionAttributeListsMasterClp extends BaseModelImpl<SampleCollectionAttributeListsMaster>
	implements SampleCollectionAttributeListsMaster {
	public SampleCollectionAttributeListsMasterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionAttributeListsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionAttributeListsMaster.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sampleCollectionAttributeListsMasterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleCollectionAttributeListsMasterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleCollectionAttributeListsMasterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionAttributeListsMasterId",
			getSampleCollectionAttributeListsMasterId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionAttributeListsMasterId = (Long)attributes.get(
				"sampleCollectionAttributeListsMasterId");

		if (sampleCollectionAttributeListsMasterId != null) {
			setSampleCollectionAttributeListsMasterId(sampleCollectionAttributeListsMasterId);
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
	public long getSampleCollectionAttributeListsMasterId() {
		return _sampleCollectionAttributeListsMasterId;
	}

	@Override
	public void setSampleCollectionAttributeListsMasterId(
		long sampleCollectionAttributeListsMasterId) {
		_sampleCollectionAttributeListsMasterId = sampleCollectionAttributeListsMasterId;

		if (_sampleCollectionAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionAttributeListsMasterId",
						long.class);

				method.invoke(_sampleCollectionAttributeListsMasterRemoteModel,
					sampleCollectionAttributeListsMasterId);
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

		if (_sampleCollectionAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListName",
						String.class);

				method.invoke(_sampleCollectionAttributeListsMasterRemoteModel,
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

		if (_sampleCollectionAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListValue",
						String.class);

				method.invoke(_sampleCollectionAttributeListsMasterRemoteModel,
					attributeListValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleCollectionAttributeListsMasterRemoteModel() {
		return _sampleCollectionAttributeListsMasterRemoteModel;
	}

	public void setSampleCollectionAttributeListsMasterRemoteModel(
		BaseModel<?> sampleCollectionAttributeListsMasterRemoteModel) {
		_sampleCollectionAttributeListsMasterRemoteModel = sampleCollectionAttributeListsMasterRemoteModel;
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

		Class<?> remoteModelClass = _sampleCollectionAttributeListsMasterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sampleCollectionAttributeListsMasterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleCollectionAttributeListsMasterLocalServiceUtil.addSampleCollectionAttributeListsMaster(this);
		}
		else {
			SampleCollectionAttributeListsMasterLocalServiceUtil.updateSampleCollectionAttributeListsMaster(this);
		}
	}

	@Override
	public SampleCollectionAttributeListsMaster toEscapedModel() {
		return (SampleCollectionAttributeListsMaster)ProxyUtil.newProxyInstance(SampleCollectionAttributeListsMaster.class.getClassLoader(),
			new Class[] { SampleCollectionAttributeListsMaster.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleCollectionAttributeListsMasterClp clone = new SampleCollectionAttributeListsMasterClp();

		clone.setSampleCollectionAttributeListsMasterId(getSampleCollectionAttributeListsMasterId());
		clone.setAttributeListName(getAttributeListName());
		clone.setAttributeListValue(getAttributeListValue());

		return clone;
	}

	@Override
	public int compareTo(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		long primaryKey = sampleCollectionAttributeListsMaster.getPrimaryKey();

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

		if (!(obj instanceof SampleCollectionAttributeListsMasterClp)) {
			return false;
		}

		SampleCollectionAttributeListsMasterClp sampleCollectionAttributeListsMaster =
			(SampleCollectionAttributeListsMasterClp)obj;

		long primaryKey = sampleCollectionAttributeListsMaster.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{sampleCollectionAttributeListsMasterId=");
		sb.append(getSampleCollectionAttributeListsMasterId());
		sb.append(", attributeListName=");
		sb.append(getAttributeListName());
		sb.append(", attributeListValue=");
		sb.append(getAttributeListValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sampleCollectionAttributeListsMasterId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionAttributeListsMasterId());
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

	private long _sampleCollectionAttributeListsMasterId;
	private String _attributeListName;
	private String _attributeListValue;
	private BaseModel<?> _sampleCollectionAttributeListsMasterRemoteModel;
	private Class<?> _clpSerializerClass = com.bcnet.portlet.biobank.service.ClpSerializer.class;
}