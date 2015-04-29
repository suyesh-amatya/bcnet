<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<SampleCollectionAttributeListsMaster> searchContainer = null;
%>

<%

//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_sample_collection_attribute_lists_master = "ADD_SAMPLE_COLLECTION_ATTRIBUTE_LISTS_MASTER";
String actionId_edit_sample_collection_attribute_lists_master = "EDIT_SAMPLE_COLLECTION_ATTRIBUTE_LISTS_MASTER";
String actionId_delete_sample_collection_attribute_lists_master = "DELETE_SAMPLE_COLLECTION_ATTRIBUTE_LISTS_MASTER";

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<aui:button-row>
	<portlet:renderURL var="addSampleCollectionAttributeListsMasterURL">
		<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectionattributelistsmaster/edit_samplecollectionattributelistsmaster.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<c:choose>		
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_sample_collection_attribute_lists_master) %>">
			<aui:button onClick="<%= addSampleCollectionAttributeListsMasterURL.toString() %>" value="add-sampleCollectionAttributeListsMaster" />
		</c:when>
	</c:choose>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="sampleCollectionAttributeListsMaster-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= SampleCollectionAttributeListsMasterLocalServiceUtil.getSampleCollectionAttributeListsMasters(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= SampleCollectionAttributeListsMasterLocalServiceUtil.getSampleCollectionAttributeListsMastersCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster"
		keyProperty="sampleCollectionAttributeListsMasterId"
		modelVar="sampleCollectionAttributeListsMaster" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="attributeListName"
			value="<%= sampleCollectionAttributeListsMaster.getAttributeListName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="attributeListValue"
			property="attributeListValue"
		/>
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_sample_collection_attribute_lists_master) ||  
									permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample_collection_attribute_lists_master) %>">
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/samplecollection/samplecollectionattributelistsmaster/samplecollectionattributelistsmaster_actions.jsp"
				/>
			</c:when>
		</c:choose>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>