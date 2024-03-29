package com.bcnet.portlet.biobank;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankGeneralInformationPortlet
 */
public class BiobankGeneralInformationPortlet extends MVCPortlet {

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long organizationId = ParamUtil.getLong(resourceRequest, "biobankDbId");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		/* Check for duplicate biobank name */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankName")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankNamebiobankId")){
			String organizationName = ParamUtil.getString(resourceRequest, "name");
			String prevOrganizationName = null;
			
			try {
				prevOrganizationName = OrganizationLocalServiceUtil.getOrganization(organizationId).getName();
			} catch (PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			boolean organizationNameExists = false;
			
			try {
				if(!organizationName.equalsIgnoreCase(prevOrganizationName)){
					for(Organization organization : OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS)){
						//While updating check if the biobank name already exists! The biobank name is deemed to already exist if its name equals any other biobanks'
						//name except the name of the current one being updated.
						if(organization.getName().equalsIgnoreCase(organizationName) /*&& !organization.getName().equalsIgnoreCase(prevOrganizationName)*/){
							organizationNameExists = true;
							json.put("organizationNameExists", organizationNameExists == true ? true : false);
							
							break;
						}
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/* Check for duplicate biobank id */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankId")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankNamebiobankId")){
			String biobankId = ParamUtil.getString(resourceRequest, "biobankId");
			String prevBiobankId = null;
			
			try {
				prevBiobankId = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId).getBiobankId();
			} catch (PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			boolean biobankIdExists = false;

			try {
				if(!biobankId.equalsIgnoreCase(prevBiobankId)){
					for(BiobankGeneralInformation biobank : BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformations(QueryUtil.ALL_POS,QueryUtil.ALL_POS)){
						if(biobank.getBiobankId().equalsIgnoreCase(biobankId)){
							biobankIdExists = true;
							json.put("biobankIdExists", biobankIdExists == true ? true : false);
							
							break;
						}
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			resourceResponse.getPortletOutputStream().write(json.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updateBiobankGeneralInformation(ActionRequest request, ActionResponse response) throws Exception{
		
		_updateBiobankGeneralInformation(request);
		
		//sendRedirect(request, response);
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(ParamUtil.getLong(request, "biobankDbId"));
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SessionMessages.add(request, "biobank-add-success");
		response.sendRedirect(themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL());
	}

	private BiobankGeneralInformation _updateBiobankGeneralInformation(ActionRequest request) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		String biobankId = ParamUtil.getString(request, "biobankId");
		String acronym = ParamUtil.getString(request, "acronym");
		String name = ParamUtil.getString(request, "name");
		String url = ParamUtil.getString(request, "url");
		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		String countryCode = ParamUtil.getString(request, "countryCode");
		String description = ParamUtil.getString(request, "description");
		boolean backup = ParamUtil.getBoolean(request, "backup");
		boolean trainingCourses = ParamUtil.getBoolean(request, "trainingCourses");
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		BiobankGeneralInformation biobankGeneralInformation;
		
		try{
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(biobankDbId);
		}
		catch(Exception e){
			biobankGeneralInformation = new BiobankGeneralInformationImpl();
			biobankGeneralInformation.setBiobankDbId(biobankDbId);
		}
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankDbId);
		organization.setName(name);
		
		Group group = organization.getGroup();
		group.setFriendlyURL("/"+name.trim().replaceAll(" +", " ").replaceAll(" ", "-").toLowerCase());
		GroupLocalServiceUtil.updateGroup(group);
		
		try{
			OrganizationLocalServiceUtil.updateOrganization(organization);
		}
		catch(Exception e){
			SessionErrors.add(request, "duplicate-name");
		}
		
		biobankGeneralInformation.setBiobankId(biobankId);
		biobankGeneralInformation.setAcronym(acronym);
		biobankGeneralInformation.setUrl(url);
		biobankGeneralInformation.setJuristicPersonId(juristicPersonId);
		biobankGeneralInformation.setCountryCode(countryCode);
		biobankGeneralInformation.setDescription(description);
		biobankGeneralInformation.setBackup(backup);
		biobankGeneralInformation.setTrainingCourses(trainingCourses);
		
		return BiobankGeneralInformationLocalServiceUtil.updateBiobankGeneralInformation(biobankGeneralInformation);
		
	}
	
	
		
	public void deleteBiobankOrganization(ActionRequest request, ActionResponse response) throws IOException{
		long biobankDbId = ParamUtil.getLong(request, "biobankDbId");
		
		if(SampleLocalServiceUtil.getSamplesByBiobankDbId(biobankDbId).isEmpty()){
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
				BiobankAttributeListsLocalServiceUtil.deleteBiobankAttributeListsBybiobankDbId(biobankDbId);
				BiobankGeneralInformationLocalServiceUtil.deleteBiobankGeneralInformation(biobankDbId);			
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				response.sendRedirect(themeDisplay.getURLPortal()+"/biobanks");
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			SessionErrors.add(request, "samples-exist-for-this-biobank");
		}
		
	}
	

}
