<%@include file="/html/init.jsp"%>

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
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="50" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
    String keywords = ParamUtil.getString(request, "keywords");

	SearchContainer<Sample> sampleSearchContainer = new SearchContainer<Sample>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, searchURL, null, "no-samples-match-search-criteria");
	

    SearchContext searchContext = SearchContextFactory.getInstance(request);
    
    
	Hits hits = SampleLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords, sampleSearchContainer.getStart(), sampleSearchContainer.getEnd());

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

<liferay-ui:search-container searchContainer="<%=sampleSearchContainer %>">
        <liferay-ui:search-container-results
                results="<%= samples %>"
                total="<%= hits.getLength() %>"
        />

        <liferay-ui:search-container-row
                className="com.bcnet.portlet.biobank.model.Sample"
                keyProperty="sampleDbId" modelVar="sample" escapedModel="<%=true%>">
                <liferay-ui:search-container-column-text name="materialType"
                        value="<%=sample.getMaterialType()%>" />

                <liferay-ui:search-container-column-text property="container" />

                <liferay-ui:search-container-column-text property="diseaseFreeText" />

                <<%-- liferay-ui:search-container-column-jsp
            path="/html/guestbook/guestbook_actions.jsp"
            align="right" /> --%>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
</liferay-ui:search-container>

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