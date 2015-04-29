<%@ include file="/html/init.jsp" %>

<%
	SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster = null;

	long sampleCollectionAttributeListsMasterId = ParamUtil.getLong(request, "sampleCollectionAttributeListsMasterId");

	if (sampleCollectionAttributeListsMasterId > 0) {
		sampleCollectionAttributeListsMaster = SampleCollectionAttributeListsMasterLocalServiceUtil.getSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}


	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= sampleCollectionAttributeListsMaster %>" model="<%= SampleCollectionAttributeListsMaster.class %>" />
<portlet:renderURL var="viewSampleCollectionAttributeListsMasterURL" />
<portlet:actionURL name='<%= sampleCollectionAttributeListsMaster == null ? "addSampleCollectionAttributeListsMaster" : "updateSampleCollectionAttributeListsMaster" %>' var="editSampleCollectionAttributeListsMasterURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewSampleCollectionAttributeListsMasterURL %>"
	title='<%= (sampleCollectionAttributeListsMaster != null) ? sampleCollectionAttributeListsMaster.getAttributeListName() : "new-sampleCollectionAttributeListsMaster" %>'
/>

<aui:form action="<%= editSampleCollectionAttributeListsMasterURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="sampleCollectionAttributeListsMasterId" type="hidden" value='<%= sampleCollectionAttributeListsMaster == null ? "" : sampleCollectionAttributeListsMaster.getSampleCollectionAttributeListsMasterId() %>'/>

		<% 
			String sampleCollectionAttributeListName = "";
			if (sampleCollectionAttributeListsMaster != null) sampleCollectionAttributeListName = sampleCollectionAttributeListsMaster.getAttributeListName();
		%>

		<aui:select label="Attribute List Name" name="attributeListName" showEmptyOption="<%= true %>">
			<aui:option value="Data Categories" selected="<%=\"Data Categories\".equals(sampleCollectionAttributeListName) %>">Data Categories</aui:option>
	 		<aui:option value="Material Type" selected="<%=\"Material Type\".equals(sampleCollectionAttributeListName) %>">Material Type</aui:option>
	 		<aui:option value="Storage Temperature" selected="<%=\"Storage Temperature\".equals(sampleCollectionAttributeListName) %>">Storage Temperature</aui:option>
	 		<aui:option value="Collection Type" selected="<%=\"Collection Type\".equals(sampleCollectionAttributeListName) %>">Collection Type</aui:option>
	 		<aui:option value="Disease" selected="<%=\"Disease\".equals(sampleCollectionAttributeListName) %>">Disease</aui:option>
	 		<aui:option value="Origin of Collection" selected="<%=\"Origin of Collection\".equals(sampleCollectionAttributeListName) %>">Origin of Collection</aui:option>
	 		<aui:option value="Consent Form" selected="<%=\"Consent Form\".equals(sampleCollectionAttributeListName) %>">Consent Form</aui:option>
	 		<aui:option value="Quality Management" selected="<%=\"Quality Management\".equals(sampleCollectionAttributeListName) %>">Quality Management</aui:option>
	 		<aui:option value="Storage Facility" selected="<%=\"Storage Facility\".equals(sampleCollectionAttributeListName) %>">Storage Facility</aui:option>
		</aui:select>
		
		<aui:input name="attributeListValue" label="Attribute Value"/>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewSampleCollectionAttributeListsMasterURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>