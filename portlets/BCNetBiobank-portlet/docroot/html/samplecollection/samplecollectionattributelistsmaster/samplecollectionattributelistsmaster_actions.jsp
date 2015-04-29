<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster = (SampleCollectionAttributeListsMaster) row.getObject();

	String name = SampleCollectionAttributeListsMaster.class.getName();
	long sampleCollectionAttributeListsMasterId = sampleCollectionAttributeListsMaster.getSampleCollectionAttributeListsMasterId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String portlet_name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_sample_collection_attribute_lists_master = "EDIT_SAMPLE_COLLECTION_ATTRIBUTE_LISTS_MASTER";
	String actionId_delete_sample_collection_attribute_lists_master = "DELETE_SAMPLE_COLLECTION_ATTRIBUTE_LISTS_MASTER";
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectionattributelistsmaster/edit_samplecollectionattributelistsmaster.jsp" />
		<portlet:param name="sampleCollectionAttributeListsMasterId" value="<%= String.valueOf(sampleCollectionAttributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_edit_sample_collection_attribute_lists_master) %>">
			<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
		</c:when>
	</c:choose>
	
	<portlet:actionURL name="deleteSampleCollectionAttributeListsMaster" var="deleteURL">
		<portlet:param name="sampleCollectionAttributeListsMasterId" value="<%= String.valueOf(sampleCollectionAttributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_delete_sample_collection_attribute_lists_master) %>">
			<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>