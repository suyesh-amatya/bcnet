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

import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.ClpSerializer;

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
public class BiobankAttributeListsMasterClp extends BaseModelImpl<BiobankAttributeListsMaster>
	implements BiobankAttributeListsMaster {
	public BiobankAttributeListsMasterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankAttributeListsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankAttributeListsMaster.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _biobankAttributeListsMasterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankAttributeListsMasterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankAttributeListsMasterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankAttributeListsMasterId",
			getBiobankAttributeListsMasterId());
		attributes.put("attributeListName", getAttributeListName());
		attributes.put("attributeListValue", getAttributeListValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankAttributeListsMasterId = (Long)attributes.get(
				"biobankAttributeListsMasterId");

		if (biobankAttributeListsMasterId != null) {
			setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);
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
	public long getBiobankAttributeListsMasterId() {
		return _biobankAttributeListsMasterId;
	}

	@Override
	public void setBiobankAttributeListsMasterId(
		long biobankAttributeListsMasterId) {
		_biobankAttributeListsMasterId = biobankAttributeListsMasterId;

		if (_biobankAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankAttributeListsMasterId",
						long.class);

				method.invoke(_biobankAttributeListsMasterRemoteModel,
					biobankAttributeListsMasterId);
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

		if (_biobankAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListName",
						String.class);

				method.invoke(_biobankAttributeListsMasterRemoteModel,
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

		if (_biobankAttributeListsMasterRemoteModel != null) {
			try {
				Class<?> clazz = _biobankAttributeListsMasterRemoteModel.getClass();

				Method method = clazz.getMethod("setAttributeListValue",
						String.class);

				method.invoke(_biobankAttributeListsMasterRemoteModel,
					attributeListValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBiobankAttributeListsMasterRemoteModel() {
		return _biobankAttributeListsMasterRemoteModel;
	}

	public void setBiobankAttributeListsMasterRemoteModel(
		BaseModel<?> biobankAttributeListsMasterRemoteModel) {
		_biobankAttributeListsMasterRemoteModel = biobankAttributeListsMasterRemoteModel;
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

		Class<?> remoteModelClass = _biobankAttributeListsMasterRemoteModel.getClass();

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

		Object returnValue = method.invoke(_biobankAttributeListsMasterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiobankAttributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster(this);
		}
		else {
			BiobankAttributeListsMasterLocalServiceUtil.updateBiobankAttributeListsMaster(this);
		}
	}

	@Override
	public BiobankAttributeListsMaster toEscapedModel() {
		return (BiobankAttributeListsMaster)ProxyUtil.newProxyInstance(BiobankAttributeListsMaster.class.getClassLoader(),
			new Class[] { BiobankAttributeListsMaster.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiobankAttributeListsMasterClp clone = new BiobankAttributeListsMasterClp();

		clone.setBiobankAttributeListsMasterId(getBiobankAttributeListsMasterId());
		clone.setAttributeListName(getAttributeListName());
		clone.setAttributeListValue(getAttributeListValue());

		return clone;
	}

	@Override
	public int compareTo(
		BiobankAttributeListsMaster biobankAttributeListsMaster) {
		long primaryKey = biobankAttributeListsMaster.getPrimaryKey();

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

		if (!(obj instanceof BiobankAttributeListsMasterClp)) {
			return false;
		}

		BiobankAttributeListsMasterClp biobankAttributeListsMaster = (BiobankAttributeListsMasterClp)obj;

		long primaryKey = biobankAttributeListsMaster.getPrimaryKey();

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

		sb.append("{biobankAttributeListsMasterId=");
		sb.append(getBiobankAttributeListsMasterId());
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
		sb.append("com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankAttributeListsMasterId</column-name><column-value><![CDATA[");
		sb.append(getBiobankAttributeListsMasterId());
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

	private long _biobankAttributeListsMasterId;
	private String _attributeListName;
	private String _attributeListValue;
	private BaseModel<?> _biobankAttributeListsMasterRemoteModel;
	private Class<?> _clpSerializerClass = com.bcnet.portlet.biobank.service.ClpSerializer.class;
}