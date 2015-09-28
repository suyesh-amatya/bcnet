package com.bcnet.portlet.biobank;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BiobankOrganizationCreationPortlet
 */
public class BiobankOrganizationCreationPortlet extends MVCPortlet {
 

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		/* Check for duplicate biobank name */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankName")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("biobankNamebiobankId")){
			String organizationName = ParamUtil.getString(resourceRequest, "name");
			boolean organizationNameExists = false;
			
			try {
				for(Organization organization : OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS)){
					//While adding check if the biobank name already exists! The biobank name is deemed to already exist if its name equals any other biobanks'
					//name.
					if(organization.getName().equalsIgnoreCase(organizationName)){
						organizationNameExists = true;
						json.put("organizationNameExists", organizationNameExists == true ? true : false);
						
						break;
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
			boolean biobankIdExists = false;
			
			try {
				for(BiobankGeneralInformation biobank : BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformations(QueryUtil.ALL_POS,QueryUtil.ALL_POS)){
					if(biobank.getBiobankId().equalsIgnoreCase(biobankId)){
						biobankIdExists = true;
						json.put("biobankIdExists", biobankIdExists == true ? true : false);
						
						break;
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
	
	public void createBiobankOrganization(ActionRequest request, ActionResponse response) throws Exception{
		
		BiobankGeneralInformation biobank = _createBiobankOrganization(request);
		
		Organization organization = OrganizationLocalServiceUtil.getOrganization(biobank.getBiobankDbId());
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SessionMessages.add(request, "biobank-add-success");
		response.sendRedirect(themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL());

	}

	private BiobankGeneralInformation _createBiobankOrganization(ActionRequest request) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		Company company = CompanyLocalServiceUtil.getCompanyById(companyId);
		long userId = company.getDefaultUser().getUserId();
		long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
		String name = ParamUtil.getString(request, "name");
		String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
		long regionId = 0;
        long countryId = 0;
        int statusId = GetterUtil.getInteger(PropsUtil.get("sql.data.com.liferay.portal.model.ListType.organization.status"));
		//com.liferay.portal.kernel.workflow.WorkflowConstants.STATUS_APPROVED
        String comments = null;
        boolean site = true;
        
        
        
        ServiceContext  serviceContext = null;
		Organization organization = OrganizationLocalServiceUtil.addOrganization(userId, parentOrganizationId, name, type, regionId, countryId, 
				statusId, comments, site, serviceContext);
		long organizationId = organization.getOrganizationId();
		
		long pageTemplate = ParamUtil.getLong(request, "pagetemplate");
		if(site){
			try {
				createPages(organization, pageTemplate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String biobankId = ParamUtil.getString(request, "biobankId");
		String acronym = ParamUtil.getString(request, "acronym");
		String url = ParamUtil.getString(request, "url");
		long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
		String countryCode = ParamUtil.getString(request, "countryCode");
		String description = ParamUtil.getString(request, "description");
		boolean backup = ParamUtil.getBoolean(request, "backup");
		boolean trainingCourses = ParamUtil.getBoolean(request, "trainingCourses");

		BiobankGeneralInformation biobankGeneralInformation;
		
		try{
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId);
		}
		catch(Exception e){
			biobankGeneralInformation = new BiobankGeneralInformationImpl();
			biobankGeneralInformation.setBiobankDbId(organizationId);
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
	
	
	private void createPages(Organization organization , long publicLayoutSetPrototypeId) throws Exception {
		try {
			boolean isPrivateLayout = false;
			Group organizationGroup = organization.getGroup();
			
			long groupId = organizationGroup.getGroupId();
		    LayoutSetPrototype prototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(publicLayoutSetPrototypeId);
		    boolean layoutSetPrototypeLinkEnabled = true;
		    LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(groupId, isPrivateLayout,
		            layoutSetPrototypeLinkEnabled, prototype.getUuid());
		    
		    LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, isPrivateLayout);
		    SitesUtil.mergeLayoutSetPrototypeLayouts(organizationGroup, layoutSet);
		} catch (Exception e) {
			System.out.println("------------------------------------------------------");
			System.out.println("Exception in creating organization pages!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
