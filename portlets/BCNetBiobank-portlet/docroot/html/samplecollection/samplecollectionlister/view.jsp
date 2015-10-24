<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="samples-exist-for-this-sample-collection" message="samples-exist-for-this-sample-collection"/>

<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<SampleCollection> searchContainer = null;
%>

<%
	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_delete_sample_collection = "DELETE_SAMPLE_COLLECTION";
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
%>


<liferay-ui:search-container emptyResultsMessage="sampleCollection-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= SampleCollectionLocalServiceUtil.getSampleCollections(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= SampleCollectionLocalServiceUtil.getSampleCollectionsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.SampleCollection"
		keyProperty="sampleCollectionDbId"
		modelVar="sampleCollection" escapedModel="<%= true %>"
	>
		<% 
			String viewPath = themeDisplay.getURLPortal()+"/sample-collections/general-information?scdbid="+sampleCollection.getSampleCollectionDbId();
		%>
		
		<portlet:actionURL name="deleteSampleCollection" var="deleteSampleCollectionURL">
			<portlet:param name="scdbid" value="<%= String.valueOf(sampleCollection.getSampleCollectionDbId()) %>" />
		</portlet:actionURL>
		
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= sampleCollection.getName() %>"
			href="<%= viewPath %>"
		/>

		<liferay-ui:search-container-column-text
			name="Sample Collection Id"
			property="sampleCollectionId"
			href="<%= viewPath %>"
		/>

		<liferay-ui:search-container-column-text
			name="Acronym"
			property="acronym"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="description"
			property="description"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Consent Template"
			value="<%=sampleCollection.getConsentTemplate()==true?\"yes\":\"no\" %>"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Reuse of Samples"
			value="<%=sampleCollection.getReuseOfSamples()==true?\"yes\":\"no\" %>"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Material Transfer Agreement"
			value="<%=sampleCollection.getMaterialTransferAgreement()==true?\"yes\":\"no\" %>"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Accreditation"
			value="<%=sampleCollection.getAccreditation()==true?\"yes\":\"no\" %>"
			href="<%= viewPath %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Quality Control"
			value="<%=sampleCollection.getQualityControl()==true?\"yes\":\"no\" %>"
			href="<%= viewPath %>"
		/>
		
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample_collection) %>">
				<liferay-ui:search-container-column-text>
					<liferay-ui:icon-delete url="<%= deleteSampleCollectionURL.toString() %>" 
						message="<%= \"Delete \"+sampleCollection.getName()+\"\" %>" 
						confirmation="<%= \"Are you sure you want to delete \"+sampleCollection.getName()+\"?\" %>"
					/>
				</liferay-ui:search-container-column-text>
			</c:when>
		</c:choose>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>