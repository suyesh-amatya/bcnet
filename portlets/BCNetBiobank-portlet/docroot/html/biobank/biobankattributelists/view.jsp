<%@ include file="/html/init.jsp" %>

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_edit_biobank_attribute_lists = "EDIT_BIOBANK_ATTRIBUTE_LISTS";
String actionId_delete_biobank_attribute_lists = "DELETE_BIOBANK_ATTRIBUTE_LISTS";
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
	
	biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId);	
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
%>

<portlet:renderURL var="editBiobankAttributesURL">
	<portlet:param name="mvcPath" value="/html/biobank/biobankattributelists/edit_biobankattributes.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name="deleteBiobankAttributeLists" var="deleteBiobankAttributesURL">
	<portlet:param name="biobankDbId" value="<%= String.valueOf(organizationId) %>" />
</portlet:actionURL>

<div class="list-group">
	<span class="list-group-item-active">
		Attributes and Services for <b><%=biobankGeneralInformation.getBiobankName()%></b>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_biobank_attribute_lists) %>">
				<a href="<%=editBiobankAttributesURL.toString()%>">
					<liferay-ui:icon image="edit" message="Edit Biobank Attributes and Services" cssClass="biobankOrganizationEdit"/>
				</a>
			</c:when>
		</c:choose>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_biobank_attribute_lists) %>">
				<liferay-ui:icon-delete url="<%= deleteBiobankAttributesURL.toString() %>" message="Delete Biobank Attributes and Services" cssClass="biobankOrganizationDelete"
						confirmation="Are you sure you want to delete it?"/>
			</c:when>
		</c:choose>
	</span>


<%		
			
			
	List<BiobankAttributeLists> biobankAttributeLists = biobankGeneralInformation.getBiobankAttributeLists();
	if(biobankAttributeLists.size() != 0){
		String attributeListName = "";
		String attributeListValue = "";
		String result = "";
		int counter = 0;
		int counterPreviousValue = 0;
		
		for(BiobankAttributeLists biobankAttribute : biobankAttributeLists){

			if(!attributeListName.equalsIgnoreCase(biobankAttribute.getAttributeListName())){
				if(counter > counterPreviousValue){
					result += "</span>";
				}
				result += "<span class=\"list-group-item\">";
				attributeListName = biobankAttribute.getAttributeListName();
				result += "<b>"+ attributeListName+ ":</b> ";
				attributeListValue = biobankAttribute.getAttributeListValue();
				result += attributeListValue; 
			 
			}
			else{
				counterPreviousValue = counter;
				counter++;
				attributeListValue = biobankAttribute.getAttributeListValue(); 
				result += ", "+attributeListValue;
			}
		}
		
		out.println(result);
		
	}
	else{
		 out.println("<span class=\"list-group-item\">No Services and Facilities Available For This Biobank</span>");
	}
%>
</div>