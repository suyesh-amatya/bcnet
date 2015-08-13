<%@page import="com.bcnet.portlet.biobank.model.impl.SampleImportLogImpl"%>
<%@ include file="/html/init.jsp" %>


<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<SampleImportLog> searchContainer = null; 
%>

<%
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
	 
	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	
	//Logic for toggle asc and desc
	if(orderByType.equals("desc")){
	    orderByType = "asc";
	}else{
	    orderByType = "desc";
	}
	 
	if(Validator.isNull(orderByType)){
	    orderByType = "desc";
	}
	
%>

<liferay-ui:search-container emptyResultsMessage="sampleImportLog-empty-results-message"  orderByType="<%= orderByType %>">

	<%-- <liferay-ui:search-container-results > --%>

	<%
	
	List<SampleImportLog> allSampleImportLogs = SampleImportLogLocalServiceUtil.getSampleImportLogs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<SampleImportLog> sampleImportLogsPerPage = ListUtil.subList(allSampleImportLogs, searchContainer.getStart(),searchContainer.getEnd());
	List<SampleImportLog> sortableSampleImportLogs = new ArrayList<SampleImportLog>(sampleImportLogsPerPage);
	if(Validator.isNotNull(orderByCol)){
	    //Pass the column name to BeanComparator to get comparator object
	    BeanComparator comparator = new BeanComparator(orderByCol);
	    if(orderByType.equalsIgnoreCase("asc")){
	        //It will sort in ascending order
	        Collections.sort(sortableSampleImportLogs, comparator);
	    }else{
	        //It will sort in descending order
	        //Collections.reverse(sortableSampleImportLogs);
	        Collections.sort(sortableSampleImportLogs, Collections.reverseOrder(comparator));
	    }
	
	}
	searchContainer.setResults(sortableSampleImportLogs);
	searchContainer.setTotal(SampleImportLogLocalServiceUtil.getSampleImportLogsCount());
	//pageContext.setAttribute("results", sortableSampleImportLogs);
	//pageContext.setAttribute("total", SampleImportLogLocalServiceUtil.getSampleImportLogsCount());
	%>
	<%-- </liferay-ui:search-container-results>  --%>
	<%-- <liferay-ui:search-container-results
		results="<%= sortableSampleImportLogs %>"
		total="<%= SampleImportLogLocalServiceUtil.getSampleImportLogsCount() %>"
	/> --%>
		<liferay-ui:search-container-row
			className="com.bcnet.portlet.biobank.model.SampleImportLog"
			keyProperty="importId"
			modelVar="sampleImportLog" escapedModel="<%= true %>"
		>
			<portlet:renderURL var="viewSampleImportDetailsURL">
				<portlet:param name="mvcPath" value="/html/sample/sampleimportlog/sample_import_detail.jsp" />
				<portlet:param name="uuid" value="<%= sampleImportLog.getUuid() %>" />
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text
				name="uuid"
				property="uuid" 
				orderable="true"
				orderableProperty="uuid"
				href="<%= viewSampleImportDetailsURL %>"
			/>
	
			<liferay-ui:search-container-column-text
				name="File Name"
				property="fileName"
				orderable="true"
				orderableProperty="fileName"
			/>
	
			<liferay-ui:search-container-column-text
				name="Imported By"
				property="fullNameImporter"
				orderable="true"
				orderableProperty="fullNameImporter"
			/>
			
			<liferay-ui:search-container-column-text
				name="Date Of Import"
				property="dateOfImport"
				orderable="true"
				orderableProperty="dateOfImport"
			/>
			<%-- <c:choose>		
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_juristic_person) ||  
										permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_juristic_person) %>">
					<liferay-ui:search-container-column-jsp
						align="right"
						path="/html/juristicperson/juristicperson_actions.jsp"
					/>
				</c:when>
			</c:choose> --%>
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>