<%@ include file="/html/init.jsp" %>

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_edit_sample_collection_attribute_lists = "EDIT_SAMPLE_COLLECTION_ATTRIBUTE_LISTS";
String actionId_delete_sample_collection_attribute_lists = "DELETE_SAMPLE_COLLECTION_ATTRIBUTE_LISTS";
%>


<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));
	
	SampleCollection sampleCollection = null;
	
	sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="editSampleCollectionAttributesURL">
	<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectionattributelists/edit_samplecollectionattributes.jsp" />
	<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name="deleteSampleCollectionAttributeLists" var="deleteSampleCollectionAttributesURL">
	<portlet:param name="scdbid" value="<%= String.valueOf(sampleCollectionDbId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<div class="list-group">
	<span class="list-group-item-active">
		Attributes for <b><%=sampleCollection.getName()%></b>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_sample_collection_attribute_lists) %>">
				<!-- Passing "scdbid" as a url parameter, because in absence of this parameter samplecollection theme redirects to the page "/sample-collections".
				But we are not accessing this parameter on the edit page. We are passing "sampleCollectionDbId" as a portlet parameter in the render url,
				which we access on the edit page. -->
				<a href="<%=editSampleCollectionAttributesURL.toString()+"&scdbid="+sampleCollectionDbId%>">
					<liferay-ui:icon image="edit" message="Edit Sample Collection Attributes" cssClass="sampleCollectionEdit"/>
				</a>
			</c:when>
		</c:choose>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample_collection_attribute_lists) %>">
				<liferay-ui:icon-delete url="<%= deleteSampleCollectionAttributesURL.toString() %>" message="Delete Sample Collection Attributes" cssClass="sampleCollectionDelete"
						confirmation="Are you sure you want to delete it?"/>
			</c:when>
		</c:choose>
	</span>


<%		
			
			
	List<SampleCollectionAttributeLists> sampleCollectionAttributeLists = sampleCollection.getSampleCollectionAttributeLists();
	
	if(sampleCollectionAttributeLists.size() != 0){
		String attributeListName = "";
		String attributeListValue = "";
		String result = "";
		int counter = 0;
		int counterPreviousValue = 0;
		
		for(SampleCollectionAttributeLists sampleCollectionAttribute : sampleCollectionAttributeLists){

			if(!attributeListName.equalsIgnoreCase(sampleCollectionAttribute.getAttributeListName())){
				if(counter > counterPreviousValue){
					result += "</span>";
				}
				result += "<span class=\"list-group-item\">";
				attributeListName = sampleCollectionAttribute.getAttributeListName();
				result += "<b>"+ attributeListName+ ":</b> ";
				attributeListValue = sampleCollectionAttribute.getAttributeListValue();
				result += attributeListValue; 
				
				counterPreviousValue = counter;
				counter++;
			 
			}
			else{
				counterPreviousValue = counter;
				counter++;
				attributeListValue = sampleCollectionAttribute.getAttributeListValue(); 
				result += ", "+attributeListValue;
			}
		}
		result += "</span>";
		out.println(result);
		
	}
	else{
		 out.println("<span class=\"list-group-item\">No Attributes Available For This Sample Collection.</span>");
	}
%>
</div>