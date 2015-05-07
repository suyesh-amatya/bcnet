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
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;

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
public class SampleCollectionClp extends BaseModelImpl<SampleCollection>
	implements SampleCollection {
	public SampleCollectionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SampleCollection.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollection.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleCollectionDbId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("sampleCollectionId", getSampleCollectionId());
		attributes.put("acronym", getAcronym());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("consentTemplate", getConsentTemplate());
		attributes.put("reuseOfSamples", getReuseOfSamples());
		attributes.put("materialTransferAgreement",
			getMaterialTransferAgreement());
		attributes.put("accreditation", getAccreditation());
		attributes.put("qualityControl", getQualityControl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		String sampleCollectionId = (String)attributes.get("sampleCollectionId");

		if (sampleCollectionId != null) {
			setSampleCollectionId(sampleCollectionId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean consentTemplate = (Boolean)attributes.get("consentTemplate");

		if (consentTemplate != null) {
			setConsentTemplate(consentTemplate);
		}

		Boolean reuseOfSamples = (Boolean)attributes.get("reuseOfSamples");

		if (reuseOfSamples != null) {
			setReuseOfSamples(reuseOfSamples);
		}

		Boolean materialTransferAgreement = (Boolean)attributes.get(
				"materialTransferAgreement");

		if (materialTransferAgreement != null) {
			setMaterialTransferAgreement(materialTransferAgreement);
		}

		Boolean accreditation = (Boolean)attributes.get("accreditation");

		if (accreditation != null) {
			setAccreditation(accreditation);
		}

		Boolean qualityControl = (Boolean)attributes.get("qualityControl");

		if (qualityControl != null) {
			setQualityControl(qualityControl);
		}
	}

	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionDbId",
						long.class);

				method.invoke(_sampleCollectionRemoteModel, sampleCollectionDbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSampleCollectionId() {
		return _sampleCollectionId;
	}

	@Override
	public void setSampleCollectionId(String sampleCollectionId) {
		_sampleCollectionId = sampleCollectionId;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionId",
						String.class);

				method.invoke(_sampleCollectionRemoteModel, sampleCollectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAcronym() {
		return _acronym;
	}

	@Override
	public void setAcronym(String acronym) {
		_acronym = acronym;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setAcronym", String.class);

				method.invoke(_sampleCollectionRemoteModel, acronym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_sampleCollectionRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_sampleCollectionRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getConsentTemplate() {
		return _consentTemplate;
	}

	@Override
	public boolean isConsentTemplate() {
		return _consentTemplate;
	}

	@Override
	public void setConsentTemplate(boolean consentTemplate) {
		_consentTemplate = consentTemplate;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setConsentTemplate",
						boolean.class);

				method.invoke(_sampleCollectionRemoteModel, consentTemplate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReuseOfSamples() {
		return _reuseOfSamples;
	}

	@Override
	public boolean isReuseOfSamples() {
		return _reuseOfSamples;
	}

	@Override
	public void setReuseOfSamples(boolean reuseOfSamples) {
		_reuseOfSamples = reuseOfSamples;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setReuseOfSamples",
						boolean.class);

				method.invoke(_sampleCollectionRemoteModel, reuseOfSamples);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMaterialTransferAgreement() {
		return _materialTransferAgreement;
	}

	@Override
	public boolean isMaterialTransferAgreement() {
		return _materialTransferAgreement;
	}

	@Override
	public void setMaterialTransferAgreement(boolean materialTransferAgreement) {
		_materialTransferAgreement = materialTransferAgreement;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialTransferAgreement",
						boolean.class);

				method.invoke(_sampleCollectionRemoteModel,
					materialTransferAgreement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAccreditation() {
		return _accreditation;
	}

	@Override
	public boolean isAccreditation() {
		return _accreditation;
	}

	@Override
	public void setAccreditation(boolean accreditation) {
		_accreditation = accreditation;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setAccreditation",
						boolean.class);

				method.invoke(_sampleCollectionRemoteModel, accreditation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getQualityControl() {
		return _qualityControl;
	}

	@Override
	public boolean isQualityControl() {
		return _qualityControl;
	}

	@Override
	public void setQualityControl(boolean qualityControl) {
		_qualityControl = qualityControl;

		if (_sampleCollectionRemoteModel != null) {
			try {
				Class<?> clazz = _sampleCollectionRemoteModel.getClass();

				Method method = clazz.getMethod("setQualityControl",
						boolean.class);

				method.invoke(_sampleCollectionRemoteModel, qualityControl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeLists() {
		try {
			String methodName = "getSampleCollectionAttributeLists";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> returnObj =
				(java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSampleCollectionRemoteModel() {
		return _sampleCollectionRemoteModel;
	}

	public void setSampleCollectionRemoteModel(
		BaseModel<?> sampleCollectionRemoteModel) {
		_sampleCollectionRemoteModel = sampleCollectionRemoteModel;
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

		Class<?> remoteModelClass = _sampleCollectionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sampleCollectionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleCollectionLocalServiceUtil.addSampleCollection(this);
		}
		else {
			SampleCollectionLocalServiceUtil.updateSampleCollection(this);
		}
	}

	@Override
	public SampleCollection toEscapedModel() {
		return (SampleCollection)ProxyUtil.newProxyInstance(SampleCollection.class.getClassLoader(),
			new Class[] { SampleCollection.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleCollectionClp clone = new SampleCollectionClp();

		clone.setSampleCollectionDbId(getSampleCollectionDbId());
		clone.setSampleCollectionId(getSampleCollectionId());
		clone.setAcronym(getAcronym());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setConsentTemplate(getConsentTemplate());
		clone.setReuseOfSamples(getReuseOfSamples());
		clone.setMaterialTransferAgreement(getMaterialTransferAgreement());
		clone.setAccreditation(getAccreditation());
		clone.setQualityControl(getQualityControl());

		return clone;
	}

	@Override
	public int compareTo(SampleCollection sampleCollection) {
		long primaryKey = sampleCollection.getPrimaryKey();

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

		if (!(obj instanceof SampleCollectionClp)) {
			return false;
		}

		SampleCollectionClp sampleCollection = (SampleCollectionClp)obj;

		long primaryKey = sampleCollection.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{sampleCollectionDbId=");
		sb.append(getSampleCollectionDbId());
		sb.append(", sampleCollectionId=");
		sb.append(getSampleCollectionId());
		sb.append(", acronym=");
		sb.append(getAcronym());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", consentTemplate=");
		sb.append(getConsentTemplate());
		sb.append(", reuseOfSamples=");
		sb.append(getReuseOfSamples());
		sb.append(", materialTransferAgreement=");
		sb.append(getMaterialTransferAgreement());
		sb.append(", accreditation=");
		sb.append(getAccreditation());
		sb.append(", qualityControl=");
		sb.append(getQualityControl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.SampleCollection");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sampleCollectionDbId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>acronym</column-name><column-value><![CDATA[");
		sb.append(getAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consentTemplate</column-name><column-value><![CDATA[");
		sb.append(getConsentTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reuseOfSamples</column-name><column-value><![CDATA[");
		sb.append(getReuseOfSamples());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialTransferAgreement</column-name><column-value><![CDATA[");
		sb.append(getMaterialTransferAgreement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accreditation</column-name><column-value><![CDATA[");
		sb.append(getAccreditation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualityControl</column-name><column-value><![CDATA[");
		sb.append(getQualityControl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sampleCollectionDbId;
	private String _sampleCollectionId;
	private String _acronym;
	private String _name;
	private String _description;
	private boolean _consentTemplate;
	private boolean _reuseOfSamples;
	private boolean _materialTransferAgreement;
	private boolean _accreditation;
	private boolean _qualityControl;
	private BaseModel<?> _sampleCollectionRemoteModel;
}