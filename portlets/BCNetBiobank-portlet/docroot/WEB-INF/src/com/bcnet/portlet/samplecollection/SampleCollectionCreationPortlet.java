package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionCreationPortlet
 */
public class SampleCollectionCreationPortlet extends MVCPortlet {
 

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		/* Check for duplicate sample collection name */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scName")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scNamescId")){
			String sampleCollectionName = ParamUtil.getString(resourceRequest, "name");
			boolean sampleCollectionNameExists = false;
			
			try {
				for(SampleCollection sampleCollection : SampleCollectionLocalServiceUtil.getSampleCollections(QueryUtil.ALL_POS, QueryUtil.ALL_POS)){
					//While adding check if the sample collection name already exists! The sample collection name is deemed to already exist if its name 
					//equals any other sample collections' name.
					if(sampleCollection.getName().equalsIgnoreCase(sampleCollectionName)){
						sampleCollectionNameExists = true;
						json.put("sampleCollectionNameExists", sampleCollectionNameExists == true ? true : false);
						
						break;
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/* Check for duplicate biobank id */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scId")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scNamescId")){
			String sampleCollectionId = ParamUtil.getString(resourceRequest, "sampleCollectionId");
			boolean sampleCollectionIdExists = false;
			
			try {
				for(SampleCollection sampleCollection : SampleCollectionLocalServiceUtil.getSampleCollections(QueryUtil.ALL_POS, QueryUtil.ALL_POS)){
					if(sampleCollection.getSampleCollectionId().equalsIgnoreCase(sampleCollectionId)){
						sampleCollectionIdExists = true;
						json.put("sampleCollectionIdExists", sampleCollectionIdExists == true ? true : false);
						
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
	
	
	public void createSampleCollection(ActionRequest request, ActionResponse response) throws Exception{
		SampleCollection sampleCollection = _createSampleCollection(request);
		long sampleCollectionDbId = sampleCollection.getSampleCollectionDbId();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SessionMessages.add(request, "sample-collection-add-success");
		response.sendRedirect(themeDisplay.getURLPortal()+"/sample-collections/general-information?scdbid="+sampleCollectionDbId);
	}
	
	
	private SampleCollection _createSampleCollection(ActionRequest request) throws SystemException{
		
		SampleCollection sampleCollection;
		
		String name = ParamUtil.getString(request, "name");
		String sampleCollectionId = ParamUtil.getString(request, "sampleCollectionId");
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
}
