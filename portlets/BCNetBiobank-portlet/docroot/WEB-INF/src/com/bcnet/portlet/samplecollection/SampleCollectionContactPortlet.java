package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException;
import com.bcnet.portlet.biobank.model.JuristicPerson;
import com.bcnet.portlet.biobank.model.SampleCollectionContact;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionContactPortlet
 */
public class SampleCollectionContactPortlet extends MVCPortlet {

	public void editSampleCollectionMainContact(ActionRequest request, ActionResponse response) throws NoSuchSampleCollectionContactException, SystemException{
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
		long sampleCollectionMainContactUserId = ParamUtil.getLong(request, "sampleCollectionMainContactUserId");
		
		SampleCollectionContactLocalServiceUtil.editSampleCollectionMainContact(sampleCollectionDbId, sampleCollectionMainContactUserId);
	}

	
	public void deleteContactFromSampleCollection(ActionRequest request, ActionResponse response) throws IOException, SystemException{
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
		long userId = ParamUtil.getLong(request, "userid");
		
		SampleCollectionContact sampleCollectionContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, userId);
		SampleCollectionContactLocalServiceUtil.deleteSampleCollectionContact(sampleCollectionContact);
		
	}
	
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String email = ParamUtil.getString(resourceRequest, "email").toLowerCase();
			User user = null;
			if(email.length() != 0) {
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), email);
			}
			
			json.put("firstName", user != null ? user.getFirstName() : "");
			json.put("middleName", user != null ? user.getMiddleName() : "");
			json.put("lastName", user != null ? user.getLastName() : "");
			json.put("userid", user != null ? String.valueOf(user.getUserId()) : "");
			
			Long result = (Long)user.getExpandoBridge().getAttribute("juristicPersonId");
			long juristicPersonId = result.longValue();
			if(juristicPersonId > 0){
				json.put("juristicPersonId", user != null ?  juristicPersonId : 0);
				JuristicPerson juristicPerson = JuristicPersonLocalServiceUtil.getJuristicPerson(juristicPersonId);
				String juristicPersonName = juristicPerson.getName();
				json.put("juristicPersonName", user != null ?  juristicPersonName : "");
			}
			
			
			json.put("department", user != null ? (String)user.getExpandoBridge().getAttribute("department") : "");
			
			json.put("orcId", user != null ? (String)user.getExpandoBridge().getAttribute("orcId") : "");
			
			resourceResponse.getPortletOutputStream().write(json.toString().getBytes());
		} catch (IOException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("IOException");
			e.printStackTrace();
		} catch (PortalException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("PortalException");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("-----------------------------------------");
			System.out.println("BiBBox Exception in People::serveResource");
			System.out.println("SystemException");
			e.printStackTrace();
		}
	}
	
	
	public void addSampleCollectionContactUser(ActionRequest request, ActionResponse response){
		try {
			long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
			long userId = ParamUtil.getLong(request, "userId");
			
			SampleCollectionContact sampleCollectionContact = null;
			User user = null;
			if(userId != 0) {
				user = UserLocalServiceUtil.getUser(userId);
				sampleCollectionContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, userId);
			} else {
				try {
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), ParamUtil.getString(request, "email").toLowerCase());
				} catch(Exception e) {
					System.out.println("-----------------------------------");
					System.out.println("Exception in SampleCollectionContactPortlet::addSampleCollectionContactUser");
					System.out.println("Exception");
					System.out.println("User not found in the Database. Need to be created");
				}
			}
			user = getUserFromRequest(request, user);
			UserLocalServiceUtil.updateUser(user);
			
			if(sampleCollectionContact == null){
				SampleCollectionContactPK sampleCollectionContactPK = new SampleCollectionContactPK(sampleCollectionDbId, user.getUserId());
				sampleCollectionContact = SampleCollectionContactLocalServiceUtil.createSampleCollectionContact(sampleCollectionContactPK);
			}
			
			boolean owner = ParamUtil.getBoolean(request, "owner");
			boolean editor = ParamUtil.getBoolean(request, "editor");
			boolean mainContact = ParamUtil.getBoolean(request, "maincontact");
			
			if(mainContact){
				SampleCollectionContact prevSampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
				if(prevSampleCollectionMainContact != null){
					prevSampleCollectionMainContact.setMainContact(false);
					SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(prevSampleCollectionMainContact);
				}
				
			}
			
			sampleCollectionContact.setMainContact(mainContact);
			sampleCollectionContact.setSampleCollectionEditor(editor);
			sampleCollectionContact.setSampleCollectionOwner(owner);
			
			SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(sampleCollectionContact);
			
		} catch(Exception e) {
			System.out.println("-----------------------------------");
			System.out.println("Exception in SampleCollectionContactPortlet::addSampleCollectionContactUser");
			System.out.println("Exception");
			e.printStackTrace();
		}
		
	}

	
	public void editSampleCollectionContactUser(ActionRequest request, ActionResponse response){
		try {
			long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
			long userId = ParamUtil.getLong(request, "userId");
			
			User user = UserLocalServiceUtil.getUser(userId);
			user = getUserFromRequest(request, user);			
			UserLocalServiceUtil.updateUser(user);
			
			SampleCollectionContact sampleCollectionContact;
			try{
				sampleCollectionContact =  SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, userId);
			}catch(Exception e){
				SampleCollectionContactPK sampleCollectionContactPK = new SampleCollectionContactPK(sampleCollectionDbId, user.getUserId());
				sampleCollectionContact = SampleCollectionContactLocalServiceUtil.createSampleCollectionContact(sampleCollectionContactPK);
				
			}
			
			boolean owner = ParamUtil.getBoolean(request, "owner");
			boolean editor = ParamUtil.getBoolean(request, "editor");
			boolean mainContact = ParamUtil.getBoolean(request, "maincontact");
			
			if(mainContact){
				SampleCollectionContact prevSampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
				if(prevSampleCollectionMainContact != null){
					prevSampleCollectionMainContact.setMainContact(false);
					SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(prevSampleCollectionMainContact);
				}
				
			}
			
			sampleCollectionContact.setMainContact(mainContact);
			sampleCollectionContact.setSampleCollectionEditor(editor);
			sampleCollectionContact.setSampleCollectionOwner(owner);
			
			SampleCollectionContactLocalServiceUtil.updateSampleCollectionContact(sampleCollectionContact);
			
			
		} catch(Exception e) {
			System.out.println("------------------------------------");
			System.out.println("Exception in SampleCollectionContactPortlet::editSampleCollectionContactUser");
			System.out.println("Exception");
			e.printStackTrace();
		}
	}
	

	private User getUserFromRequest(ActionRequest request, User user) {
		// TODO Auto-generated method stub
		try {
			String firstname = ParamUtil.getString(request, "firstname");
			String middlname = ParamUtil.getString(request, "middlename");
			String lastname = ParamUtil.getString(request, "lastname");
			String email = ParamUtil.getString(request, "email").toLowerCase();
			long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");
			String department = ParamUtil.getString(request, "ExpandoAttribute--department--");
			String orcId = ParamUtil.getString(request, "ExpandoAttribute--orcId--");
			if (user == null) {
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setAddGroupPermissions(true);
				serviceContext.setAddGuestPermissions(true);
				boolean autoPassword = true;
				String password1 = "";
				boolean autoScreenName = true;
				String screenName = "";
				long facebookId = 0;
				String openId = "";
				int prefixId = 0;
				int suffixId = 0;
				int birthdayMonth = 1;
				int birthdayDay = 1;
				int birthdayYear = 1970;
				String jobTitle = "";
				long[] groupIds = new long[0];
				long[] organizationIds = new long[0];
				long[] roleIds = new long[0];
				long[] userGroupIds = new long[0];
				boolean male = false;
				boolean sendEmail = ParamUtil.getBoolean(request, "sendmailnotification");;
				try {
					user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), autoPassword, password1, password1, autoScreenName, screenName, email,
							facebookId, openId, themeDisplay.getLocale(), firstname, middlname, lastname, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
							groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
				} catch (PortalException e) {
					System.out.println("----------------------------------------------");
					System.out.println("Exception in SampleCollectionContactPortlet::getUserFromRequest");
					System.out.println("PortalException");
					e.printStackTrace();
				} catch (SystemException e) {
					System.out.println("----------------------------------------------");
					System.out.println("Exception in SampleCollectionContactPortlet::getUserFromRequest");
					System.out.println("SystemException");
					e.printStackTrace();
				}
			} else {
				user.setFirstName(firstname);
				user.setMiddleName(middlname);
				user.setLastName(lastname);
				user.setEmailAddress(email);
			}
			
			user.getExpandoBridge().setAttribute("juristicPersonId", juristicPersonId);
			user.getExpandoBridge().setAttribute("department", department);
			user.getExpandoBridge().setAttribute("orcId", orcId);
			

		} catch (Exception e) {
			System.out.println("----------------------------------------------");
			System.out.println("Exception in SampleCollectionContactPortlet::getUserFromRequest");
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return user;
	}
	

}
