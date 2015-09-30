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
	
		<div class="well biobankSearch"  id="<%=biobankGeneralInformation.getBiobankDbId()%>">
			<div class="biobankSearchAccordionTitle">
			<%
				Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankGeneralInformation.getBiobankDbId());
				String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
				String countryName = "";
		
				try {
					countryName = CountryServiceUtil.getCountryByA2
							(biobankGeneralInformation.getCountryCode()).getName();
				} 
				catch (Exception e) {
				}
	
				String title = "<a href="+orgPath+"><b>"+biobankGeneralInformation.getBiobankName()+"</b></a>"+"<br/>"+countryName.toUpperCase()+"<br/><a href="+biobankGeneralInformation.getUrl()+" target=\"_blank\">"+biobankGeneralInformation.getUrl()+"</a>";
				
				out.println(title);
				
				String attributeListName = "";
				String attributeListValue = "";
			%>
			</div>
			<h6 class="header toggler-header-collapsed"><a href="#">More</a></h6>
			<p class="content toggler-content-collapsed">
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
			</p>
		</div>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
	
<aui:script>
AUI().use('aui-toggler', function(A){
	A.all("h6 .header, .toggler-header-collapsed").on('click', function(event){
		if(event.target.get('text')=='More'){
		 event.target.set('text', 'Less');
		}
		else{
		 event.target.set('text', 'More');
		}
		 
		var containerId = event.target.get('parentNode').get('parentNode').get('id');
		new A.TogglerDelegate(
	    	{
		        animated: true,
		        closeAllOnExpand: true,
		        container: "#"+containerId,
		        content: '.content',
		        expanded: false,
		        header: '.header',
		        transition: {
					duration: 0.2,
					easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
	    	}
		); 
	});
});
</aui:script>