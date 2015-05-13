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

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster;
import com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the sample collection attribute lists master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil
 */
public class SampleCollectionAttributeListsMasterLocalServiceImpl
	extends SampleCollectionAttributeListsMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil} to access the sample collection attribute lists master local service.
	 */
	
	public List<SampleCollectionAttributeListsMaster> getSampleCollectionAttributeListsMasterByAttributeListName(String attributeListName)
			throws SystemException{
		
		return sampleCollectionAttributeListsMasterPersistence.findByattributeListName(attributeListName);
	}
}