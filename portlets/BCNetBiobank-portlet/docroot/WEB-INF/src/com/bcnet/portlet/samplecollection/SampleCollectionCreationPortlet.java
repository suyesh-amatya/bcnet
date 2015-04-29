package com.bcnet.portlet.samplecollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionCreationPortlet
 */
public class SampleCollectionCreationPortlet extends MVCPortlet {
 

	public void createSampleCollection(ActionRequest request, ActionResponse response) throws Exception{
		SampleCollection sampleCollection = _createSampleCollection(request);
		long sampleCollectionDbId = sampleCollection.getSampleCollectionDbId();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
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
