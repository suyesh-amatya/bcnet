package com.bcnet.portlet.samplecollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionContactPortlet
 */
public class SampleCollectionContactPortlet extends MVCPortlet {

	public void editSampleCollectionMainContact(ActionRequest request, ActionResponse response) throws NoSuchSampleCollectionContactException, SystemException{
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
		long sampleCollectionMainContactUserId = ParamUtil.getLong(request, "sampleCollectionMainContactUserId");
		
		SampleCollectionContactLocalServiceUtil.editSampleCollectionMainContact(sampleCollectionDbId, sampleCollectionMainContactUserId);
	}

}
