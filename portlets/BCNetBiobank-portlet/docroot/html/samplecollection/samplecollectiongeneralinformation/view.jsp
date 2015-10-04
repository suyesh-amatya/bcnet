<%@ include file="/html/init.jsp" %> 

<liferay-ui:success key="sample-collection-add-success" message="sample-collection-add-success"/>

<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));
	
	
	// Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_sample_collection_general_information = "EDIT_SAMPLE_COLLECTION_GENERAL_INFORMATION";
	String actionId_delete_sample_collection = "DELETE_SAMPLE_COLLECTION";
	
	boolean editSampleCollection = false;
	boolean deleteSampleCollection = false;
	
	SampleCollectionContact selSampleCollectionContact = 
			SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, themeDisplay.getUserId());

	if(selSampleCollectionContact != null){
		if(selSampleCollectionContact.getSampleCollectionOwner()){
			editSampleCollection = true;
			deleteSampleCollection = true;
		}
		if(selSampleCollectionContact.getSampleCollectionEditor()){
			editSampleCollection = true;
		}
	}

	SampleCollection sampleCollection = null;
	sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="editSampleCollectionGeneralInformationURL">
	<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectiongeneralinformation/edit_samplecollection_general_information.jsp" />
	<%-- For our special need, we are not passing "scdbid" as <portlet:param /> which adds the <portlet:namespace /> in the URL. --%>
	<%-- <portlet:param name="scdbid" value="<%= String.valueOf(sampleCollectionDbId) %>" /> --%>
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:actionURL name="deleteSampleCollection" var="deleteSampleCollectionURL">
	<portlet:param name="scdbid" value="<%= String.valueOf(sampleCollectionDbId) %>" />
</portlet:actionURL>


<div class="list-group">
	<span class="list-group-item-active">
		<b><%=sampleCollection.getName() %></b>
		
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_sample_collection_general_information) || editSampleCollection %>">
				<!-- Building the edit URL first and then appending "scdbid" as a URL parameter. -->
				<a href="<%=editSampleCollectionGeneralInformationURL.toString()+"&scdbid="+sampleCollectionDbId%>">
				<liferay-ui:icon image="edit" message="Edit Sample Collection" cssClass="sampleCollectionEdit"/>
				</a>
			</c:when>
		</c:choose>
		
		<c:choose>		
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample_collection) || deleteSampleCollection %>">
				<liferay-ui:icon-delete url="<%= deleteSampleCollectionURL.toString() %>" message="Delete Sample Collection" cssClass="sampleCollectionDelete"
				confirmation="Are you sure you want to delete it?"/>
			</c:when>
		</c:choose>
	</span>
	
	<span class="list-group-item">SampleCollectionId: <b><%=sampleCollection.getSampleCollectionId() %></b></span>
	<span class="list-group-item">Acronym: <b><%=sampleCollection.getAcronym() %></b></span>
	<span class="list-group-item">Description: <b><%=sampleCollection.getDescription() %></b></span>
	<span class="list-group-item">Consent Template: <b><%=sampleCollection.getConsentTemplate()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Reuse of Samples: <b><%=sampleCollection.getReuseOfSamples()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Material Transfer Agreement: <b><%=sampleCollection.getMaterialTransferAgreement()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Accreditation: <b><%=sampleCollection.getAccreditation()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Quality Control: <b><%=sampleCollection.getQualityControl()== true?"yes":"no" %></b></span>
</div>