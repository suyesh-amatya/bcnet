<%@ include file="/html/init.jsp" %>

<%
	
	long optionsPageTemplate_option = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
	List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();
	List<Country> countries = CountryServiceUtil.getCountries();

	String redirect = ParamUtil.getString(request, "redirect");
	
%>


<portlet:renderURL var="viewBiobankGeneralInfomrationURL" />
<portlet:actionURL name='createBiobankOrganization' var="createBiobankOrganizationURL" windowState="normal" />



<aui:form action="<%= createBiobankOrganizationURL %>" method="POST" name="fm" onSubmit="event.preventDefault();">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<!-- hidden elements direct from config -->
		<aui:input name="pagetemplate" type="hidden" value ="<%= optionsPageTemplate_option %>" />
		
		<aui:row>
			<aui:column columnWidth="30">
				 <!-- "type" should be specified here in the aui:input because the bean "biobankGeneralInfomration" does not have the "name" attribute
					 defined. So the input box will not be displayed if "type" is not specified. -->
				
				<aui:input name="name" label='Name <i class="icon-asterisk"></i>' type="text" />
				<div class="form-validator-stack help-inline" id="organizationNameError" style="display:none;">
					<div role="alert" class="required">The Name is already taken.</div>
				</div>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="biobankId" label='Biobank Id <i class="icon-asterisk"></i>' />
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="acronym" label="Acronym"/>
			</aui:column>
		</aui:row>
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input name="url" label="URL"/>
			</aui:column>
			<aui:column columnWidth="25">
				<aui:select name="juristicPersonId" label='Juristic Person <i class="icon-asterisk"></i>' >
					<aui:option>Select</aui:option>
					<%
						for (JuristicPerson juristicPerson : juristicPersons) {
						
					%>
					
							<aui:option 
							 value="<%= juristicPerson.getJuristicPersonId()%>">
								<%=juristicPerson.getName() %>
							</aui:option>
					<% 
						}
					%>
				</aui:select>
				
				<%
					String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
					String portletNamespace = PortalUtil.getPortletNamespace(portletId);
				%>
		
				<c:set var="portletNameSpaceVal" value="<%=portletNamespace%>" />
		
				<%-- <liferay-portlet:renderURL 
					var="addJuristicPersonURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					portletName="juristicperson_WAR_BCNetBiobankportlet">
					<liferay-portlet:param name="jspPage" value="/html/juristicperson/edit_juristicperson_popup.jsp"/>
				</liferay-portlet:renderURL> --%>
				
				<%
					Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
					long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
					
					LiferayPortletURL addJuristicPersonURL = PortletURLFactoryUtil.create(request, "juristicperson_WAR_BCNetBiobankportlet", controlPanelPlid, "RENDER_PHASE");
					addJuristicPersonURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
					addJuristicPersonURL.setParameter("jspPage", "/html/juristicperson/edit_juristicperson_popup.jsp");
					addJuristicPersonURL.setWindowState(LiferayWindowState.POP_UP);
				%>
		
				<c:set var="portletURL" value="<%=addJuristicPersonURL%>" />
				
				
			</aui:column>
			<aui:column columnWidth="5">
				<aui:a cssClass="jp" href="#" onClick="${portletNameSpaceVal}showPopup('${portletURL}')" >
					<liferay-ui:icon image="add" message="Add Juristic Person" />
				</aui:a>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:select name="countryCode" label='Country <i class="icon-asterisk"></i>' >
					<aui:option>Select</aui:option>
					<%
						for (Country country : countries) {
					%>
					
							<aui:option  value="<%= country.getA2() %>"><%=country.getName().toUpperCase() %></aui:option>
					
					<%
						}
					%>
				</aui:select>
			</aui:column>
		</aui:row>
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input type="textarea" name="description" label="Description"/>
			</aui:column>
			
			<% 
				String backup = null;
				
			%>
			<aui:column columnWidth="30">
				<aui:select name="backup" label="Backup"  >
					<aui:option>Select</aui:option>
					<aui:option value="true" selected="<%=\"yes\".equals(backup) %>">yes</aui:option>
					<aui:option value="false" selected="<%=\"no\".equals(backup) %>">no</aui:option>
				</aui:select>
			</aui:column>
			
			<% 
				String trainingCourses = null;
				
			%>
			<aui:column columnWidth="30">
				<aui:select name="trainingCourses" label="Training Courses"  >
					<aui:option>Select</aui:option>
					<aui:option value="true" selected="<%=\"yes\".equals(trainingCourses) %>">yes</aui:option>
					<aui:option value="false" selected="<%=\"yes\".equals(trainingCourses) %>">no</aui:option>
				</aui:select>
			</aui:column>
		</aui:row>

	</aui:fieldset>

	<aui:button-row>
		<aui:column columnWidth="30">
			<aui:button type="submit" />
			<aui:button onClick="<%= viewBiobankGeneralInfomrationURL %>"  type="cancel" />
		</aui:column>
	</aui:button-row>
</aui:form>

<%-- <aui:script use="aui-base,aui-form-validator">
	AUI().use('aui-base',' aui-form-validator',function(A){
		var rules = {
      		<portlet:namespace/>name: {
        		required: true
      		},
      		
      		<portlet:namespace/>biobankId: {
        		required: true
      		},
      		
      		<portlet:namespace/>url: {
        		url: true
      		},
      		
      		<portlet:namespace/>juristicPersonId: {
        		required: true
      		},
      		
      		<portlet:namespace/>countryCode: {
        		required: true
      		},
      	};

		var fieldStrings = {
			<portlet:namespace/>name: {
		    	required: 'The Name field is required.'
		  	},
		  	
		  	<portlet:namespace/>biobankId: {
		    	required: 'The Biobank Id field is required.'
		  	},
		  	
		  	<portlet:namespace/>juristicPersonId: {
		    	required: 'Please select the Juristic Person.'
		  	},
		  	
		  	<portlet:namespace/>countryCode: {
		    	required: 'Please select the Country.'
		  	},
		};
		
		new A.FormValidator({
	        boundingBox: '#<portlet:namespace/>fm',
	        fieldStrings: fieldStrings,
	        rules: rules,
	        showAllMessages:true
      	});
	});
	
</aui:script>
 --%>
<aui:script>
	function <portlet:namespace />showPopup(url) {
	
	    var url = url;
	    //console.log(url);
	    
			Liferay.Util.openWindow(
				{
					dialog: {
						cache: false,
						width:800,
						modal: true,
						centered: true
					},
					id: 'juristicperson_WAR_BCNetBiobankportlet',				
					uri: url
				}
			);
	}
	
</aui:script>



<aui:script>
    Liferay.provide(window, 'refreshJuristicPersonPortlet', function(juristicPersonId, name) {
        var A = AUI();
        A.one('#<portlet:namespace/>juristicPersonId').append('<option value="'+ juristicPersonId +'">'+ name +'</option>');
        A.one('#<portlet:namespace/>juristicPersonId').set('value', juristicPersonId);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>

<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>


<portlet:resourceURL var="checkOrganizationNameURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-form-validator,aui-io-request">
	AUI().use('aui-base','aui-form-validator','aui-io-request', function(A){
		var rules = {
	      		<portlet:namespace/>name: {
	        		required: true
	      		},
	      		
	      		<portlet:namespace/>biobankId: {
	        		required: true
	      		},
	      		
	      		<portlet:namespace/>url: {
	        		url: true
	      		},
	      		
	      		<portlet:namespace/>juristicPersonId: {
	        		required: true
	      		},
	      		
	      		<portlet:namespace/>countryCode: {
	        		required: true
	      		},
	      	};

		var fieldStrings = {
			<portlet:namespace/>name: {
		    	required: 'The Name field is required.'
		  	},
		  	
		  	<portlet:namespace/>biobankId: {
		    	required: 'The Biobank Id field is required.'
		  	},
		  	
		  	<portlet:namespace/>juristicPersonId: {
		    	required: 'Please select the Juristic Person.'
		  	},
		  	
		  	<portlet:namespace/>countryCode: {
		    	required: 'Please select the Country.'
		  	},
		};
		
		var validator = new A.FormValidator({
        	boundingBox: '#<portlet:namespace/>fm',
	        fieldStrings: fieldStrings,
	        rules: rules,
	        showAllMessages:true
      	});
      	
      	
		var organizationNameExists = false;
		var url = '<%=checkOrganizationNameURL.toString()%>';
		
		A.one("#<portlet:namespace/>name").on('blur',function(event){
			A.one('#organizationNameError').hide();
		});
		
		A.one("#<portlet:namespace/>fm").on('submit',function(event){
			
			var organizationName = A.one("#<portlet:namespace/>name").get("value");
			A.io.request(
				url, 
				{
			        method: 'get',
			        data: {
			        	<portlet:namespace/>name :organizationName
			        },
			        dataType: 'json',
	        		on:{
			        	success: function(){
			        		if(this.get('responseData')!=null && this.get('responseData').organizationNameExists){
				        		A.one("#<portlet:namespace/>name").get('parentNode').removeClass('success').addClass('error');
				        		A.one("#<portlet:namespace/>name").addClass('error-field lfr-input-text').removeClass('success-field');
				        		A.one("#<portlet:namespace/>name").get('parentNode').append(A.one('#organizationNameError').show());
			        		}
			        		else{
			        			A.one('#organizationNameError').hide();
			        			if(!validator.hasErrors()){
				        			document.<portlet:namespace/>fm.submit();
			        			}
			        		}
			        	}
		        	}
       		});
        });
	});

</aui:script>

