<%@ include file="/html/init.jsp" %>


<%
	String currentTab = ParamUtil.getString(request, "tabs1", "identity");
%>
 


<liferay-portlet:renderURL var="changeTabURL" >
	<portlet:param name="mvcPath" value="/html/biobanksearch/view.jsp" />
</liferay-portlet:renderURL>


<liferay-ui:tabs
    names="identity,services"
    url="<%= changeTabURL %>"
/>

<liferay-util:include
    page='<%= "/html/biobanksearch/" + currentTab + ".jsp" %>'
    servletContext="<%= application %>"
/>

