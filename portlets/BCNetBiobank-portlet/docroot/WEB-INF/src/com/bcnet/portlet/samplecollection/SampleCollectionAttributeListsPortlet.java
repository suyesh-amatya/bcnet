package com.bcnet.portlet.samplecollection;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleCollectionAttributeListsPortlet
 */
public class SampleCollectionAttributeListsPortlet extends MVCPortlet {

	public void deleteSampleCollectionAttributeLists(ActionRequest request,
            ActionResponse response) throws IOException{
		
		long sampleCollectionDbId = ParamUtil.getLong(request, "scdbid");
		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);

	}
	
	
	public void addSampleCollectionAttributeLists(ActionRequest request, ActionResponse response) throws SystemException, IOException{
        
        editSampleCollectionAttributeListsDataCategories(request, response);
        editSampleCollectionAttributeListsMaterialType(request, response);
        editSampleCollectionAttributeListsStorageTemperature(request, response);
        editSampleCollectionAttributeListsCollectionType(request, response);
        editSampleCollectionAttributeListsDisease(request, response);
        editSampleCollectionAttributeListsOriginOfCollection(request, response);
        editSampleCollectionAttributeListsConsentForm(request, response);
        editSampleCollectionAttributeListsQualityManagement(request, response);
        editSampleCollectionAttributeListsStorageFacility(request, response);
      
        sendRedirect(request, response);
    }


	
	private void editSampleCollectionAttributeListsDataCategories(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availabledc = ParamUtil.getParameterValues(request, "availabledc");
        String[] selecteddc = ParamUtil.getParameterValues(request, "selecteddc");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availabledc, selecteddc);
		
	}

	
	private void editSampleCollectionAttributeListsMaterialType(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availablemt = ParamUtil.getParameterValues(request, "availablemt");
        String[] selectedmt = ParamUtil.getParameterValues(request, "selectedmt");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availablemt, selectedmt);
		
	}
	
	
	private void editSampleCollectionAttributeListsStorageTemperature(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availablest = ParamUtil.getParameterValues(request, "availablest");
        String[] selectedst = ParamUtil.getParameterValues(request, "selectedst");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availablest, selectedst);
		
	}
	
	
	private void editSampleCollectionAttributeListsCollectionType(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availablect = ParamUtil.getParameterValues(request, "availablect");
        String[] selectedct = ParamUtil.getParameterValues(request, "selectedct");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availablect, selectedct);
		
	}
	
	
	private void editSampleCollectionAttributeListsDisease(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availabled = ParamUtil.getParameterValues(request, "availabled");
        String[] selectedd = ParamUtil.getParameterValues(request, "selectedd");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availabled, selectedd);
		
	}
	
	
	private void editSampleCollectionAttributeListsOriginOfCollection(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availableooc = ParamUtil.getParameterValues(request, "availableooc");
        String[] selectedooc = ParamUtil.getParameterValues(request, "selectedooc");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availableooc, selectedooc);
		
	}
	
	
	private void editSampleCollectionAttributeListsConsentForm(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availablecf = ParamUtil.getParameterValues(request, "availablecf");
        String[] selectedcf = ParamUtil.getParameterValues(request, "selectedcf");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availablecf, selectedcf);
		
	}
	
	
	private void editSampleCollectionAttributeListsQualityManagement(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availableqm = ParamUtil.getParameterValues(request, "availableqm");
        String[] selectedqm = ParamUtil.getParameterValues(request, "selectedqm");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availableqm, selectedqm);
		
	}
	
	
	private void editSampleCollectionAttributeListsStorageFacility(
			ActionRequest request, ActionResponse response) throws SystemException {
		// TODO Auto-generated method stub
		long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
        String[] availablesf = ParamUtil.getParameterValues(request, "availablesf");
        String[] selectedsf = ParamUtil.getParameterValues(request, "selectedsf");
        
        editSampleCollectionAttributeLists(sampleCollectionDbId, availablesf, selectedsf);
		
	}
	
	
	
	private void editSampleCollectionAttributeLists(long sampleCollectionDbId,
			String[] available, String[] selected) throws SystemException {
		// TODO Auto-generated method stub
		
		/* Input-move-boxes add/update/delete logic for Sample Collection Attribute Lists */

		for(String str : available){
        	String attributeListName = str.split("_")[0];
        	String attributeListValue = str.split("_")[1];
        	
        	SampleCollectionAttributeLists sampleCollectionAttributeLists = null;
        	sampleCollectionAttributeLists = SampleCollectionAttributeListsLocalServiceUtil.
        			getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName_AttributeListValue(sampleCollectionDbId, attributeListName, attributeListValue);
        	
        	if(sampleCollectionAttributeLists != null){
        		SampleCollectionAttributeListsLocalServiceUtil.deleteSampleCollectionAttributeLists(sampleCollectionAttributeLists);
        	}
        	
        }
		
		for(String str : selected){
        	String attributeListName = str.split("_")[0];
        	String attributeListValue = str.split("_")[1];
        	
        	SampleCollectionAttributeLists sampleCollectionAttributeLists = null;
        	sampleCollectionAttributeLists = SampleCollectionAttributeListsLocalServiceUtil.
        			getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName_AttributeListValue(sampleCollectionDbId, attributeListName, attributeListValue);
        	
        	if(sampleCollectionAttributeLists != null){
        		continue;
        	}
        	else{
        		long sampleCollectionAttributeListsId = CounterLocalServiceUtil.increment();
        		sampleCollectionAttributeLists = SampleCollectionAttributeListsLocalServiceUtil.createSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
        		sampleCollectionAttributeLists.setSampleCollectionDbId(sampleCollectionDbId);
        		sampleCollectionAttributeLists.setAttributeListName(attributeListName);
        		sampleCollectionAttributeLists.setAttributeListValue(attributeListValue);
        		SampleCollectionAttributeListsLocalServiceUtil.addSampleCollectionAttributeLists(sampleCollectionAttributeLists);
        		
        		/*
        		 * Alternative way to achieve the same result is to use the method call below. 
        		 * But then such method should be implemented in the SampleCollectionAttributeListsLocalServiceImpl class.
        		 * In BiobankAttributeListsPortlet such way has been used.
        		 * 
        		 * */
        		//SampleCollectionAttributeListsLocalServiceUtil.addSampleCollectionAttributeLists(sampleCollectionDbId, attributeListName, attributeListValue);
        	}
        	
        }
		
	}


}
