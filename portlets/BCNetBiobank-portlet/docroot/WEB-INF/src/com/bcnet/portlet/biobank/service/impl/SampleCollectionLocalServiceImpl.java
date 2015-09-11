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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionException;
import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.base.SampleCollectionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the sample collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.SampleCollectionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil
 */
public class SampleCollectionLocalServiceImpl
	extends SampleCollectionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil} to access the sample collection local service.
	 */
	
	public SampleCollection getSampleCollectionBySampleCollectionId(String sampleCollectionId) throws NoSuchSampleCollectionException, SystemException{
		return sampleCollectionPersistence.findBysampleCollectionId(sampleCollectionId);
	}
}