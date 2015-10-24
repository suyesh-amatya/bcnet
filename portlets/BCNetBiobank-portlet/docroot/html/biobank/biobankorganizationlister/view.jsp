<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="samples-exist-for-this-biobank" message="samples-exist-for-this-biobank" />

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_delete_biobank = "DELETE_BIOBANK";
%>

<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankGeneralInformation> searchContainer = null;

%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>



<liferay-ui:search-container emptyResultsMessage="biobank-empty-results-message">

<%
	List<BiobankGeneralInformation> biobankOrganizations = BiobankGeneralInformationLocalServiceUtil.findAllBiobankOrganizations(searchContainer.getStart(), searchContainer.getEnd());
	int totalResults = BiobankGeneralInformationLocalServiceUtil.findAllBiobankOrganizationsCount();

%>
	<liferay-ui:search-container-results
		results="<%= biobankOrganizations %>"
		total="<%= totalResults %>"
	/>
	<p><b>Total Results:  <%= totalResults %></b></p>
	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankGeneralInformation"
		keyProperty="biobankDbId"
		modelVar="biobankGeneralInformation" escapedModel="<%= true %>"
	>
		<%
			Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankGeneralInformation.getBiobankDbId());
			String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
			String countryName = CountryServiceUtil.getCountryByA2(biobankGeneralInformation.getCountryCode()).getName();
			
		%>
		
		
		<portlet:actionURL name="deleteBiobankOrganization" var="deleteBiobankOrganizationURL">
			<portlet:param name="biobankDbId" value="<%= String.valueOf(biobankGeneralInformation.getBiobankDbId()) %>" />
		</portlet:actionURL>
		
	
		<div class="well">
			<a href="<%=orgPath%>"><b><%= biobankGeneralInformation.getBiobankName() %></b></a>
			<%
				boolean biobankOwner = false;
				for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroupId())) {
					if(ugr.getRole().getName().equalsIgnoreCase("Biobank Owner"))
						biobankOwner = true;    
				}
			
				if(biobankOwner || permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_biobank)){
			%>
					<liferay-ui:icon-delete url="<%= deleteBiobankOrganizationURL.toString() %>" 
						message="<%= \"Delete \"+biobankGeneralInformation.getBiobankName()+\"\" %>" 
						confirmation="<%= \"Are you sure you want to delete \"+biobankGeneralInformation.getBiobankName()+\"?\" %>"
						cssClass="biobankOrganizationDelete"/>
   			<%
				}
   			%>
				
			<br/>
			
			<%=countryName.toUpperCase()%>
			
			<br/>
			
			<a href="<%=biobankGeneralInformation.getUrl()%>" target="_blank"><b><%= biobankGeneralInformation.getUrl() %></b></a>
			
		</div>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>