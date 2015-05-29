package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPersistence;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionGeneralInformationPortlet
 */
public class SampleCollectionGeneralInformationPortlet extends MVCPortlet {
 
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
	
	public void deleteSampleCollection(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		
		SampleCollectionContactLocalServiceUtil.deleteSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
		SampleCollectionLocalServiceUtil.deleteSampleCollection(sampleCollectionDbId);
		
	}
}
