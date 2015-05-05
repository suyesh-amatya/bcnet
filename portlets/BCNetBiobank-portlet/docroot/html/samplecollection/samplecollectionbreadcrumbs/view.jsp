<%@ include file="/html/init.jsp"%>
<%
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	
	long sampleCollectionDbId = 0;
	
	if (httpRequest.getParameter("scdbid") != null){
		sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));
	}
	
	String currentURL = themeDisplay.getURLPortal()+themeDisplay.getURLCurrent();

%>

<nav id="breadcrumbs">
	<ul aria-label="Breadcrumb" class="breadcrumb">
	
		<li class="first breadcrumb-truncate">
			<a href="<%=themeDisplay.getURLPortal()%>/sample-collections">Sample Collections</a>
			<span class="divider">/</span>
		</li>
		
		<%
			SampleCollection sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
			String name = sampleCollection.getName();
		%>
		<li class="current-parent breadcrumb-truncate">
			<a href="<%=themeDisplay.getURLPortal()%>/sample-collections/general-information?scdbid=<%=sampleCollectionDbId %>"><%=name%></a>
			<span class="divider">/</span>
		</li>
		
		<%
			if(currentURL.contains("general-information")){
		%>
		
		<li class="active last breadcrumb-truncate">
			<a href="<%=currentURL%>">General Information</a>
			<span class="divider">/</span>
		</li>
		
		<% 
			}
		%>
		
		<%
			if(currentURL.contains("attributes")){
		%>
		
		<li class="active last breadcrumb-truncate">
			<a href="<%=currentURL%>">Attributes</a>
			<span class="divider">/</span>
		</li>
		
		<% 
			}
		%>
		
		<%
			if(currentURL.contains("contacts")){
		%>
		
		<li class="active last breadcrumb-truncate">
			<a href="<%=currentURL%>">Contacts</a>
			<span class="divider">/</span>
		</li>
		
		<% 
			}
		%>
		
	</ul>
</nav>
