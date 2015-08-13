<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankGeneralInformation> searchContainer = null;
%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	List<Country> countries = CountryServiceUtil.getCountries();
	
	String countryCode =  ParamUtil.getString (request, "countryCode");
	String keywords = ParamUtil.getString(request, "keywords");
	

%>



<portlet:renderURL var="searchBiobankURL">
	<portlet:param name="mvcPath" value="/html/biobank/biobanksearch/biobanksearch.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<aui:form action="<%= searchBiobankURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:row>
			<aui:column>
				<aui:input name="keywords" label='Keywords <i class="icon-question-sign" title="Search by Keywords (Example: Name, Id, Acronym of the biobank;
				 Different Services and Facilities keywords like: Genomics, DNA/RNA Extraction, Cell Biology, MySQL, etc)"></i>' type="text" value="" style="width:500px"
					/>
			</aui:column>
			<aui:column>
				<aui:select name="countryCode" label='Country' >
					<aui:option>Select</aui:option>
					<%
						for (Country country : countries) {
					%>
					
							<aui:option selected="<%= country.getA2() == countryCode %>" value="<%= country.getA2() %>"><%=country.getName().toUpperCase() %></aui:option>
					
					<%
						}
					%>
				</aui:select>
			</aui:column>
			<aui:column>
				<aui:button type="submit" value="Search" cssClass="biobank-search-button"/>
				<aui:button type="cancel"  onClick="<%= redirect %>" cssClass="biobank-search-button"/>
			</aui:column>
		</aui:row>
		
	
	</aui:fieldset>
</aui:form>



<liferay-ui:search-container emptyResultsMessage="biobank-empty-results-message">

<%
	List<BiobankGeneralInformation> searchResults = BiobankGeneralInformationLocalServiceUtil.findBiobanksByKeywordsCountry(keywords, countryCode, searchContainer.getStart(), searchContainer.getEnd());
	int totalResults = BiobankGeneralInformationLocalServiceUtil.findBiobanksCountByKeywordsCountry(keywords, countryCode);
%>
	<liferay-ui:search-container-results
		results="<%= searchResults %>"
		total="<%= totalResults %>"
	/>
	<p><b>Total Results:  <%= totalResults %></b></p>
	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankGeneralInformation"
		keyProperty="biobankDbId"
		modelVar="biobankGeneralInformation" escapedModel="<%= true %>"
	>
	
		<liferay-ui:panel-container accordion="false">
		<%
			String countryName = "";
	
			try {
				countryName = CountryServiceUtil.getCountryByA2
						(biobankGeneralInformation.getCountryCode()).getName();
			} 
			catch (Exception e) {
			}

			String title = "<b>"+biobankGeneralInformation.getBiobankName()+"</b>"+"<br/>"+countryName.toUpperCase()+"<br/><a href="+biobankGeneralInformation.getUrl()+">"+biobankGeneralInformation.getUrl()+"</a>";
			String attributeListName = "";
			String attributeListValue = "";
		%>
			<liferay-ui:panel title="<%=title %>" defaultState="" cssClass="biobankSearchAccordionTitle"> 
		<%		
			
			
			List<BiobankAttributeLists> biobankAttributeLists = biobankGeneralInformation.getBiobankAttributeLists();
			if(biobankAttributeLists.size() != 0){
				int i = 0;
				for(BiobankAttributeLists biobankAttribute : biobankAttributeLists){
				
	
					if(!attributeListName.equalsIgnoreCase(biobankAttribute.getAttributeListName())){
						attributeListName = biobankAttribute.getAttributeListName();
						if(i!=0){ out.println("<br/>");}
					
		%>
					
						<b><%=attributeListName %>:</b>
	
		<%
						out.println(biobankAttribute.getAttributeListValue());
					
					}
					else{
						out.println(", "+biobankAttribute.getAttributeListValue());
					}
					i++;
				
				}
			}
			else{
				 out.println("No Services and Facilities Available For This Biobank");
			}
		%>
				
			
			</liferay-ui:panel>
			
		</liferay-ui:panel-container> 
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%-- <liferay-ui:search-container emptyResultsMessage="biobank-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankGeneralInformationLocalServiceUtil.findBiobanksByKeywordsCountry(keywords, countryCode, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= searchResults.size() %>"
	/>
	
	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankGeneralInformation"
		keyProperty="biobankDbId"
		modelVar="biobankGeneralInformation" escapedModel="<%= true %>"
	>
		

		
		<liferay-ui:search-container-column-text name="Search Results"> --%>
	<%-- <%	
		for(BiobankGeneralInformation biobankgeneralinformation : searchResults) {
	if(biobankDbId != biobankgeneralinformation.getBiobankDbId()) {out.println(biobankgeneralinformation.getBiobankDbId());
		%><h4 class="header toggler-header-collapsed"><span><%= biobankgeneralinformation.getBiobankName() %></span></h4><%
	}
	%><p class="content toggler-content-collapsed"><%
	String attributelistname = "";
	String attributelistvalue = "";
	List<BiobankAttributeLists> biobankattributelists = biobankgeneralinformation.getBiobankAttributeLists();
	out.println(biobankattributelists);
	for(BiobankAttributeLists biobankattribute : biobankattributelists){
		if(attributelistname.equalsIgnoreCase(biobankattribute.getAttributeListName())) {
			if(!attributelistvalue.equalsIgnoreCase("")) {
				attributelistvalue += ", ";
			}
			attributelistvalue += biobankattribute.getAttributeListValue();
		} else if(!attributelistname.equalsIgnoreCase("")) {
			%><%= biobankattribute.getAttributeListName() %>:<br />
			<%= attributelistvalue %>:<br /><%
			
			attributelistname = biobankattribute.getAttributeListName();
			attributelistvalue = "";
		}
	}
	%></p>
<%
}
%> --%>
		
		<%-- <table>
			<tbody>
				<tr>
					<td>
						<a href="http://catalogue.rd-connect.eu/web/clinical-registry-investigating-bardet-biedl-syndrome/home"><%=biobankGeneralInformation.getBiobankName() %></a>
					</td>
				</tr>
				<tr>
					<td><%=biobankGeneralInformation.getDescription()%></td>
				</tr>
				<tr>
					<td>
						<a href="https://cribbs.marshfieldclinic.org/"><%=biobankGeneralInformation.getUrl() %></a>
					</td>
				</tr>
			</tbody>
		</table> --%>
		<%-- </liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container> --%>


		