<%@ include file="/html/init.jsp" %>


<%
	Organization organization = null;
	long organizationId = 0;
	BiobankGeneralInformation biobankGeneralInformation = null;
	BiobankAttributeLists biobankAttributeLists = null;
	
	Group currentGroup = themeDisplay.getLayout().getGroup();
	if(currentGroup.isOrganization()){
		organizationId = currentGroup.getClassPK();
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	
	
	try{
		biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId);	
	}
	catch(Exception e){
		biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.createBiobankGeneralInformation(organizationId);
	}
	
	String redirect = ParamUtil.getString(request, "redirect");
	String cancelURL = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL();
	
	/* Type of Repository Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> typeOfRepositoryList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Type of Repository");
	
	List<BiobankAttributeLists> biobankTypeOfRepositoryList = BiobankAttributeListsLocalServiceUtil.
								getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Type of Repository");
			
	List<KeyValuePair> leftTypeOfRepositoryList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightTypeOfRepositoryList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: typeOfRepositoryList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankTypeOfRepositoryList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightTypeOfRepositoryList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftTypeOfRepositoryList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	} 
	
	/* Data Management Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> dataManagementList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Data Management");
	
	List<BiobankAttributeLists> biobankDataManagementList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Data Management");
			
	List<KeyValuePair> leftDataManagementList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightDataManagementList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: dataManagementList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankDataManagementList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightDataManagementList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftDataManagementList.add(new KeyValuePair(
					attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}	
	
	/* Database Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> databaseList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Database");
	
	List<BiobankAttributeLists> biobankDatabaseList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Database");
			
	List<KeyValuePair> leftDatabaseList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightDatabaseList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: databaseList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankDatabaseList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightDatabaseList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftDatabaseList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	} 
	
	
	/* Storage Facility Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> storageFacilityList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Storage Facility");
	
	List<BiobankAttributeLists> biobankStorageFacilityList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Storage Facility");
			
	List<KeyValuePair> leftStorageFacilityList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightStorageFacilityList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: storageFacilityList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankStorageFacilityList){
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
	
	
	/* Monitoring Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> monitoringList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Monitoring");
	
	List<BiobankAttributeLists> biobankMonitoringList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Monitoring");
			
	List<KeyValuePair> leftMonitoringList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightMonitoringList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: monitoringList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankMonitoringList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightMonitoringList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftMonitoringList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Genetic Platform Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> geneticPlatformList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Genetic Platform");
	
	List<BiobankAttributeLists> biobankGeneticPlatformList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Genetic Platform");
			
	List<KeyValuePair> leftGeneticPlatformList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightGeneticPlatformList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: geneticPlatformList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankGeneticPlatformList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightGeneticPlatformList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftGeneticPlatformList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Proteomics Platform Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> proteomicsPlatformList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Proteomics Platform");
	
	List<BiobankAttributeLists> biobankProteomicsPlatformList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Proteomics Platform");
			
	List<KeyValuePair> leftProteomicsPlatformList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightProteomicsPlatformList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: proteomicsPlatformList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankProteomicsPlatformList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightProteomicsPlatformList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftProteomicsPlatformList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Metabolomics Platform Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> metabolomicsPlatformList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Metabolomics Platform");
	
	List<BiobankAttributeLists> biobankMetabolomicsPlatformList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Metabolomics Platform");
			
	List<KeyValuePair> leftMetabolomicsPlatformList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightMetabolomicsPlatformList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: metabolomicsPlatformList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankMetabolomicsPlatformList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightMetabolomicsPlatformList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftMetabolomicsPlatformList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Epigenomics Platform Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> epigenomicsPlatformList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Epigenomics Platform");
	
	List<BiobankAttributeLists> biobankEpigenomicsPlatformList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Epigenomics Platform");
			
	List<KeyValuePair> leftEpigenomicsPlatformList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightEpigenomicsPlatformList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: epigenomicsPlatformList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankEpigenomicsPlatformList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightEpigenomicsPlatformList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftEpigenomicsPlatformList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Bioinformatics Data Analysis Service Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> bioinformaticsDataAnalysisServiceList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Bioinformatics Data Analysis Service");
	
	List<BiobankAttributeLists> biobankBioinformaticsDataAnalysisServiceList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Bioinformatics Data Analysis Service");
			
	List<KeyValuePair> leftBioinformaticsDataAnalysisServiceList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightBioinformaticsDataAnalysisServiceList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: bioinformaticsDataAnalysisServiceList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankBioinformaticsDataAnalysisServiceList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightBioinformaticsDataAnalysisServiceList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftBioinformaticsDataAnalysisServiceList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Complementary Services Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> complementaryServicesList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Complementary Services");
	
	List<BiobankAttributeLists> biobankComplementaryServicesList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Complementary Services");
			
	List<KeyValuePair> leftComplementaryServicesList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightComplementaryServicesList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: complementaryServicesList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankComplementaryServicesList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightComplementaryServicesList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftComplementaryServicesList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Automation Services Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> automationServicesList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Automation Services");
	
	List<BiobankAttributeLists> biobankAutomationServicesList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Automation Services");
			
	List<KeyValuePair> leftAutomationServicesList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightAutomationServicesList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: automationServicesList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankAutomationServicesList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightAutomationServicesList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftAutomationServicesList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
	
	
	/* Available Documents Lists for input-move-boxes */
	List<BiobankAttributeListsMaster> availableDocumentsList = BiobankAttributeListsMasterLocalServiceUtil.
										getBiobankAttributeListsMasterByAttributeListName("Available Documents");
	
	List<BiobankAttributeLists> biobankAvailableDocumentsList = BiobankAttributeListsLocalServiceUtil.
			getBiobankAttributeListsByBiobankDbId_AttributeListName(organizationId, "Available Documents");
			
	List<KeyValuePair> leftAvailableDocumentsList = new ArrayList<KeyValuePair>();
	List<KeyValuePair> rightAvailableDocumentsList = new ArrayList<KeyValuePair>();
	
	for(BiobankAttributeListsMaster attributeMaster: availableDocumentsList){
		boolean selected = false;
		for(BiobankAttributeLists attribute: biobankAvailableDocumentsList){
			if(attributeMaster.getAttributeListValue().equals(attribute.getAttributeListValue())){
				selected = true;
				rightAvailableDocumentsList.add(new KeyValuePair(
						attribute.getAttributeListName()+"_"+attribute.getAttributeListValue(), attribute.getAttributeListValue()));
				break;
			}
		}
		if(!selected){
			leftAvailableDocumentsList.add(new KeyValuePair(
						attributeMaster.getAttributeListName()+"_"+attributeMaster.getAttributeListValue(), attributeMaster.getAttributeListValue()));
			
		}
		
	}
%>

<aui:model-context bean="<%= biobankGeneralInformation %>" model="<%= BiobankGeneralInformation.class %>" />

<portlet:actionURL name='addBiobankAttributeLists' var="editBiobankAttributeListsURL" windowState="normal" />


<aui:form action="<%= editBiobankAttributeListsURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="biobankDbId" type="hidden" value='<%= biobankGeneralInformation == null ? "" : biobankGeneralInformation.getBiobankDbId() %>'/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availabletor"
			leftTitle="Type of Repository Available"
			leftList="<%=leftTypeOfRepositoryList %>"
			rightBoxName="selectedtor"
			rightTitle="Type of Repository Selected"
			rightList="<%= rightTypeOfRepositoryList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availabledm"
			leftTitle="Data Management Available"
			leftList="<%=leftDataManagementList %>"
			rightBoxName="selecteddm"
			rightTitle="Data Management Selected"
			rightList="<%= rightDataManagementList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availabledb"
			leftTitle="Database Available"
			leftList="<%=leftDatabaseList %>"
			rightBoxName="selecteddb"
			rightTitle="Database Selected"
			rightList="<%= rightDatabaseList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablesf"
			leftTitle="Storage Facility Available"
			leftList="<%=leftStorageFacilityList %>"
			rightBoxName="selectedsf"
			rightTitle="Storage Facility Selected"
			rightList="<%= rightStorageFacilityList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablem"
			leftTitle="Monitoring Available"
			leftList="<%=leftMonitoringList %>"
			rightBoxName="selectedm"
			rightTitle="Monitoring Selected"
			rightList="<%= rightMonitoringList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablegp"
			leftTitle="Genetic Platform Available"
			leftList="<%=leftGeneticPlatformList %>"
			rightBoxName="selectedgp"
			rightTitle="Genetic Platform Selected"
			rightList="<%= rightGeneticPlatformList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablepp"
			leftTitle="Proteomics Platform Available"
			leftList="<%=leftProteomicsPlatformList %>"
			rightBoxName="selectedpp"
			rightTitle="Proteomics Platform Selected"
			rightList="<%= rightProteomicsPlatformList%>"     
		/> 
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablemp"
			leftTitle="Metabolomics Platform Available"
			leftList="<%=leftMetabolomicsPlatformList %>"
			rightBoxName="selectedmp"
			rightTitle="Metabolomics Platform Selected"
			rightList="<%= rightMetabolomicsPlatformList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availableep"
			leftTitle="Epigenomics Platform Available"
			leftList="<%=leftEpigenomicsPlatformList %>"
			rightBoxName="selectedep"
			rightTitle="Epigenomics Platform Selected"
			rightList="<%= rightEpigenomicsPlatformList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablebdas"
			leftTitle="Bioinformatics Data Analysis Service Available"
			leftList="<%=leftBioinformaticsDataAnalysisServiceList %>"
			rightBoxName="selectedbdas"
			rightTitle="Bioinformatics Data Analysis Service Selected"
			rightList="<%= rightBioinformaticsDataAnalysisServiceList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablecs"
			leftTitle="Complementary Services Available"
			leftList="<%=leftComplementaryServicesList %>"
			rightBoxName="selectedcs"
			rightTitle="Complementary Services Selected"
			rightList="<%= rightComplementaryServicesList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availableas"
			leftTitle="Automation Services Available"
			leftList="<%=leftAutomationServicesList %>"
			rightBoxName="selectedas"
			rightTitle="Automation Services Selected"
			rightList="<%= rightAutomationServicesList%>"     
		/>
		
		<liferay-ui:input-move-boxes
			leftBoxName="availablead"
			leftTitle="Available Documents Available"
			leftList="<%=leftAvailableDocumentsList %>"
			rightBoxName="selectedad"
			rightTitle="Available Documents Selected"
			rightList="<%= rightAvailableDocumentsList%>"     
		/> 
		
	</aui:fieldset>
<% 

	String availabletor = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availabletor);";
	String selectedtor = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedtor);";
	String availabledm = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availabledm);";
	String selecteddm = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selecteddm);";
	String availabledb = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availabledb);";
	String selecteddb = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selecteddb);";
	String availablesf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablesf);";
	String selectedsf = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedsf);";
	String availablem = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablem);";
	String selectedm = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedm);";
	String availablegp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablegp);";
	String selectedgp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedgp);";
	String availablepp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablepp);";
	String selectedpp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedpp);";
	String availablemp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablemp);";
	String selectedmp = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedmp);";
	String availableep = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availableep);";
	String selectedep = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedep);";
	String availablebdas = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablebdas);";
	String selectedbdas = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedbdas);";
	String availablecs = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablecs);";
	String selectedcs = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedcs);";
	String availableas = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availableas);";
	String selectedas = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedas);";
	String availablead = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "availablead);";
	String selectedad = renderResponse.getNamespace() + "selectAll("+ renderResponse.getNamespace() + "selectedad);";

%>


	<aui:button-row>
		<aui:button type="submit" onClick="<%=availabletor+\"\"+selectedtor+\"\"+availabledm+\"\"
			+selecteddm+\"\"+availabledb+\"\"+selecteddb+\"\"+availablesf+\"\"+selectedsf
			+\"\"+availablem+\"\"+selectedm+\"\"+availablegp+\"\"+selectedgp+\"\"+availablepp+\"\"+selectedpp
			+\"\"+availablemp+\"\"+selectedmp+\"\"+availableep+\"\"+selectedep
			+\"\"+availablebdas+\"\"+selectedbdas+\"\"+availablecs+\"\"+selectedcs
			+\"\"+availableas+\"\"+selectedas+\"\"+availablead+\"\"+selectedad%>" />

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