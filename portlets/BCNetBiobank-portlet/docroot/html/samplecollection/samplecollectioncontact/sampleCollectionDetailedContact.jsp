<%@ include file="/html/init.jsp" %>
<%
long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
long sampleCollectionContactUserId = ParamUtil.getLong(request, "sampleCollectionContactUserId");
String redirect = ParamUtil.getString(request, "redirect");


if(sampleCollectionDbId != 0) {
	
	String firstname = "";
	String middlename = "";
	String lastname = "";
	String email = "";
	boolean owner = false;
	boolean editor = false;
	boolean maincontact = false;
	User sampleCollectionContactUser = null;
	SampleCollectionContact sampleCollectionContact = null;
	long juristicPersonId = 0;
	if(sampleCollectionContactUserId != 0) {
		sampleCollectionContactUser = UserLocalServiceUtil.getUser(sampleCollectionContactUserId);
		firstname = sampleCollectionContactUser.getFirstName();
		middlename = sampleCollectionContactUser.getMiddleName();
		lastname = sampleCollectionContactUser.getLastName();
		email = sampleCollectionContactUser.getEmailAddress();
		sampleCollectionContact = SampleCollectionContactLocalServiceUtil.getSampleCollectionContact(sampleCollectionDbId, sampleCollectionContactUserId);
		
		if(sampleCollectionContact.getMainContact()) {
			maincontact = true;
		}
		if(sampleCollectionContact.getSampleCollectionEditor()) {
			editor = true;
		}
		if(sampleCollectionContact.getSampleCollectionOwner()) {
			owner = true;
		}
		

		Long result= (Long)sampleCollectionContactUser.getExpandoBridge().getAttribute("juristicPersonId");
		juristicPersonId = result.longValue();
	}
	
%>
<aui:button-row>
	<aui:button onClick="<%= redirect %>" value="back" cssClass="btn btn-primary"/>
</aui:button-row>

<div class="page-header" style="border-bottom:none;margin:0;">
 	<h1><small>Detailed Information of <%=firstname %></small></h1>
</div>

<table class="table table-striped">
	<tr>
		<th class="span2">Full Name:</th>
		<td class="span10"><%=firstname+" "+middlename+" "+lastname %></td>
	</tr>
	<%
	if(maincontact || editor || owner){
	%>
	<tr>
		<th class="span2">Roles:</th>
		<td class="span10"><%=owner == true? "Sample Collection Owner ":"" %><%=editor == true? "Sample Collection Editor ":"" %><%=maincontact == true? "Main Contact ":"" %></td>
	</tr>
	<%
	}
	if(!sampleCollectionContactUser.getPhones().isEmpty()){
	%>
	<tr>
		<th class="span2">Phone:</th>
		<td class="span10"><%=sampleCollectionContactUser.getPhones().get(0).getNumber() %></td>
	</tr>
	<%
	}
	%>
	<tr>
		<th class="span2">Email:</th>
		<td class="span10"><aui:a href='<%= "mailto:" + email %>'><%= email %></aui:a></td>
	</tr>
	<%
  	if(!sampleCollectionContactUser.getAddresses().isEmpty()){
	%>
	<tr>
		<th class="span2">Street:</th>
		<td class="span10"><%=sampleCollectionContactUser.getAddresses().get(0).getStreet1() %></td>
	</tr>
	<tr>
		<th class="span2">Zip:</th>
		<td class="span10"><%=sampleCollectionContactUser.getAddresses().get(0).getZip() %></td>
	</tr>
	<tr>
		<th class="span2">City:</th>
		<td class="span10"><%=sampleCollectionContactUser.getAddresses().get(0).getCity() %></td>
	</tr>
	<%
  	if(sampleCollectionContactUser.getAddresses().get(0).getCountryId() != 0){
	%>
	<tr>
		<th class="span2">Country:</th>
		<td class="span10"><%=sampleCollectionContactUser.getAddresses().get(0).getCountry().getName().toUpperCase() %></td>
	</tr>
	<%
  	}
	}
	if(juristicPersonId > 0){
	%>
	<tr>
		<th class="span2">Juristic Person:</th>
		<td class="span10"><%=JuristicPersonLocalServiceUtil.getJuristicPerson(juristicPersonId).getName() %></td>
	</tr>
	<%
	}
	if(sampleCollectionContactUser.getExpandoBridge().getAttribute("department") != ""){
	%>
	<tr>
		<th class="span2">Department:</th>
		<td class="span10"><%=sampleCollectionContactUser.getExpandoBridge().getAttribute("department")  %></td>
	</tr>
	<%
	}
	if(sampleCollectionContactUser.getExpandoBridge().getAttribute("orcId") != ""){
	%>
	<tr>
		<th class="span2">ORC ID:</th>
		<td class="span10"><%=sampleCollectionContactUser.getExpandoBridge().getAttribute("orcId")  %></td>
	</tr>
	<%
	}
	%>
</table>
<%
}
%>
