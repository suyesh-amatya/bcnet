package com.bcnet.portlet.sample;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleImportLogPortlet
 */
public class SampleImportLogPortlet extends MVCPortlet {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public void deleteSampleImport(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long importId = ParamUtil.getLong(request, "importId");//request.getParameter("importId")
		String uuid = ParamUtil.getString(request, "uuid");
		SampleLocalServiceUtil.deleteSamplesByuuid(uuid);
		SampleImportLogLocalServiceUtil.deleteSampleImportLog(importId);
		
		sendRedirect(request, response);
	}
	
	public void deleteSample(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
		SampleLocalServiceUtil.deleteSample(sampleDbId);
		
		sendRedirect(request, response);
	}
	
	public void editSample(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
		String sampleCollectionId = ParamUtil.getString(request, "sampleCollectionId");
		String hashedSampleId = ParamUtil.getString(request, "hashedSampleId");
		String materialType = ParamUtil.getString(request, "materialType");
		String container = ParamUtil.getString(request, "container");
		String storageTemperature = ParamUtil.getString(request, "storageTemperature");
		String yearmonthday = ParamUtil.getString(request, "yearmonthday");
		String hour = ParamUtil.getString(request, "hour");
		String minute = ParamUtil.getString(request, "minute");
		Date sampledTime = null;
		
		String yearmonthdayhourminute = null;
		if(!yearmonthday.isEmpty()){
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
				
		Sample sample = SampleLocalServiceUtil.getSample(sampleDbId);
		
		sample.setSampleCollectionId(sampleCollectionId);
		sample.setHashedSampleId(hashedSampleId);
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
		
		SampleLocalServiceUtil.updateSample(sample);
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("sampleCollectionId")){
			JSONArray jsonArray =  JSONFactoryUtil.createJSONArray();
			List<SampleCollection> sampleCollections = null;
			try {
				sampleCollections = SampleCollectionLocalServiceUtil.getSampleCollections(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(SampleCollection sc:sampleCollections){
				jsonArray.put(sc.getSampleCollectionId());
			}
			resourceResponse.getPortletOutputStream().write(jsonArray.toString().getBytes());
		}
		
		
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("materialType")){
			String[] materialType = {"DNA", "RNA", "cDNA/mRNA", "microRNA", "Whole Blood", "Peripheral Blood Cells", "Plasma", "Serum", "Tissue; Cryo Preserved"
					, "Tissue; Paraffin Preserved", "Cell Lines", "Urine", "Saliva", "Faeces", "Pathogen", "Other"};
			JSONArray jsonArray =  JSONFactoryUtil.createJSONArray();
			for(String str:materialType){
				jsonArray.put(str);
			}
			resourceResponse.getPortletOutputStream().write(jsonArray.toString().getBytes());
		}
		
		if(ParamUtil.getString(resourceRequest, "type").equalsIgnoreCase("storageTemperature")){
			String[] storageTemperature = {"RT", "2 �C to 10 �C", "-18 �C to -35 �C", "-60 �C to -85 �C", "LN", "Other"};
			JSONArray jsonArray =  JSONFactoryUtil.createJSONArray();
			for(String str:storageTemperature){
				jsonArray.put(str);
			}
			resourceResponse.getPortletOutputStream().write(jsonArray.toString().getBytes());
		}
		
	}
	

}
