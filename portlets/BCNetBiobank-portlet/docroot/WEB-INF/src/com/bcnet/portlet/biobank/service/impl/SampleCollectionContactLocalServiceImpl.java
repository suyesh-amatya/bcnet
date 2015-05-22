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

package com.bcnet.portlet.biobank.service.impl;

import java.util.List;

import com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException;
import com.bcnet.portlet.biobank.model.SampleCollectionContact;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.base.SampleCollectionContactLocalServiceBaseImpl;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the sample collection contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.SampleCollectionContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionContactLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil
 */
public class SampleCollectionContactLocalServiceImpl
	extends SampleCollectionContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil} to access the sample collection contact local service.
	 */
	
	public SampleCollectionContact getSampleCollectionContact (long sampleCollectionDbId, long userId) throws SystemException{
		SampleCollectionContactPK sampleCollectionContactPK = new SampleCollectionContactPK(sampleCollectionDbId, userId);
		try {
			return getSampleCollectionContact(sampleCollectionContactPK);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public SampleCollectionContact getSampleCollectionMainContact (long sampleCollectionDbId) throws NoSuchSampleCollectionContactException, SystemException{
		return sampleCollectionContactPersistence.findBysampleCollectionDbId_mainContact(sampleCollectionDbId, true);
	}

	
	public List<SampleCollectionContact> getSampleCollectionContactsBySampleCollectionDbId (long sampleCollectionDbId) throws SystemException{
		
		return sampleCollectionContactPersistence.findBysampleCollectionDbId(sampleCollectionDbId);
	}
	
	
	public void editSampleCollectionMainContact(long sampleCollectionDbId, long sampleCollectionMainContactUserId) throws SystemException{
		SampleCollectionContact sampleCollectionMainContact, sampleCollectionNewMainContact;
		try {
			sampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
			sampleCollectionMainContact.setMainContact(sampleCollectionMainContactUserId == sampleCollectionMainContact.getUserId() ? true : false);
			SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(sampleCollectionMainContact);
			if(sampleCollectionMainContactUserId != sampleCollectionMainContact.getUserId()){
				sampleCollectionNewMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, sampleCollectionMainContactUserId);
				sampleCollectionNewMainContact.setMainContact(true);
				SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(sampleCollectionNewMainContact);
			}
		} catch (NoSuchSampleCollectionContactException e) {
			// TODO Auto-generated catch block
			if(sampleCollectionMainContactUserId > 0){
				sampleCollectionNewMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, sampleCollectionMainContactUserId);
				sampleCollectionNewMainContact.setMainContact(true);
				SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(sampleCollectionNewMainContact);
			}
			
		}
		
	}
}