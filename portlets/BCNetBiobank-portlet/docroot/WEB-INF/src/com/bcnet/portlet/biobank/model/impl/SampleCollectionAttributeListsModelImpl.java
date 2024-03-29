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

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsModel;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsSoap;

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
 * The base model implementation for the SampleCollectionAttributeLists service. Represents a row in the &quot;samplecollectionattributelists&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SampleCollectionAttributeListsImpl}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsImpl
 * @see com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists
 * @see com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsModel
 * @generated
 */
@JSON(strict = true)
public class SampleCollectionAttributeListsModelImpl extends BaseModelImpl<SampleCollectionAttributeLists>
	implements SampleCollectionAttributeListsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sample collection attribute lists model instance should use the {@link com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists} interface instead.
	 */
	public static final String TABLE_NAME = "samplecollectionattributelists";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sampleCollectionAttributeListsId", Types.BIGINT },
			{ "sampleCollectionDbId", Types.BIGINT },
			{ "attributeListName", Types.VARCHAR },
			{ "attributeListValue", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table samplecollectionattributelists (sampleCollectionAttributeListsId LONG not null primary key,sampleCollectionDbId LONG,attributeListName VARCHAR(75) null,attributeListValue VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table samplecollectionattributelists";
	public static final String ORDER_BY_JPQL = " ORDER BY sampleCollectionAttributeLists.sampleCollectionDbId ASC, sampleCollectionAttributeLists.attributeListName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY samplecollectionattributelists.sampleCollectionDbId ASC, samplecollectionattributelists.attributeListName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists"),
			true);
	public static long ATTRIBUTELISTNAME_COLUMN_BITMASK = 1L;
	public static long ATTRIBUTELISTVALUE_COLUMN_BITMASK = 2L;
	public static long SAMPLECOLLECTIONDBID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SampleCollectionAttributeLists toModel(
		SampleCollectionAttributeListsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SampleCollectionAttributeLists model = new SampleCollectionAttributeListsImpl();

		model.setSampleCollectionAttributeListsId(soapModel.getSampleCollectionAttributeListsId());
		model.setSampleCollectionDbId(soapModel.getSampleCollectionDbId());
		model.setAttributeListName(soapModel.getAttributeListName());
		model.setAttributeListValue(soapModel.getAttributeListValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SampleCollectionAttributeLists> toModels(
		SampleCollectionAttributeListsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SampleCollectionAttributeLists> models = new ArrayList<SampleCollectionAttributeLists>(soapModels.length);

		for (SampleCollectionAttributeListsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists"));

	public SampleCollectionAttributeListsModelImpl() {
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
	public Class<?> getModelClass() {
		return SampleCollectionAttributeLists.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionAttributeLists.class.getName();
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

	@JSON
	@Override
	public long getSampleCollectionAttributeListsId() {
		return _sampleCollectionAttributeListsId;
	}

	@Override
	public void setSampleCollectionAttributeListsId(
		long sampleCollectionAttributeListsId) {
		_sampleCollectionAttributeListsId = sampleCollectionAttributeListsId;
	}

	@JSON
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_columnBitmask = -1L;

		if (!_setOriginalSampleCollectionDbId) {
			_setOriginalSampleCollectionDbId = true;

			_originalSampleCollectionDbId = _sampleCollectionDbId;
		}

		_sampleCollectionDbId = sampleCollectionDbId;
	}

	public long getOriginalSampleCollectionDbId() {
		return _originalSampleCollectionDbId;
	}

	@JSON
	@Override
	public String getAttributeListName() {
		if (_attributeListName == null) {
			return StringPool.BLANK;
		}
		else {
			return _attributeListName;
		}
	}

	@Override
	public void setAttributeListName(String attributeListName) {
		_columnBitmask = -1L;

		if (_originalAttributeListName == null) {
			_originalAttributeListName = _attributeListName;
		}

		_attributeListName = attributeListName;
	}

	public String getOriginalAttributeListName() {
		return GetterUtil.getString(_originalAttributeListName);
	}

	@JSON
	@Override
	public String getAttributeListValue() {
		if (_attributeListValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _attributeListValue;
		}
	}

	@Override
	public void setAttributeListValue(String attributeListValue) {
		_columnBitmask |= ATTRIBUTELISTVALUE_COLUMN_BITMASK;

		if (_originalAttributeListValue == null) {
			_originalAttributeListValue = _attributeListValue;
		}

		_attributeListValue = attributeListValue;
	}

	public String getOriginalAttributeListValue() {
		return GetterUtil.getString(_originalAttributeListValue);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SampleCollectionAttributeLists.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SampleCollectionAttributeLists toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SampleCollectionAttributeLists)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SampleCollectionAttributeListsImpl sampleCollectionAttributeListsImpl = new SampleCollectionAttributeListsImpl();

		sampleCollectionAttributeListsImpl.setSampleCollectionAttributeListsId(getSampleCollectionAttributeListsId());
		sampleCollectionAttributeListsImpl.setSampleCollectionDbId(getSampleCollectionDbId());
		sampleCollectionAttributeListsImpl.setAttributeListName(getAttributeListName());
		sampleCollectionAttributeListsImpl.setAttributeListValue(getAttributeListValue());

		sampleCollectionAttributeListsImpl.resetOriginalValues();

		return sampleCollectionAttributeListsImpl;
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

		if (!(obj instanceof SampleCollectionAttributeLists)) {
			return false;
		}

		SampleCollectionAttributeLists sampleCollectionAttributeLists = (SampleCollectionAttributeLists)obj;

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
	public void resetOriginalValues() {
		SampleCollectionAttributeListsModelImpl sampleCollectionAttributeListsModelImpl =
			this;

		sampleCollectionAttributeListsModelImpl._originalSampleCollectionDbId = sampleCollectionAttributeListsModelImpl._sampleCollectionDbId;

		sampleCollectionAttributeListsModelImpl._setOriginalSampleCollectionDbId = false;

		sampleCollectionAttributeListsModelImpl._originalAttributeListName = sampleCollectionAttributeListsModelImpl._attributeListName;

		sampleCollectionAttributeListsModelImpl._originalAttributeListValue = sampleCollectionAttributeListsModelImpl._attributeListValue;

		sampleCollectionAttributeListsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SampleCollectionAttributeLists> toCacheModel() {
		SampleCollectionAttributeListsCacheModel sampleCollectionAttributeListsCacheModel =
			new SampleCollectionAttributeListsCacheModel();

		sampleCollectionAttributeListsCacheModel.sampleCollectionAttributeListsId = getSampleCollectionAttributeListsId();

		sampleCollectionAttributeListsCacheModel.sampleCollectionDbId = getSampleCollectionDbId();

		sampleCollectionAttributeListsCacheModel.attributeListName = getAttributeListName();

		String attributeListName = sampleCollectionAttributeListsCacheModel.attributeListName;

		if ((attributeListName != null) && (attributeListName.length() == 0)) {
			sampleCollectionAttributeListsCacheModel.attributeListName = null;
		}

		sampleCollectionAttributeListsCacheModel.attributeListValue = getAttributeListValue();

		String attributeListValue = sampleCollectionAttributeListsCacheModel.attributeListValue;

		if ((attributeListValue != null) && (attributeListValue.length() == 0)) {
			sampleCollectionAttributeListsCacheModel.attributeListValue = null;
		}

		return sampleCollectionAttributeListsCacheModel;
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

	private static ClassLoader _classLoader = SampleCollectionAttributeLists.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SampleCollectionAttributeLists.class
		};
	private long _sampleCollectionAttributeListsId;
	private long _sampleCollectionDbId;
	private long _originalSampleCollectionDbId;
	private boolean _setOriginalSampleCollectionDbId;
	private String _attributeListName;
	private String _originalAttributeListName;
	private String _attributeListValue;
	private String _originalAttributeListValue;
	private long _columnBitmask;
	private SampleCollectionAttributeLists _escapedModel;
}