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
	
	String attributeListName = "";
	String attributeListValue = "";
%>

<portlet:renderURL var="editBiobankAttributesURL">
	<portlet:param name="mvcPath" value="/html/biobank/biobankattributelists/edit_biobankattributes.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name="deleteBiobankAttributessdd" var="deleteBiobankAttributesURL">

</portlet:actionURL>

<div class="list-group">
	<span class="list-group-item-active">
		Attributes and Services for <b><%=biobankGeneralInformation.getBiobankName()%></b>
		<a href="<%=editBiobankAttributesURL.toString()%>">
			<liferay-ui:icon image="edit" message="Edit Biobank Attributes and Services" cssClass="biobankOrganizationEdit"/>
		</a>
		<liferay-ui:icon-delete url="<%= deleteBiobankAttributesURL.toString() %>" message="Delete Biobank" cssClass="biobankOrganizationDelete"
				confirmation="Are you sure you want to delete it?"/>
	</span>


<%		
			
			
			List<BiobankAttributeLists> biobankAttributeLists = biobankGeneralInformation.getBiobankAttributeLists();
			if(biobankAttributeLists.size() != 0){
				String result = "";
				for(BiobankAttributeLists biobankAttribute : biobankAttributeLists){
				
	
					if(!attributeListName.equalsIgnoreCase(biobankAttribute.getAttributeListName())){
						result = "<span class=\"list-group-item\">";
						attributeListName = biobankAttribute.getAttributeListName();
						attributeListValue += biobankAttribute.getAttributeListValue(); 
					
		%>
	
		<%
		
					
					}
					else{ attributeListValue += biobankAttribute.getAttributeListValue(); 
						%>
						<span class="list-group-item">
						<b><%=attributeListName %>:</b><%=attributeListValue %>
					</span>
						<%
						
					}
					
				
				}
			}
			else{
				 out.println("No Services and Facilities Available For This Biobank");
			}
		%>
</div>			