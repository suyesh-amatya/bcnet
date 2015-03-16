<%@ include file="/html/init.jsp" %>

<%
long optionsPageTemplate_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:column columnWidth="100" first="true">
				<%
				List<LayoutSetPrototype> site_templates = LayoutSetPrototypeServiceUtil.search(company.getCompanyId(), Boolean.TRUE, null);
				%>
				<aui:select label="Select PageTemplate for Organization" name="preferences--optionsPageTemplate--">
					<aui:option value="0" selected='<%= optionsPageTemplate_cfg == 0 ? true : false %>' >No Page</aui:option>
					<% for(LayoutSetPrototype site_template : site_templates) { %>
						<aui:option value="<%= site_template.getPrimaryKey() %>" selected='<%= optionsPageTemplate_cfg == site_template.getPrimaryKey() ? true : false %>' ><%= site_template.getName() %></aui:option>
					<% } %>
				</aui:select>
		</aui:column>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>