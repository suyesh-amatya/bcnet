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

import com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.base.BiobankAttributeListsMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the biobank attribute lists master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankAttributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil
 */
public class BiobankAttributeListsMasterLocalServiceImpl
	extends BiobankAttributeListsMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil} to access the biobank attribute lists master local service.
	 */
	
	public BiobankAttributeListsMaster addBiobankAttributeListsMaster(String attributeListName,
			String attributeListValue) throws SystemException{
		
		long biobankAttributeListsMasterId = 
				counterLocalService.increment(BiobankAttributeListsMaster.class.getName());
		
		BiobankAttributeListsMaster biobankAttributeListsMaster = 
				biobankAttributeListsMasterPersistence.create(biobankAttributeListsMasterId);
		
		biobankAttributeListsMaster.setAttributeListName(attributeListName);
		biobankAttributeListsMaster.setAttributeListValue(attributeListValue);
		
		super.addBiobankAttributeListsMaster(biobankAttributeListsMaster);
		
		return biobankAttributeListsMaster;
	
	}
	
	public BiobankAttributeListsMaster deleteBiobankAttributeListsMaster(BiobankAttributeListsMaster
			biobankAttributeListsMaster) throws SystemException{
		
		return biobankAttributeListsMasterPersistence.remove(biobankAttributeListsMaster);
	}
	
	public BiobankAttributeListsMaster deleteBiobankAttributeListsMaster(long
			biobankAttributeListsMasterId) throws PortalException, SystemException{
		
		BiobankAttributeListsMaster biobankAttributeListsMaster = biobankAttributeListsMasterPersistence.
				findByPrimaryKey(biobankAttributeListsMasterId);
		
		return deleteBiobankAttributeListsMaster(biobankAttributeListsMaster);
	}
	
	public BiobankAttributeListsMaster getBiobankAttributeListsMaster(long
			biobankAttributeListsMasterId) throws PortalException, SystemException{
		
		return biobankAttributeListsMasterPersistence.findByPrimaryKey(biobankAttributeListsMasterId);
	}
	
	public List<BiobankAttributeListsMaster> getAllBiobankAttributeListsMasters() throws SystemException{
		
		return biobankAttributeListsMasterPersistence.findAll();
	}
	
	public List<BiobankAttributeListsMaster> getAllBiobankAttributeListsMasters(int start, int end)
			throws SystemException{
		
		return biobankAttributeListsMasterPersistence.findAll(start, end);
	}
	
	public List<BiobankAttributeListsMaster> getBiobankAttributeListsMasterByAttributeListName(String attributeListName)
			throws SystemException{
		
		return biobankAttributeListsMasterPersistence.findByattribute(attributeListName);
	}
	
	public BiobankAttributeListsMaster updateBiobankAttributeListsMaster(long biobankAttributeListsMasterId, 
			String attributeListName, String attributeListValue) throws SystemException{
	
		BiobankAttributeListsMaster biobankAttributeListsMaster = BiobankAttributeListsMasterLocalServiceUtil.
				fetchBiobankAttributeListsMaster(biobankAttributeListsMasterId);
		
		biobankAttributeListsMaster.setAttributeListName(attributeListName);
		biobankAttributeListsMaster.setAttributeListValue(attributeListValue);
		
		super.updateBiobankAttributeListsMaster(biobankAttributeListsMaster);
		
		return biobankAttributeListsMaster;
	}
}