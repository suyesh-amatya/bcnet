<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankGeneralInformation> searchContainer = null;

%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<liferay-ui:success key="biobankOrganizationDeleteSuccess" message="Greeting saved successfully!" />
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
			String countryName = CountryLocalServiceUtil.getCountry(biobankGeneralInformation.getCountryCode()).getName();
			
		%>
		
		
		<portlet:actionURL name="deleteBiobankOrganization" var="deleteBiobankOrganizationURL">
			<portlet:param name="biobankDbId" value="<%= String.valueOf(biobankGeneralInformation.getBiobankDbId()) %>" />
		</portlet:actionURL>
		
	
		<div class="well">
			<a href="<%=orgPath%>"><b><%= biobankGeneralInformation.getBiobankName() %></b></a>
			
			<liferay-ui:icon-delete url="<%= deleteBiobankOrganizationURL.toString() %>" 
				message="<%= \"Delete \"+biobankGeneralInformation.getBiobankName()+\"\" %>" 
				confirmation="<%= \"Are you sure you want to delete \"+biobankGeneralInformation.getBiobankName()+\"?\" %>"
				cssClass="biobankOrganizationDelete"/>
				
			<br/>
			
			<%=countryName%>
			
			<br/>
			
			<a href="<%=biobankGeneralInformation.getUrl()%>"><b><%= biobankGeneralInformation.getUrl() %></b></a>
			
		</div>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>