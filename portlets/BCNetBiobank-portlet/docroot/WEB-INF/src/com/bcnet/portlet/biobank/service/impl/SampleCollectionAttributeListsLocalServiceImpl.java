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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the sample collection attribute lists local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil
 */
public class SampleCollectionAttributeListsLocalServiceImpl
	extends SampleCollectionAttributeListsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil} to access the sample collection attribute lists local service.
	 */
	
	
	public List<SampleCollectionAttributeLists> getSampleCollectionAttributeListsBySampleCollectionDbId(long sampleCollectionDbId)
			throws SystemException{
		
			return sampleCollectionAttributeListsPersistence.findBysampleCollectionDbId(sampleCollectionDbId);
	}
	
	
	public List<SampleCollectionAttributeLists> getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(long sampleCollectionDbId, String attributeListName)
		throws SystemException{
	
		return sampleCollectionAttributeListsPersistence.findBysampleCollectionDbId_attributeListName(sampleCollectionDbId, attributeListName);
	}
	
	
	public SampleCollectionAttributeLists getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName_AttributeListValue
		(long sampleCollectionDbId, String attributeListName, String attributeListValue) throws SystemException{

		try {
			return sampleCollectionAttributeListsPersistence.
					findBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId, attributeListName, attributeListValue);
		} catch (NoSuchSampleCollectionAttributeListsException e) {
			// TODO Auto-generated catch block
			System.out.println("No such SampleCollectionAttributeLists exists!");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public SampleCollectionAttributeLists deleteSampleCollectionAttributeListsBySampleCollectionDbId(long sampleCollectionDbId){
		
		try {
			sampleCollectionAttributeListsPersistence.removeBysampleCollectionDbId(sampleCollectionDbId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}