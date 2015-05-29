<%@ include file="/html/init.jsp" %>

<%

boolean optionsDisplayMaincontact_option = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));
String optionsDisplayMaincontactTitle_option = GetterUtil.getString(portletPreferences.getValue("optionsDisplayMaincontactTitle", "Main contact"));
String editimgpath = request.getContextPath() + "/images/edit.png";


HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));

//Parameters for permission Checking
Role administratorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator");
Role curatorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Curator");
boolean isAdministrator = UserLocalServiceUtil.hasRoleUser(administratorRole.getRoleId(), themeDisplay.getUserId());
boolean isCurator = UserLocalServiceUtil.hasRoleUser(curatorRole.getRoleId(), themeDisplay.getUserId());
boolean manageSampleCollectionMainContact = false;
boolean viewSampleCollectionDetailedContact = false;
boolean editSampleCollectionContact = false;
boolean deleteSampleCollectionContact = false;
boolean addSampleCollectionContact = false;

if(isAdministrator || isCurator){
	manageSampleCollectionMainContact = true;
	viewSampleCollectionDetailedContact = true;
	editSampleCollectionContact = true;
	deleteSampleCollectionContact = true;
	addSampleCollectionContact = true;
}

SampleCollectionContact selSampleCollectionContact = 
	SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, themeDisplay.getUserId());
if(selSampleCollectionContact != null){
	viewSampleCollectionDetailedContact = true;
	if(selSampleCollectionContact.getSampleCollectionOwner()){
		manageSampleCollectionMainContact = true;
		editSampleCollectionContact = true;
		deleteSampleCollectionContact = true;
		addSampleCollectionContact = true;
	}
	if(selSampleCollectionContact.getSampleCollectionEditor()){
		editSampleCollectionContact = true;
	}
}


String currentURL = PortalUtil.getCurrentURL(request);//also renderRequest can be passed as a parameter.

long sampleCollectionMainContactUserId = 0;
if(optionsDisplayMaincontact_option) {
	SampleCollectionContact sampleCollectionMainContact = null;
	User sampleCollectionMainContactUser = null;
	try{
		sampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
		sampleCollectionMainContactUserId = sampleCollectionMainContact.getUserId();
		sampleCollectionMainContactUser = UserLocalServiceUtil.getUser(sampleCollectionMainContactUserId);
	}
	catch(Exception e){
	}
	
	

%>

	<portlet:renderURL var="editSampleCollectionMainContactURL">
		<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/sampleCollectionMainContact.jsp" />
		<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
		<portlet:param name="sampleCollectionMainContactUserId" value="<%= String.valueOf(sampleCollectionMainContactUserId) %>"/>
		<portlet:param name="redirect" value="<%= currentURL %>"/>
	</portlet:renderURL>
	
	<div style="height:100%;width:100%;">
		<span class="rdc_idcard_idcaibody-headlines" style="height:100%;width:100%;margin-bottom:5px;"><b style="font-size: 20px;"><%= optionsDisplayMaincontactTitle_option %></b>
			 <% 
			 if(manageSampleCollectionMainContact){ 
			 %>
			 	&nbsp;&nbsp;<a href="<%= editSampleCollectionMainContactURL.toString()+"&scdbid="+sampleCollectionDbId%>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
			 <%
			 }
			 %>
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
				<portlet:param name="sampleCollectionContactUserId" value="<%= String.valueOf(sampleCollectionMainContactUserId) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			
			<span class="rdc_idcard_idcaibody-contactname">
			<% 
			if(viewSampleCollectionDetailedContact || (themeDisplay.getUserId() == sampleCollectionMainContactUserId)){ 
			%>
			 	<a href="<%=detailedSampleCollectionMainContactURL.toString()+"&scdbid="+sampleCollectionDbId %>"><%= sampleCollectionMainContactUser.getFullName() %></a>
			<%
			}
			else{
			%>
				<%= sampleCollectionMainContactUser.getFullName() %>
			<%
			}
			if(editSampleCollectionContact || (themeDisplay.getUserId() == sampleCollectionMainContactUserId)){
			%>				
				<portlet:renderURL var="editSampleCollectionMainContactUserURL">
					<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/editSampleCollectionContact.jsp" />
					<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
					<portlet:param name="sampleCollectionContactUserId" value="<%= String.valueOf(sampleCollectionMainContactUserId) %>"/>
					<portlet:param name="redirect" value="<%= currentURL %>"/>
				</portlet:renderURL>
				&nbsp;&nbsp;
				<a  href="<%= editSampleCollectionMainContactUserURL.toString()+"&scdbid="+sampleCollectionDbId %>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
			<%
			}
			if(deleteSampleCollectionContact){
			%>	
				&nbsp;&nbsp;
				<a id="deleteContactFromSampleCollection" class="icon-remove" style="color: red;" sampleCollectionDbId="<%= sampleCollectionDbId %>" userid="<%= sampleCollectionMainContactUserId %>" 
					userfullname="<%= sampleCollectionMainContactUser.getFullName() %>" ></a>
			<%
			}
			%>
			</span>
			<br />
			<% 
			if(viewSampleCollectionDetailedContact || (themeDisplay.getUserId() == sampleCollectionMainContactUserId)){ 
			%>
				<span class="rdc_idcard_idcaibody-contactemail">
					<aui:a href='<%= "mailto:" + sampleCollectionMainContactUser.getEmailAddress() %>'><%= sampleCollectionMainContactUser.getEmailAddress() %></aui:a>
				</span>
			<%
			}
		}
		%>
	</div>
	<br />
	<br />
	<hr />
	
<%
}
%>


<!-- Personal List -->
<%
String optionsDisplayPeopleTitle_option = GetterUtil.getString(portletPreferences.getValue("optionsDisplayPeopleTitle", "Personal"));
%>
<div style="height:100%;width:100%;">
	<span class="rdc_idcard_idcaibody-headlines"  style="height:100%;width:100%;margin-bottom:5px;"><b style="font-size: 20px;"><%= optionsDisplayPeopleTitle_option %></b>
		<% 
		if(addSampleCollectionContact){ 
		%>
			<portlet:renderURL var="addSampleCollectionContactUserURL">
				<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/editSampleCollectionContact.jsp" />
				<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
				<portlet:param name="sampleCollectionContactUserId" value="0"/>
				<portlet:param name="redirect" value="<%= currentURL %>"/>
			</portlet:renderURL>
		&nbsp;&nbsp;/&nbsp;&nbsp;
		<a href="<%= addSampleCollectionContactUserURL.toString()+"&scdbid="+sampleCollectionDbId %>" cssClass="icon-user">&nbsp;Add User</a>
		<%
		}
		%>
	</span>
</div>

<% 
//Get list of SampleCollectionContact From a Sample Collection
List<SampleCollectionContact> sampleCollectionContacts = SampleCollectionContactLocalServiceUtil.getSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
int row = 0;

User sampleCollectionContactUser = null;
for(SampleCollectionContact sampleCollectionContact : sampleCollectionContacts) {
	long sampleCollectionContactUserId = sampleCollectionContact.getUserId();
	sampleCollectionContactUser = UserLocalServiceUtil.getUser(sampleCollectionContactUserId);
	if(sampleCollectionMainContactUserId == sampleCollectionContact.getUserId()) {
		continue;
	}
	String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+sampleCollectionContactUser.getScreenName()+"&amp;companyId="+sampleCollectionContactUser.getCompanyId();
	if(row%3 == 0){
	%>
		<div class="row rdc-people-display">
	<%
	}
	%>
			<portlet:renderURL var="detailedSampleCollectionContactURL">
				<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/sampleCollectionDetailedContact.jsp" />
				<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
				<portlet:param name="sampleCollectionContactUserId" value="<%= String.valueOf(sampleCollectionContactUserId) %>"/>
				<portlet:param name="redirect" value="<%= currentURL %>" />
			</portlet:renderURL>
			
			<div class="span4">
				<img style="float:left;margin-right:10px;" alt="" class="avatar" src="<%= imgPath %>" width="35" />
				<% 
				if(viewSampleCollectionDetailedContact || (themeDisplay.getUserId() == sampleCollectionContactUserId)){ 
				%>
					<a href="<%=detailedSampleCollectionContactURL.toString()+"&scdbid="+sampleCollectionDbId  %>"><%= sampleCollectionContactUser.getFullName() %></a>
				<%
				}
				else{
				%>
					<%= sampleCollectionContactUser.getFullName() %>
				<%
				}
				if(editSampleCollectionContact || (themeDisplay.getUserId() == sampleCollectionContactUserId)){
				%>
				
					<portlet:renderURL var="editSampleCollectionContactUserURL">
						<portlet:param name="mvcPath" value="/html/samplecollection/samplecollectioncontact/editSampleCollectionContact.jsp" />
						<portlet:param name="sampleCollectionDbId" value="<%= String.valueOf(sampleCollectionDbId) %>"/>
						<portlet:param name="sampleCollectionContactUserId" value="<%= String.valueOf(sampleCollectionContactUserId) %>"/>
						<portlet:param name="redirect" value="<%= currentURL %>"/>
					</portlet:renderURL>
					&nbsp;&nbsp;
					<a  href="<%= editSampleCollectionContactUserURL.toString()+"&scdbid="+sampleCollectionDbId  %>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
				<%
				}
				if(deleteSampleCollectionContact){
				%>
					&nbsp;&nbsp;
					<a id="deleteContactFromSampleCollection" class="icon-remove" style="color: red;" sampleCollectionDbId="<%= sampleCollectionDbId %>" 
					userid="<%= sampleCollectionContactUserId %>" userfullname="<%= sampleCollectionContactUser.getFullName() %>"></a>
					
				<br>
				<%
				}
				if(viewSampleCollectionDetailedContact || (themeDisplay.getUserId() == sampleCollectionContactUserId)){ 
				%> 
					<aui:a href='<%= "mailto:" + sampleCollectionContactUser.getEmailAddress() %>' ><%= sampleCollectionContactUser.getEmailAddress() %></aui:a>
				<%
				}
				%>
			</div>
	<%
	if(row > 0 && row%2 == 0){
	%>
		</div>
	<%
	}
	row++;
}
%>


<portlet:actionURL name='deleteContactFromSampleCollection' var="deleteContactFromSampleCollectionURL" />

<aui:script use="aui-base,event">
	A.all('#deleteContactFromSampleCollection').on(
			'click',
			function(event) {
				var confirmation_to_delete_user = confirm("Are you sure you want to delete the user " + event.currentTarget.getAttribute('userfullname') + " from your Sample Collection?");
				if (confirmation_to_delete_user == true) {
					var url = '<%= deleteContactFromSampleCollectionURL.toString() %>';
					A.io.request(url,{
						//this is the data that you are sending to the action method
						data: {
						   <portlet:namespace />sampleCollectionDbId: event.currentTarget.getAttribute('sampleCollectionDbId'),
						   <portlet:namespace />userid: event.currentTarget.getAttribute('userid'),
						},
						dataType: 'json',
						on: {
						  failure: function() { //alert('There is a problem with the server connection.');
						  },
						  success: function() { //alert("success");
						  }
						}
					});
				    //Liferay.Portlet.refresh('#p_p_id_people_WAR_BiBBoxCommonServicesportlet_');
				    document.location.reload();
				} 	 
				return false;
			}
		);
</aui:script>