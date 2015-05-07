<%@ include file="/html/init.jsp" %>

<%
	long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");

	out.println("sampleCollectionDbId:"+sampleCollectionDbId+"<br/>");
	
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long scdbid = Long.parseLong(httpRequest.getParameter("scdbid"));
	out.println("scdbid:"+scdbid);
%>