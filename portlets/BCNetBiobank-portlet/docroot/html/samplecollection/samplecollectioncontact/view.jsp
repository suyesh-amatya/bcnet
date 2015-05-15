<%@ include file="/html/init.jsp" %>

<%
//Parameters for permission Checking
//TBD

boolean optionsDisplayMaincontact_option = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));
		
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));

String currentURL = PortalUtil.getCurrentURL(request);//also renderRequest can be passed as a parameter.
out.println(currentURL);

long sampleCollectionMainContactId = 0;
if(optionsDisplayMaincontact_option) {
	SampleCollectionContact sampleCollectionMainContact = null;
	try{
		sampleCollectionMainContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionMainContact(sampleCollectionDbId);
		out.println(sampleCollectionMainContact);
	}
	catch(Exception e){
	}
	
	List<SampleCollectionContact> sampleCollectionContacts = SampleCollectionContactLocalServiceUtil.getSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
	out.println(sampleCollectionContacts);
	
}
%>