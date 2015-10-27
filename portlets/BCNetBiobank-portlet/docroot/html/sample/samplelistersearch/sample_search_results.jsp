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
            <aui:input inlineField="<%= true %>" label="Keywords" name="keywords" size="50" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
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

       
%>

<div id="sample-search-results-container">
<liferay-ui:search-container searchContainer="<%=sampleSearchContainer %>">
	
	<liferay-ui:search-container-results results="<%= samples %>" total="<%= hits.getLength() %>" />
	<p><b>Total Results:  <%= hits.getLength() %></b></p>
	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.Sample"
		keyProperty="sampleDbId" modelVar="sample" escapedModel="<%=true%>">
	
	<div class="well sample-search-results" >
		<div class="sample-search-results-title">
		<% 
			out.println(srMap.get(sample.getSampleDbId()));
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