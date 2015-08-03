<%@ include file="/html/init.jsp" %>

<%
//out.println(PortalUUIDUtil.generate());
System.out.println(PortalUUIDUtil.generate());

Sample sample = (Sample) renderRequest.getAttribute("sample");
if (sample != null)
out.println(sample.getSampleDbId());


%>



<%
if(renderRequest.getAttribute("xls-header-not-defined-columns-missing") != null) {
	%>
	<div class="alert alert-error">
		<i class="fa fa-exclamation-circle"></i>&nbsp&nbsp<liferay-ui:message key='xls-header-not-defined-columns-missing' arguments='<%= renderRequest.getAttribute("xls-header-not-defined-columns-missing") %>'/>
	</div>
	<%
}

if(renderRequest.getAttribute("xls-row-import-errors") != null) {
	%>
	<div style="margin:10px; padding: 10px; background-color: #0066FF;opacity: 0.4;filter: alpha(opacity=40);color: #ffffff;" >
		<i class="fa fa-exclamation-circle"></i>&nbsp&nbsp<liferay-ui:message key='xls-row-import-errors' arguments='<%= renderRequest.getAttribute("xls-row-import-errors") %>'/>
	</div>
	<%
}
%>
<liferay-ui:error key="file-upload-wrong-type" message="file-upload-wrong-type"></liferay-ui:error>


<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/additional-methods.min.js"></script>	

<script src="<%=request.getContextPath()%>/js/jquery.steps.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.steps.css">

<portlet:actionURL name='uploadSample' var="uploadSampleURL" />

<portlet:renderURL var="viewSampleUploadURL" />
<h3>Sample Upload</h3>



<aui:form action="<%=uploadSampleURL%>" enctype="multipart/form-data" method="post" name="fm">
	<%-- <aui:input type="file" name="fileupload" label='File Upload <i class="icon-asterisk"></i>' required="true" showRequiredLabel="false">
		<aui:validator name="acceptFiles" errorMessage="Please submit the file with valid extension (xls, xlsx).">'xls,xlsx'</aui:validator>
	</aui:input> --%>
	<aui:input type="file" name="fileupload" label='File Upload <i class="icon-asterisk"></i>' showRequiredLabel="false">
	</aui:input>
	<aui:button type="submit" />
	<aui:button onClick="<%= viewSampleUploadURL %>"  type="cancel" />
</aui:form>

<%-- <aui:form action="<%=uploadSampleURL%>" enctype="multipart/form-data" method="post" name="fm">
	<div>
		<h3>Upload File</h3>
		<section>
			<aui:input type="file" name="fileupload" label="File Upload *"/>
			<p>(*) Mandatory</p>
		</section>
		<h3>Profile</h3>
		<section>
		    <label for="name">First name *</label>
		    <input id="name" name="name" type="text" class="required">
		    <label for="surname">Last name *</label>
		    <input id="surname" name="surname" type="text" class="required">
		    <label for="email">Email *</label>
		    <input id="email" name="email" type="text" class="required email">
		    <label for="address">Address</label>
		    <input id="address" name="address" type="text">
		    <p>(*) Mandatory</p>
		</section>
		<h3>Hints</h3>
		<section>
		    <ul>
		        <li>Foo</li>
		        <li>Bar</li>
		        <li>Foobar</li>
		    </ul>
		</section>
		<h3>Finish</h3>
		<section>
		    <input id="acceptTerms" name="acceptTerms" type="checkbox" class="required"> <label for="acceptTerms">I agree with the Terms and Conditions.</label>
		</section>
	</div>

</aui:form> --%>


<!-- <script type="text/javascript">

	var form = $("#<portlet:namespace/>fm");
	form.validate({
	    errorPlacement: function errorPlacement(error, element) { element.before(error); },
	    rules: {
	    	<portlet:namespace/>fileupload: {
	        	required: true,
	        	extension: "xls|xlsx"
	        }
	    }
	});
	form.children("div").steps({
	    headerTag: "h3",
	    bodyTag: "section",
	    transitionEffect: "slideLeft",
	    onStepChanging: function (event, currentIndex, newIndex)
	    {	
	        form.validate().settings.ignore = ":disabled,:hidden";
	        return form.valid();
	    },
	    onFinishing: function (event, currentIndex)
	    {
	        form.validate().settings.ignore = ":disabled";
	        return form.valid();
	    },
	    onStepChanged:	function (event, currentIndex, priorIndex)
		{	
	    	alert("test");
	    },
	    onFinished: function (event, currentIndex)
	    {
	        alert("Submitted!");
	    }
	});

</script>
 -->