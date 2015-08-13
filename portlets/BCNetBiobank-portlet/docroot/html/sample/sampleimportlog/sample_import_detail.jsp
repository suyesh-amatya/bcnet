<%@ include file="/html/init.jsp" %>

<%

out.println(ParamUtil.getString(request, "uuid"));
out.println(renderRequest.getAttribute("uuid"));
out.println(renderRequest.getParameter("uuid"));
%>