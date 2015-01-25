package com.bcnet.hook.portlet.users_admin.user;

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
import com.liferay.portal.theme.ThemeDisplay;


public class CustomEditUserAction extends BaseStrutsPortletAction{
	
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long juristicPersonId = ParamUtil.getLong(actionRequest, "juristicPersonId");
		
		user.getExpandoBridge().setAttribute("juristicPersonId", juristicPersonId);
		
		/*long userClassNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
		ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(themeDisplay.getCompanyId(), userClassNameId );
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "juristicPersonId");
		ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.addValue(userClassNameId ,table.getTableId(), column.getColumnId(), user.getUserId(), (String)juristicPersonId);*/
		
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