package com.bcnet.portlet.sample;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleImportLogPortlet
 */
public class SampleImportLogPortlet extends MVCPortlet {

	public void deleteSampleImport(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long importId = ParamUtil.getLong(request, "importId");//request.getParameter("importId")
		String uuid = ParamUtil.getString(request, "uuid");
		SampleLocalServiceUtil.deleteSamplesByuuid(uuid);
		SampleImportLogLocalServiceUtil.deleteSampleImportLog(importId);
		
		sendRedirect(request, response);
	}
	
	public void filterColumns(ActionRequest request, ActionResponse response) throws IOException{
		//System.out.println(ParamUtil.getString(request, "test"));
		//System.out.println(request.getParameter("submit"));
		System.out.println(request.getMethod());
		//System.out.println(ParamUtil.getString(request, "container"));
		
		//response.sendRedirect(ParamUtil.getString(request, "redirect"));
		//sendRedirect(request, response);
		//response.setRenderParameter("container", ParamUtil.getString(request, "container"));
	}

}
