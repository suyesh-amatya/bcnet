<%@ include file="/html/init.jsp" %>

<%
//Parameters for permission Checking
//TBD

boolean optionsDisplayMaincontact_option = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));
String optionsDisplayMaincontactTitle_option = GetterUtil.getString(portletPreferences.getValue("optionsDisplayMaincontactTitle", "Main contact"));
String editimgpath = request.getContextPath() + "/images/edit.png";
		
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));

String currentURL = PortalUtil.getCurrentURL(request);//also renderRequest can be passed as a parameter.
//out.println(currentURL);

long sampleCollectionMainContactUserId = 0;
if(optionsDisplayMaincontact_option) {
	SampleCollectionContact sampleCollectionMainContact = null;
	User sampleCollectionMainContactUser = null;
	try{
		sampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
		sampleCollectionMainContactUserId = sampleCollectionMainContact.getUserId();
		sampleCollectionMainContactUser = UserLocalServiceUtil.getUser(sampleCollectionMainContactUserId);
		//out.println(sampleCollectionMainContact);
	}
	catch(Exception e){
	}
	
	List<SampleCollectionContact> sampleCollectionContacts = SampleCollectionContactLocalServiceUtil.getSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
	//out.println(sampleCollectionContacts);
	

%>

	<portlet:renderURL var="editSampleCollectionMainContactURL">
		<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/sampleCollectionMainContact.jsp" />
		<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
		<portlet:param name="sampleCollectionMainContactUserId" value="<%= String.valueOf(sampleCollectionMainContactUserId) %>"/>
		<portlet:param name="redirect" value="<%= currentURL %>"/>
	</portlet:renderURL>
	
	<div style="height:100%;width:100%;">
		<span class="rdc_idcard_idcaibody-headlines" style="height:100%;width:100%;margin-bottom:5px;"><b style="font-size: 20px;"><%= optionsDisplayMaincontactTitle_option %></b>
<%-- 			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_manage_maincontact) %>">
 --%>					&nbsp;&nbsp;<a href="<%= editSampleCollectionMainContactURL.toString()+"&scdbid="+sampleCollectionDbId%>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
				<%-- </c:when>
			</c:choose> --%>
		</span>
		<% 
		if(sampleCollectionMainContact != null) {
			String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+sampleCollectionMainContactUser.getScreenName()+"&amp;companyId="+sampleCollectionMainContactUser.getCompanyId();
			
			%>
			<br><br>
			<div class="rdc_idcard_idcaibody-avatar"><img alt="" style="margin-left:10px;float:right;" src="<%= imgPath %>" /></div>
			
			<portlet:renderURL var="detailedSampleCollectionMainContactURL">
				<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/sampleCollectionDetailedContact.jsp" />
				<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
				<portlet:param name="sampleCollectionMainContactUserId" value="<%= String.valueOf(sampleCollectionMainContactUserId) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			
			<span class="rdc_idcard_idcaibody-contactname">
			<%-- <c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_view_detailed_contact) || userId == maincontactid %>"> --%>
					<aui:a href="<%=detailedSampleCollectionMainContactURL.toString() %>"><%= sampleCollectionMainContactUser.getFullName() %></aui:a>
				<%-- </c:when>
				<c:otherwise>
					<%= maincontact.getFullName() %>
				</c:otherwise>
			</c:choose> --%>
				
				<%-- <c:choose>
					<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_user) || userId == maincontactid %>">
						<portlet:renderURL var="editUserURL">
							<portlet:param name="mvcPath" value="/html/user/people/edit.jsp" />
							<portlet:param name="redirect" value="<%= currentURL %>"/>
							<portlet:param name="bibbox_cs_userid" value="<%= String.valueOf(maincontact.getUserId()) %>"/>
							<portlet:param name="bibbox_cs_cmd" value="edit"/>
							<portlet:param name="bibbox_cs_organizationid" value="<%= String.valueOf(organizationId) %>"/>
						</portlet:renderURL>
						&nbsp;&nbsp;
						<aui:a  href="<%= editUserURL.toString() %>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></aui:a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_user) %>">
						&nbsp;&nbsp;
						<a id="deleteUserFromOrganisation" class="icon-remove" style="color: red;" organisationid="<%= organizationId %>" userid="<%= maincontact.getUserId() %>" userfulename="<%= maincontact.getFullName() %>"></a>
					</c:when>
				</c:choose> --%>
			</span>
			
			<br />
			<%-- <c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_view_detailed_contact) || userId == maincontactid %>">
					<span class="rdc_idcard_idcaibody-contactemail">
						<aui:a href='<%= "mailto:" + maincontact.getEmailAddress() %>'><%= maincontact.getEmailAddress() %></aui:a>
					</span>
				</c:when>
			</c:choose> --%>
			<%
		}
		%>
	</div>
	<br />
	<hr />
	
<%
}
%>