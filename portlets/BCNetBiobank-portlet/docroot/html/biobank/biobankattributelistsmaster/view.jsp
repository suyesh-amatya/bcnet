<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankAttributeListsMaster> searchContainer = null;
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

<aui:input name="scopeGroupId" type="hidden" value="<%=scopeGroupId %>"></aui:input>
<%-- <%= scopeGroupId %> --%>

<aui:button-row>
	<portlet:renderURL var="addBiobankAttributeListsMasterURL">
		<portlet:param name="mvcPath" value="/html/biobank/biobankattributelistsmaster/edit_biobankattributelistsmaster.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_biobank_attribute_lists_master) %>">
			<aui:button onClick="<%= addBiobankAttributeListsMasterURL.toString() %>" value="add-biobankAttributeListsMaster" />
		</c:when>
	</c:choose>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="biobankAttributeListsMaster-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankAttributeListsMasterLocalServiceUtil.getAllBiobankAttributeListsMasters(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMastersCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster"
		keyProperty="biobankAttributeListsMasterId"
		modelVar="biobankAttributeListsMaster" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="attributeListName"
			value="<%= biobankAttributeListsMaster.getAttributeListName() %>"
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
					path="/html/biobank/biobankattributelistsmaster/biobankattributelistsmaster_actions.jsp"
				/>
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>