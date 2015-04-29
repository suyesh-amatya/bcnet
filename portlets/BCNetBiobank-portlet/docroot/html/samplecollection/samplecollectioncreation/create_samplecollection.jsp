<%@ include file="/html/init.jsp" %>

<%
	
	long optionsPageTemplate_option = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));

	String redirect = ParamUtil.getString(request, "redirect");
	
	
%>


<portlet:renderURL var="viewSampleCollectionGeneralInfomrationURL" />
<portlet:actionURL name='createSampleCollection' var="createSampleCollectionURL" windowState="normal" />


<aui:form action="<%= createSampleCollectionURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<!-- hidden elements direct from config -->
		<aui:input name="pagetemplate" type="hidden" value ="<%= optionsPageTemplate_option %>" />
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input name="name" label='Name <i class="icon-asterisk"></i>' showRequiredLabel="false">
				<aui:validator name="required" errorMessage="The Name field is required."/>
				</aui:input>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="sampleCollectionId" label='Sample Collection Id' />
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="acronym" label="Acronym"/>
			</aui:column>
		</aui:row>
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input type="textarea" name="description" label='Description' rows="6"/>
			</aui:column>
			
			<% 
				String backup = null;
				
			%>
			<aui:column columnWidth="60">
				<label>Check the ones which apply:</label>
				<aui:input name="consentTemplate" type="checkbox" label="Consent Template"></aui:input>
				<aui:input name="reuseOfSamples" type="checkbox" label="Reuse of Samples"></aui:input>
				<aui:input name="materialTransferAgreement" type="checkbox" label="Material Transfer Agreement"></aui:input>
				<aui:input name="accreditation" type="checkbox" label="Accreditation"></aui:input>
				<aui:input name="qualityControl" type="checkbox" label="Quality Control"></aui:input>
			</aui:column>
			
			
		</aui:row>

	</aui:fieldset>

	<aui:button-row>
		<aui:column columnWidth="30">
			<aui:button type="submit" />
			<aui:button onClick="<%= viewSampleCollectionGeneralInfomrationURL %>"  type="cancel" />
		</aui:column>
	</aui:button-row>
</aui:form>