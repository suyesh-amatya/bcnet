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
		 
	Long result= (Long)selUser.getExpandoBridge().getAttribute("juristicPersonId");
	long juristicPersonId = result.longValue();
	
		 
%>

<h3><liferay-ui:message key="custom-fields" /></h3>

<aui:fieldset>
	<aui:select name="juristicPersonId" label='Juristic Person' >
		<aui:option>Select</aui:option>
		<%
		for (JuristicPerson juristicPerson : juristicPersons) {
		%>
			<aui:option selected="<%= (selUser != null && juristicPerson.getJuristicPersonId() == juristicPersonId) %>"
				value="<%= juristicPerson.getJuristicPersonId()%>">
								<%=juristicPerson.getName() %>
			</aui:option>
		<% 
		}
		%>
	</aui:select>
	<liferay-ui:custom-attribute
		className="com.liferay.portal.model.User"
		classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
		name="department"
	/>
	<liferay-ui:custom-attribute
		className="com.liferay.portal.model.User"
		classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
		name="orcId"
	/> 
</aui:fieldset>