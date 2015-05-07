package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionAttributeListsPortlet
 */
public class SampleCollectionAttributeListsPortlet extends MVCPortlet {

	public void deleteSampleCollectionAttributeLists(ActionRequest request,
            ActionResponse response) throws IOException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);

	}

}
