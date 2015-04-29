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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SampleCollection in entity cache.
 *
 * @author suyama
 * @see SampleCollection
 * @generated
 */
public class SampleCollectionCacheModel implements CacheModel<SampleCollection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{sampleCollectionDbId=");
		sb.append(sampleCollectionDbId);
		sb.append(", sampleCollectionId=");
		sb.append(sampleCollectionId);
		sb.append(", acronym=");
		sb.append(acronym);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", consentTemplate=");
		sb.append(consentTemplate);
		sb.append(", reuseOfSamples=");
		sb.append(reuseOfSamples);
		sb.append(", materialTransferAgreement=");
		sb.append(materialTransferAgreement);
		sb.append(", accreditation=");
		sb.append(accreditation);
		sb.append(", qualityControl=");
		sb.append(qualityControl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SampleCollection toEntityModel() {
		SampleCollectionImpl sampleCollectionImpl = new SampleCollectionImpl();

		sampleCollectionImpl.setSampleCollectionDbId(sampleCollectionDbId);

		if (sampleCollectionId == null) {
			sampleCollectionImpl.setSampleCollectionId(StringPool.BLANK);
		}
		else {
			sampleCollectionImpl.setSampleCollectionId(sampleCollectionId);
		}

		if (acronym == null) {
			sampleCollectionImpl.setAcronym(StringPool.BLANK);
		}
		else {
			sampleCollectionImpl.setAcronym(acronym);
		}

		if (name == null) {
			sampleCollectionImpl.setName(StringPool.BLANK);
		}
		else {
			sampleCollectionImpl.setName(name);
		}

		if (description == null) {
			sampleCollectionImpl.setDescription(StringPool.BLANK);
		}
		else {
			sampleCollectionImpl.setDescription(description);
		}

		sampleCollectionImpl.setConsentTemplate(consentTemplate);
		sampleCollectionImpl.setReuseOfSamples(reuseOfSamples);
		sampleCollectionImpl.setMaterialTransferAgreement(materialTransferAgreement);
		sampleCollectionImpl.setAccreditation(accreditation);
		sampleCollectionImpl.setQualityControl(qualityControl);

		sampleCollectionImpl.resetOriginalValues();

		return sampleCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sampleCollectionDbId = objectInput.readLong();
		sampleCollectionId = objectInput.readUTF();
		acronym = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		consentTemplate = objectInput.readBoolean();
		reuseOfSamples = objectInput.readBoolean();
		materialTransferAgreement = objectInput.readBoolean();
		accreditation = objectInput.readBoolean();
		qualityControl = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sampleCollectionDbId);

		if (sampleCollectionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sampleCollectionId);
		}

		if (acronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronym);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(consentTemplate);
		objectOutput.writeBoolean(reuseOfSamples);
		objectOutput.writeBoolean(materialTransferAgreement);
		objectOutput.writeBoolean(accreditation);
		objectOutput.writeBoolean(qualityControl);
	}

	public long sampleCollectionDbId;
	public String sampleCollectionId;
	public String acronym;
	public String name;
	public String description;
	public boolean consentTemplate;
	public boolean reuseOfSamples;
	public boolean materialTransferAgreement;
	public boolean accreditation;
	public boolean qualityControl;
}