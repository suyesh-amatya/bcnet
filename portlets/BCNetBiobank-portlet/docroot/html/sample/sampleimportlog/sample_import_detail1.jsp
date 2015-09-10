<%@ include file="/html/init.jsp" %>

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
	<portlet:param name="mvcPath" value="/html/sample/sampleimportlog/sample_import_detail1.jsp" />
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

<h6>Samples Imported in a batch from file <%=fileName%> for <%=biobankName %></h6>


<div id="sample-import-detail">
	<div class="container-fluid">
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		            <th>sampleCollectionId</th>
		            <th>hashedSampleId</th>
		            <th>materialType</th>
		            <th>container</th>
		            <th>storageTemperature</th>
		            <th>sampledTime</th>
		            <th>anatomicalPartOntology</th>
		            <th>anatomicalPartOntologyVersion</th>
		            <th>anatomicalPartOntologyCode</th>
		            <th>anatomicalPartOntologyDescription</th>
		            <th>anatomicalPartFreeText</th>
		            <th>sex</th>
		            <th>ageHigh</th>
		            <th>ageLow</th>
		            <th>ageUnit</th>
		            <th>diseaseOntology</th>
		            <th>diseaseOntologyVersion</th>
		            <th>diseaseOntologyCode</th>
		            <th>diseaseOntologyDescription</th>
		            <th>diseaseFreeText</th>
		        </tr>
		    </thead>
		    <tbody>
		    <%
		    for(Sample sample: samplesByuuid){
		    %>
		        <tr>
		            <td><%=sample.getSampleCollectionId() %></td>
		            <td><%=sample.getHashedSampleId() %></td>
		            <td><%=sample.getMaterialType() %></td>
		            <td><%=sample.getContainer() %></td>
		            <td><%=sample.getStorageTemperature() %></td>
		            <td><%=sample.getSampledTime() %></td>
		            <td><%=sample.getAnatomicalPartOntology() %></td>
		            <td><%=sample.getAnatomicalPartOntologyVersion() %></td>
		            <td><%=sample.getAnatomicalPartOntologyCode() %></td>
		            <td><%=sample.getAnatomicalPartOntologyDescription() %></td>
		            <td><%=sample.getAnatomicalPartFreeText() %></td>
		            <td><%=sample.getSex() %></td>
		            <td><%=sample.getAgeHigh() %></td>
		            <td><%=sample.getAgeLow() %></td>
		            <td><%=sample.getAgeUnit() %></td>
		            <td><%=sample.getDiseaseOntology() %></td>
		            <td><%=sample.getDiseaseOntologyVersion() %></td>
		            <td><%=sample.getDiseaseOntologyCode() %></td>
		            <td><%=sample.getDiseaseOntologyDescription() %></td>
		            <td><%=sample.getDiseaseFreeText() %></td>
		        </tr>
		  <%
		    }
		  %>
		    </tbody>
		</table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready( function () {
	    $('#table_id').DataTable({
	    	"scrollX": true,
	    	"pagingType": "full_numbers",
	    	"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	    	 dom: 'l<"clear">Bfrtip',
	        buttons: [
	            'colvis',
	            {
	                extend: 'colvisGroup',
	                text: 'Show all',
	                show: ':hidden'
	            }
	        ] 
	    });
	});
</script>