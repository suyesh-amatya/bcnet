package com.bcnet.portlet.biobank;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankAttributeListsMaster
 */
public class BiobankAttributeListsMasterPortlet extends MVCPortlet {

	public void addBiobankAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateBiobankAttributeListsMaster(request);

		sendRedirect(request, response);
	}

	
	public void updateBiobankAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		_updateBiobankAttributeListsMaster(request);

		sendRedirect(request, response);
	}
	
	private BiobankAttributeListsMaster _updateBiobankAttributeListsMaster(ActionRequest request)
			throws PortalException, SystemException {

		long biobankAttributeListsMasterId = ParamUtil.getLong(request, "biobankAttributeListsMasterId");
		String attributeListName = ParamUtil.getString(request, "attributeListName");
		//String attributeListValue = ParamUtil.getString(request, "attributeListValue");
		
		/* 
		 * ParamUtil.getParameterValues in BiobankAttributeListsPortlet has a bug for String[] type values with comma.
		 * As a result a whole string block consisting of comma gets split into different string parts at comma.
		 * For e.g. "Detection (Mass Spectometry, NMR)" becomes "Detection (Mass Spectometry" and  "NMR)"
		 * So replacing all the commas with semicolon while inserting into the database to circumvent this bug. 
		 * 
		 * */
		String attributeListValue = ParamUtil.getString(request, "attributeListValue").replaceAll(",", ";");
		

		BiobankAttributeListsMaster biobankAttributeListsMaster = null;

		if (biobankAttributeListsMasterId <= 0) {
			biobankAttributeListsMaster = BiobankAttributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster(attributeListName, attributeListValue);
		}
		else {
			biobankAttributeListsMaster = BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMaster(biobankAttributeListsMasterId);

			biobankAttributeListsMaster = BiobankAttributeListsMasterLocalServiceUtil.
					updateBiobankAttributeListsMaster(biobankAttributeListsMasterId, attributeListName, attributeListValue);
					
		}

		return biobankAttributeListsMaster;
	}
	
	public void deleteBiobankAttributeListsMaster(ActionRequest request, ActionResponse response)
			throws Exception {

		long biobankAttributeListsMasterId = ParamUtil.getLong(request, "biobankAttributeListsMasterId");

		BiobankAttributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster(biobankAttributeListsMasterId);

		sendRedirect(request, response);
	}
}
