<%@ include file="/html/init.jsp" %>

<portlet:actionURL name='uploadSample' var="uploadSampleURL" />

<aui:form action="<%=uploadSampleURL%>" enctype="multipart/form-data" method="post" name="fm">
 
	<aui:input type="file" name="fileupload" label="File Upload"/>
	
	<aui:button name="Save" value="Save" type="submit" />
 
</aui:form>
 