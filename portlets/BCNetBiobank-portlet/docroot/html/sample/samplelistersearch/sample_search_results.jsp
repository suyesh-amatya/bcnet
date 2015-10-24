<%@include file="/html/init.jsp"%>

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

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
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
        /* SearchContext searchContext = SearchContextFactory
        .getInstance(request);

        searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(10);
        System.out.println("searchContext"+searchContext.getKeywords());
        Indexer indexer = IndexerRegistryUtil.getIndexer(Sample.class); 
System.out.println("Indexer"+indexer.getFullQuery(searchContext));
        Hits hits = indexer.search(searchContext); */
        Hits hits = SampleLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords);
        System.out.println("hits "+hits.toString());
        List<Sample> entries = new ArrayList<Sample>();
        System.out.println("hits "+hits.getDocs().length);
        for (int i = 0; i < hits.getDocs().length; i++) {
                Document doc = hits.doc(i);
System.out.println(doc.toString());
out.println(doc.toString());
                long entryId = GetterUtil
                .getLong(doc.get(Field.ENTRY_CLASS_PK));

                Sample entry = null;

                try {
                        entry = SampleLocalServiceUtil.getSample(entryId);
                } catch (PortalException pe) {
                        _log.error(pe.getLocalizedMessage());
                } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage());
                }

                entries.add(entry);
        }

        List<Sample> guestbooks = SampleLocalServiceUtil.getSamples(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        //System.out.println("Sample "+guestbooks);
        Map<String, String> guestbookMap = new HashMap<String, String>();

        for (Sample guestbook : guestbooks) {
                guestbookMap.put(Long.toString(guestbook.getSampleDbId()), guestbook.getHashedSampleId());
        }
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found" iteratorURL="<%=searchURL %>">
        <liferay-ui:search-container-results
                results="<%= entries %>"
                total="<%= entries.size() %>"
        />

        <liferay-ui:search-container-row
                className="com.bcnet.portlet.biobank.model.Sample"
                keyProperty="sampleDbId" modelVar="sample" escapedModel="<%=true%>">
                <liferay-ui:search-container-column-text name="guestbook"
                        value="<%=guestbookMap.get(Long.toString(sample.getSampleDbId()))%>" />

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
        private static Log _log = LogFactoryUtil.getLog("docroot.html.guestbook.view_search_jsp");
%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page import="javax.portlet.PortletURL" %>