package com.bcnet.portlet.biobank;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankOrganizationListerPortlet
 */
public class BiobankOrganizationListerPortlet extends MVCPortlet {
 
	public void deleteBiobankOrganization(ActionRequest request, ActionResponse response){
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankDbId);
			long organizationid = organization.getOrganizationId();
			
			List<User> users = UserLocalServiceUtil.getOrganizationUsers(biobankDbId);
			
			for(User user : users){
				long userid = user.getUserId();
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(userid, organization.getGroup().getGroupId());
				long[] userid_array = { userid };
				for (UserGroupRole ugr : usergrouprolles) {
					UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userid_array, organization.getGroup().getGroupId(), ugr.getRoleId());
				}
				
				String user_positions = user.getExpandoBridge().getAttribute("Role within the organisation").toString();
				String new_user_positions = user_positions.replaceAll("(?m)(?<=^|;)"+organizationid+"[^;]*;", "");
				user.getExpandoBridge().setAttribute("Role within the organisation", new_user_positions);
				
				OrganizationLocalServiceUtil.deleteUserOrganization(userid, organization);
			}
			
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
