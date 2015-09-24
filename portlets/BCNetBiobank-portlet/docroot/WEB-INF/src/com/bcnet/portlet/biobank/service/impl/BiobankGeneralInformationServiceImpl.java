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

import com.bcnet.portlet.biobank.NoSuchJuristicPersonException;
import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;
import com.bcnet.portlet.biobank.service.base.BiobankGeneralInformationServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.CountryServiceUtil;

/**
 * The implementation of the biobank general information remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankGeneralInformationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankGeneralInformationServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankGeneralInformationServiceUtil
 */

@JSONWebService
public class BiobankGeneralInformationServiceImpl
	extends BiobankGeneralInformationServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankGeneralInformationServiceUtil} to access the biobank general information remote service.
	 */
	@AccessControlled(guestAccessEnabled=true)
	public String getAllBiobanks() throws NoSuchJuristicPersonException, PortalException, SystemException {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	    List<BiobankGeneralInformation> biobanks = null;
		try {
			biobanks = BiobankGeneralInformationLocalServiceUtil.getAllBiobankGeneralInformations();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    for(BiobankGeneralInformation biobank:biobanks){
	    	JSONObject json = JSONFactoryUtil.createJSONObject();
	    	json.put("biobankDbId", biobank.getBiobankDbId());
	    	json.put("biobankId", biobank.getBiobankId());
	    	json.put("name", biobank.getBiobankName());
	    	json.put("acronym", biobank.getAcronym());
	    	json.put("url", biobank.getUrl());
	    	json.put("juristicPersonName", JuristicPersonLocalServiceUtil.getJuristicPerson(biobank.getJuristicPersonId()).getName());
	    	json.put("juristicPersonUrl", JuristicPersonLocalServiceUtil.getJuristicPerson(biobank.getJuristicPersonId()).getUrl());
	    	json.put("juristicPersonAddress", JuristicPersonLocalServiceUtil.getJuristicPerson(biobank.getJuristicPersonId()).getAddress());
	    	//json.put("country", CountryServiceUtil.getCountryByA2(biobank.getCountryCode()).getName());
	    	json.put("description", biobank.getDescription());
	    	json.put("backup", biobank.getBackup()==true?"yes":"no");
	    	json.put("trainingCourses", biobank.getTrainingCourses()==true?"yes":"no");
	    	
	    	jsonArray.put(json);
	    }
	    System.out.println("jsonArray"+jsonArray);
	    System.out.println("jsonArraytostring"+jsonArray.toString());
	    return jsonArray.toString();
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public String helloWorld(String worldName) {
	    return "Hello world: " + worldName;
	}
}