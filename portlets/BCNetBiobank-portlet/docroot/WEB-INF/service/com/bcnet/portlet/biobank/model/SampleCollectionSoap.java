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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bcnet.portlet.biobank.service.http.SampleCollectionServiceSoap}.
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.http.SampleCollectionServiceSoap
 * @generated
 */
public class SampleCollectionSoap implements Serializable {
	public static SampleCollectionSoap toSoapModel(SampleCollection model) {
		SampleCollectionSoap soapModel = new SampleCollectionSoap();

		soapModel.setSampleCollectionDbId(model.getSampleCollectionDbId());
		soapModel.setSampleCollectionId(model.getSampleCollectionId());
		soapModel.setAcronym(model.getAcronym());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setConsentTemplate(model.getConsentTemplate());
		soapModel.setReuseOfSamples(model.getReuseOfSamples());
		soapModel.setMaterialTransferAgreement(model.getMaterialTransferAgreement());
		soapModel.setAccreditation(model.getAccreditation());
		soapModel.setQualityControl(model.getQualityControl());

		return soapModel;
	}

	public static SampleCollectionSoap[] toSoapModels(SampleCollection[] models) {
		SampleCollectionSoap[] soapModels = new SampleCollectionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionSoap[][] toSoapModels(
		SampleCollection[][] models) {
		SampleCollectionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SampleCollectionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SampleCollectionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SampleCollectionSoap[] toSoapModels(
		List<SampleCollection> models) {
		List<SampleCollectionSoap> soapModels = new ArrayList<SampleCollectionSoap>(models.size());

		for (SampleCollection model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SampleCollectionSoap[soapModels.size()]);
	}

	public SampleCollectionSoap() {
	}

	public long getPrimaryKey() {
		return _sampleCollectionDbId;
	}

	public void setPrimaryKey(long pk) {
		setSampleCollectionDbId(pk);
	}

	public long getSampleCollectionDbId() {
		return _sampleCollectionDbId;
	}

	public void setSampleCollectionDbId(long sampleCollectionDbId) {
		_sampleCollectionDbId = sampleCollectionDbId;
	}

	public String getSampleCollectionId() {
		return _sampleCollectionId;
	}

	public void setSampleCollectionId(String sampleCollectionId) {
		_sampleCollectionId = sampleCollectionId;
	}

	public String getAcronym() {
		return _acronym;
	}

	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getConsentTemplate() {
		return _consentTemplate;
	}

	public boolean isConsentTemplate() {
		return _consentTemplate;
	}

	public void setConsentTemplate(boolean consentTemplate) {
		_consentTemplate = consentTemplate;
	}

	public boolean getReuseOfSamples() {
		return _reuseOfSamples;
	}

	public boolean isReuseOfSamples() {
		return _reuseOfSamples;
	}

	public void setReuseOfSamples(boolean reuseOfSamples) {
		_reuseOfSamples = reuseOfSamples;
	}

	public boolean getMaterialTransferAgreement() {
		return _materialTransferAgreement;
	}

	public boolean isMaterialTransferAgreement() {
		return _materialTransferAgreement;
	}

	public void setMaterialTransferAgreement(boolean materialTransferAgreement) {
		_materialTransferAgreement = materialTransferAgreement;
	}

	public boolean getAccreditation() {
		return _accreditation;
	}

	public boolean isAccreditation() {
		return _accreditation;
	}

	public void setAccreditation(boolean accreditation) {
		_accreditation = accreditation;
	}

	public boolean getQualityControl() {
		return _qualityControl;
	}

	public boolean isQualityControl() {
		return _qualityControl;
	}

	public void setQualityControl(boolean qualityControl) {
		_qualityControl = qualityControl;
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
}