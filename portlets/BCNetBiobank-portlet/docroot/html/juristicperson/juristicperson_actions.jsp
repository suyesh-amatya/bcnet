<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	JuristicPerson juristicPerson = (JuristicPerson) row.getObject();

	String name = JuristicPerson.class.getName();
	long juristicPersonId = juristicPerson.getJuristicPersonId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String portlet_name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_juristic_person = "EDIT_JURISTIC_PERSON";
	String actionId_delete_juristic_person = "DELETE_JURISTIC_PERSON";
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/juristicperson/edit_juristicperson.jsp" />
		<portlet:param name="juristicPersonId" value="<%= String.valueOf(juristicPersonId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_edit_juristic_person) %>">
			<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
		</c:when>
	</c:choose>
	<portlet:actionURL name="deleteJuristicPerson" var="deleteURL">
		<portlet:param name="juristicPersonId" value="<%= String.valueOf(juristicPersonId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, portlet_name, primKey, actionId_delete_juristic_person) %>">
			<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
		</c:when>
	</c:choose>
</liferay-ui:icon-menu>