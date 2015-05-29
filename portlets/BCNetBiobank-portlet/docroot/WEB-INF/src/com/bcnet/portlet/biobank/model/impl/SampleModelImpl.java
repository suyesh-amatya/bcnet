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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.SampleModel;
import com.bcnet.portlet.biobank.model.SampleSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Sample service. Represents a row in the &quot;sample&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bcnet.portlet.biobank.model.SampleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SampleImpl}.
 * </p>
 *
 * @author suyama
 * @see SampleImpl
 * @see com.bcnet.portlet.biobank.model.Sample
 * @see com.bcnet.portlet.biobank.model.SampleModel
 * @generated
 */
@JSON(strict = true)
public class SampleModelImpl extends BaseModelImpl<Sample>
	implements SampleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sample model instance should use the {@link com.bcnet.portlet.biobank.model.Sample} interface instead.
	 */
	public static final String TABLE_NAME = "sample";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sampleId", Types.BIGINT },
			{ "sampleCollectionDbId", Types.BIGINT },
			{ "biobankDbId", Types.BIGINT },
			{ "hashedSampleId", Types.VARCHAR },
			{ "materialType", Types.VARCHAR },
			{ "container", Types.VARCHAR },
			{ "storageTemperature", Types.VARCHAR },
			{ "sampledTime", Types.VARCHAR },
			{ "anatomicalPartOntology", Types.VARCHAR },
			{ "anatomicalPartOntologyVersion", Types.VARCHAR },
			{ "anatomicalPartOntologyCode", Types.VARCHAR },
			{ "anatomicalPartDescription", Types.VARCHAR },
			{ "anatomicalPartFreeText", Types.VARCHAR },
			{ "sex", Types.VARCHAR },
			{ "ageHigh", Types.BIGINT },
			{ "ageLow", Types.BIGINT },
			{ "ageUnit", Types.VARCHAR },
			{ "diseaseOntology", Types.VARCHAR },
			{ "diseaseOntologyVersion", Types.VARCHAR },
			{ "diseaseOntologyCode", Types.VARCHAR },
			{ "diseaseDescription", Types.VARCHAR },
			{ "diseaseFreeText", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table sample (sampleId LONG not null primary key,sampleCollectionDbId LONG,biobankDbId LONG,hashedSampleId VARCHAR(75) null,materialType VARCHAR(75) null,container VARCHAR(75) null,storageTemperature VARCHAR(75) null,sampledTime VARCHAR(75) null,anatomicalPartOntology VARCHAR(75) null,anatomicalPartOntologyVersion VARCHAR(75) null,anatomicalPartOntologyCode VARCHAR(75) null,anatomicalPartDescription VARCHAR(75) null,anatomicalPartFreeText VARCHAR(75) null,sex VARCHAR(75) null,ageHigh LONG,ageLow LONG,ageUnit VARCHAR(75) null,diseaseOntology VARCHAR(75) null,diseaseOntologyVersion VARCHAR(75) null,diseaseOntologyCode VARCHAR(75) null,diseaseDescription VARCHAR(75) null,diseaseFreeText VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table sample";
	public static final String ORDER_BY_JPQL = " ORDER BY sample.sampleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY sample.sampleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bcnet.portlet.biobank.model.Sample"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bcnet.portlet.biobank.model.Sample"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Sample toModel(SampleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Sample model = new SampleImpl();

		model.setSampleId(soapModel.getSampleId());
		model.setSampleCollectionDbId(soapModel.getSampleCollectionDbId());
		model.setBiobankDbId(soapModel.getBiobankDbId());
		model.setHashedSampleId(soapModel.getHashedSampleId());
		model.setMaterialType(soapModel.getMaterialType());
		model.setContainer(soapModel.getContainer());
		model.setStorageTemperature(soapModel.getStorageTemperature());
		model.setSampledTime(soapModel.getSampledTime());
		model.setAnatomicalPartOntology(soapModel.getAnatomicalPartOntology());
		model.setAnatomicalPartOntologyVersion(soapModel.getAnatomicalPartOntologyVersion());
		model.setAnatomicalPartOntologyCode(soapModel.getAnatomicalPartOntologyCode());
		model.setAnatomicalPartDescription(soapModel.getAnatomicalPartDescription());
		model.setAnatomicalPartFreeText(soapModel.getAnatomicalPartFreeText());
		model.setSex(soapModel.getSex());
		model.setAgeHigh(soapModel.getAgeHigh());
		model.setAgeLow(soapModel.getAgeLow());
		model.setAgeUnit(soapModel.getAgeUnit());
		model.setDiseaseOntology(soapModel.getDiseaseOntology());
		model.setDiseaseOntologyVersion(soapModel.getDiseaseOntologyVersion());
		model.setDiseaseOntologyCode(soapModel.getDiseaseOntologyCode());
		model.setDiseaseDescription(soapModel.getDiseaseDescription());
		model.setDiseaseFreeText(soapModel.getDiseaseFreeText());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Sample> toModels(SampleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Sample> models = new ArrayList<Sample>(soapModels.length);

		for (SampleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bcnet.portlet.biobank.model.Sample"));

	public SampleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _sampleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSampleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sampleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sampleId", getSampleId());
		attributes.put("sampleCollectionDbId", getSampleCollectionDbId());
		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("hashedSampleId", getHashedSampleId());
		attributes.put("materialType", getMaterialType());
		attributes.put("container", getContainer());
		attributes.put("storageTemperature", getStorageTemperature());
		attributes.put("sampledTime", getSampledTime());
		attributes.put("anatomicalPartOntology", getAnatomicalPartOntology());
		attributes.put("anatomicalPartOntologyVersion",
			getAnatomicalPartOntologyVersion());
		attributes.put("anatomicalPartOntologyCode",
			getAnatomicalPartOntologyCode());
		attributes.put("anatomicalPartDescription",
			getAnatomicalPartDescription());
		attributes.put("anatomicalPartFreeText", getAnatomicalPartFreeText());
		attributes.put("sex", getSex());
		attributes.put("ageHigh", getAgeHigh());
		attributes.put("ageLow", getAgeLow());
		attributes.put("ageUnit", getAgeUnit());
		attributes.put("diseaseOntology", getDiseaseOntology());
		attributes.put("diseaseOntologyVersion", getDiseaseOntologyVersion());
		attributes.put("diseaseOntologyCode", getDiseaseOntologyCode());
		attributes.put("diseaseDescription", getDiseaseDescription());
		attributes.put("diseaseFreeText", getDiseaseFreeText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sampleId = (Long)attributes.get("sampleId");

		if (sampleId != null) {
			setSampleId(sampleId);
		}

		Long sampleCollectionDbId = (Long)attributes.get("sampleCollectionDbId");

		if (sampleCollectionDbId != null) {
			setSampleCollectionDbId(sampleCollectionDbId);
		}

		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String hashedSampleId = (String)attributes.get("hashedSampleId");

		if (hashedSampleId != null) {
			setHashedSampleId(hashedSampleId);
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

		String sampledTime = (String)attributes.get("sampledTime");

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

		String anatomicalPartDescription = (String)attributes.get(
				"anatomicalPartDescription");

		if (anatomicalPartDescription != null) {
			setAnatomicalPartDescription(anatomicalPartDescription);
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

		String diseaseDescription = (String)attributes.get("diseaseDescription");

		if (diseaseDescription != null) {
			setDiseaseDescription(diseaseDescription);
		}

		String diseaseFreeText = (String)attributes.get("diseaseFreeText");

		if (diseaseFreeText != null) {
			setDiseaseFreeText(diseaseFreeText);
		}
	}

	@JSON
	@Override
	public long getSampleId() {
		return _sampleId;
	}

	@Override
	public void setSampleId(long sampleId) {
		_sampleId = sampleId;
	}

	@JSON
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;
	}

	@JSON
	@Override
	public long getBiobankDbId() {
		return _biobankDbId;
	}

	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;
	}

	@JSON
	@Override
	public String getHashedSampleId() {
		if (_hashedSampleId == null) {
			return StringPool.BLANK;
		}
		else {
			return _hashedSampleId;
		}
	}

	@Override
	public void setHashedSampleId(String hashedSampleId) {
		_hashedSampleId = hashedSampleId;
	}

	@JSON
	@Override
	public String getMaterialType() {
		if (_materialType == null) {
			return StringPool.BLANK;
		}
		else {
			return _materialType;
		}
	}

	@Override
	public void setMaterialType(String materialType) {
		_materialType = materialType;
	}

	@JSON
	@Override
	public String getContainer() {
		if (_container == null) {
			return StringPool.BLANK;
		}
		else {
			return _container;
		}
	}

	@Override
	public void setContainer(String container) {
		_container = container;
	}

	@JSON
	@Override
	public String getStorageTemperature() {
		if (_storageTemperature == null) {
			return StringPool.BLANK;
		}
		else {
			return _storageTemperature;
		}
	}

	@Override
	public void setStorageTemperature(String storageTemperature) {
		_storageTemperature = storageTemperature;
	}

	@JSON
	@Override
	public String getSampledTime() {
		if (_sampledTime == null) {
			return StringPool.BLANK;
		}
		else {
			return _sampledTime;
		}
	}

	@Override
	public void setSampledTime(String sampledTime) {
		_sampledTime = sampledTime;
	}

	@JSON
	@Override
	public String getAnatomicalPartOntology() {
		if (_anatomicalPartOntology == null) {
			return StringPool.BLANK;
		}
		else {
			return _anatomicalPartOntology;
		}
	}

	@Override
	public void setAnatomicalPartOntology(String anatomicalPartOntology) {
		_anatomicalPartOntology = anatomicalPartOntology;
	}

	@JSON
	@Override
	public String getAnatomicalPartOntologyVersion() {
		if (_anatomicalPartOntologyVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _anatomicalPartOntologyVersion;
		}
	}

	@Override
	public void setAnatomicalPartOntologyVersion(
		String anatomicalPartOntologyVersion) {
		_anatomicalPartOntologyVersion = anatomicalPartOntologyVersion;
	}

	@JSON
	@Override
	public String getAnatomicalPartOntologyCode() {
		if (_anatomicalPartOntologyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _anatomicalPartOntologyCode;
		}
	}

	@Override
	public void setAnatomicalPartOntologyCode(String anatomicalPartOntologyCode) {
		_anatomicalPartOntologyCode = anatomicalPartOntologyCode;
	}

	@JSON
	@Override
	public String getAnatomicalPartDescription() {
		if (_anatomicalPartDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _anatomicalPartDescription;
		}
	}

	@Override
	public void setAnatomicalPartDescription(String anatomicalPartDescription) {
		_anatomicalPartDescription = anatomicalPartDescription;
	}

	@JSON
	@Override
	public String getAnatomicalPartFreeText() {
		if (_anatomicalPartFreeText == null) {
			return StringPool.BLANK;
		}
		else {
			return _anatomicalPartFreeText;
		}
	}

	@Override
	public void setAnatomicalPartFreeText(String anatomicalPartFreeText) {
		_anatomicalPartFreeText = anatomicalPartFreeText;
	}

	@JSON
	@Override
	public String getSex() {
		if (_sex == null) {
			return StringPool.BLANK;
		}
		else {
			return _sex;
		}
	}

	@Override
	public void setSex(String sex) {
		_sex = sex;
	}

	@JSON
	@Override
	public long getAgeHigh() {
		return _ageHigh;
	}

	@Override
	public void setAgeHigh(long ageHigh) {
		_ageHigh = ageHigh;
	}

	@JSON
	@Override
	public long getAgeLow() {
		return _ageLow;
	}

	@Override
	public void setAgeLow(long ageLow) {
		_ageLow = ageLow;
	}

	@JSON
	@Override
	public String getAgeUnit() {
		if (_ageUnit == null) {
			return StringPool.BLANK;
		}
		else {
			return _ageUnit;
		}
	}

	@Override
	public void setAgeUnit(String ageUnit) {
		_ageUnit = ageUnit;
	}

	@JSON
	@Override
	public String getDiseaseOntology() {
		if (_diseaseOntology == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseaseOntology;
		}
	}

	@Override
	public void setDiseaseOntology(String diseaseOntology) {
		_diseaseOntology = diseaseOntology;
	}

	@JSON
	@Override
	public String getDiseaseOntologyVersion() {
		if (_diseaseOntologyVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseaseOntologyVersion;
		}
	}

	@Override
	public void setDiseaseOntologyVersion(String diseaseOntologyVersion) {
		_diseaseOntologyVersion = diseaseOntologyVersion;
	}

	@JSON
	@Override
	public String getDiseaseOntologyCode() {
		if (_diseaseOntologyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseaseOntologyCode;
		}
	}

	@Override
	public void setDiseaseOntologyCode(String diseaseOntologyCode) {
		_diseaseOntologyCode = diseaseOntologyCode;
	}

	@JSON
	@Override
	public String getDiseaseDescription() {
		if (_diseaseDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseaseDescription;
		}
	}

	@Override
	public void setDiseaseDescription(String diseaseDescription) {
		_diseaseDescription = diseaseDescription;
	}

	@JSON
	@Override
	public String getDiseaseFreeText() {
		if (_diseaseFreeText == null) {
			return StringPool.BLANK;
		}
		else {
			return _diseaseFreeText;
		}
	}

	@Override
	public void setDiseaseFreeText(String diseaseFreeText) {
		_diseaseFreeText = diseaseFreeText;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Sample.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Sample toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Sample)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SampleImpl sampleImpl = new SampleImpl();

		sampleImpl.setSampleId(getSampleId());
		sampleImpl.setSampleCollectionDbId(getSampleCollectionDbId());
		sampleImpl.setBiobankDbId(getBiobankDbId());
		sampleImpl.setHashedSampleId(getHashedSampleId());
		sampleImpl.setMaterialType(getMaterialType());
		sampleImpl.setContainer(getContainer());
		sampleImpl.setStorageTemperature(getStorageTemperature());
		sampleImpl.setSampledTime(getSampledTime());
		sampleImpl.setAnatomicalPartOntology(getAnatomicalPartOntology());
		sampleImpl.setAnatomicalPartOntologyVersion(getAnatomicalPartOntologyVersion());
		sampleImpl.setAnatomicalPartOntologyCode(getAnatomicalPartOntologyCode());
		sampleImpl.setAnatomicalPartDescription(getAnatomicalPartDescription());
		sampleImpl.setAnatomicalPartFreeText(getAnatomicalPartFreeText());
		sampleImpl.setSex(getSex());
		sampleImpl.setAgeHigh(getAgeHigh());
		sampleImpl.setAgeLow(getAgeLow());
		sampleImpl.setAgeUnit(getAgeUnit());
		sampleImpl.setDiseaseOntology(getDiseaseOntology());
		sampleImpl.setDiseaseOntologyVersion(getDiseaseOntologyVersion());
		sampleImpl.setDiseaseOntologyCode(getDiseaseOntologyCode());
		sampleImpl.setDiseaseDescription(getDiseaseDescription());
		sampleImpl.setDiseaseFreeText(getDiseaseFreeText());

		sampleImpl.resetOriginalValues();

		return sampleImpl;
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

		if (!(obj instanceof Sample)) {
			return false;
		}

		Sample sample = (Sample)obj;

		long primaryKey = sample.getPrimaryKey();

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Sample> toCacheModel() {
		SampleCacheModel sampleCacheModel = new SampleCacheModel();

		sampleCacheModel.sampleId = getSampleId();

		sampleCacheModel.sampleCollectionDbId = getSampleCollectionDbId();

		sampleCacheModel.biobankDbId = getBiobankDbId();

		sampleCacheModel.hashedSampleId = getHashedSampleId();

		String hashedSampleId = sampleCacheModel.hashedSampleId;

		if ((hashedSampleId != null) && (hashedSampleId.length() == 0)) {
			sampleCacheModel.hashedSampleId = null;
		}

		sampleCacheModel.materialType = getMaterialType();

		String materialType = sampleCacheModel.materialType;

		if ((materialType != null) && (materialType.length() == 0)) {
			sampleCacheModel.materialType = null;
		}

		sampleCacheModel.container = getContainer();

		String container = sampleCacheModel.container;

		if ((container != null) && (container.length() == 0)) {
			sampleCacheModel.container = null;
		}

		sampleCacheModel.storageTemperature = getStorageTemperature();

		String storageTemperature = sampleCacheModel.storageTemperature;

		if ((storageTemperature != null) && (storageTemperature.length() == 0)) {
			sampleCacheModel.storageTemperature = null;
		}

		sampleCacheModel.sampledTime = getSampledTime();

		String sampledTime = sampleCacheModel.sampledTime;

		if ((sampledTime != null) && (sampledTime.length() == 0)) {
			sampleCacheModel.sampledTime = null;
		}

		sampleCacheModel.anatomicalPartOntology = getAnatomicalPartOntology();

		String anatomicalPartOntology = sampleCacheModel.anatomicalPartOntology;

		if ((anatomicalPartOntology != null) &&
				(anatomicalPartOntology.length() == 0)) {
			sampleCacheModel.anatomicalPartOntology = null;
		}

		sampleCacheModel.anatomicalPartOntologyVersion = getAnatomicalPartOntologyVersion();

		String anatomicalPartOntologyVersion = sampleCacheModel.anatomicalPartOntologyVersion;

		if ((anatomicalPartOntologyVersion != null) &&
				(anatomicalPartOntologyVersion.length() == 0)) {
			sampleCacheModel.anatomicalPartOntologyVersion = null;
		}

		sampleCacheModel.anatomicalPartOntologyCode = getAnatomicalPartOntologyCode();

		String anatomicalPartOntologyCode = sampleCacheModel.anatomicalPartOntologyCode;

		if ((anatomicalPartOntologyCode != null) &&
				(anatomicalPartOntologyCode.length() == 0)) {
			sampleCacheModel.anatomicalPartOntologyCode = null;
		}

		sampleCacheModel.anatomicalPartDescription = getAnatomicalPartDescription();

		String anatomicalPartDescription = sampleCacheModel.anatomicalPartDescription;

		if ((anatomicalPartDescription != null) &&
				(anatomicalPartDescription.length() == 0)) {
			sampleCacheModel.anatomicalPartDescription = null;
		}

		sampleCacheModel.anatomicalPartFreeText = getAnatomicalPartFreeText();

		String anatomicalPartFreeText = sampleCacheModel.anatomicalPartFreeText;

		if ((anatomicalPartFreeText != null) &&
				(anatomicalPartFreeText.length() == 0)) {
			sampleCacheModel.anatomicalPartFreeText = null;
		}

		sampleCacheModel.sex = getSex();

		String sex = sampleCacheModel.sex;

		if ((sex != null) && (sex.length() == 0)) {
			sampleCacheModel.sex = null;
		}

		sampleCacheModel.ageHigh = getAgeHigh();

		sampleCacheModel.ageLow = getAgeLow();

		sampleCacheModel.ageUnit = getAgeUnit();

		String ageUnit = sampleCacheModel.ageUnit;

		if ((ageUnit != null) && (ageUnit.length() == 0)) {
			sampleCacheModel.ageUnit = null;
		}

		sampleCacheModel.diseaseOntology = getDiseaseOntology();

		String diseaseOntology = sampleCacheModel.diseaseOntology;

		if ((diseaseOntology != null) && (diseaseOntology.length() == 0)) {
			sampleCacheModel.diseaseOntology = null;
		}

		sampleCacheModel.diseaseOntologyVersion = getDiseaseOntologyVersion();

		String diseaseOntologyVersion = sampleCacheModel.diseaseOntologyVersion;

		if ((diseaseOntologyVersion != null) &&
				(diseaseOntologyVersion.length() == 0)) {
			sampleCacheModel.diseaseOntologyVersion = null;
		}

		sampleCacheModel.diseaseOntologyCode = getDiseaseOntologyCode();

		String diseaseOntologyCode = sampleCacheModel.diseaseOntologyCode;

		if ((diseaseOntologyCode != null) &&
				(diseaseOntologyCode.length() == 0)) {
			sampleCacheModel.diseaseOntologyCode = null;
		}

		sampleCacheModel.diseaseDescription = getDiseaseDescription();

		String diseaseDescription = sampleCacheModel.diseaseDescription;

		if ((diseaseDescription != null) && (diseaseDescription.length() == 0)) {
			sampleCacheModel.diseaseDescription = null;
		}

		sampleCacheModel.diseaseFreeText = getDiseaseFreeText();

		String diseaseFreeText = sampleCacheModel.diseaseFreeText;

		if ((diseaseFreeText != null) && (diseaseFreeText.length() == 0)) {
			sampleCacheModel.diseaseFreeText = null;
		}

		return sampleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{sampleId=");
		sb.append(getSampleId());
		sb.append(", sampleCollectionDbId=");
		sb.append(getSampleCollectionDbId());
		sb.append(", biobankDbId=");
		sb.append(getBiobankDbId());
		sb.append(", hashedSampleId=");
		sb.append(getHashedSampleId());
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
		sb.append(", anatomicalPartDescription=");
		sb.append(getAnatomicalPartDescription());
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
		sb.append(", diseaseDescription=");
		sb.append(getDiseaseDescription());
		sb.append(", diseaseFreeText=");
		sb.append(getDiseaseFreeText());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.Sample");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sampleId</column-name><column-value><![CDATA[");
		sb.append(getSampleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleCollectionDbId</column-name><column-value><![CDATA[");
		sb.append(getSampleCollectionDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biobankDbId</column-name><column-value><![CDATA[");
		sb.append(getBiobankDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hashedSampleId</column-name><column-value><![CDATA[");
		sb.append(getHashedSampleId());
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
			"<column><column-name>anatomicalPartDescription</column-name><column-value><![CDATA[");
		sb.append(getAnatomicalPartDescription());
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
			"<column><column-name>diseaseDescription</column-name><column-value><![CDATA[");
		sb.append(getDiseaseDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diseaseFreeText</column-name><column-value><![CDATA[");
		sb.append(getDiseaseFreeText());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Sample.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Sample.class };
	private long _sampleId;
	private long _sampleCollectionDbId;
	private long _biobankDbId;
	private String _hashedSampleId;
	private String _materialType;
	private String _container;
	private String _storageTemperature;
	private String _sampledTime;
	private String _anatomicalPartOntology;
	private String _anatomicalPartOntologyVersion;
	private String _anatomicalPartOntologyCode;
	private String _anatomicalPartDescription;
	private String _anatomicalPartFreeText;
	private String _sex;
	private long _ageHigh;
	private long _ageLow;
	private String _ageUnit;
	private String _diseaseOntology;
	private String _diseaseOntologyVersion;
	private String _diseaseOntologyCode;
	private String _diseaseDescription;
	private String _diseaseFreeText;
	private Sample _escapedModel;
}