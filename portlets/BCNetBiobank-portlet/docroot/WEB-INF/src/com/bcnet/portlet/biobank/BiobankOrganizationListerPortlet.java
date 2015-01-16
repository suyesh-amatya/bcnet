package com.bcnet.portlet.biobank;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankOrganizationListerPortlet
 */
public class BiobankOrganizationListerPortlet extends MVCPortlet {
 
	public void deleteBiobankOrganization(ActionRequest request, ActionResponse response){
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankDbId);			
			OrganizationLocalServiceUtil.deleteOrganization(organization);			
			BiobankGeneralInformationLocalServiceUtil.deleteBiobankGeneralInformation(biobankDbId);			
			BiobankAttributeListsLocalServiceUtil.deleteBiobankAttributeListsBybiobankDbId(biobankDbId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
