<%@ include file="/html/init.jsp" %>

<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<User> searchContainer = null;
%>
<%
	Organization organization = null;
	long organizationId = 0;
	
	
	Group currentGroup = themeDisplay.getLayout().getGroup();
	if(currentGroup.isOrganization()){
		organizationId = currentGroup.getClassPK();
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	//OrganizationLocalServiceUtil.addUserOrganization(themeDisplay.getUserId(), organizationId);
	//OrganizationLocalServiceUtil.deleteUserOrganization(themeDisplay.getUserId(), organizationId);
	
	//System.out.println(UserLocalServiceUtil.getOrganizationUserIds(organizationId).length);
	//System.out.println(organizationId);
	String redirect = ParamUtil.getString(request, "redirect");
	
%>

<liferay-ui:search-container emptyResultsMessage="contact-empty-results-message">

<%
List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId, searchContainer.getStart(), searchContainer.getEnd());
%>
	<liferay-ui:search-container-results
		results="<%= users %>"
	/>

	<liferay-ui:search-container-row 
		className="com.liferay.portal.model.User" 
		keyProperty="userId"
		modelVar="selUser" escapedModel="<%= true %>"
	>
	
		
		<%
			//https://www.liferay.com/community/forums/-/message_boards/message/46258637
			Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.CONTROL_PANEL);
			long myAccountPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
			
			LiferayPortletURL userAccountURL = PortletURLFactoryUtil.create(request, PortletKeys.USERS_ADMIN, myAccountPlid, PortletRequest.RENDER_PHASE);
			userAccountURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
			userAccountURL.setParameter("struts_action", "/users_admin/edit_user");
			//userAccountURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
			userAccountURL.setParameter("backURL", redirect);
			userAccountURL.setWindowState(LiferayWindowState.POP_UP);
			
			String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
			String portletNamespace = PortalUtil.getPortletNamespace(portletId);
		%>
		
		<c:set var="portletNamespace" value="<%=portletNamespace%>" />
		<c:set var="userAccountURL" value="${userAccountURL}" />
		<c:out value="${userAccountURL}"/>
		<liferay-ui:search-container-column-text 
			name="name"
		>
			<aui:a href="#" cssClass="userPopUp" id="<%=String.valueOf(selUser.getUserId())%>"><%=selUser.getFullName()%></aui:a>
			
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="email"
			property="emailAddress" href="<%=\"mailto:\"+selUser.getEmailAddress()%>"
		/>
		
		
		<%
			String juristicPersonName = "";

			try {
				juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
						((Long)selUser.getExpandoBridge().getAttribute("juristicPersonId")).getName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="juristicPerson"
			value="<%= juristicPersonName %>"
		/>

		
		<liferay-ui:search-container-column-text
			name="department"
			value='<%= selUser.getExpandoBridge().getAttribute("department").toString()%>'
		/>

		<liferay-ui:search-container-column-text
			name="orcId"
			value='<%= selUser.getExpandoBridge().getAttribute("orcId").toString()%>'
		/>

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script>
	AUI().use('aui-base', 'liferay-portlet-url', function(A){
		A.all("a.userPopUp").on('click',function(){
		
		
		
			var userIdWithPortletNameSpace = event.currentTarget.getAttribute('id');
			var portletNamespace = '${portletNamespace}';
			
			
			var userId = userIdWithPortletNameSpace.replace(portletNamespace, '');
			
			//var portletURL = new Liferay.PortletURL();
			//portletURL.setParameter("p_u_i_d", userId);
			//portletURL.setParameter("p_u_i_d", userId);
			
			var portletURL = '${userAccountURL}';
			console.log(portletURL);
			Liferay.Util.openWindow(
				{
					dialog: {
						cache: false,
						width:1100,
						modal: true,
						centered: true
					},
					uri: portletURL
				}
			);
		});
	});
</aui:script>


