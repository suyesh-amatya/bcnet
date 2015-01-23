package com.bcnet.hook.portlet.users_admin.user;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

public class CustomEditUser extends BaseStrutsPortletAction{
	
	public void processAction(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, ActionRequest request, ActionResponse response)
        throws Exception {
		
		
		originalStrutsPortletAction.processAction(originalStrutsPortletAction, portletConfig, request, response);
	}
	
	
	public String render(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, RenderRequest request, RenderResponse response)
        throws Exception {
 
        return originalStrutsPortletAction.render(
                originalStrutsPortletAction, portletConfig, request, response);
 
    }
}