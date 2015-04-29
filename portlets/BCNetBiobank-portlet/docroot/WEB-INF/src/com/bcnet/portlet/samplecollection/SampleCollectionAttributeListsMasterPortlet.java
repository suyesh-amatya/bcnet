package com.bcnet.portlet.samplecollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionAttributeListsMasterPortlet
 */
public class SampleCollectionAttributeListsMasterPortlet extends MVCPortlet {

	public void addSampleCollectionAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateSampleCollectionAttributeListsMaster(request);

		sendRedirect(request, response);
	}
	
	
	public void updateSampleCollectionAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateSampleCollectionAttributeListsMaster(request);

		sendRedirect(request, response);
	}


	private SampleCollectionAttributeListsMaster _updateSampleCollectionAttributeListsMaster(ActionRequest request)
			throws PortalException, SystemException {

		long sampleCollectionAttributeListsMasterId = ParamUtil.getLong(request, "sampleCollectionAttributeListsMasterId");
		String attributeListName = ParamUtil.getString(request, "attributeListName");
		String attributeListValue = ParamUtil.getString(request, "attributeListValue").replaceAll(",", ";");;

		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster = null;

		if (sampleCollectionAttributeListsMasterId <= 0) {
			sampleCollectionAttributeListsMasterId = CounterLocalServiceUtil.increment();
			sampleCollectionAttributeListsMaster = SampleCollectionAttributeListsMasterLocalServiceUtil.createSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
		}
		else {
			sampleCollectionAttributeListsMaster = SampleCollectionAttributeListsMasterLocalServiceUtil.getSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
		}
		
		sampleCollectionAttributeListsMaster.setAttributeListName(attributeListName);
		sampleCollectionAttributeListsMaster.setAttributeListValue(attributeListValue);

		return SampleCollectionAttributeListsMasterLocalServiceUtil.updateSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
	}
	
	
	public void deleteSampleCollectionAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		long sampleCollectionAttributeListsMasterId = ParamUtil.getLong(request, "sampleCollectionAttributeListsMasterId");

		SampleCollectionAttributeListsMasterLocalServiceUtil.deleteSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
		
		sendRedirect(request, response);
	}

}
