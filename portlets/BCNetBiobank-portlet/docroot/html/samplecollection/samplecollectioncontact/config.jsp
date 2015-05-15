<%@ include file="/html/init.jsp" %> 

<%
boolean optionsDisplayMaincontact_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));
String optionsDisplayMaincontactTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDisplayMaincontactTitle", "Main contact"));
String optionsDisplayPeopleTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsDisplayPeopleTitle", "Personal"));
boolean optionsSendMailNotification_cfg = GetterUtil.getBoolean(portletPreferences.getValue("optionsSendMailNotification", "false"));

/* out.println(optionsDisplayMaincontact_cfg);
out.println(optionsDisplayMaincontactTitle_cfg);
out.println(optionsDisplayPeopleTitle_cfg);
out.println(optionsSendMailNotification_cfg); */
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<!-- Display Main Contact Title -->
			<aui:column columnWidth="25" first="true">
				<aui:input name="preferences--optionsDisplayMaincontactTitle--" value="<%= optionsDisplayMaincontactTitle_cfg %>" label="Main Contact Title" />
			</aui:column>
			<!-- Display Main Contact -->
			<aui:column columnWidth="25">
				<aui:input name="preferences--optionsDisplayMaincontact--" type="checkbox" value="<%= optionsDisplayMaincontact_cfg %>" label="Display Main Contact" />
			</aui:column>
		</aui:layout>
		<aui:layout>
			<!-- Display People Title -->
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--optionsDisplayPeopleTitle--" value="<%= optionsDisplayPeopleTitle_cfg %>" label="People Title" />
			</aui:column>
			<!-- Send Mail User Notification -->
			<aui:column columnWidth="100" first="true">
				<aui:input name="preferences--optionsSendMailNotification--" type="checkbox" value="<%= optionsSendMailNotification_cfg %>" label="Send Mail Notification on Creation" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>