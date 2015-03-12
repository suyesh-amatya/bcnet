<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<JuristicPerson> searchContainer = null;
%>

<%
	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_add_juristic_person = "ADD_JURISTIC_PERSON";
	String actionId_edit_juristic_person = "EDIT_JURISTIC_PERSON";
	String actionId_delete_juristic_person = "DELETE_JURISTIC_PERSON";
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
<liferay-ui:error key="juristicPersonError" message="This Juristic Person is associated with some biobank. So it cannot be deleted."/>
<aui:button-row>
	<portlet:renderURL var="addJuristicPersonURL">
		<portlet:param name="mvcPath" value="/html/juristicperson/edit_juristicperson.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_juristic_person) %>">
			<aui:button onClick="<%= addJuristicPersonURL.toString() %>" value="add-juristicPerson" />
		</c:when>
	</c:choose>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="juristicPerson-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= JuristicPersonLocalServiceUtil.getAllJuristicPersons(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= JuristicPersonLocalServiceUtil.getJuristicPersonsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.JuristicPerson"
		keyProperty="juristicPersonId"
		modelVar="juristicPerson" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= juristicPerson.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="url"
			property="url"
		/>

		<liferay-ui:search-container-column-text
			name="address"
			property="address"
		/>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_juristic_person) ||  
									permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_juristic_person) %>">
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/juristicperson/juristicperson_actions.jsp"
				/>
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>