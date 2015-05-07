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

import java.util.List;

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model implementation for the SampleCollection service. Represents a row in the &quot;samplecollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.model.SampleCollection} interface.
 * </p>
 *
 * @author suyama
 */
public class SampleCollectionImpl extends SampleCollectionBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a sample collection model instance should use the {@link com.bcnet.portlet.biobank.model.SampleCollection} interface instead.
	 */
	public SampleCollectionImpl() {
	}
	
	
	public List<SampleCollectionAttributeLists> getSampleCollectionAttributeLists(){
		
		try {
			return SampleCollectionAttributeListsLocalServiceUtil.getSampleCollectionAttributeListsBySampleCollectionDbId(this.getSampleCollectionDbId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}