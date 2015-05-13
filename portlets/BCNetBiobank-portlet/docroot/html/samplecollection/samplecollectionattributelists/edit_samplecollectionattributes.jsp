<%@ include file="/html/init.jsp" %>

<%
	/* Accessing "sampleCollectionDbId" which has been passed as portlet parameter. */
	
	long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
	//out.println("sampleCollectionDbId:"+sampleCollectionDbId+"<br/>");
	
	
	/* Alternate way to access "scdbid" which has been passed as a parameter in url. */
	
	/* HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long scdbid = Long.parseLong(httpRequest.getParameter("scdbid"));
	out.println("scdbid:"+scdbid); */
	
	String redirect = ParamUtil.getString(request, "redirect");
	
	
	/* Data Categories Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> dataCategoriesList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Data Categories");
	
	List<SampleCollectionAttributeLists> sampleCollectionDataCategoriesList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Data Categories");
			
	List<KeyValuePair> leftDataCategoriesList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightDataCategoriesList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: dataCategoriesList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionDataCategoriesList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightDataCategoriesList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftDataCategoriesList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Material Type Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> materialTypeList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Material Type");
	
	List<SampleCollectionAttributeLists> sampleCollectionMaterialTypeList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Material Type");
			
	List<KeyValuePair> leftMaterialTypeList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightMaterialTypeList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: materialTypeList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionMaterialTypeList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightMaterialTypeList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftMaterialTypeList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Storage Temperature Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> storageTemperatureList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Storage Temperature");
	
	List<SampleCollectionAttributeLists> sampleCollectionStorageTemperatureList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Storage Temperature");
			
	List<KeyValuePair> leftStorageTemperatureList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightStorageTemperatureList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: storageTemperatureList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionStorageTemperatureList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightStorageTemperatureList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftStorageTemperatureList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Collection Type Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> collectionTypeList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Collection Type");
	
	List<SampleCollectionAttributeLists> sampleCollectionCollectionTypeList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Collection Type");
			
	List<KeyValuePair> leftCollectionTypeList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightCollectionTypeList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: collectionTypeList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionCollectionTypeList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightCollectionTypeList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftCollectionTypeList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Disease Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> diseaseList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Disease");
	
	List<SampleCollectionAttributeLists> sampleCollectionDiseaseList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Disease");
			
	List<KeyValuePair> leftDiseaseList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightDiseaseList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: diseaseList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionDiseaseList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightDiseaseList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftDiseaseList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Origin of Collection Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> originOfCollectionList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Origin of Collection");
	
	List<SampleCollectionAttributeLists> sampleCollectionOriginOfCollectionList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Origin of Collection");
			
	List<KeyValuePair> leftOriginOfCollectionList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightOriginOfCollectionList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: originOfCollectionList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionOriginOfCollectionList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightOriginOfCollectionList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftOriginOfCollectionList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Consent Form Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> consentFormList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Consent Form");
	
	List<SampleCollectionAttributeLists> sampleCollectionConsentFormList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Consent Form");
			
	List<KeyValuePair> leftConsentFormList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightConsentFormList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: consentFormList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionConsentFormList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightConsentFormList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftConsentFormList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Quality Management Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> qualityManagementList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Quality Management");
	
	List<SampleCollectionAttributeLists> sampleCollectionQualityManagementList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Quality Management");
			
	List<KeyValuePair> leftQualityManagementList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightQualityManagementList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: qualityManagementList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionQualityManagementList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightQualityManagementList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftQualityManagementList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Storage Facility Lists for input-move-boxes */
	List<SampleCollectionAttributeListsMaster> storageFacilityList = SampleCollectionAttributeListsMasterLocalServiceUtil.
										getSampleCollectionAttributeListsMasterByAttributeListName("Storage Facility");
	
	List<SampleCollectionAttributeLists> sampleCollectionStorageFacilityList = SampleCollectionAttributeListsLocalServiceUtil.
								getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId, "Storage Facility");
			
	List<KeyValuePair> leftStorageFacilityList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightStorageFacilityList = new ArrayList<KeyValuePair>();
	
	for(SampleCollectionAttributeListsMaster attributeMaster: storageFacilityList){
		boolean selected = false;
		for(SampleCollectionAttributeLists attribute: sampleCollectionStorageFacilityList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightStorageFacilityList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftStorageFacilityList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
%>
<portlet:actionURL name='addSampleCollectionAttributeLists' var="editSampleCollectionAttributeListsURL" windowState="normal" />

<aui:form action="<%= editSampleCollectionAttributeListsURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="sampleCollectionDbId" type="hidden" value='<%= sampleCollectionDbId %>'/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availabledc"
			leftTitle="Data Categories Available"
			leftList="<%=leftDataCategoriesList %>"
			rightBoxName="selecteddc"
			rightTitle="Data Categories Selected"
			rightList="<%= rightDataCategoriesList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablemt"
			leftTitle="Material Type Available"
			leftList="<%=leftMaterialTypeList %>"
			rightBoxName="selectedmt"
			rightTitle="Material Type Selected"
			rightList="<%= rightMaterialTypeList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablest"
			leftTitle="Storage Temperature Available"
			leftList="<%=leftStorageTemperatureList %>"
			rightBoxName="selectedst"
			rightTitle="Storage Temperature Selected"
			rightList="<%= rightStorageTemperatureList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablect"
			leftTitle="Collection Type Available"
			leftList="<%=leftCollectionTypeList %>"
			rightBoxName="selectedct"
			rightTitle="Collection Type Selected"
			rightList="<%= rightCollectionTypeList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availabled"
			leftTitle="Disease Available"
			leftList="<%=leftDiseaseList %>"
			rightBoxName="selectedd"
			rightTitle="Disease Selected"
			rightList="<%= rightDiseaseList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availableooc"
			leftTitle="Origin of Collection Available"
			leftList="<%=leftOriginOfCollectionList %>"
			rightBoxName="selectedooc"
			rightTitle="Origin of Collection Selected"
			rightList="<%= rightOriginOfCollectionList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablecf"
			leftTitle="Consent Form Available"
			leftList="<%=leftConsentFormList %>"
			rightBoxName="selectedcf"
			rightTitle="Consent Form Selected"
			rightList="<%= rightConsentFormList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availableqm"
			leftTitle="Quality Management Available"
			leftList="<%=leftQualityManagementList %>"
			rightBoxName="selectedqm"
			rightTitle="Quality Management Selected"
			rightList="<%= rightQualityManagementList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablesf"
			leftTitle="Storage Facility Available"
			leftList="<%=leftStorageFacilityList %>"
			rightBoxName="selectedsf"
			rightTitle="Storage Facility Selected"
			rightList="<%= rightStorageFacilityList%>"     
		/>
	</aui:fieldset>

<% 

	String availabledc = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availabledc);";
	String selecteddc = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selecteddc);";
	String availablemt = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablemt);";
	String selectedmt = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedmt);";
	String availablest = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablest);";
	String selectedst = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedst);";
	String availablect = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablect);";
	String selectedct = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedct);";
	String availabled = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availabled);";
	String selectedd = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedd);";
	String availableooc = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availableooc);";
	String selectedooc = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedooc);";
	String availablecf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablecf);";
	String selectedcf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedcf);";
	String availableqm = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availableqm);";
	String selectedqm = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedqm);";
	String availablesf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablesf);";
	String selectedsf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedsf);";

%>

	<aui:button-row>
		<aui:button type="submit" onClick="<%=availabledc+\"\"+selecteddc+\"\"+availablemt+\"\"
			+selectedmt+\"\"+availablest+\"\"+selectedst+\"\"+availablect+\"\"+selectedct
			+\"\"+availabled+\"\"+selectedd+\"\"+availableooc+\"\"+selectedooc+\"\"+availablecf+\"\"+selectedcf
			+\"\"+availableqm+\"\"+selectedqm+\"\"+availablesf+\"\"+selectedsf%>" />

		<aui:button onClick="<%=redirect.toString()%>"  type="cancel" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
function <portlet:namespace />selectAll(selectbox){
	for (var i=0; i<selectbox.options.length; i++) {
		selectbox.options[i].selected = true;
	}
}
</script>