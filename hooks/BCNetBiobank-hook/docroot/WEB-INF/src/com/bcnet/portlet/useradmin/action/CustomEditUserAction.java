package com.bcnet.portlet.useradmin.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


public class CustomEditUserAction extends BaseStrutsPortletAction{
	
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		if(userId > 0){
			User user = UserLocalServiceUtil.getUser(userId);
			
			long juristicPersonId = ParamUtil.getLong(actionRequest, "juristicPersonId");
			
			user.getExpandoBridge().setAttribute("juristicPersonId", juristicPersonId);
		}
		
		
		
		originalStrutsPortletAction.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
	}
	
	
	public String render(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, RenderRequest actionRequest, RenderResponse actionResponse)
        throws Exception {
 
        return originalStrutsPortletAction.render(
                originalStrutsPortletAction, portletConfig, actionRequest, actionResponse);
 
    }
}