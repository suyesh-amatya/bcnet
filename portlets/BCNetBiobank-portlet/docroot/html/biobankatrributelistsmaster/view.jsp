<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankAtrributeListsMaster> searchContainer = null;
%>

<%


//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_biobank_attribute_lists_master = "ADD_BIOBANK_ATTRIBUTE_LISTS_MASTER";
String actionId_edit_biobank_attribute_lists_master = "EDIT_BIOBANK_ATTRIBUTE_LISTS_MASTER";
String actionId_delete_biobank_attribute_lists_master = "DELETE_BIOBANK_ATTRIBUTE_LISTS_MASTER";

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<%= scopeGroupId %>

<aui:button-row>
	<portlet:renderURL var="addBiobankAtrributeListsMasterURL">
		<portlet:param name="mvcPath" value="/html/biobankatrributelistsmaster/edit_biobankatrributelistsmaster.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_biobank_attribute_lists_master) %>">
			<aui:button onClick="<%= addBiobankAtrributeListsMasterURL.toString() %>" value="add-biobankAtrributeListsMaster" />
		</c:when>
	</c:choose>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="biobankAtrributeListsMaster-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankAtrributeListsMasterLocalServiceUtil.getAllBiobankAtrributeListsMasters(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMastersCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
		keyProperty="biobankAtrributeListsMasterId"
		modelVar="biobankAtrributeListsMaster" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="attributeListName"
			value="<%= biobankAtrributeListsMaster.getAttributeListName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="attributeListValue"
			property="attributeListValue"
		/>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_biobank_attribute_lists_master) ||  
									permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_biobank_attribute_lists_master) %>">
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/biobankatrributelistsmaster/biobankatrributelistsmaster_actions.jsp"
				/>
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>