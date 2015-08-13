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

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.service.base.BiobankGeneralInformationLocalServiceBaseImpl;
import com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the biobank general information local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankGeneralInformationLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil
 */
public class BiobankGeneralInformationLocalServiceImpl
	extends BiobankGeneralInformationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil} to access the biobank general information local service.
	 */
	
	public List<BiobankGeneralInformation> findBiobanksByIdentity(String biobankId, String acronym, String name, String countryCode, int begin, int end){
		
		return BiobankGeneralInformationFinderUtil.findByIdAcronymNameCountry(biobankId, acronym, name, countryCode, begin, end);
	}
	
	public int findBiobanksCountByIdentity(String biobankId, String acronym, String name, String countryCode){
		
		return BiobankGeneralInformationFinderUtil.countByIdAcronymNameCountry(biobankId, acronym, name, countryCode);
	}
	
	public List<BiobankGeneralInformation> findBiobanksByKeywordsCountry(String keywords, String countryCode, int begin, int end){
		String[] partskeywords = keywords.split("\\s+");
		return BiobankGeneralInformationFinderUtil.findBiobanksByKeywordsCountry(partskeywords, countryCode, begin, end);
	}
	
	public int findBiobanksCountByKeywordsCountry(String keywords, String countryCode){
		String[] partskeywords = keywords.split("\\s+");
		return BiobankGeneralInformationFinderUtil.findBiobanksCountByKeywordsCountry(partskeywords, countryCode);
	}
	
	public List<BiobankGeneralInformation> findAllBiobankOrganizations(int begin, int end){
		return BiobankGeneralInformationFinderUtil.findAllBiobankOrganizations(begin, end);
	}
	
	public int findAllBiobankOrganizationsCount(){
		return BiobankGeneralInformationFinderUtil.findAllBiobankOrganizationsCount();
	}
	
	public List<BiobankGeneralInformation> getAllBiobankGeneralInformations() throws SystemException{
		return biobankGeneralInformationPersistence.findAll();
	}
}