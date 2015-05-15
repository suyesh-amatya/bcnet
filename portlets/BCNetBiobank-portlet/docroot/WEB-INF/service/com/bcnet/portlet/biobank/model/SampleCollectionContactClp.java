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
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suyama
 */
public class SampleCollectionContactClp extends BaseModelImpl<SampleCollectionContact>
	implements SampleCollectionContact {
	public SampleCollectionContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollectionContact.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionContact.class.getName();
	}

	@Override
	public SampleCollectionContactPK getPrimaryKey() {
		return new SampleCollectionContactPK(_sampleCollectionDbId, _userId);
	}

	@Override
	public void setPrimaryKey(SampleCollectionContactPK primaryKey) {
		setSampleCollectionDbId(primaryKey.sampleCollectionDbId);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SampleCollectionContactPK(_sampleCollectionDbId, _userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SampleCollectionContactPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("userId", getUserId());
		attributes.put("mainContact", getMainContact());
		attributes.put("sampleCollectionOwner", getSampleCollectionOwner());
		attributes.put("sampleCollectionEditor", getSampleCollectionEditor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean mainContact = (Boolean)attributes.get("mainContact");

		if (mainContact != null) {
			setMainContact(mainContact);
		}

		Boolean sampleCollectionOwner = (Boolean)attributes.get(
				"sampleCollectionOwner");

		if (sampleCollectionOwner != null) {
			setSampleCollectionOwner(sampleCollectionOwner);
		}

		Boolean sampleCollectionEditor = (Boolean)attributes.get(
				"sampleCollectionEditor");

		if (sampleCollectionEditor != null) {
			setSampleCollectionEditor(sampleCollectionEditor);
		}
	}

	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;

		if (_sampleCollectionContactRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionDbId",
						long.class);

				method.invoke(_sampleCollectionContactRemoteModel,
					sampleCollectionDbId);
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

		if (_sampleCollectionContactRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionContactRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_sampleCollectionContactRemoteModel, userId);
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
	public boolean getMainContact() {
		return _mainContact;
	}

	@Override
	public boolean isMainContact() {
		return _mainContact;
	}

	@Override
	public void setMainContact(boolean mainContact) {
		_mainContact = mainContact;

		if (_sampleCollectionContactRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMainContact", boolean.class);

				method.invoke(_sampleCollectionContactRemoteModel, mainContact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSampleCollectionOwner() {
		return _sampleCollectionOwner;
	}

	@Override
	public boolean isSampleCollectionOwner() {
		return _sampleCollectionOwner;
	}

	@Override
	public void setSampleCollectionOwner(boolean sampleCollectionOwner) {
		_sampleCollectionOwner = sampleCollectionOwner;

		if (_sampleCollectionContactRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionOwner",
						boolean.class);

				method.invoke(_sampleCollectionContactRemoteModel,
					sampleCollectionOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSampleCollectionEditor() {
		return _sampleCollectionEditor;
	}

	@Override
	public boolean isSampleCollectionEditor() {
		return _sampleCollectionEditor;
	}

	@Override
	public void setSampleCollectionEditor(boolean sampleCollectionEditor) {
		_sampleCollectionEditor = sampleCollectionEditor;

		if (_sampleCollectionContactRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionEditor",
						boolean.class);

				method.invoke(_sampleCollectionContactRemoteModel,
					sampleCollectionEditor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleCollectionContactRemoteModel() {
		return _sampleCollectionContactRemoteModel;
	}

	public void setSampleCollectionContactRemoteModel(
		BaseModel<?> sampleCollectionContactRemoteModel) {
		_sampleCollectionContactRemoteModel = sampleCollectionContactRemoteModel;
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

		Class<?> remoteModelClass = _sampleCollectionContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sampleCollectionContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleCollectionContactLocalServiceUtil.addSampleCollectionContact(this);
		}
		else {
			SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(this);
		}
	}

	@Override
	public SampleCollectionContact toEscapedModel() {
		return (SampleCollectionContact)ProxyUtil.newProxyInstance(SampleCollectionContact.class.getClassLoader(),
			new Class[] { SampleCollectionContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleCollectionContactClp clone = new SampleCollectionContactClp();

		clone.setSampleCollectionDbId(getSampleCollectionDbId());
		clone.setUserId(getUserId());
		clone.setMainContact(getMainContact());
		clone.setSampleCollectionOwner(getSampleCollectionOwner());
		clone.setSampleCollectionEditor(getSampleCollectionEditor());

		return clone;
	}

	@Override
	public int compareTo(SampleCollectionContact sampleCollectionContact) {
		SampleCollectionContactPK primaryKey = sampleCollectionContact.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleCollectionContactClp)) {
			return false;
		}

		SampleCollectionContactClp sampleCollectionContact = (SampleCollectionContactClp)obj;

		SampleCollectionContactPK primaryKey = sampleCollectionContact.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{sampleCollectionDbId=");
		sb.append(getSampleCollectionDbId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", mainContact=");
		sb.append(getMainContact());
		sb.append(", sampleCollectionOwner=");
		sb.append(getSampleCollectionOwner());
		sb.append(", sampleCollectionEditor=");
		sb.append(getSampleCollectionEditor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.SampleCollectionContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sampleCollectionDbId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainContact</column-name><column-value><![CDATA[");
		sb.append(getMainContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionOwner</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionEditor</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionEditor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sampleCollectionDbId;
	private long _userId;
	private String _userUuid;
	private boolean _mainContact;
	private boolean _sampleCollectionOwner;
	private boolean _sampleCollectionEditor;
	private BaseModel<?> _sampleCollectionContactRemoteModel;
}