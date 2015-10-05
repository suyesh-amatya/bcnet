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
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suyama
 */
public class SampleClp extends BaseModelImpl<Sample> implements Sample {
	public SampleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Sample.class;
	}

	@Override
	public String getModelClassName() {
		return Sample.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sampleDbId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleDbId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleDbId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid_", getUuid_());
		attributes.put("sampleDbId", getSampleDbId());
		attributes.put("sampleCollectionId", getSampleCollectionId());
		attributes.put("biobankId", getBiobankId());
		attributes.put("hashedSampleId", getHashedSampleId());
		attributes.put("hashedIndividualId", getHashedIndividualId());
		attributes.put("materialType", getMaterialType());
		attributes.put("container", getContainer());
		attributes.put("storageTemperature", getStorageTemperature());
		attributes.put("sampledTime", getSampledTime());
		attributes.put("anatomicalPartOntology", getAnatomicalPartOntology());
		attributes.put("anatomicalPartOntologyVersion",
			getAnatomicalPartOntologyVersion());
		attributes.put("anatomicalPartOntologyCode",
			getAnatomicalPartOntologyCode());
		attributes.put("anatomicalPartOntologyDescription",
			getAnatomicalPartOntologyDescription());
		attributes.put("anatomicalPartFreeText", getAnatomicalPartFreeText());
		attributes.put("sex", getSex());
		attributes.put("ageHigh", getAgeHigh());
		attributes.put("ageLow", getAgeLow());
		attributes.put("ageUnit", getAgeUnit());
		attributes.put("diseaseOntology", getDiseaseOntology());
		attributes.put("diseaseOntologyVersion", getDiseaseOntologyVersion());
		attributes.put("diseaseOntologyCode", getDiseaseOntologyCode());
		attributes.put("diseaseOntologyDescription",
			getDiseaseOntologyDescription());
		attributes.put("diseaseFreeText", getDiseaseFreeText());
		attributes.put("countryOfOrigin", getCountryOfOrigin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long sampleDbId = (Long)attributes.get("sampleDbId");

		if (sampleDbId != null) {
			setSampleDbId(sampleDbId);
		}

		String sampleCollectionId = (String)attributes.get("sampleCollectionId");

		if (sampleCollectionId != null) {
			setSampleCollectionId(sampleCollectionId);
		}

		String biobankId = (String)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		String hashedSampleId = (String)attributes.get("hashedSampleId");

		if (hashedSampleId != null) {
			setHashedSampleId(hashedSampleId);
		}

		String hashedIndividualId = (String)attributes.get("hashedIndividualId");

		if (hashedIndividualId != null) {
			setHashedIndividualId(hashedIndividualId);
		}

		String materialType = (String)attributes.get("materialType");

		if (materialType != null) {
			setMaterialType(materialType);
		}

		String container = (String)attributes.get("container");

		if (container != null) {
			setContainer(container);
		}

		String storageTemperature = (String)attributes.get("storageTemperature");

		if (storageTemperature != null) {
			setStorageTemperature(storageTemperature);
		}

		Date sampledTime = (Date)attributes.get("sampledTime");

		if (sampledTime != null) {
			setSampledTime(sampledTime);
		}

		String anatomicalPartOntology = (String)attributes.get(
				"anatomicalPartOntology");

		if (anatomicalPartOntology != null) {
			setAnatomicalPartOntology(anatomicalPartOntology);
		}

		String anatomicalPartOntologyVersion = (String)attributes.get(
				"anatomicalPartOntologyVersion");

		if (anatomicalPartOntologyVersion != null) {
			setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);
		}

		String anatomicalPartOntologyCode = (String)attributes.get(
				"anatomicalPartOntologyCode");

		if (anatomicalPartOntologyCode != null) {
			setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);
		}

		String anatomicalPartOntologyDescription = (String)attributes.get(
				"anatomicalPartOntologyDescription");

		if (anatomicalPartOntologyDescription != null) {
			setAnatomicalPartOntologyDescription(anatomicalPartOntologyDescription);
		}

		String anatomicalPartFreeText = (String)attributes.get(
				"anatomicalPartFreeText");

		if (anatomicalPartFreeText != null) {
			setAnatomicalPartFreeText(anatomicalPartFreeText);
		}

		String sex = (String)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		Long ageHigh = (Long)attributes.get("ageHigh");

		if (ageHigh != null) {
			setAgeHigh(ageHigh);
		}

		Long ageLow = (Long)attributes.get("ageLow");

		if (ageLow != null) {
			setAgeLow(ageLow);
		}

		String ageUnit = (String)attributes.get("ageUnit");

		if (ageUnit != null) {
			setAgeUnit(ageUnit);
		}

		String diseaseOntology = (String)attributes.get("diseaseOntology");

		if (diseaseOntology != null) {
			setDiseaseOntology(diseaseOntology);
		}

		String diseaseOntologyVersion = (String)attributes.get(
				"diseaseOntologyVersion");

		if (diseaseOntologyVersion != null) {
			setDiseaseOntologyVersion(diseaseOntologyVersion);
		}

		String diseaseOntologyCode = (String)attributes.get(
				"diseaseOntologyCode");

		if (diseaseOntologyCode != null) {
			setDiseaseOntologyCode(diseaseOntologyCode);
		}

		String diseaseOntologyDescription = (String)attributes.get(
				"diseaseOntologyDescription");

		if (diseaseOntologyDescription != null) {
			setDiseaseOntologyDescription(diseaseOntologyDescription);
		}

		String diseaseFreeText = (String)attributes.get("diseaseFreeText");

		if (diseaseFreeText != null) {
			setDiseaseFreeText(diseaseFreeText);
		}

		String countryOfOrigin = (String)attributes.get("countryOfOrigin");

		if (countryOfOrigin != null) {
			setCountryOfOrigin(countryOfOrigin);
		}
	}

	@Override
	public String getUuid_() {
		return _uuid_;
	}

	@Override
	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid_", String.class);

				method.invoke(_sampleRemoteModel, uuid_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSampleDbId() {
		return _sampleDbId;
	}

	@Override
	public void setSampleDbId(long sampleDbId) {
		_sampleDbId = sampleDbId;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleDbId", long.class);

				method.invoke(_sampleRemoteModel, sampleDbId);
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

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleCollectionId",
						String.class);

				method.invoke(_sampleRemoteModel, sampleCollectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiobankId() {
		return _biobankId;
	}

	@Override
	public void setBiobankId(String biobankId) {
		_biobankId = biobankId;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankId", String.class);

				method.invoke(_sampleRemoteModel, biobankId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHashedSampleId() {
		return _hashedSampleId;
	}

	@Override
	public void setHashedSampleId(String hashedSampleId) {
		_hashedSampleId = hashedSampleId;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setHashedSampleId",
						String.class);

				method.invoke(_sampleRemoteModel, hashedSampleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHashedIndividualId() {
		return _hashedIndividualId;
	}

	@Override
	public void setHashedIndividualId(String hashedIndividualId) {
		_hashedIndividualId = hashedIndividualId;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setHashedIndividualId",
						String.class);

				method.invoke(_sampleRemoteModel, hashedIndividualId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaterialType() {
		return _materialType;
	}

	@Override
	public void setMaterialType(String materialType) {
		_materialType = materialType;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialType", String.class);

				method.invoke(_sampleRemoteModel, materialType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContainer() {
		return _container;
	}

	@Override
	public void setContainer(String container) {
		_container = container;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setContainer", String.class);

				method.invoke(_sampleRemoteModel, container);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStorageTemperature() {
		return _storageTemperature;
	}

	@Override
	public void setStorageTemperature(String storageTemperature) {
		_storageTemperature = storageTemperature;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setStorageTemperature",
						String.class);

				method.invoke(_sampleRemoteModel, storageTemperature);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSampledTime() {
		return _sampledTime;
	}

	@Override
	public void setSampledTime(Date sampledTime) {
		_sampledTime = sampledTime;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setSampledTime", Date.class);

				method.invoke(_sampleRemoteModel, sampledTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnatomicalPartOntology() {
		return _anatomicalPartOntology;
	}

	@Override
	public void setAnatomicalPartOntology(String anatomicalPartOntology) {
		_anatomicalPartOntology = anatomicalPartOntology;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnatomicalPartOntology",
						String.class);

				method.invoke(_sampleRemoteModel, anatomicalPartOntology);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnatomicalPartOntologyVersion() {
		return _anatomicalPartOntologyVersion;
	}

	@Override
	public void setAnatomicalPartOntologyVersion(
		String anatomicalPartOntologyVersion) {
		_anatomicalPartOntologyVersion = anatomicalPartOntologyVersion;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnatomicalPartOntologyVersion",
						String.class);

				method.invoke(_sampleRemoteModel, anatomicalPartOntologyVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnatomicalPartOntologyCode() {
		return _anatomicalPartOntologyCode;
	}

	@Override
	public void setAnatomicalPartOntologyCode(String anatomicalPartOntologyCode) {
		_anatomicalPartOntologyCode = anatomicalPartOntologyCode;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnatomicalPartOntologyCode",
						String.class);

				method.invoke(_sampleRemoteModel, anatomicalPartOntologyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnatomicalPartOntologyDescription() {
		return _anatomicalPartOntologyDescription;
	}

	@Override
	public void setAnatomicalPartOntologyDescription(
		String anatomicalPartOntologyDescription) {
		_anatomicalPartOntologyDescription = anatomicalPartOntologyDescription;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnatomicalPartOntologyDescription",
						String.class);

				method.invoke(_sampleRemoteModel,
					anatomicalPartOntologyDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnatomicalPartFreeText() {
		return _anatomicalPartFreeText;
	}

	@Override
	public void setAnatomicalPartFreeText(String anatomicalPartFreeText) {
		_anatomicalPartFreeText = anatomicalPartFreeText;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAnatomicalPartFreeText",
						String.class);

				method.invoke(_sampleRemoteModel, anatomicalPartFreeText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSex() {
		return _sex;
	}

	@Override
	public void setSex(String sex) {
		_sex = sex;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setSex", String.class);

				method.invoke(_sampleRemoteModel, sex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAgeHigh() {
		return _ageHigh;
	}

	@Override
	public void setAgeHigh(long ageHigh) {
		_ageHigh = ageHigh;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeHigh", long.class);

				method.invoke(_sampleRemoteModel, ageHigh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAgeLow() {
		return _ageLow;
	}

	@Override
	public void setAgeLow(long ageLow) {
		_ageLow = ageLow;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeLow", long.class);

				method.invoke(_sampleRemoteModel, ageLow);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgeUnit() {
		return _ageUnit;
	}

	@Override
	public void setAgeUnit(String ageUnit) {
		_ageUnit = ageUnit;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeUnit", String.class);

				method.invoke(_sampleRemoteModel, ageUnit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseaseOntology() {
		return _diseaseOntology;
	}

	@Override
	public void setDiseaseOntology(String diseaseOntology) {
		_diseaseOntology = diseaseOntology;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseaseOntology",
						String.class);

				method.invoke(_sampleRemoteModel, diseaseOntology);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseaseOntologyVersion() {
		return _diseaseOntologyVersion;
	}

	@Override
	public void setDiseaseOntologyVersion(String diseaseOntologyVersion) {
		_diseaseOntologyVersion = diseaseOntologyVersion;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseaseOntologyVersion",
						String.class);

				method.invoke(_sampleRemoteModel, diseaseOntologyVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseaseOntologyCode() {
		return _diseaseOntologyCode;
	}

	@Override
	public void setDiseaseOntologyCode(String diseaseOntologyCode) {
		_diseaseOntologyCode = diseaseOntologyCode;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseaseOntologyCode",
						String.class);

				method.invoke(_sampleRemoteModel, diseaseOntologyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseaseOntologyDescription() {
		return _diseaseOntologyDescription;
	}

	@Override
	public void setDiseaseOntologyDescription(String diseaseOntologyDescription) {
		_diseaseOntologyDescription = diseaseOntologyDescription;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseaseOntologyDescription",
						String.class);

				method.invoke(_sampleRemoteModel, diseaseOntologyDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiseaseFreeText() {
		return _diseaseFreeText;
	}

	@Override
	public void setDiseaseFreeText(String diseaseFreeText) {
		_diseaseFreeText = diseaseFreeText;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setDiseaseFreeText",
						String.class);

				method.invoke(_sampleRemoteModel, diseaseFreeText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryOfOrigin() {
		return _countryOfOrigin;
	}

	@Override
	public void setCountryOfOrigin(String countryOfOrigin) {
		_countryOfOrigin = countryOfOrigin;

		if (_sampleRemoteModel != null) {
			try {
				Class<?> clazz = _sampleRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryOfOrigin",
						String.class);

				method.invoke(_sampleRemoteModel, countryOfOrigin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSampleRemoteModel() {
		return _sampleRemoteModel;
	}

	public void setSampleRemoteModel(BaseModel<?> sampleRemoteModel) {
		_sampleRemoteModel = sampleRemoteModel;
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

		Class<?> remoteModelClass = _sampleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sampleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SampleLocalServiceUtil.addSample(this);
		}
		else {
			SampleLocalServiceUtil.updateSample(this);
		}
	}

	@Override
	public Sample toEscapedModel() {
		return (Sample)ProxyUtil.newProxyInstance(Sample.class.getClassLoader(),
			new Class[] { Sample.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SampleClp clone = new SampleClp();

		clone.setUuid_(getUuid_());
		clone.setSampleDbId(getSampleDbId());
		clone.setSampleCollectionId(getSampleCollectionId());
		clone.setBiobankId(getBiobankId());
		clone.setHashedSampleId(getHashedSampleId());
		clone.setHashedIndividualId(getHashedIndividualId());
		clone.setMaterialType(getMaterialType());
		clone.setContainer(getContainer());
		clone.setStorageTemperature(getStorageTemperature());
		clone.setSampledTime(getSampledTime());
		clone.setAnatomicalPartOntology(getAnatomicalPartOntology());
		clone.setAnatomicalPartOntologyVersion(getAnatomicalPartOntologyVersion());
		clone.setAnatomicalPartOntologyCode(getAnatomicalPartOntologyCode());
		clone.setAnatomicalPartOntologyDescription(getAnatomicalPartOntologyDescription());
		clone.setAnatomicalPartFreeText(getAnatomicalPartFreeText());
		clone.setSex(getSex());
		clone.setAgeHigh(getAgeHigh());
		clone.setAgeLow(getAgeLow());
		clone.setAgeUnit(getAgeUnit());
		clone.setDiseaseOntology(getDiseaseOntology());
		clone.setDiseaseOntologyVersion(getDiseaseOntologyVersion());
		clone.setDiseaseOntologyCode(getDiseaseOntologyCode());
		clone.setDiseaseOntologyDescription(getDiseaseOntologyDescription());
		clone.setDiseaseFreeText(getDiseaseFreeText());
		clone.setCountryOfOrigin(getCountryOfOrigin());

		return clone;
	}

	@Override
	public int compareTo(Sample sample) {
		long primaryKey = sample.getPrimaryKey();

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

		if (!(obj instanceof SampleClp)) {
			return false;
		}

		SampleClp sample = (SampleClp)obj;

		long primaryKey = sample.getPrimaryKey();

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
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid_=");
		sb.append(getUuid_());
		sb.append(", sampleDbId=");
		sb.append(getSampleDbId());
		sb.append(", sampleCollectionId=");
		sb.append(getSampleCollectionId());
		sb.append(", biobankId=");
		sb.append(getBiobankId());
		sb.append(", hashedSampleId=");
		sb.append(getHashedSampleId());
		sb.append(", hashedIndividualId=");
		sb.append(getHashedIndividualId());
		sb.append(", materialType=");
		sb.append(getMaterialType());
		sb.append(", container=");
		sb.append(getContainer());
		sb.append(", storageTemperature=");
		sb.append(getStorageTemperature());
		sb.append(", sampledTime=");
		sb.append(getSampledTime());
		sb.append(", anatomicalPartOntology=");
		sb.append(getAnatomicalPartOntology());
		sb.append(", anatomicalPartOntologyVersion=");
		sb.append(getAnatomicalPartOntologyVersion());
		sb.append(", anatomicalPartOntologyCode=");
		sb.append(getAnatomicalPartOntologyCode());
		sb.append(", anatomicalPartOntologyDescription=");
		sb.append(getAnatomicalPartOntologyDescription());
		sb.append(", anatomicalPartFreeText=");
		sb.append(getAnatomicalPartFreeText());
		sb.append(", sex=");
		sb.append(getSex());
		sb.append(", ageHigh=");
		sb.append(getAgeHigh());
		sb.append(", ageLow=");
		sb.append(getAgeLow());
		sb.append(", ageUnit=");
		sb.append(getAgeUnit());
		sb.append(", diseaseOntology=");
		sb.append(getDiseaseOntology());
		sb.append(", diseaseOntologyVersion=");
		sb.append(getDiseaseOntologyVersion());
		sb.append(", diseaseOntologyCode=");
		sb.append(getDiseaseOntologyCode());
		sb.append(", diseaseOntologyDescription=");
		sb.append(getDiseaseOntologyDescription());
		sb.append(", diseaseFreeText=");
		sb.append(getDiseaseFreeText());
		sb.append(", countryOfOrigin=");
		sb.append(getCountryOfOrigin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.Sample");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid_</column-name><column-value><![CDATA[");
		sb.append(getUuid_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleDbId</column-name><column-value><![CDATA[");
		sb.append(getSampleDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankId</column-name><column-value><![CDATA[");
		sb.append(getBiobankId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hashedSampleId</column-name><column-value><![CDATA[");
		sb.append(getHashedSampleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hashedIndividualId</column-name><column-value><![CDATA[");
		sb.append(getHashedIndividualId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materialType</column-name><column-value><![CDATA[");
		sb.append(getMaterialType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>container</column-name><column-value><![CDATA[");
		sb.append(getContainer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storageTemperature</column-name><column-value><![CDATA[");
		sb.append(getStorageTemperature());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampledTime</column-name><column-value><![CDATA[");
		sb.append(getSampledTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anatomicalPartOntology</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartOntology());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anatomicalPartOntologyVersion</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartOntologyVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anatomicalPartOntologyCode</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartOntologyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anatomicalPartOntologyDescription</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartOntologyDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anatomicalPartFreeText</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartFreeText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sex</column-name><column-value><![CDATA[");
		sb.append(getSex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageHigh</column-name><column-value><![CDATA[");
		sb.append(getAgeHigh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageLow</column-name><column-value><![CDATA[");
		sb.append(getAgeLow());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageUnit</column-name><column-value><![CDATA[");
		sb.append(getAgeUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseOntology</column-name><column-value><![CDATA[");
		sb.append(getDiseaseOntology());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseOntologyVersion</column-name><column-value><![CDATA[");
		sb.append(getDiseaseOntologyVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseOntologyCode</column-name><column-value><![CDATA[");
		sb.append(getDiseaseOntologyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseOntologyDescription</column-name><column-value><![CDATA[");
		sb.append(getDiseaseOntologyDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseFreeText</column-name><column-value><![CDATA[");
		sb.append(getDiseaseFreeText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryOfOrigin</column-name><column-value><![CDATA[");
		sb.append(getCountryOfOrigin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid_;
	private long _sampleDbId;
	private String _sampleCollectionId;
	private String _biobankId;
	private String _hashedSampleId;
	private String _hashedIndividualId;
	private String _materialType;
	private String _container;
	private String _storageTemperature;
	private Date _sampledTime;
	private String _anatomicalPartOntology;
	private String _anatomicalPartOntologyVersion;
	private String _anatomicalPartOntologyCode;
	private String _anatomicalPartOntologyDescription;
	private String _anatomicalPartFreeText;
	private String _sex;
	private long _ageHigh;
	private long _ageLow;
	private String _ageUnit;
	private String _diseaseOntology;
	private String _diseaseOntologyVersion;
	private String _diseaseOntologyCode;
	private String _diseaseOntologyDescription;
	private String _diseaseFreeText;
	private String _countryOfOrigin;
	private BaseModel<?> _sampleRemoteModel;
	private Class<?> _clpSerializerClass = com.bcnet.portlet.biobank.service.ClpSerializer.class;
}