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

import com.bcnet.portlet.biobank.model.SampleCollectionContact;
import com.bcnet.portlet.biobank.model.SampleCollectionContactModel;
import com.bcnet.portlet.biobank.model.SampleCollectionContactSoap;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SampleCollectionContact service. Represents a row in the &quot;samplecollectioncontact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.bcnet.portlet.biobank.model.SampleCollectionContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SampleCollectionContactImpl}.
 * </p>
 *
 * @author suyama
 * @see SampleCollectionContactImpl
 * @see com.bcnet.portlet.biobank.model.SampleCollectionContact
 * @see com.bcnet.portlet.biobank.model.SampleCollectionContactModel
 * @generated
 */
@JSON(strict = true)
public class SampleCollectionContactModelImpl extends BaseModelImpl<SampleCollectionContact>
	implements SampleCollectionContactModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sample collection contact model instance should use the {@link com.bcnet.portlet.biobank.model.SampleCollectionContact} interface instead.
	 */
	public static final String TABLE_NAME = "samplecollectioncontact";
	public static final Object[][] TABLE_COLUMNS = {
			{ "sampleCollectionDbId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "mainContact", Types.BOOLEAN },
			{ "sampleCollectionOwner", Types.BOOLEAN },
			{ "sampleCollectionEditor", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table samplecollectioncontact (sampleCollectionDbId LONG not null,userId LONG not null,mainContact BOOLEAN,sampleCollectionOwner BOOLEAN,sampleCollectionEditor BOOLEAN,primary key (sampleCollectionDbId, userId))";
	public static final String TABLE_SQL_DROP = "drop table samplecollectioncontact";
	public static final String ORDER_BY_JPQL = " ORDER BY sampleCollectionContact.id.sampleCollectionDbId ASC, sampleCollectionContact.id.userId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY samplecollectioncontact.sampleCollectionDbId ASC, samplecollectioncontact.userId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollectionContact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.bcnet.portlet.biobank.model.SampleCollectionContact"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.bcnet.portlet.biobank.model.SampleCollectionContact"),
			true);
	public static long MAINCONTACT_COLUMN_BITMASK = 1L;
	public static long SAMPLECOLLECTIONDBID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SampleCollectionContact toModel(
		SampleCollectionContactSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SampleCollectionContact model = new SampleCollectionContactImpl();

		model.setSampleCollectionDbId(soapModel.getSampleCollectionDbId());
		model.setUserId(soapModel.getUserId());
		model.setMainContact(soapModel.getMainContact());
		model.setSampleCollectionOwner(soapModel.getSampleCollectionOwner());
		model.setSampleCollectionEditor(soapModel.getSampleCollectionEditor());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SampleCollectionContact> toModels(
		SampleCollectionContactSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SampleCollectionContact> models = new ArrayList<SampleCollectionContact>(soapModels.length);

		for (SampleCollectionContactSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.bcnet.portlet.biobank.model.SampleCollectionContact"));

	public SampleCollectionContactModelImpl() {
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
	public Class<?> getModelClass() {
		return SampleCollectionContact.class;
	}

	@Override
	public String getModelClassName() {
		return SampleCollectionContact.class.getName();
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

	@JSON
	@Override
	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	@Override
	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_columnBitmask |= SAMPLECOLLECTIONDBID_COLUMN_BITMASK;

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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
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
		_columnBitmask |= MAINCONTACT_COLUMN_BITMASK;

		if (!_setOriginalMainContact) {
			_setOriginalMainContact = true;

			_originalMainContact = _mainContact;
		}

		_mainContact = mainContact;
	}

	public boolean getOriginalMainContact() {
		return _originalMainContact;
	}

	@JSON
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
	}

	@JSON
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public SampleCollectionContact toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SampleCollectionContact)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SampleCollectionContactImpl sampleCollectionContactImpl = new SampleCollectionContactImpl();

		sampleCollectionContactImpl.setSampleCollectionDbId(getSampleCollectionDbId());
		sampleCollectionContactImpl.setUserId(getUserId());
		sampleCollectionContactImpl.setMainContact(getMainContact());
		sampleCollectionContactImpl.setSampleCollectionOwner(getSampleCollectionOwner());
		sampleCollectionContactImpl.setSampleCollectionEditor(getSampleCollectionEditor());

		sampleCollectionContactImpl.resetOriginalValues();

		return sampleCollectionContactImpl;
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

		if (!(obj instanceof SampleCollectionContact)) {
			return false;
		}

		SampleCollectionContact sampleCollectionContact = (SampleCollectionContact)obj;

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
	public void resetOriginalValues() {
		SampleCollectionContactModelImpl sampleCollectionContactModelImpl = this;

		sampleCollectionContactModelImpl._originalSampleCollectionDbId = sampleCollectionContactModelImpl._sampleCollectionDbId;

		sampleCollectionContactModelImpl._setOriginalSampleCollectionDbId = false;

		sampleCollectionContactModelImpl._originalMainContact = sampleCollectionContactModelImpl._mainContact;

		sampleCollectionContactModelImpl._setOriginalMainContact = false;

		sampleCollectionContactModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SampleCollectionContact> toCacheModel() {
		SampleCollectionContactCacheModel sampleCollectionContactCacheModel = new SampleCollectionContactCacheModel();

		sampleCollectionContactCacheModel.sampleCollectionDbId = getSampleCollectionDbId();

		sampleCollectionContactCacheModel.userId = getUserId();

		sampleCollectionContactCacheModel.mainContact = getMainContact();

		sampleCollectionContactCacheModel.sampleCollectionOwner = getSampleCollectionOwner();

		sampleCollectionContactCacheModel.sampleCollectionEditor = getSampleCollectionEditor();

		return sampleCollectionContactCacheModel;
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

	private static ClassLoader _classLoader = SampleCollectionContact.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SampleCollectionContact.class
		};
	private long _sampleCollectionDbId;
	private long _originalSampleCollectionDbId;
	private boolean _setOriginalSampleCollectionDbId;
	private long _userId;
	private String _userUuid;
	private boolean _mainContact;
	private boolean _originalMainContact;
	private boolean _setOriginalMainContact;
	private boolean _sampleCollectionOwner;
	private boolean _sampleCollectionEditor;
	private long _columnBitmask;
	private SampleCollectionContact _escapedModel;
}