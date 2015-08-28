<%@ include file="/html/init.jsp" %>

<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Sample> searchContainer = null; 
%>

<%

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
	String biobankName = BiobankGeneralInformationLocalServiceUtil.getBiobankByBiobankId(samplesByuuid.get(0).getBiobankId()).getBiobankName();
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
</liferay-portlet:renderURL>

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


<div id="sample-import-detail">
	<div class="container-fluid">
	    <div class="row-fluid">
	        <div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Columns to Display</li>
						<li class="active"><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="nav-header">Sidebar</li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="nav-header">Sidebar</li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
					</ul>
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
				
						<liferay-ui:search-container-column-text 
							name="container"
							property="container" 
							orderable="true"
							orderableProperty="container"
						/>
				
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

<aui:script use="aui-base">
	A.one("#sample-import-detail-horizontal").on('click',function(event){
		A.one("#sample-import-detail .span2").hide();
		A.one("#sample-import-detail .span10").addClass("span12").removeClass("span10");
		A.one("#sample-import-detail-horizontal").hide();
		A.one("#sample-import-detail-small").show();
	});
	
	A.one("#sample-import-detail-small").on('click',function(event){
		A.one("#sample-import-detail .span2").show();
		A.one("#sample-import-detail .span12").addClass("span10").removeClass("span12");
		A.one("#sample-import-detail-small").hide();
		A.one("#sample-import-detail-horizontal").show();
	});
</aui:script>