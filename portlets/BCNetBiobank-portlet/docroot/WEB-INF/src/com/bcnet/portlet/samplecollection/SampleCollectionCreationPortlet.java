package com.bcnet.portlet.samplecollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionCreationPortlet
 */
public class SampleCollectionCreationPortlet extends MVCPortlet {
 

	public void createSampleCollection(ActionRequest request, ActionResponse response) throws Exception{
		SampleCollection sampleCollection = _createSampleCollection(request);
		long sampleCollectionDbId = sampleCollection.getSampleCollectionDbId();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		//response.setRenderParameter("mvcPath",
	    //          "/html/samplecollection/samplecollectiongeneralinformation/view.jsp?scdbid="+sampleCollectionDbId);
		response.sendRedirect(themeDisplay.getURLPortal()+"/sample-collections/"+"general-information?scdbid="+sampleCollectionDbId);
		//sendRedirect(request, response);
		//response.sendRedirect(themeDisplay.getURLPortal()+"/web"+themeDisplay.getSiteGroup().getFriendlyURL());
	}
	
	
	private SampleCollection _createSampleCollection(ActionRequest request) throws SystemException{
		
		/*long pageTemplate = ParamUtil.getLong(request, "pagetemplate");
		boolean site = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Group siteGroup = themeDisplay.getSiteGroup();
		if(site){
			try {
				createPages(siteGroup, pageTemplate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		SampleCollection sampleCollection;
		
		String name = ParamUtil.getString(request, "name");
		String sampleCollectionId = ParamUtil.getString(request, "SampleCollectionId");
		String acronym = ParamUtil.getString(request, "acronym");
		String description = ParamUtil.getString(request, "description");
		boolean consentTemplate = ParamUtil.getBoolean(request, "consentTemplate");
		boolean reuseOfSamples = ParamUtil.getBoolean(request, "reuseOfSamples");
		boolean materialTransferAgreement = ParamUtil.getBoolean(request, "materialTransferAgreement");
		boolean accreditation = ParamUtil.getBoolean(request, "accreditation");
		boolean qualityControl = ParamUtil.getBoolean(request, "qualityControl");
		
		long sampleCollectionDbId = CounterLocalServiceUtil.increment();
		sampleCollection = SampleCollectionLocalServiceUtil.createSampleCollection(sampleCollectionDbId);
		sampleCollection.setName(name);
		sampleCollection.setSampleCollectionId(sampleCollectionId);
		sampleCollection.setAcronym(acronym);
		sampleCollection.setDescription(description);
		sampleCollection.setConsentTemplate(consentTemplate);
		sampleCollection.setReuseOfSamples(reuseOfSamples);
		sampleCollection.setMaterialTransferAgreement(materialTransferAgreement);
		sampleCollection.setAccreditation(accreditation);
		sampleCollection.setQualityControl(qualityControl);
		
		SampleCollectionLocalServiceUtil.updateSampleCollection(sampleCollection);
		
		return sampleCollection;
	}


	private void createPages(Group siteGroup, long publicLayoutSetPrototypeId) throws Exception {
		try {
			boolean isPrivateLayout = false;			
			long groupId = siteGroup.getGroupId();
		    LayoutSetPrototype prototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(publicLayoutSetPrototypeId);
		    boolean layoutSetPrototypeLinkEnabled = true;
		    LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(groupId, isPrivateLayout,
		            layoutSetPrototypeLinkEnabled, prototype.getUuid());
		    
		    LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, isPrivateLayout);
		    SitesUtil.mergeLayoutSetPrototypeLayouts(siteGroup, layoutSet);
		} catch (Exception e) {
			System.out.println("------------------------------------------------------");
			System.out.println("Exception in creating sample collection pages!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
