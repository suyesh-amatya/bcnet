<%@ include file="/html/init.jsp" %>


<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));
	
	SampleCollection sampleCollection = null;
	sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
	
	String redirect = ParamUtil.getString(request, "redirect");
	String currentURL = PortalUtil.getCurrentURL(request);
	
	
%>

<portlet:renderURL var="viewSampleCollectionGeneralInfomrationURL" />
<portlet:actionURL name='updateSampleCollection' var="updateSampleCollectionURL" windowState="normal" />
	
<% 
	String cancelURL = viewSampleCollectionGeneralInfomrationURL+"&scdbid="+sampleCollectionDbId;
%>

<aui:form action="<%= updateSampleCollectionURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="scdbid" type="hidden" value='<%= sampleCollectionDbId %>'/>
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input name="name" label='Name <i class="icon-asterisk"></i>' showRequiredLabel="false" value="<%=sampleCollection.getName() %>">
				<aui:validator name="required" errorMessage="The Name field is required."/>
				</aui:input>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="sampleCollectionId" label='Sample Collection Id' value="<%=sampleCollection.getSampleCollectionId() %>"/>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="acronym" label="Acronym" value="<%=sampleCollection.getAcronym() %>" />
			</aui:column>
		</aui:row>
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input type="textarea" name="description" label='Description' rows="6" value="<%=sampleCollection.getDescription() %>" />
			</aui:column>
			
			<aui:column columnWidth="60">
				<label>Check the ones which apply:</label>
				<aui:input name="consentTemplate" type="checkbox" label="Consent Template" checked="<%=sampleCollection.getConsentTemplate()==true %>"></aui:input>
				<aui:input name="reuseOfSamples" type="checkbox" label="Reuse of Samples" checked="<%=sampleCollection.getReuseOfSamples()==true %>"></aui:input>
				<aui:input name="materialTransferAgreement" type="checkbox" label="Material Transfer Agreement" checked="<%=sampleCollection.getMaterialTransferAgreement()==true %>"></aui:input>
				<aui:input name="accreditation" type="checkbox" label="Accreditation" checked="<%=sampleCollection.getAccreditation()==true %>"></aui:input>
				<aui:input name="qualityControl" type="checkbox" label="Quality Control" checked="<%=sampleCollection.getQualityControl()==true %>"></aui:input>
			</aui:column>
			
			
		</aui:row>

	</aui:fieldset>

	<aui:button-row>
		<aui:column columnWidth="30">
			<aui:button type="submit" />
			<aui:button onClick="<%= cancelURL %>"  type="cancel" />
		</aui:column>
	</aui:button-row>
</aui:form>