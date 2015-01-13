package com.bcnet.portlet.biobank;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class BiobankOrganizationCreationConfig extends DefaultConfigurationAction {
	
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		/*System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		System.out.println(portletResource);
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); */
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}