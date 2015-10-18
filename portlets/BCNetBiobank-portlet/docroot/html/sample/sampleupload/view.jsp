<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="file-upload-wrong-type" message="file-upload-wrong-type"/>	

<liferay-ui:error key="file-not-found" message="file-not-found"/>

<liferay-ui:error key='file-size-zero' message="file-size-zero"/>

<liferay-ui:error key='xls-sheet-no-data' message="xls-sheet-no-data"/>

<liferay-ui:error key='xls-sheet-not-found' message="xls-sheet-not-found"/>

<liferay-ui:error key='xls-headers-not-string' message="xls-headers-not-string"/>


<%
	if(renderRequest.getAttribute("error") != null) {
%>

		<portlet:resourceURL var="downloadErrorReportURL">
			<portlet:param name="<%=Constants.CMD%>" value="error" />
			<portlet:param name="errorFileName" value="<%=renderRequest.getAttribute(\"errorFileName\").toString() %>"/>
		</portlet:resourceURL>
		<div class="alert alert-error">
			<aui:a href="<%=downloadErrorReportURL.toString()%>">Download Error Report</aui:a>
		</div>	

<%
	}


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
		<!-- <div style="margin:10px; padding: 10px; background-color: #0066FF;opacity: 0.4;filter: alpha(opacity=40);color: #ffffff;" > -->
		<div class="alert alert-error">
			<liferay-ui:message key='xls-row-import-errors' arguments='<%= renderRequest.getAttribute("xls-row-import-errors") %>'/>
		</div>
<%
	}
	
	List<BiobankGeneralInformation> biobanks = BiobankGeneralInformationLocalServiceUtil.getAllBiobankGeneralInformations();
	
%>






<portlet:actionURL name='uploadSample' var="uploadSampleURL" />

<portlet:renderURL var="viewSampleUploadURL" />

<portlet:resourceURL var="downloadTemplateFileXlsxURL">
	<portlet:param name="<%=Constants.CMD %>" value="xlsxTemplate"/>	
</portlet:resourceURL>

<portlet:resourceURL var="downloadTemplateFileXlsURL">
	<portlet:param name="<%=Constants.CMD %>" value="xlsTemplate"/>	
</portlet:resourceURL>

<div class="sample-import-form">
	<div class="sample-import-form-header">Sample Import</div>
	<div class="sample-import-form-container">
		<aui:form action="<%=uploadSampleURL%>" enctype="multipart/form-data" method="post" name="fm">
			<aui:fieldset>
				<aui:row>
					<div id="download-template-file">
						<aui:a href="<%=downloadTemplateFileXlsxURL.toString()%>">
							Download Template File (.xlsx)
						</aui:a> 
						&nbsp;&#124;&nbsp;
						<aui:a href="<%=downloadTemplateFileXlsURL.toString()%>">
							Download Template File (.xls)
						</aui:a>
					</div>
				</aui:row>
				<aui:row>
					<aui:column>
						<aui:select name="biobankDbId" label='Biobank <i class="icon-asterisk"></i>' showRequiredLabel="false">
							<aui:option>Select the Biobank to import the sample for:</aui:option>
							<%
								for (BiobankGeneralInformation biobank : biobanks) {
								
							%>
									<aui:option value="<%= biobank.getBiobankDbId() %>">
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
