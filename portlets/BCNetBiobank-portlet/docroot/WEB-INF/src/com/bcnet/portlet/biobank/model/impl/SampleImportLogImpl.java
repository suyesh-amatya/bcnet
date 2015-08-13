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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the SampleImportLog service. Represents a row in the &quot;sampleimportlog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.model.SampleImportLog} interface.
 * </p>
 *
 * @author suyama
 */
public class SampleImportLogImpl extends SampleImportLogBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a sample import log model instance should use the {@link com.bcnet.portlet.biobank.model.SampleImportLog} interface instead.
	 */
	
	private String fullNameImporter;
	
	public SampleImportLogImpl() {
	}
	
	
	public String getFullNameImporter(){
		
		try {
			fullNameImporter = UserLocalServiceUtil.getUser(this.getUserId()).getFullName();
			return fullNameImporter;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
}