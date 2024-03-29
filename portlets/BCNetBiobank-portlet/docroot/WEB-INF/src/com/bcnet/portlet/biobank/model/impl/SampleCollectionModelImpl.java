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

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.model.SampleCollectionModel;
import com.bcnet.portlet.biobank.model.SampleCollectionSoap;

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
 * The base model implementation for the SampleCollection service. Represents a row in the &quot;samplecollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bcnet.portlet.biobank.model.SampleCollectionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SampleCollectionImpl}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionImpl
 * @see com.bcnet.portlet.biobank.model.SampleCollection
 * @see com.bcnet.portlet.biobank.model.SampleCollectionModel
 * @generated
 */
@JSON(strict = true)
public class SampleCollectionModelImpl extends BaseModelImpl<SampleCollection>
	implements SampleCollectionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sample collection model instance should use the {@link com.bcnet.portlet.biobank.model.SampleCollection} interface instead.
	 */
	public static final String TABLE_NAME = "samplecollection";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sampleCollectionDbId", Types.BIGINT },
			{ "sampleCollectionId", Types.VARCHAR },
			{ "acronym", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "consentTemplate", Types.BOOLEAN },
			{ "reuseOfSamples", Types.BOOLEAN },
			{ "materialTransferAgreement", Types.BOOLEAN },
			{ "accreditation", Types.BOOLEAN },
			{ "qualityControl", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table samplecollection (sampleCollectionDbId LONG not null primary key,sampleCollectionId VARCHAR(75) null,acronym VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null,consentTemplate BOOLEAN,reuseOfSamples BOOLEAN,materialTransferAgreement BOOLEAN,accreditation BOOLEAN,qualityControl BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table samplecollection";
	public static final String ORDER_BY_JPQL = " ORDER BY sampleCollection.sampleCollectionDbId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY samplecollection.sampleCollectionDbId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollection"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollection"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bcnet.portlet.biobank.model.SampleCollection"),
			true);
	public static long SAMPLECOLLECTIONID_COLUMN_BITMASK = 1L;
	public static long SAMPLECOLLECTIONDBID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SampleCollection toModel(SampleCollectionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SampleCollection model = new SampleCollectionImpl();

		model.setSampleCollectionDbId(soapModel.getSampleCollectionDbId());
		model.setSampleCollectionId(soapModel.getSampleCollectionId());
		model.setAcronym(soapModel.getAcronym());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setConsentTemplate(soapModel.getConsentTemplate());
		model.setReuseOfSamples(soapModel.getReuseOfSamples());
		model.setMaterialTransferAgreement(soapModel.getMaterialTransferAgreement());
		model.setAccreditation(soapModel.getAccreditation());
		model.setQualityControl(soapModel.getQualityControl());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SampleCollection> toModels(
		SampleCollectionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SampleCollection> models = new ArrayList<SampleCollection>(soapModels.length);

		for (SampleCollectionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bcnet.portlet.biobank.model.SampleCollection"));

	public SampleCollectionModelImpl() {
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
	public Class<?> getModelClass() {
		return SampleCollection.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollection.class.getName();
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
	public String getSampleCollectionId() {
		if (_sampleCollectionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _sampleCollectionId;
		}
	}

	@Override
	public void setSampleCollectionId(String sampleCollectionId) {
		_columnBitmask |= SAMPLECOLLECTIONID_COLUMN_BITMASK;

		if (_originalSampleCollectionId == null) {
			_originalSampleCollectionId = _sampleCollectionId;
		}

		_sampleCollectionId = sampleCollectionId;
	}

	public String getOriginalSampleCollectionId() {
		return GetterUtil.getString(_originalSampleCollectionId);
	}

	@JSON
	@Override
	public String getAcronym() {
		if (_acronym == null) {
			return StringPool.BLANK;
		}
		else {
			return _acronym;
		}
	}

	@Override
	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SampleCollection.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SampleCollection toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SampleCollection)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SampleCollectionImpl sampleCollectionImpl = new SampleCollectionImpl();

		sampleCollectionImpl.setSampleCollectionDbId(getSampleCollectionDbId());
		sampleCollectionImpl.setSampleCollectionId(getSampleCollectionId());
		sampleCollectionImpl.setAcronym(getAcronym());
		sampleCollectionImpl.setName(getName());
		sampleCollectionImpl.setDescription(getDescription());
		sampleCollectionImpl.setConsentTemplate(getConsentTemplate());
		sampleCollectionImpl.setReuseOfSamples(getReuseOfSamples());
		sampleCollectionImpl.setMaterialTransferAgreement(getMaterialTransferAgreement());
		sampleCollectionImpl.setAccreditation(getAccreditation());
		sampleCollectionImpl.setQualityControl(getQualityControl());

		sampleCollectionImpl.resetOriginalValues();

		return sampleCollectionImpl;
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

		if (!(obj instanceof SampleCollection)) {
			return false;
		}

		SampleCollection sampleCollection = (SampleCollection)obj;

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
	public void resetOriginalValues() {
		SampleCollectionModelImpl sampleCollectionModelImpl = this;

		sampleCollectionModelImpl._originalSampleCollectionId = sampleCollectionModelImpl._sampleCollectionId;

		sampleCollectionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SampleCollection> toCacheModel() {
		SampleCollectionCacheModel sampleCollectionCacheModel = new SampleCollectionCacheModel();

		sampleCollectionCacheModel.sampleCollectionDbId = getSampleCollectionDbId();

		sampleCollectionCacheModel.sampleCollectionId = getSampleCollectionId();

		String sampleCollectionId = sampleCollectionCacheModel.sampleCollectionId;

		if ((sampleCollectionId != null) && (sampleCollectionId.length() == 0)) {
			sampleCollectionCacheModel.sampleCollectionId = null;
		}

		sampleCollectionCacheModel.acronym = getAcronym();

		String acronym = sampleCollectionCacheModel.acronym;

		if ((acronym != null) && (acronym.length() == 0)) {
			sampleCollectionCacheModel.acronym = null;
		}

		sampleCollectionCacheModel.name = getName();

		String name = sampleCollectionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			sampleCollectionCacheModel.name = null;
		}

		sampleCollectionCacheModel.description = getDescription();

		String description = sampleCollectionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			sampleCollectionCacheModel.description = null;
		}

		sampleCollectionCacheModel.consentTemplate = getConsentTemplate();

		sampleCollectionCacheModel.reuseOfSamples = getReuseOfSamples();

		sampleCollectionCacheModel.materialTransferAgreement = getMaterialTransferAgreement();

		sampleCollectionCacheModel.accreditation = getAccreditation();

		sampleCollectionCacheModel.qualityControl = getQualityControl();

		return sampleCollectionCacheModel;
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

	private static ClassLoader _classLoader = SampleCollection.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SampleCollection.class
		};
	private long _sampleCollectionDbId;
	private String _sampleCollectionId;
	private String _originalSampleCollectionId;
	private String _acronym;
	private String _name;
	private String _description;
	private boolean _consentTemplate;
	private boolean _reuseOfSamples;
	private boolean _materialTransferAgreement;
	private boolean _accreditation;
	private boolean _qualityControl;
	private long _columnBitmask;
	private SampleCollection _escapedModel;
}