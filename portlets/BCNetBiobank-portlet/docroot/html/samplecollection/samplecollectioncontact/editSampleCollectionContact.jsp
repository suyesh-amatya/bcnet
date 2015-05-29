<%@ include file="/html/init.jsp" %> 

<%
String redirect = ParamUtil.getString(request, "redirect");

long sampleCollectionContactUserId = ParamUtil.getLong(request, "sampleCollectionContactUserId");
long sampleCollectionDbId = ParamUtil.getLong(request, "sampleCollectionDbId");
boolean optionsSendMailNotification_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsSendMailNotification", "false"));


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

	List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();

	
	%>
	
	<%-- <aui:model-context bean="<%= user %>" model="<%= User.class %>" /> --%>
	<portlet:actionURL name='<%= sampleCollectionContactUserId == 0 ? "addSampleCollectionContactUser" : "editSampleCollectionContactUser" %>' var="addEditUserURL" windowState="normal" />
	<aui:form action="<%= addEditUserURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="sampleCollectionDbId" value="<%= sampleCollectionDbId %>" />
			<aui:input type="hidden" name="userId" value="<%= String.valueOf(sampleCollectionContactUserId) %>" />
			<aui:input type="hidden" name="sendmailnotification" value="<%= optionsSendMailNotification_cfg %>" />
						
			
			<aui:row>
				<aui:column columnWidth="30">
					<aui:input name="email" label="E-mail&nbsp;&nbsp;&nbsp;<a id='checkemail'>Check if user exists</a>" type="text" value ="<%= email %>">
						<aui:validator name="required" errorMessage="The E-mail field is required."/>
						<aui:validator name="email" errorMessage="Please enter a valid E-mail."/>
					</aui:input>
				</aui:column>
				<aui:column columnWidth="30">
					<aui:input name="firstname" label="First Name" type="text" value ="<%= firstname %>">
						<aui:validator name="required" errorMessage="The First Name field is required."/>
					</aui:input>
				</aui:column>
				<aui:column columnWidth="30">
					<aui:input name="middlename" label="Middle Name" type="text" value ="<%= middlename %>"/>
				</aui:column>
			</aui:row>
			
			<aui:row>
				<aui:column columnWidth="30">
					<aui:input name="lastname" label="Last Name" type="text" value ="<%= lastname %>"/>
				</aui:column>
				<aui:column columnWidth="30">
					<aui:select name="juristicPersonId" label='Juristic Person' >
						<aui:option>Select</aui:option>
						<%
						for (JuristicPerson juristicPerson : juristicPersons) {
						%>
							<aui:option selected="<%= (sampleCollectionContactUser != null && juristicPerson.getJuristicPersonId() == juristicPersonId) %>"
							value="<%= juristicPerson.getJuristicPersonId()%>">
							<%=juristicPerson.getName() %>
							</aui:option>
						<% 
						}
						%>
					</aui:select>
				</aui:column>
				<aui:column columnWidth="30">
					<liferay-ui:custom-attribute
						className="com.liferay.portal.model.User"
						classPK="<%= (sampleCollectionContactUser != null) ? sampleCollectionContactUser.getUserId() : 0 %>"
						editable="<%= true %>"
						label="<%= true %>"
						name="department"
					/>
				</aui:column>
			</aui:row>
			
			<aui:row>
				<aui:column columnWidth="30">
					<label>Roles</label>
					<aui:input name="owner" label="Sample Collection Owner" type="checkbox" value ="<%= owner %>"/>
					<aui:input name="editor" label="Sample Collection Editor" type="checkbox" value ="<%= editor %>"/>
					<aui:input name="maincontact" label="Main Contact" type="checkbox" value ="<%= maincontact %>"/>
				</aui:column>
				<aui:column columnWidth="30">
					<liferay-ui:custom-attribute
						className="com.liferay.portal.model.User"
						classPK="<%= (sampleCollectionContactUser != null) ? sampleCollectionContactUser.getUserId() : 0 %>"
						editable="<%= true %>"
						label="<%= true %>"
						name="orcId"
					/>
				</aui:column>
			</aui:row>
			
		</aui:fieldset>
	
		
		<aui:button-row>
			<aui:column columnWidth="30">
				<aui:button type="submit"/>
				<aui:button type="cancel"  onClick="<%= redirect %>" />
			</aui:column>
		</aui:button-row>
	</aui:form>
	<%
} else {
	%>
	<h2>There is a problem with the link. Please contact the administrator.</h2>
	<% 
}
%>

<portlet:resourceURL var="checkEmailForUserURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-io-request,aui-io-request,event,node,aui-popover,valuechange,event-hover,aui-tooltip,event-valuechange,click">
	AUI().use(
	'aui-base',
	'aui-io-request',  
	'node', 
	function(A){
		A.all('#checkemail').each(function() {
	      this.on('click', function(event){
			var url = '<%= checkEmailForUserURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
				   <portlet:namespace />email: event.currentTarget.get('parentNode').get('parentNode').one('#<portlet:namespace />email').get('value'),
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('Enter the email address to check if the user already exists.'); },
				  success: function(data) { 
				  	var response = this.get('responseData');
				  	if(response != null){
					  	//alert(response['firstName'] + " " + response['lastName'] + " " + response['middleName']);
					  	//alert(response['juristicPersonName'] + " " + response['department'] + " " + response['orcId']);
					  	A.one('#<portlet:namespace />firstname').set('value', response['firstName']);
					  	A.one('#<portlet:namespace />middlename').set('value', response['middleName']);
					  	A.one('#<portlet:namespace />lastname').set('value', response['lastName']);
					  	A.one('#<portlet:namespace />userId').set('value', response['userid']);
					  	
					  	A.one('#<portlet:namespace/>juristicPersonId').val(response['juristicPersonName']);
	        			A.one('#<portlet:namespace/>juristicPersonId').set('value', response['juristicPersonId']);
					  	A.one("[name='<portlet:namespace />ExpandoAttribute--department--']").set('value', response['department']);
					  	A.one("[name='<portlet:namespace />ExpandoAttribute--orcId--']").set('value', response['orcId']);
				  	}
				  	else{
				  		alert('The user with this email address does not exist.');
				  	}
				  	
				  	
				  }
				}
			});
		});
	});
	});
</aui:script>