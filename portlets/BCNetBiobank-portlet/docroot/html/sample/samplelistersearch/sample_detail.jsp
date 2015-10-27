<%@ include file="/html/init.jsp" %>

<%
	long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
	String backURL = ParamUtil.getString(request, "backURL");
	
	Sample sample = SampleLocalServiceUtil.getSample(sampleDbId);
	
%>



<div class="sample-edit-form">
	<div class="sample-edit-form-header">Sample Detail</div>
	<div class="sample-edit-form-container">
		<dl class="dl-horizontal">
			
			<dt>Biobank:</dt>
			<%
			Organization organization = OrganizationLocalServiceUtil.getOrganization(sample.getBiobankDbId());
			String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
			%>
			<dd><aui:a href="<%=orgPath %>" target="blank"><%=BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(sample.getBiobankDbId()).getBiobankName() %></aui:a></dd>
		
			<%
			if(sample.getSampleCollectionDbId() > 0){
				String scPath = themeDisplay.getURLPortal()+"/sample-collections/general-information?scdbid="+sample.getSampleCollectionDbId();
				
			%>
			<dt>Sample Collection:</dt>
			<dd><aui:a href="<%=scPath %>" target="blank"><%=SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getName() %></aui:a></dd>
			<%
			}
			else{
			%>
			<dt>Sample Collection:</dt>
			<dd>N/A</dd>
			<%	
			}
			%>
			
			<dt>Hashed Sample Id:</dt>
			<%
			String hashedSampleId = "";
			if(!sample.getHashedSampleId().equals("")){
				hashedSampleId = sample.getHashedSampleId();
			}
			else{
				hashedSampleId = "N/A";
			}
			%>
			<dd><%=hashedSampleId%></dd>
			
			<dt>Hashed Individual Id:</dt>
			<%
			String hashedIndividualId = "";
			if(!sample.getHashedIndividualId().equals("")){
				hashedIndividualId = sample.getHashedIndividualId();
			}
			else{
				hashedIndividualId = "N/A";
			}
			%>
			<dd><%=hashedIndividualId%></dd>
			
			<dt>Material Type:</dt>
			<%
			String materialType = "";
			if(!sample.getMaterialType().equals("")){
				materialType = sample.getMaterialType();
			}
			else{
				materialType = "N/A";
			}
			%>
			<dd><%=materialType%></dd>
			
			<dt>Container:</dt>
			<%
			String container = "";
			if(!sample.getContainer().equals("")){
				container = sample.getContainer();
			}
			else{
				container = "N/A";
			}
			%>
			<dd><%=container%></dd>
			
			<dt>Storage Temperature:</dt>
			<%
			String storageTemperature = "";
			if(!sample.getStorageTemperature().equals("")){
				storageTemperature = sample.getStorageTemperature();
			}
			else{
				storageTemperature = "N/A";
			}
			%>
			<dd><%=storageTemperature%></dd>
			
			<dt>Sampled Time:</dt>
			<%
			String sampledTime = "";
			if(sample.getSampledTime() != null){
				sampledTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(sample.getSampledTime());
			}
			else{
				sampledTime = "N/A";
			}
			%>
			<dd><%=sampledTime%></dd>
		</dl>
				
		<hr/>
				
		<dl class="dl-horizontal">
			<dt>Anatomical Part</dt>
		</dl>
		<dl class="dl-horizontal">
			<dt>Ontology:</dt>
			<%
			String anatomicalPartOntology = "";
			if(!sample.getAnatomicalPartOntology().equals("")){
				anatomicalPartOntology = sample.getAnatomicalPartOntology();
			}
			else{
				anatomicalPartOntology = "N/A";
			}
			%>
			<dd><%=anatomicalPartOntology%></dd>
			
			<dt>Ontology Version:</dt>
			<%
			String anatomicalPartOntologyVersion = "";
			if(!sample.getAnatomicalPartOntologyVersion().equals("")){
				anatomicalPartOntologyVersion = sample.getAnatomicalPartOntologyVersion();
			}
			else{
				anatomicalPartOntologyVersion = "N/A";
			}
			%>
			<dd><%=anatomicalPartOntologyVersion%></dd>
			
			<dt>Ontology Code:</dt>
			<%
			String anatomicalPartOntologyCode = "";
			if(!sample.getAnatomicalPartOntologyCode().equals("")){
				anatomicalPartOntologyCode = sample.getAnatomicalPartOntologyCode();
			}
			else{
				anatomicalPartOntologyCode = "N/A";
			}
			%>
			<dd><%=anatomicalPartOntologyCode%></dd>
			
			<dt>Ontology Description:</dt>
			<%
			String anatomicalPartOntologyDescription = "";
			if(!sample.getAnatomicalPartOntologyDescription().equals("")){
				anatomicalPartOntologyDescription = sample.getAnatomicalPartOntologyDescription();
			}
			else{
				anatomicalPartOntologyDescription = "N/A";
			}
			%>
			<dd><%=anatomicalPartOntologyDescription%></dd>
			
			<dt>Free Text:</dt>
			<%
			String anatomicalPartFreeText = "";
			if(!sample.getAnatomicalPartFreeText().equals("")){
				anatomicalPartFreeText = sample.getAnatomicalPartFreeText();
			}
			else{
				anatomicalPartFreeText = "N/A";
			}
			%>
			<dd><%=anatomicalPartFreeText%></dd>
		</dl>
				
		<hr/>
				
		<dl class="dl-horizontal">
			<dt>Sex:</dt>
			<%
			String sex = "";
			if(!sample.getSex().equals("")){
				sex = sample.getSex();
			}
			else{
				sex = "N/A";
			}
			%>
			<dd><%=sex%></dd>
			
			<dt>Age Range:</dt>
			<%
			String ageRange = "";
			if(sample.getAgeLow() > 0 && sample.getAgeHigh() > 0){
				ageRange = sample.getAgeLow()+"-"+sample.getAgeHigh();
			}
			else{
				ageRange = "N/A";
			}
			%>
			<dd><%=ageRange%></dd>
			
			<dt>Age Unit:</dt>
			<%
			String ageUnit = "";
			if(!sample.getAgeUnit().equals("")){
				ageUnit = sample.getAgeUnit();
			}
			else{
				ageUnit = "N/A";
			}
			%>
			<dd><%=ageUnit%></dd>
			
			<dt>Country Of Origin:</dt>
			<%
			String countryOfOrigin = "";
			if(!sample.getCountryOfOrigin().equals("")){
				countryOfOrigin = sample.getCountryOfOrigin();
			}
			else{
				countryOfOrigin = "N/A";
			}
			%>
			<dd><%=countryOfOrigin%></dd>
		</dl>
				
		<hr/>
				
		<dl class="dl-horizontal">
			<dt>Disease</dt>
		</dl>
		<dl class="dl-horizontal">
			<dt>Ontology:</dt>
			<%
			String diseaseOntology = "";
			if(!sample.getDiseaseOntology().equals("")){
				diseaseOntology = sample.getDiseaseOntology();
			}
			else{
				diseaseOntology = "N/A";
			}
			%>
			<dd><%=diseaseOntology%></dd>
			
			<dt>Ontology Version:</dt>
			<%
			String diseaseOntologyVersion = "";
			if(!sample.getDiseaseOntologyVersion().equals("")){
				diseaseOntologyVersion = sample.getDiseaseOntologyVersion();
			}
			else{
				diseaseOntologyVersion = "N/A";
			}
			%>
			<dd><%=diseaseOntologyVersion%></dd>
			
			<dt>Ontology Code:</dt>
			<%
			String diseaseOntologyCode = "";
			if(!sample.getDiseaseOntologyCode().equals("")){
				diseaseOntologyCode = sample.getDiseaseOntologyCode();
			}
			else{
				diseaseOntologyCode = "N/A";
			}
			%>
			<dd><%=diseaseOntologyCode%></dd>
			
			<dt>Ontology Description:</dt>
			<%
			String diseaseOntologyDescription = "";
			if(!sample.getDiseaseOntologyDescription().equals("")){
				diseaseOntologyDescription = sample.getDiseaseOntologyDescription();
			}
			else{
				diseaseOntologyDescription = "N/A";
			}
			%>
			<dd><%=diseaseOntologyDescription%></dd>
			
			<dt>Free Text:</dt>
			<%
			String diseaseFreeText = "";
			if(!sample.getDiseaseFreeText().equals("")){
				diseaseFreeText = sample.getDiseaseFreeText();
			}
			else{
				diseaseFreeText = "N/A";
			}
			%>
			<dd><%=diseaseFreeText%></dd>
		</dl>
					
	</div>
</div>

<aui:button-row>
	<aui:button onClick="<%= backURL %>" value="back" cssClass="btn btn-primary"/>
</aui:button-row>
