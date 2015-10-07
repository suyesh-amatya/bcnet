<%@ include file="/html/init.jsp" %>

<%
if(renderRequest.getAttribute("error") != null) {
	System.out.println(renderRequest.getAttribute("error"));
	out.println(renderRequest.getAttribute("error"));
%>
<a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xlsx" />
				<%-- <portlet:param name="error" value='<%= renderRequest.getAttribute("error").toString() %>' /> --%>
				</portlet:resourceURL>">Download Disease Matrix as XLSX File</a>

<%
}
	List<BiobankGeneralInformation> biobanks = BiobankGeneralInformationLocalServiceUtil.getAllBiobankGeneralInformations();

	if(renderRequest.getAttribute("xls-header-not-defined-columns-missing") != null) {
		%>
		<div class="alert alert-error">
			<liferay-ui:message key='xls-header-not-defined-columns-missing' arguments='<%= renderRequest.getAttribute("xls-header-not-defined-columns-missing") %>'/>
		</div>
		<%
	}

	if(renderRequest.getAttribute("xls-header-not-defined-extra-columns") != null) {
		%>
		<div class="alert alert-error">
			<liferay-ui:message key='xls-header-not-defined-extra-columns' arguments='<%= renderRequest.getAttribute("xls-header-not-defined-extra-columns") %>'/>
		</div>
		<%
	}
	
	if(renderRequest.getAttribute("xls-row-import-errors") != null) {
		%>
		<div style="margin:10px; padding: 10px; background-color: #0066FF;opacity: 0.4;filter: alpha(opacity=40);color: #ffffff;" >
			<liferay-ui:message key='xls-row-import-errors' arguments='<%= renderRequest.getAttribute("xls-row-import-errors") %>'/>
		</div>
		<%
	}
	
%>

<liferay-ui:error key="file-upload-wrong-type" message="file-upload-wrong-type"></liferay-ui:error>	




<portlet:actionURL name='uploadSample' var="uploadSampleURL" />

<portlet:renderURL var="viewSampleUploadURL" />


<div class="sample-import-form">
	<div class="sample-import-form-header">Sample Import</div>
	<div class="sample-import-form-container">
		<aui:form action="<%=uploadSampleURL%>" enctype="multipart/form-data" method="post" name="fm">
			<aui:fieldset>
				<aui:row>
					<div id="download-template-file">
						<aui:a href="#">Download Template File (.xlsx)</aui:a> | <aui:a href="#">Download Template File (.xls)</aui:a>
					</div>
				</aui:row>
				<aui:row>
					<aui:column>
						<aui:select name="biobankId" label='Biobank <i class="icon-asterisk"></i>' showRequiredLabel="false">
							<aui:option>Select the Biobank to import the sample for:</aui:option>
							<%
								for (BiobankGeneralInformation biobank : biobanks) {
								
							%>
									<aui:option value="<%= biobank.getBiobankId() %>">
										<%=biobank.getBiobankName() %>
									</aui:option>
							<% 
								}
							%>
					
						</aui:select>
					</aui:column>
				</aui:row>
			
				<aui:row>
					<aui:column>
						<aui:input type="file" name="fileupload" label='File Upload <i class="icon-asterisk"></i>' required="true" showRequiredLabel="false">
							<aui:validator name="acceptFiles" errorMessage="Please submit the file with valid extension (xls, xlsx).">'xls,xlsx'</aui:validator>
						</aui:input>
					</aui:column>
				</aui:row>
			</aui:fieldset>
				
			<aui:button-row>
				<aui:column>
					<aui:button type="submit" />
					<aui:button onClick="<%= viewSampleUploadURL %>"  type="cancel" />
				</aui:column>
			</aui:button-row>
		</aui:form>
	</div>
</div>


<aui:script use="aui-base,aui-form-validator">
	AUI().use('aui-base','aui-form-validator',function(A){
		var rules = {
      		<portlet:namespace/>biobankId: {
        		required: true
      		}
      	};

		var fieldStrings = {
			<portlet:namespace/>biobankId: {
		    	required: 'The Biobank must be selected.'
		  	}
		};
		
		new A.FormValidator({
	        boundingBox: '#<portlet:namespace/>fm',
	        fieldStrings: fieldStrings,
	        rules: rules,
	        showAllMessages:true
      	});
	});
</aui:script>
