<%@ include file="/html/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/sample/samplelistersearch/sample_search_results.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/sample/samplelistersearch/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" placeholder="type-your-query" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%

	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_sample = "EDIT_SAMPLE";
	String actionId_delete_sample = "DELETE_SAMPLE";

	String sampleSearchResultsURL = PortalUtil.getCurrentURL(renderRequest);

    String keywords = ParamUtil.getString(request, "keywords");

	SearchContainer<Sample> sampleSearchContainer = new SearchContainer<Sample>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, searchURL, null, "no-samples-match-search-criteria");
	

    SearchContext searchContext = SearchContextFactory.getInstance(request);
    
    
	Hits hits = SampleLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords, sampleSearchContainer.getStart(), sampleSearchContainer.getEnd());

	List<SearchResult> srList = SearchResultUtil.getSearchResults(hits, null, searchURL);
	
	Map<Long, String> srMap = new HashMap<Long, String>();
	
	for(SearchResult sr : srList){
		srMap.put(sr.getClassPK(), sr.getSummary().getContent());
	}
	
	
	List<Sample> samples = new ArrayList<Sample>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);
		
		long sampleDbId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		Sample sample = null;
		
		try {
			sample = SampleLocalServiceUtil.getSample(sampleDbId);
		} catch (PortalException pe) {
		        _log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
		        _log.error(se.getLocalizedMessage());
		}
		
		samples.add(sample);
	}

	 String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
     String portletNamespace = PortalUtil.getPortletNamespace(portletId);
       
%>

<c:set var="portletNameSpaceVal" value="<%=portletNamespace%>" />

<div id="sample-search-results-container">
	<liferay-ui:search-container searchContainer="<%=sampleSearchContainer %>">
		
		<liferay-ui:search-container-results results="<%= samples %>" total="<%= hits.getLength() %>" />
		<p><b>Total Results:  <%= hits.getLength() %></b></p>
		<liferay-ui:search-container-row
			className="com.bcnet.portlet.biobank.model.Sample"
			keyProperty="sampleDbId" modelVar="sample" escapedModel="<%=true%>">
		
		<div class="well sample-search-results" >
			<div class="sample-search-results-title">
			
			<portlet:renderURL var="viewSampleDetailsURL">
				<portlet:param name="mvcPath" value="/html/sample/samplelistersearch/sample_detail.jsp" />
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="backURL" value="<%= sampleSearchResultsURL %>" />
			</portlet:renderURL>
			
			<%
				// Popup has permission issues for guest/unauthenticated users.
				/* Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
				long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
				
				LiferayPortletURL viewSampleDetailsURL = PortletURLFactoryUtil.create(request, "samplelistersearch_WAR_BCNetBiobankportlet", controlPanelPlid, "RENDER_PHASE");
				viewSampleDetailsURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
				viewSampleDetailsURL.setParameter("jspPage", "/html/sample/samplelistersearch/sample_detail.jsp");
				viewSampleDetailsURL.setParameter("sampleDbId", String.valueOf(sample.getSampleDbId()));
				
				viewSampleDetailsURL.setWindowState(LiferayWindowState.POP_UP); */
			%>
			
			<%-- <c:set var="portletURL" value="<%=viewSampleDetailsURL%>" />
			
			<aui:a href="#" onClick="${portletNameSpaceVal}showPopup('${portletURL}')"><%=srMap.get(sample.getSampleDbId()) %></aui:a> --%>
			
			<% 
				out.println("<a href="+viewSampleDetailsURL+">"+srMap.get(sample.getSampleDbId())+"</a> ");
			%>
			
			</div>
			<%
				String sampleBodyContent = sample.getDiseaseOntologyDescription()+" "+sample.getDiseaseFreeText()+" "+sample.getAnatomicalPartOntology()+" "+sample.getAnatomicalPartOntologyVersion()
						+" "+sample.getAnatomicalPartOntologyCode()+" "+sample.getAnatomicalPartOntologyDescription()+" "+sample.getAnatomicalPartFreeText()+"<br/>";
				
				if(!sample.getHashedIndividualId().equals("")){
					sampleBodyContent += sample.getHashedIndividualId()+" ";
				}
				if(!sample.getSex().equals("")){
					sampleBodyContent += sample.getSex()+" ";
				}
				if(sample.getAgeLow() > 0 && sample.getAgeHigh() > 0 && !sample.getAgeUnit().equals("")){
					sampleBodyContent += sample.getAgeLow()+"-"+sample.getAgeHigh()+" "+sample.getAgeUnit()+" ";
				}
				if(!sample.getCountryOfOrigin().equals("")){
					sampleBodyContent += sample.getCountryOfOrigin()+"<br/>";
				}
				if(sample.getSampledTime() != null){
					sampleBodyContent += new SimpleDateFormat("yyyy-MM-dd HH:mm").format(sample.getSampledTime())+" ";
				}
				if(!sample.getStorageTemperature().equals("")){
					sampleBodyContent += sample.getStorageTemperature()+" ";
				}
				if(!sample.getContainer().equals("")){
					sampleBodyContent += sample.getContainer()+"<br/>";
				}
				if(sample.getSampleCollectionDbId() > 0){
					String scPath = themeDisplay.getURLPortal()+"/sample-collections/general-information?scdbid="+sample.getSampleCollectionDbId();
					sampleBodyContent += "<a href="+scPath+">"+SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getName()+" ";
				}
				if(sample.getBiobankDbId() > 0){
					Organization organization = OrganizationLocalServiceUtil.getOrganization(sample.getBiobankDbId());
					String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
					sampleBodyContent += "<a href="+orgPath+">"+BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(sample.getBiobankDbId()).getBiobankName()+"</a> ";
				}
				out.println(sampleBodyContent);
			%>
			
			
			<portlet:renderURL var="editSampleURL">
				<portlet:param name="mvcPath" value="/html/sample/samplelistersearch/edit_sample_search.jsp" />
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="redirect" value="<%= sampleSearchResultsURL %>" />
			</portlet:renderURL>

			<portlet:actionURL name="deleteSample" var="deleteSampleURL">
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="redirect" value="<%= sampleSearchResultsURL %>" />
			</portlet:actionURL>
			

			<c:choose>		
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_sample) %>">
					<a href="<%=editSampleURL.toString()%>">
					<liferay-ui:icon image="edit" message="Edit Sample" cssClass="biobankOrganizationEdit"/>
					</a>
				</c:when>
			</c:choose>
			
			<c:choose>		
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample) %>">
					<liferay-ui:icon-delete url="<%= deleteSampleURL.toString() %>" message="Delete Sample" cssClass="biobankOrganizationDelete"
					confirmation="Are you sure you want to delete it?"/>
				</c:when>
			</c:choose>
			
		</div>
		
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<%
        if (Validator.isNotNull(keywords)) {
                String currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
                                pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.sample.samplelistersearch.sample_search_results.jsp");
%>

<aui:script>
     function <portlet:namespace />showPopup(url) {

         var url = url;

             Liferay.Util.openWindow(
                 {
                     dialog: {
                         cache: false,
                         width:800,
                         modal: true,
                         centered: true
                     },
                     id: 'samplelistersearch_WAR_BCNetBiobankportlet',                
                     uri: url
                 }
             );
     }

 </aui:script>