<%@page import="com.rdconnect.org.idcardmolgenis.service.RDConnectIDCardMolgenisLocalServiceUtil"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<div id="diseasematrix"></div>

<aui:script>
<%=RDConnectIDCardMolgenisLocalServiceUtil.getUserCredential() %>
</aui:script>

