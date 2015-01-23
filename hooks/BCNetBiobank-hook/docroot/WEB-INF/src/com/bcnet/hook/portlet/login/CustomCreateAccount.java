package com.bcnet.hook.portlet.login;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

public class CustomCreateAccount extends BaseStrutsPortletAction{
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest request,
            ActionResponse response)
        throws Exception {
		/*
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		System.out.println("Country"+ParamUtil.getString(actionRequest, "countryCode"));
		//String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		System.out.println("User>"+UserLocalServiceUtil.getUserIdByEmailAddress(themeDisplay.getCompanyId(), emailAddress));
		int juristicPersonId = (Integer) PortalUtil.getExpandoValue(actionRequest, "ExpandoAttribute--" + "juristicPersonId" + "--", ExpandoColumnConstants.INTEGER, ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX);
		System.out.println("##################juristicPersonId###########################################"+juristicPersonId);
		
		System.out.println(PortalUtil.getExpandoValue(actionRequest, "ExpandoAttribute--" +"orcId"+ "--", 
				ExpandoColumnConstants.STRING, ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX));
		System.out.println(themeDisplay.getCompanyId());
		System.out.println(User.class.getName());
		System.out.println(themeDisplay.getUserId());
		long userClassNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
		
		ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(themeDisplay.getCompanyId(), userClassNameId );
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "countryCode");*/
		//ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.addValue(userClassNameId ,table.getTableId(), column.getColumnId(), 11, 
				//ParamUtil.getString(actionRequest, "countryCode"));
		//ExpandoBridgeFactoryUtil.getExpandoBridge(themeDisplay.getCompanyId(), 
				//User.class.getName()).setAttribute("ExpandoAttribute--countryCode--", ParamUtil.getString(actionRequest, "countryCode"));
	    
         
		 
		 
		 
        originalStrutsPortletAction.processAction(
            originalStrutsPortletAction, portletConfig, request,
            response);
    }
	
	public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest request,
            RenderResponse response)
        throws Exception {
 
        return originalStrutsPortletAction.render(
                originalStrutsPortletAction, portletConfig, request, response);
 
    }
}
