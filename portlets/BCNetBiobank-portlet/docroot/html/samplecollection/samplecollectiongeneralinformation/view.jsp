<%@ include file="/html/init.jsp" %> 

<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	
	
	
	

%>
<liferay-ui:tabs names="tab1,tab2,tab3" refresh="false" tabsValues="tab1,tab2,tab3">
    <liferay-ui:section>
      <%  out.println(httpRequest.getParameter("scdbid"));%>
    </liferay-ui:section>
    <liferay-ui:section>
        Text for Tab 2.
    </liferay-ui:section>
    <liferay-ui:section>
        Text for Tab 3.
    </liferay-ui:section>
</liferay-ui:tabs>