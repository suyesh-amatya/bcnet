package com.bcnet.portlet.sample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.NoSuchSampleCollectionException;
import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleListerSearchPortlet
 */
public class SampleListerSearchPortlet extends MVCPortlet {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public void deleteSample(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
		SampleLocalServiceUtil.deleteSample(sampleDbId);
		
		sendRedirect(request, response);
	}
	
	
	public void editSample(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
		String sampleCollectionId = ParamUtil.getString(request, "sampleCollectionId");
		String hashedSampleId = ParamUtil.getString(request, "hashedSampleId");
		String hashedIndividualId = ParamUtil.getString(request, "hashedIndividualId");
		String materialType = ParamUtil.getString(request, "materialType");
		String container = ParamUtil.getString(request, "container");
		String storageTemperature = ParamUtil.getString(request, "storageTemperature");
		String yearmonthday = ParamUtil.getString(request, "yearmonthday");
		String hour = ParamUtil.getString(request, "hour");
		String minute = ParamUtil.getString(request, "minute");
		Date sampledTime = null;
		
		String yearmonthdayhourminute = null;
		if(!yearmonthday.isEmpty()){
			if(hour.isEmpty()){
				hour = "00";
			}
			if(minute.isEmpty()){
				minute = "00";
			}
			yearmonthdayhourminute = yearmonthday+" "+hour+":"+minute;
			try {
				sampledTime = sdf.parse(yearmonthdayhourminute);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String anatomicalPartOntology = ParamUtil.getString(request, "anatomicalPartOntology");
		String anatomicalPartOntologyVersion = ParamUtil.getString(request, "anatomicalPartOntologyVersion");
		String anatomicalPartOntologyCode = ParamUtil.getString(request, "anatomicalPartOntologyCode");
		String anatomicalPartOntologyDescription = ParamUtil.getString(request, "anatomicalPartOntologyDescription");
		String anatomicalPartFreeText = ParamUtil.getString(request, "anatomicalPartFreeText");
		String sex = ParamUtil.getString(request, "sex");
		long ageLow = ParamUtil.getLong(request, "ageLow");
		long ageHigh = ParamUtil.getLong(request, "ageHigh");
		String ageUnit = ParamUtil.getString(request, "ageUnit");
		String diseaseOntology = ParamUtil.getString(request, "diseaseOntology");
		String diseaseOntologyVersion = ParamUtil.getString(request, "diseaseOntologyVersion");
		String diseaseOntologyCode = ParamUtil.getString(request, "diseaseOntologyCode");
		String diseaseOntologyDescription = ParamUtil.getString(request, "diseaseOntologyDescription");
		String diseaseFreeText = ParamUtil.getString(request, "diseaseFreeText");
		String countryOfOrigin = ParamUtil.getString(request, "countryOfOrigin");
				
		Sample sample = SampleLocalServiceUtil.getSample(sampleDbId);
		
		if(!sampleCollectionId.equals("")){
			
			try{
				SampleCollection sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollectionBySampleCollectionId(sampleCollectionId);
				sample.setSampleCollectionDbId(sampleCollection.getSampleCollectionDbId());
				
			}
			catch(NoSuchSampleCollectionException e){
				e.printStackTrace();
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				SessionErrors.add(request, "sample-collection-does-not-exist");
				response.sendRedirect(themeDisplay.getURLPortal()+ParamUtil.getString(request, "editSampleFormURL"));
				return;
			}
			
		}
		else{
			sample.setSampleCollectionDbId(0);
		}
		
		
		sample.setHashedSampleId(hashedSampleId);
		sample.setHashedIndividualId(hashedIndividualId);
		sample.setMaterialType(materialType);
		sample.setContainer(container);
		sample.setStorageTemperature(storageTemperature);
		sample.setSampledTime(sampledTime);
		sample.setAnatomicalPartOntology(anatomicalPartOntology);
		sample.setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);
		sample.setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);
		sample.setAnatomicalPartOntologyDescription(anatomicalPartOntologyDescription);
		sample.setAnatomicalPartFreeText(anatomicalPartFreeText);
		sample.setSex(sex);
		sample.setAgeLow(ageLow);
		sample.setAgeHigh(ageHigh);
		sample.setAgeUnit(ageUnit);
		sample.setDiseaseOntology(diseaseOntology);
		sample.setDiseaseOntologyVersion(diseaseOntologyVersion);
		sample.setDiseaseOntologyCode(diseaseOntologyCode);
		sample.setDiseaseOntologyDescription(diseaseOntologyDescription);
		sample.setDiseaseFreeText(diseaseFreeText);
		sample.setCountryOfOrigin(countryOfOrigin);
		
		
		SampleLocalServiceUtil.updateSample(sample);
		
		//sendRedirect(request, response);
	}

}
