<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	BiobankAtrributeListsMaster biobankAtrributeListsMaster = (BiobankAtrributeListsMaster) row.getObject();

	String name = BiobankAtrributeListsMaster.class.getName();
	long biobankAtrributeListsMasterId = biobankAtrributeListsMaster.getBiobankAttributeListsMasterId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String portlet_name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_biobank_attribute_lists_master = "EDIT_BIOBANK_ATTRIBUTE_LISTS_MASTER";
	String actionId_delete_biobank_attribute_lists_master = "DELETE_BIOBANK_ATTRIBUTE_LISTS_MASTER";
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/biobankatrributelistsmaster/edit_biobankatrributelistsmaster.jsp" />
		<portlet:param name="biobankAtrributeListsMasterId" value="<%= String.valueOf(biobankAtrributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_edit_biobank_attribute_lists_master) %>">
			<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
		</c:when>
	</c:choose>
	
	<portlet:actionURL name="deleteBiobankAtrributeListsMaster" var="deleteURL">
		<portlet:param name="biobankAtrributeListsMasterId" value="<%= String.valueOf(biobankAtrributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_delete_biobank_attribute_lists_master) %>">
			<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>