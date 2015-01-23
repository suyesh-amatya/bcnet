<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/users_admin/init.jsp" %>
<%@ page import="com.bcnet.portlet.biobank.model.JuristicPerson" %>
<%@ page import="com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil"%>

<%
User selUser = (User)request.getAttribute("user.selUser");
List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();
		 System.out.println(juristicPersons);
		 System.out.println(selUser);
		 System.out.println(selUser.getExpandoBridge().getAttribute("juristicPersonId"));
%>

<h3><liferay-ui:message key="custom-fields" /></h3>

<aui:fieldset>
	<aui:select name="juristicPersonId" label='Juristic Person <i class="icon-asterisk"></i>' >
		<aui:option>Select</aui:option>
		<%
			for (JuristicPerson juristicPerson : juristicPersons) {
			
		%>
		
				<aui:option selected="<%= (selUser != null && juristicPerson.getJuristicPersonId() == selUser.getExpandoBridge().getAttribute("juristicPersonId")) %>"
				 value="<%= juristicPerson.getJuristicPersonId()%>">
					<%=juristicPerson.getName() %>
				</aui:option>
		<% 
			}
		%>
	</aui:select>
	<%-- <liferay-ui:custom-attribute-list
		className="com.liferay.portal.model.User"
		classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
	/> --%>
</aui:fieldset>