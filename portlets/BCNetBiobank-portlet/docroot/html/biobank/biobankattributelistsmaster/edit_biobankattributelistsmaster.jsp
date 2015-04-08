<%@ include file="/html/init.jsp" %>

<%
	BiobankAttributeListsMaster biobankAttributeListsMaster = null;

	long biobankAttributeListsMasterId = ParamUtil.getLong(request, "biobankAttributeListsMasterId");

	if (biobankAttributeListsMasterId > 0) {
		biobankAttributeListsMaster = BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMaster(biobankAttributeListsMasterId);
	}

	List<BiobankAttributeListsMaster> biobankAttributeNames = BiobankAttributeListsMasterLocalServiceUtil.getAllBiobankAttributeListsMasters();

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= biobankAttributeListsMaster %>" model="<%= BiobankAttributeListsMaster.class %>" />
<portlet:renderURL var="viewBiobankAttributeListsMasterURL" />
<portlet:actionURL name='<%= biobankAttributeListsMaster == null ? "addBiobankAttributeListsMaster" : "updateBiobankAttributeListsMaster" %>' var="editBiobankAttributeListsMasterURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewBiobankAttributeListsMasterURL %>"
	title='<%= (biobankAttributeListsMaster != null) ? biobankAttributeListsMaster.getAttributeListName() : "new-biobankAttributeListsMaster" %>'
/>

<aui:form action="<%= editBiobankAttributeListsMasterURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="biobankAttributeListsMasterId" type="hidden" value='<%= biobankAttributeListsMaster == null ? "" : biobankAttributeListsMaster.getBiobankAttributeListsMasterId() %>'/>

		<% 
			String biobankAttributeListName = "";
			if (biobankAttributeListsMaster != null) biobankAttributeListName = biobankAttributeListsMaster.getAttributeListName();
		%>

		<aui:select label="Attribute List Name" name="attributeListName" showEmptyOption="<%= true %>">
			<aui:option value="Type of Repository" selected="<%=\"Type of Repository\".equals(biobankAttributeListName) %>">Type of Repository</aui:option>
	 		<aui:option value="Data Management" selected="<%=\"Data Management\".equals(biobankAttributeListName) %>">Data Management</aui:option>
	 		<aui:option value="Database" selected="<%=\"Database\".equals(biobankAttributeListName) %>">Database</aui:option>
	 		<aui:option value="Storage Facility" selected="<%=\"Storage Facility\".equals(biobankAttributeListName) %>">Storage Facility</aui:option>
	 		<aui:option value="Monitoring" selected="<%=\"Monitoring\".equals(biobankAttributeListName) %>">Monitoring</aui:option>
	 		<aui:option value="Genetic Platform" selected="<%=\"Genetic Platform\".equals(biobankAttributeListName) %>">Genetic Platform</aui:option>
	 		<aui:option value="Proteomics Platform" selected="<%=\"Proteomics Platform\".equals(biobankAttributeListName) %>">Proteomics Platform</aui:option>
	 		<aui:option value="Metabolomics Platform" selected="<%=\"Metabolomics Platform\".equals(biobankAttributeListName) %>">Metabolomics Platform</aui:option>
	 		<aui:option value="Epigenomics Platform" selected="<%=\"Epigenomics Platform\".equals(biobankAttributeListName) %>">Epigenomics Platform</aui:option>
	 		<aui:option value="Bioinformatics Data Analysis Service" selected="<%=\"Bioinformatics Data Analysis Service\".equals(biobankAttributeListName) %>">Bioinformatics Data Analysis Service</aui:option>
			<aui:option value="Complementary Services" selected="<%=\"Complementary Services\".equals(biobankAttributeListName) %>">Complementary Services</aui:option>
			<aui:option value="Automation Services" selected="<%=\"Automation Services\".equals(biobankAttributeListName) %>">Automation Services</aui:option>		
			<aui:option value="Available Documents" selected="<%=\"Available Documents\".equals(biobankAttributeListName) %>">Available Documents</aui:option>
			<aui:option value="Type of Staff" selected="<%=\"Type of Staff\".equals(biobankAttributeListName) %>">Type of Staff</aui:option>
		</aui:select>
		
		<aui:input name="attributeListValue" label="Attribute Value"/>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewBiobankAttributeListsMasterURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>