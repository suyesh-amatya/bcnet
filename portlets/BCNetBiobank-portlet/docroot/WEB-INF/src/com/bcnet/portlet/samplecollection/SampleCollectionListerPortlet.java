package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionListerPortlet
 */
public class SampleCollectionListerPortlet extends MVCPortlet {
 
	public void deleteSampleCollection(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		
		if(SampleLocalServiceUtil.getSamplesBySampleCollectionDbId(sampleCollectionDbId).isEmpty()){
			SampleCollectionContactLocalServiceUtil.deleteSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
			SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
			SampleCollectionLocalServiceUtil.deleteSampleCollection(sampleCollectionDbId);
			sendRedirect(request, response);
		}
		else{
			SessionErrors.add(request, "samples-exist-for-this-sample-collection");
		}
	}
	
	
}
