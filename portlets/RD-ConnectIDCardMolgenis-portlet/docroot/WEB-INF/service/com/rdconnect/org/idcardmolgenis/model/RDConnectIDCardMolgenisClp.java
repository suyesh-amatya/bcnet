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

package com.rdconnect.org.idcardmolgenis.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rdconnect.org.idcardmolgenis.service.ClpSerializer;
import com.rdconnect.org.idcardmolgenis.service.RDConnectIDCardMolgenisLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suyeshamatya
 */
public class RDConnectIDCardMolgenisClp extends BaseModelImpl<RDConnectIDCardMolgenis>
	implements RDConnectIDCardMolgenis {
	public RDConnectIDCardMolgenisClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDConnectIDCardMolgenis.class;
	}

	@Override
	public String getModelClassName() {
		return RDConnectIDCardMolgenis.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_rdConnectIDCardMolgenisRemoteModel != null) {
			try {
				Class<?> clazz = _rdConnectIDCardMolgenisRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_rdConnectIDCardMolgenisRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRDConnectIDCardMolgenisRemoteModel() {
		return _rdConnectIDCardMolgenisRemoteModel;
	}

	public void setRDConnectIDCardMolgenisRemoteModel(
		BaseModel<?> rdConnectIDCardMolgenisRemoteModel) {
		_rdConnectIDCardMolgenisRemoteModel = rdConnectIDCardMolgenisRemoteModel;
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

		Class<?> remoteModelClass = _rdConnectIDCardMolgenisRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdConnectIDCardMolgenisRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDConnectIDCardMolgenisLocalServiceUtil.addRDConnectIDCardMolgenis(this);
		}
		else {
			RDConnectIDCardMolgenisLocalServiceUtil.updateRDConnectIDCardMolgenis(this);
		}
	}

	@Override
	public RDConnectIDCardMolgenis toEscapedModel() {
		return (RDConnectIDCardMolgenis)ProxyUtil.newProxyInstance(RDConnectIDCardMolgenis.class.getClassLoader(),
			new Class[] { RDConnectIDCardMolgenis.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDConnectIDCardMolgenisClp clone = new RDConnectIDCardMolgenisClp();

		clone.setId(getId());

		return clone;
	}

	@Override
	public int compareTo(RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		long primaryKey = rdConnectIDCardMolgenis.getPrimaryKey();

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

		if (!(obj instanceof RDConnectIDCardMolgenisClp)) {
			return false;
		}

		RDConnectIDCardMolgenisClp rdConnectIDCardMolgenis = (RDConnectIDCardMolgenisClp)obj;

		long primaryKey = rdConnectIDCardMolgenis.getPrimaryKey();

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
		StringBundler sb = new StringBundler(3);

		sb.append("{id=");
		sb.append(getId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append(
			"com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private BaseModel<?> _rdConnectIDCardMolgenisRemoteModel;
	private Class<?> _clpSerializerClass = com.rdconnect.org.idcardmolgenis.service.ClpSerializer.class;
}