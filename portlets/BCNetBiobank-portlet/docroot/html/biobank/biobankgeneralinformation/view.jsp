<%@ include file="/html/init.jsp" %>

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_edit_biobank_general_information = "EDIT_BIOBANK_GENERAL_INFORMATION";
String actionId_delete_biobank = "DELETE_BIOBANK";
%>


<%
	Organization organization = null;
	long organizationId = 0;
	BiobankGeneralInformation biobankGeneralInformation = null;
	
	Group currentGroup = themeDisplay.getLayout().getGroup();
	if(currentGroup.isOrganization()){
		organizationId = currentGroup.getClassPK();
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	
	if(organization != null){
		try{
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId);	
		}
		catch(Exception e){
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.createBiobankGeneralInformation(organizationId);
		}
	
	}
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
<liferay-ui:error key="duplicate-name" message="Biobank Name Already Taken!" />
<portlet:renderURL var="addBiobankGeneralInformationURL">
	<portlet:param name="mvcPath" value="/html/biobank/biobankgeneralinformation/edit_biobank_general_information.jsp" />
	<portlet:param name="biobankDbId" value="<%= String.valueOf(organizationId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name="deleteBiobankOrganization" var="deleteBiobankOrganizationURL">
	<portlet:param name="biobankDbId" value="<%= String.valueOf(organizationId) %>" />
	<%-- <portlet:param name="redirect" value="<%= themeDisplay.getURLPortal() %>" /> --%>
</portlet:actionURL>


<div class="list-group">
	<span class="list-group-item-active">
		<b><%=organization.getName() %></b>
		
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_biobank_general_information) %>">
				<a href="<%=addBiobankGeneralInformationURL.toString()%>">
				<liferay-ui:icon image="edit" message="Edit Biobank" cssClass="biobankOrganizationEdit"/>
				</a>
			</c:when>
		</c:choose>
		
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_biobank) %>">
				<liferay-ui:icon-delete url="<%= deleteBiobankOrganizationURL.toString() %>" message="Delete Biobank" cssClass="biobankOrganizationDelete"
				confirmation="Are you sure you want to delete it?"/>
			</c:when>
		</c:choose>
	</span>
	<span class="list-group-item">BiobankId: <b><%=biobankGeneralInformation.getBiobankId() %></b></span>
	<span class="list-group-item">Acronym: <b><%=biobankGeneralInformation.getAcronym() %></b></span>
	<span class="list-group-item">URL: <aui:a href="<%=biobankGeneralInformation.getUrl() %>" target="blank"><b><%=biobankGeneralInformation.getUrl() %></b></aui:a></span>
  
	<%
		String juristicPersonName = "";
		
		try {
			juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
					(biobankGeneralInformation.getJuristicPersonId()).getName();
		} 
		catch (Exception e) {
		}
	%>
  
	<span class="list-group-item">Juristic Person: <b><%=juristicPersonName %></b></span>
  
	<%
		String countryName = "";
		
		try {
			countryName = CountryServiceUtil.getCountryByA2
					(biobankGeneralInformation.getCountryCode()).getName();
		} 
		catch (Exception e) {
		}
	%>
	<span class="list-group-item">Country: <b><%=countryName.toUpperCase() %></b></span>
	
	<span class="list-group-item">Description: <b><%=biobankGeneralInformation.getDescription() %></b></span>
	<span class="list-group-item">Backup: <b><%=biobankGeneralInformation.getBackup()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Training Courses: <b><%=biobankGeneralInformation.getTrainingCourses()== true?"yes":"no" %></b></span>
</div>