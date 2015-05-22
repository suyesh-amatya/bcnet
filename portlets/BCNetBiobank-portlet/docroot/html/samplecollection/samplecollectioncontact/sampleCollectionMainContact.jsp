<%@ include file="/html/init.jsp" %>

<%
long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
long sampleCollectionMainContactUserId = ParamUtil.getLong(request, "sampleCollectionMainContactUserId");
String redirect = ParamUtil.getString(request, "redirect");
User sampleCollectionContactUser = null;
%>

<portlet:actionURL name="editSampleCollectionMainContact" var="editSampleCollectionMainContactURL" windowState="normal" />
<aui:form action="<%= editSampleCollectionMainContactURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="sampleCollectionDbId" type="hidden" value="<%= sampleCollectionDbId %>" />
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:column columnWidth="100" first="true">
				<aui:select label="Set the Main Contact" name="sampleCollectionMainContactUserId">
					<%-- <aui:option>Select</aui:option> --%>
					<% 
					//Get all the contacts for Sample Collection
					List<SampleCollectionContact> sampleCollectionContacts = SampleCollectionContactLocalServiceUtil.getSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
					for(SampleCollectionContact sampleCollectionMainContact : sampleCollectionContacts) {
						sampleCollectionContactUser = UserLocalServiceUtil.getUser(sampleCollectionMainContact.getUserId());
						%>
						<aui:option value="<%= sampleCollectionContactUser.getUserId() %>" selected='<%= sampleCollectionMainContactUserId == sampleCollectionContactUser.getUserId() ? true : false %>' ><%= sampleCollectionContactUser.getFullName() %></aui:option>
						<%
					}
					%>
				</aui:select>
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= redirect %>"/>
	</aui:button-row>
</aui:form>