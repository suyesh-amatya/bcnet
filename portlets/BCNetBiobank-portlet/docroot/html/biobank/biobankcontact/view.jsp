<%@page import="com.liferay.util.portlet.PortletRequestUtil"%>
<%@ include file="/html/init.jsp" %>
<%-- <%!
   com.liferay.portal.kernel.dao.search.SearchContainer<User> searchContainer = null;
%> --%>
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
	
	System.out.println(UserLocalServiceUtil.getOrganizationUserIds(organizationId).length);
	System.out.println(organizationId);
	String currentURL = ParamUtil.getString(request, "redirect");
	
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
	
		<liferay-portlet:renderURL var="rowURL">
			<portlet:param name="struts_action" value="/users_admin/edit_user" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="p_u_i_d" value="<%= String.valueOf(selUser.getUserId()) %>" />
		</liferay-portlet:renderURL>
		
		<%
			//https://www.liferay.com/community/forums/-/message_boards/message/46258637
			Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.CONTROL_PANEL);
			long myAccountPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
			
			LiferayPortletURL userAccountURL = PortletURLFactoryUtil.create(request, PortletKeys.MY_ACCOUNT, myAccountPlid, PortletRequest.RENDER_PHASE);
			userAccountURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
			userAccountURL.setParameter("struts_action", "/users_admin/edit_user");
			userAccountURL.setParameter("p_u_i_d", String.valueOf(selUser.getUserId()));
			//userAccountURL.setWindowState(LiferayWindowState.POP_UP);
		%>
		
		<liferay-ui:search-container-column-text
			href="<%=userAccountURL %>"
			name="name"
			value="<%= selUser.getFullName()%>"
		/>


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