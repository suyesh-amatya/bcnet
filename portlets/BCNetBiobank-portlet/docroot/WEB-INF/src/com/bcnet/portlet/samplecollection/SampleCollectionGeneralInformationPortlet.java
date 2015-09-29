package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionGeneralInformationPortlet
 */
public class SampleCollectionGeneralInformationPortlet extends MVCPortlet {
 
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long sampleCollectionDbId = ParamUtil.getLong(resourceRequest, "sampleCollectionDbId");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		/* Check for duplicate sample collection name */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scName")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scNamescId")){
			String sampleCollectionName = ParamUtil.getString(resourceRequest, "name");
			String prevSampleCollectionName = null;
			
			try {
				prevSampleCollectionName = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId).getName();
			} catch (PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			boolean sampleCollectionNameExists = false;
			
			try {
				if(!sampleCollectionName.equalsIgnoreCase(prevSampleCollectionName)){
					for(SampleCollection sampleCollection : SampleCollectionLocalServiceUtil.getSampleCollections(QueryUtil.ALL_POS, QueryUtil.ALL_POS)){
						//While updating check if the sample collection name already exists! The sample collection name is deemed to already exist if its name
						//equals any other sample collections' name except the name of the current one being updated.
						if(sampleCollection.getName().equalsIgnoreCase(sampleCollectionName)){
							sampleCollectionNameExists = true;
							json.put("sampleCollectionNameExists", sampleCollectionNameExists == true ? true : false);
							
							break;
						}
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/* Check for duplicate sample collection id */
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scId")
				|| ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("scNamescId")){
			String sampleCollectionId = ParamUtil.getString(resourceRequest, "sampleCollectionId");
			String prevSampleCollectionId = null;
			
			try {
				prevSampleCollectionId = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId).getSampleCollectionId();
			} catch (PortalException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			boolean sampleCollectionIdExists = false;

			try {
				if(!sampleCollectionId.equalsIgnoreCase(prevSampleCollectionId)){
					for(SampleCollection sampleCollection : SampleCollectionLocalServiceUtil.getSampleCollections(QueryUtil.ALL_POS, QueryUtil.ALL_POS)){
						if(sampleCollection.getSampleCollectionId().equalsIgnoreCase(sampleCollectionId)){
							sampleCollectionIdExists = true;
							json.put("sampleCollectionIdExists", sampleCollectionIdExists == true ? true : false);
							
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
	
	
	public void updateSampleCollection(ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		String name = ParamUtil.getString(request, "name");
		String sampleCollectionId = ParamUtil.getString(request, "sampleCollectionId");
		String acronym = ParamUtil.getString(request, "acronym");
		String description = ParamUtil.getString(request, "description");
		boolean consentTemplate = ParamUtil.getBoolean(request, "consentTemplate");
		boolean reuseOfSamples = ParamUtil.getBoolean(request, "reuseOfSamples");
		boolean materialTransferAgreement = ParamUtil.getBoolean(request, "materialTransferAgreement");
		boolean accreditation = ParamUtil.getBoolean(request, "accreditation");
		boolean qualityControl = ParamUtil.getBoolean(request, "qualityControl");
		
		SampleCollection sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
		
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
		
		sendRedirect(request, response);
	}
	
	public void deleteSampleCollection(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		
		SampleCollectionContactLocalServiceUtil.deleteSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
		SampleCollectionLocalServiceUtil.deleteSampleCollection(sampleCollectionDbId);
		
		sendRedirect(request, response);
		
	}
}
