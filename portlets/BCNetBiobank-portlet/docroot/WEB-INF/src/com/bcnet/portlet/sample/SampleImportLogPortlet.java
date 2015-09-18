package com.bcnet.portlet.sample;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
		int year = ParamUtil.getInteger(request, "year");
		int month = ParamUtil.getInteger(request, "month");
		int day = ParamUtil.getInteger(request, "day");
		int hour = ParamUtil.getInteger(request, "hour");
		int minute = ParamUtil.getInteger(request, "minute");
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(minute);
		/*long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
		Date sampledTime = ParamUtil.getDate(request, "sampleddate", new SimpleDateFormat("yyyyMMdd"));
		System.out.println(sampledTime);
		System.out.println(sampleDbId);
		int day = ParamUtil.getInteger(request, "day");
		System.out.println(day);
		int month = ParamUtil.getInteger(request, "month");
		System.out.println(month);
		int year = ParamUtil.getInteger(request, "year");
		System.out.println(year);
		int hour = ParamUtil.getInteger(request, "hour");
		System.out.println(hour);
		int minute = ParamUtil.getInteger(request, "minute");
		System.out.println(minute);
		int pm = ParamUtil.getInteger(request, "pm");
		System.out.println(pm);
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute);
		System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Date"+c.getTime());*/
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
			String[] storageTemperature = {"RT", "2 °C to 10 °C", "-18 °C to -35 °C", "-60 °C to -85 °C", "LN", "Other"};
			JSONArray jsonArray =  JSONFactoryUtil.createJSONArray();
			for(String str:storageTemperature){
				jsonArray.put(str);
			}
			resourceResponse.getPortletOutputStream().write(jsonArray.toString().getBytes());
		}
		
	}
	

}
