package com.bcnet.portlet.samplecollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionListerPortlet
 */
public class SampleCollectionListerPortlet extends MVCPortlet {
 
	public void deleteSampleCollection(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		
		SampleCollectionLocalServiceUtil.deleteSampleCollection(sampleCollectionDbId);
		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
		
	}
	
	
}
