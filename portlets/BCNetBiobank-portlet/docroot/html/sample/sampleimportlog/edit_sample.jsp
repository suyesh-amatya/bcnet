<%@ include file="/html/init.jsp" %>

<%
	long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
	String redirect =  ParamUtil.getString(request, "redirect");
	
	Sample sample = SampleLocalServiceUtil.getSample(sampleDbId);
	
	String sampleCollectionId = sample.getSampleCollectionId();
	
	
	//out.println(SampleCollectionLocalServiceUtil.getSampleCollectionBySampleCollectionId(sampleCollectionId).getName());
%>

<portlet:actionURL name="editSample" var="editSampleURL">
	<portlet:param name="sampleDbId" value="<%= String.valueOf(sampleDbId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<%-- <aui:a href="<%=editSampleURL%>">Edit</aui:a> --%>

<div class="sample-edit-form">
	<div class="sample-edit-form-header">Edit Sample</div>
	<div class="sample-edit-form-container">
		<aui:form action="<%= editSampleURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="sampleCollectionId" label='Sample Collection'
							value="<%=SampleCollectionLocalServiceUtil.getSampleCollectionBySampleCollectionId(sampleCollectionId).getName() %>"/>
					</aui:column>
					<%-- <aui:column columnWidth="30">
						<aui:input name="sampleCollectionId" label='Sample Collection Id' value="<%=sampleCollection.getSampleCollectionId() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="acronym" label="Acronym" value="<%=sampleCollection.getAcronym() %>" />
					</aui:column> --%>
				</aui:row>
			
			
			</aui:fieldset>
		
		</aui:form>
	</div>
</div>
