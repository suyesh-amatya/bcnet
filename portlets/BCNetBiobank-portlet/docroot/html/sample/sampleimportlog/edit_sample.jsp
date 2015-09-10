<%@ include file="/html/init.jsp" %>
<%
out.println(ParamUtil.getString(request, "sampleDbId"));
String url =  ParamUtil.getString(request, "redirect");
%>
<liferay-ui:header
	backURL="<%= url %>"
	title='Back'
/>