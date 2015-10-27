<%@ include file="/html/init.jsp" %>

<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Sample> searchContainer = null; 
%>

<%
	//String currentURL = PortalUtil.getCurrentURL(request);
	//out.println();
	//HttpSession filterSession =  request.getSession();
	//boolean container = false;
	/* if(filterSession.getAttribute("container")!=null){
		container = (boolean)filterSession.getAttribute("container");
	}
	else{
		container = ParamUtil.getBoolean(request, "container");
		filterSession.setAttribute("container", container);
	} */
	/* if(filterSession.getAttribute("container")==null)
		container = ParamUtil.getBoolean(request, "container");
	filterSession.setAttribute("container", container);
	
	out.println("caontaienr"+container);
	out.println("Session container"+filterSession.getAttribute("container"));
	 */
	
	
	
	//out.println(actionRequest.getAttribute("container"));
	//boolean container = ParamUtil.getBoolean(request, "container");
	/* boolean container = false;
	if(renderRequest.getAttribute("container")!=null){
		container = (Boolean)renderRequest.getAttribute("container");
		out.println(container);
	} */
	
	out.println("method"+request.getMethod());
	boolean container = ParamUtil.getBoolean(request, "container");
	out.println(container);
	HttpSession filterSession =  request.getSession();
	filterSession.setAttribute("container", Boolean.valueOf(container));
	out.println("filterSession"+filterSession.getAttribute("container"));
	
	String containerrequest = request.getParameter("container");
	out.println("containerrequest"+containerrequest);
	
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	httpRequest.setAttribute("container", Boolean.valueOf(container));
	
	
	
	String uuid = ParamUtil.getString(request, "uuid");
	String fileName = ParamUtil.getString(request, "fileName");

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

	List<Sample> samplesByuuid = SampleLocalServiceUtil.getSamplesByuuid(uuid);
	String biobankName = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(samplesByuuid.get(0).getBiobankDbId()).getBiobankName();
%>

<%-- <portlet:renderURL var="viewSampleImportDetailsURL1">
	<portlet:param name="mvcPath"
		value="/html/sample/sampleimportlog/sample_import_detail.jsp" />
	<portlet:param name="uuid" value="<%=uuid%>" />
</portlet:renderURL> --%>

<!-- Here we need to use liferay-portlet:renderURL instead of portlet:renderURL because we need to maintain the context of search container by setting 
the varImpl parameter in iteratorURL in search container. -->
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/sample/sampleimportlog/sample_import_detail.jsp" />
	<portlet:param name="uuid" value="<%=uuid%>" />
	<portlet:param name="fileName" value="<%=fileName%>" />
	<%-- <portlet:param name="container" value="<%=String.valueOf(container)%>" /> --%>
</liferay-portlet:renderURL>

<portlet:renderURL var="searchBiobankURL">
	<portlet:param name="mvcPath" value="/html/sample/sampleimportlog/sample_import_detail.jsp" />
	<portlet:param name="uuid" value="<%=uuid%>" />
	<portlet:param name="fileName" value="<%=fileName%>" />
	<%-- <portlet:param name="container" value="<%=String.valueOf(containerrequest)%>" /> --%>
</portlet:renderURL>
<%
//iteratorURL.setParameter("container", String.valueOf(container));
//iteratorURL.setProperty("container", String.valueOf(container));
%>
<ul id="sample-import-detail-small" style="display:none;" title="Show Columns Filter">
	<li class="pull-right">
		<button class="btn" type="button"><i class="icon-resize-small"></i></button>
	</li>
</ul>
<ul id="sample-import-detail-horizontal" title="Hide Columns Filter">
	<li class="pull-right">
		<button class="btn" type="button"><i class="icon-resize-horizontal"></i></button>
	</li>
</ul>
<h6>Samples Imported in a batch from file <%=fileName%> for <%=biobankName %></h6>
<portlet:actionURL name='filterColumns' var="filterColumnsURL" windowState="normal" />

<div id="sample-import-detail">
	<div class="container-fluid">
	    <div class="row-fluid">
	        <div class="span2">
				<div class="well sidebar-nav">
					<aui:form action="<%= \"\" %>" method="POST" name="fm" >
						<%-- <aui:input name="redirect" type="hidden" value="<%= currentURL %>" /> --%>
						<ul class="nav nav-list">
							<li class="nav-header">Columns to Display</li>
							<!-- <li class="active"><a href="#">Link</a></li>
							<li><a href="#">Link</a></li> -->
							<aui:a href="#" id="selectAll">Select all</aui:a>&nbsp;&nbsp;
							<aui:a href="#" id="deselectAll">Deselect all</aui:a>
							<aui:input name="sampleCollectionId" type="checkbox" label="sampleCollectionId"></aui:input>
							<aui:input name="hashedSampleId" type="checkbox" label="hashedSampleId"></aui:input>
							<aui:input name="materialType" type="checkbox" label="materialType"></aui:input>
							<aui:input name="container" type="checkbox" label="container" checked="<%=container==true %>" value="<%=container==true?\"true\":\"false\" %>"></aui:input>
							<aui:input name="storageTemperature" type="checkbox" label="storageTemperature"></aui:input>
							<aui:input name="sampledTime" type="checkbox" label="sampledTime"></aui:input>
							<aui:input name="anatomicalPartOntology" type="checkbox" label="anatomicalPartOntology"></aui:input>
							<aui:input name="anatomicalPartOntologyVersion" type="checkbox" label="anatomicalPartOntologyVersion"></aui:input>
							<aui:input name="anatomicalPartOntologyCode" type="checkbox" label="anatomicalPartOntologyCode"></aui:input>
							<aui:input name="anatomicalPartOntologyDescription" type="checkbox" label="anatomicalPartOntologyDescription"></aui:input>
							<aui:input name="anatomicalPartFreeText" type="checkbox" label="anatomicalPartFreeText"></aui:input>
							<aui:input name="sex" type="checkbox" label="sex"></aui:input>
							<aui:input name="ageHigh" type="checkbox" label="ageHigh"></aui:input>
							<aui:input name="ageLow" type="checkbox" label="ageLow"></aui:input>
							<aui:input name="ageUnit" type="checkbox" label="ageUnit"></aui:input>
							<aui:input name="diseaseOntology" type="checkbox" label="diseaseOntology"></aui:input>
							<aui:input name="diseaseOntologyVersion" type="checkbox" label="diseaseOntologyVersion"></aui:input>
							<aui:input name="diseaseOntologyCode" type="checkbox" label="diseaseOntologyCode"></aui:input>
							<aui:input name="diseaseOntologyDescription" type="checkbox" label="diseaseOntologyDescription"></aui:input>
							<aui:input name="diseaseFreeText" type="checkbox" label="diseaseFreeText"></aui:input>
						</ul>
						
						<aui:button type="submit" value="test" name="submit"/>
					</aui:form>
				</div>
	        </div>
		
			<div class="span10">
				<liferay-ui:search-container
					emptyResultsMessage="sample-empty-results-message"
					orderByType="<%= orderByType %>" iteratorURL="<%=iteratorURL %>">
				
				
					<%
					List<Sample> samplesByuuidPerPage = ListUtil.subList(samplesByuuid, searchContainer.getStart(),searchContainer.getEnd());
					List<Sample> sortableSamplesByuuid = new ArrayList<Sample>(samplesByuuidPerPage);
					if(Validator.isNotNull(orderByCol)){
					    BeanComparator comparator = new BeanComparator(orderByCol);
					    if(orderByType.equalsIgnoreCase("desc")){
					        Collections.sort(sortableSamplesByuuid, comparator);
					    }else{
					        Collections.sort(sortableSamplesByuuid, Collections.reverseOrder(comparator));
					    }
					
					}
					searchContainer.setResults(sortableSamplesByuuid);
					searchContainer.setTotal(samplesByuuid.size());
					%>
					
					
					<liferay-ui:search-container-row
						className="com.bcnet.portlet.biobank.model.Sample"
						keyProperty="sampleDbId" modelVar="sample" escapedModel="<%= true %>">
				
						<liferay-ui:search-container-column-text 
							name="sampleCollectionId"
							property="sampleCollectionId" 
							orderable="true"
							orderableProperty="sampleCollectionId"
						/>
				
						<liferay-ui:search-container-column-text 
							name="hashedSampleId"
							property="hashedSampleId" 
							orderable="true"
							orderableProperty="hashedSampleId"
						/>
				
						<liferay-ui:search-container-column-text
							name="materialType"
							property="materialType" 
							orderable="true"
							orderableProperty="materialType" 
						/>
				<c:choose>
				<c:when test="<%= container == true %>">
						<liferay-ui:search-container-column-text 
							name="container"
							property="container" 
							orderable="true"
							orderableProperty="container"
						/>
						</c:when>
				</c:choose>
						<liferay-ui:search-container-column-text 
							name="storageTemperature"
							property="storageTemperature" 
							orderable="true"
							orderableProperty="storageTemperature"
						/>
				
						<liferay-ui:search-container-column-text 
							name="sampledTime"
							property="sampledTime" 
							orderable="true"
							orderableProperty="sampledTime"
						/>
				
						<liferay-ui:search-container-column-text 
							name="anatomicalPartOntology"
							property="anatomicalPartOntology" 
							orderable="true"
							orderableProperty="anatomicalPartOntology"
						/>
				
						<liferay-ui:search-container-column-text
							name="anatomicalPartOntologyVersion"
							property="anatomicalPartOntologyVersion" 
							orderable="true"
							orderableProperty="anatomicalPartOntologyVersion"
						/>
				
						<liferay-ui:search-container-column-text
							name="anatomicalPartOntologyCode"
							property="anatomicalPartOntologyCode" 
							orderable="<%=true %>"
							orderableProperty="anatomicalPartOntologyCode"
						/>
				
						<liferay-ui:search-container-column-text
							name="anatomicalPartOntologyDescription"
							property="anatomicalPartOntologyDescription"
							orderable="<%=true %>"
							orderableProperty="anatomicalPartOntologyDescription"
						/>
				
						<liferay-ui:search-container-column-text 
							name="anatomicalPartFreeText"
							property="anatomicalPartFreeText" 
							orderable="<%=true %>"
							orderableProperty="anatomicalPartFreeText"
						/>
				
						<liferay-ui:search-container-column-text 
							name="sex"
							property="sex" 
							orderable="<%=true %>"
							orderableProperty="sex"
						/>
				
						<liferay-ui:search-container-column-text 
							name="ageHigh"
							property="ageHigh" 
							orderable="<%=true %>"
							orderableProperty="ageHigh"
						/>
				
						<liferay-ui:search-container-column-text 
							name="ageLow"
							property="ageLow"
							orderable="<%=true %>"
							orderableProperty="ageLow"
						/>
				
						<liferay-ui:search-container-column-text 
							name="ageUnit"
							property="ageUnit" 
							orderable="<%=true %>"
							orderableProperty="ageUnit"
						/>
				
						<liferay-ui:search-container-column-text 
							name="diseaseOntology"
							property="diseaseOntology"
							orderable="<%=true %>"
							orderableProperty="diseaseOntology"
						/>
				
						<liferay-ui:search-container-column-text 
							name="diseaseOntologyVersion"
							property="diseaseOntologyVersion"
							orderable="<%=true %>"
							orderableProperty="diseaseOntologyVersion"
						 />
				
						<liferay-ui:search-container-column-text 
							name="diseaseOntologyCode"
							property="diseaseOntologyCode"
							orderable="<%=true %>"
							orderableProperty="diseaseOntologyCode"
						/>
				
						<liferay-ui:search-container-column-text
							name="diseaseOntologyDescription"
							property="diseaseOntologyDescription" 
							orderable="<%=true %>"
							orderableProperty="diseaseOntologyDescription"
							/>
				
						<liferay-ui:search-container-column-text 
							name="diseaseFreeText"
							property="diseaseFreeText" 
							orderable="<%=true %>"
							orderableProperty="diseaseFreeText"
						/>
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>

<portlet:resourceURL var="checkBoxURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-io-request">
var url = '<%=checkBoxURL.toString()%>';
var containerValue = false;

A.one("#<portlet:namespace/>containerCheckbox").on('change',function(event){
	containerValue = A.one("#<portlet:namespace/>container").get("value");
	A.io.request(
			url, 
			{
		        method: 'get',
		        data: {
		        	<portlet:namespace/>containerCheckbox :containerValue,
		        	<portlet:namespace/>type :"check"
		        }
		        
   		});
});
A.io.request(url, {
	  on: {
	   success: function(data) {
	    // if(this.get('responseData')){
	    	 console.log(data);
	    	 A.one("#<portlet:namespace/>containerCheckbox").attr("checked", true);
	 		A.one("#<portlet:namespace/>container").attr("value", true);
	     //}
	   }
	  }
	});

	//Hide Columns Filter 
	A.one("#sample-import-detail-horizontal").on('click',function(event){
		A.one("#sample-import-detail .span2").hide();
		A.one("#sample-import-detail .span10").addClass("span12").removeClass("span10");
		A.one("#sample-import-detail-horizontal").hide();
		A.one("#sample-import-detail-small").show();
	});
	
	//Show Columns Filter
	A.one("#sample-import-detail-small").on('click',function(event){
		A.one("#sample-import-detail .span2").show();
		A.one("#sample-import-detail .span12").addClass("span10").removeClass("span12");
		A.one("#sample-import-detail-small").hide();
		A.one("#sample-import-detail-horizontal").show();
	});
	
	//Select All Columns
	A.one("#<portlet:namespace/>selectAll").on('click',function(event){
		A.one("#<portlet:namespace/>sampleCollectionIdCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>sampleCollectionId").attr("value", true);
	
		A.one("#<portlet:namespace/>hashedSampleIdCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>hashedSampleId").attr("value", true);
		
		A.one("#<portlet:namespace/>materialTypeCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>materialType").attr("value", true);
		
		A.one("#<portlet:namespace/>containerCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>container").attr("value", true);
		
		A.one("#<portlet:namespace/>storageTemperatureCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>storageTemperature").attr("value", true);
		
		A.one("#<portlet:namespace/>sampledTimeCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>sampledTime").attr("value", true);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>anatomicalPartOntology").attr("value", true);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyVersionCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>anatomicalPartOntologyVersion").attr("value", true);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyCodeCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>anatomicalPartOntologyCode").attr("value", true);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyDescriptionCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>anatomicalPartOntologyDescription").attr("value", true);
		
		A.one("#<portlet:namespace/>anatomicalPartFreeTextCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>anatomicalPartFreeText").attr("value", true);
		
		A.one("#<portlet:namespace/>sexCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>sex").attr("value", true);
		
		A.one("#<portlet:namespace/>ageHighCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>ageHigh").attr("value", true);
		
		A.one("#<portlet:namespace/>ageLowCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>ageLow").attr("value", true);
		
		A.one("#<portlet:namespace/>ageUnitCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>ageUnit").attr("value", true);
		
		A.one("#<portlet:namespace/>diseaseOntologyCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>diseaseOntology").attr("value", true);
		
		A.one("#<portlet:namespace/>diseaseOntologyVersionCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>diseaseOntologyVersion").attr("value", true);
		
		A.one("#<portlet:namespace/>diseaseOntologyCodeCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>diseaseOntologyCode").attr("value", true);
		
		A.one("#<portlet:namespace/>diseaseOntologyDescriptionCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>diseaseOntologyDescription").attr("value", true);
		
		A.one("#<portlet:namespace/>diseaseFreeTextCheckbox").attr("checked", true);
		A.one("#<portlet:namespace/>diseaseFreeText").attr("value", true);
		
	});
	
	//Deselect All Columns
	A.one("#<portlet:namespace/>deselectAll").on('click',function(event){
		A.one("#<portlet:namespace/>sampleCollectionIdCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>sampleCollectionId").attr("value", false);
	
		A.one("#<portlet:namespace/>hashedSampleIdCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>hashedSampleId").attr("value", false);
		
		A.one("#<portlet:namespace/>materialTypeCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>materialType").attr("value", false);
		
		A.one("#<portlet:namespace/>containerCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>container").attr("value", false);
		
		A.one("#<portlet:namespace/>storageTemperatureCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>storageTemperature").attr("value", false);
		
		A.one("#<portlet:namespace/>sampledTimeCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>sampledTime").attr("value", false);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>anatomicalPartOntology").attr("value", false);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyVersionCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>anatomicalPartOntologyVersion").attr("value", false);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyCodeCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>anatomicalPartOntologyCode").attr("value", false);
		
		A.one("#<portlet:namespace/>anatomicalPartOntologyDescriptionCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>anatomicalPartOntologyDescription").attr("value", false);
		
		A.one("#<portlet:namespace/>anatomicalPartFreeTextCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>anatomicalPartFreeText").attr("value", false);
		
		A.one("#<portlet:namespace/>sexCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>sex").attr("value", false);
		
		A.one("#<portlet:namespace/>ageHighCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>ageHigh").attr("value", false);
		
		A.one("#<portlet:namespace/>ageLowCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>ageLow").attr("value", false);
		
		A.one("#<portlet:namespace/>ageUnitCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>ageUnit").attr("value", false);
		
		A.one("#<portlet:namespace/>diseaseOntologyCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>diseaseOntology").attr("value", false);
		
		A.one("#<portlet:namespace/>diseaseOntologyVersionCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>diseaseOntologyVersion").attr("value", false);
		
		A.one("#<portlet:namespace/>diseaseOntologyCodeCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>diseaseOntologyCode").attr("value", false);
		
		A.one("#<portlet:namespace/>diseaseOntologyDescriptionCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>diseaseOntologyDescription").attr("value", false);
		
		A.one("#<portlet:namespace/>diseaseFreeTextCheckbox").attr("checked", false);
		A.one("#<portlet:namespace/>diseaseFreeText").attr("value", false);
	});
</aui:script>