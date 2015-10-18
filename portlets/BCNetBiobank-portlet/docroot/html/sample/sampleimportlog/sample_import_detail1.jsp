<%@ include file="/html/init.jsp" %>

<!-- Trying to override the buttons.dataTables.min.css from the main.css in the plugin project or via theme did not work. So the overriding had to be done
here itself in the file. -->
<style>
div.dt-button-collection{
	width: auto;
}
</style>



<%
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	String uuid = ParamUtil.getString(request, "uuid");
	String fileName = ParamUtil.getString(request, "fileName");

	List<Sample> samplesByuuid = SampleLocalServiceUtil.getSamplesByuuid(uuid);
	Date dateOfImport = SampleImportLogLocalServiceUtil.getSampleImportLogByUuid(uuid).getDateOfImport();
	String biobankName = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(samplesByuuid.get(0).getBiobankDbId()).getBiobankName();
%>

<h6>Samples Imported in a batch from file <%=fileName%> for <%=biobankName %> on <%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dateOfImport) %></h6>


<div id="sample-import-detail">
	<div class="container-fluid">
		<table id="table_id" class="display">
		    <thead>
		        <tr>
		        	<th>Actions</th>
		            <th>sampleCollectionId</th>
		            <th>hashedSampleId</th>
		            <th>hashedIndividualId</th>
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
		            <th>ageLow</th>
		            <th>ageHigh</th>
		            <th>ageUnit</th>
		            <th>diseaseOntology</th>
		            <th>diseaseOntologyVersion</th>
		            <th>diseaseOntologyCode</th>
		            <th>diseaseOntologyDescription</th>
		            <th>diseaseFreeText</th>
		            <th>countryOfOrigin</th>
		        </tr>
		    </thead>
		    <tbody>
		    <%
		    for(Sample sample: samplesByuuid){
		    %>
		    
				<portlet:renderURL var="editSampleURL">
					<portlet:param name="mvcPath" value="/html/sample/sampleimportlog/edit_sample.jsp" />
					<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
					<portlet:param name="redirect" value="<%= redirect %>" />
				</portlet:renderURL>
				
				<portlet:actionURL name="deleteSample" var="deleteSampleURL">
					<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
					<portlet:param name="redirect" value="<%= redirect %>" />
				</portlet:actionURL>
				
		        <tr>
		        	<td>
		        		<liferay-ui:icon image="edit" message="Edit Sample" url="<%= editSampleURL.toString() %>"/>&nbsp;
		        		<liferay-ui:icon-delete url="<%= deleteSampleURL.toString() %>" 
							message="<%= \"Delete Sample\" %>" 
							confirmation="<%= \"Are you sure you want to delete this sample? \" %>"
						/>
		        	</td>
		        	<%
		        		String sampleCollectionId = "";
		        		try{
		        			sampleCollectionId = SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getSampleCollectionId();
		        		}
		        		catch(NoSuchSampleCollectionException e){
		        			e.printStackTrace();
		        		}
		        	%>
		            <td><%=sampleCollectionId %></td>
		            <td><%=sample.getHashedSampleId() %></td>
		            <td><%=sample.getHashedIndividualId() %></td>
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
		            <td><%=sample.getAgeLow() %></td>
		            <td><%=sample.getAgeHigh() %></td>
		            <td><%=sample.getAgeUnit() %></td>
		            <td><%=sample.getDiseaseOntology() %></td>
		            <td><%=sample.getDiseaseOntologyVersion() %></td>
		            <td><%=sample.getDiseaseOntologyCode() %></td>
		            <td><%=sample.getDiseaseOntologyDescription() %></td>
		            <td><%=sample.getDiseaseFreeText() %></td>
		            <td><%=sample.getCountryOfOrigin() %></td>
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
	        buttons: {
	        	buttons: [
	      	            {
	      	            	extend:'colvis',
	      	            	text: 'Show/Hide Columns',
	      	            	columns: ':not(:first-child)'
	      	            },
	    	            {
	    	                extend: 'colvisGroup',
	    	                text: 'Show all',
	    	                show: ':hidden'
	    	            }
	    	    ]
	        },
	        "order": [],
	        "columnDefs": [
	         	{ "orderable": false, "targets": 0  } 
	         ]
	    });
	});
</script>