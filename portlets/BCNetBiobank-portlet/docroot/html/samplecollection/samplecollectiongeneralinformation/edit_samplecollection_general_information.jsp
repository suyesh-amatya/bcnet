<%@ include file="/html/init.jsp" %>


<%
	/* Accessing the url parameter "scdbid". */
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	long sampleCollectionDbId = Long.parseLong(httpRequest.getParameter("scdbid"));
	
	SampleCollection sampleCollection = null;
	sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollection(sampleCollectionDbId);
	
	String redirect = ParamUtil.getString(request, "redirect");
	String currentURL = PortalUtil.getCurrentURL(request);
	
	
%>

<portlet:renderURL var="viewSampleCollectionGeneralInfomrationURL" />
<portlet:actionURL name='updateSampleCollection' var="updateSampleCollectionURL" windowState="normal" />
	
<% 
	String cancelURL = viewSampleCollectionGeneralInfomrationURL+"&scdbid="+sampleCollectionDbId;
%>

<aui:form action="<%= updateSampleCollectionURL %>" method="POST" name="fm" onSubmit="event.preventDefault();">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="scdbid" type="hidden" value='<%= sampleCollectionDbId %>'/>
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input name="name" label='Name <i class="icon-asterisk"></i>' value="<%=sampleCollection.getName() %>"/>
				<div class="form-validator-stack help-inline" id="sampleCollectionNameError" style="display:none;">
					<div role="alert" class="required">The Name is already taken.</div>
				</div>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="sampleCollectionId" label='Sample Collection Id <i class="icon-asterisk"></i>' value="<%=sampleCollection.getSampleCollectionId() %>"/>
				<div class="form-validator-stack help-inline" id="sampleCollectionIdError" style="display:none;">
					<div role="alert" class="required">The Sample Collection Id is already taken.</div>
				</div>
			</aui:column>
			<aui:column columnWidth="30">
				<aui:input name="acronym" label="Acronym" value="<%=sampleCollection.getAcronym() %>" />
			</aui:column>
		</aui:row>
		
		<aui:row>
			<aui:column columnWidth="30">
				<aui:input type="textarea" name="description" label='Description' rows="6" value="<%=sampleCollection.getDescription() %>" />
			</aui:column>
			
			<aui:column columnWidth="60">
				<label>Check the ones which apply:</label>
				<aui:input name="consentTemplate" type="checkbox" label="Consent Template" checked="<%=sampleCollection.getConsentTemplate()==true %>"></aui:input>
				<aui:input name="reuseOfSamples" type="checkbox" label="Reuse of Samples" checked="<%=sampleCollection.getReuseOfSamples()==true %>"></aui:input>
				<aui:input name="materialTransferAgreement" type="checkbox" label="Material Transfer Agreement" checked="<%=sampleCollection.getMaterialTransferAgreement()==true %>"></aui:input>
				<aui:input name="accreditation" type="checkbox" label="Accreditation" checked="<%=sampleCollection.getAccreditation()==true %>"></aui:input>
				<aui:input name="qualityControl" type="checkbox" label="Quality Control" checked="<%=sampleCollection.getQualityControl()==true %>"></aui:input>
			</aui:column>
			
			
		</aui:row>

	</aui:fieldset>

	<aui:button-row>
		<aui:column columnWidth="30">
			<aui:button type="submit" />
			<aui:button onClick="<%= cancelURL %>"  type="cancel" />
		</aui:column>
	</aui:button-row>
</aui:form>

<portlet:resourceURL var="checkSampleCollectionNameIdURL"></portlet:resourceURL>

<aui:script use="aui-base,aui-form-validator,aui-io-request">
	
	var rules = {
  		<portlet:namespace/>name: {
    		required: true
  		},
  		
  		<portlet:namespace/>sampleCollectionId: {
    		required: true
  		},
  		
  	};

	var fieldStrings = {
		<portlet:namespace/>name: {
	    	required: 'The Name field is required.'
	  	},
	  	
	  	<portlet:namespace/>sampleCollectionId: {
	    	required: 'The Sample Collection Id field is required.'
	  	},
	  	
	};
	
	var validator = new A.FormValidator({
    	boundingBox: '#<portlet:namespace/>fm',
        fieldStrings: fieldStrings,
        rules: rules,
        showAllMessages:true
  	}); 
	
	
	var sampleCollectionDbId = A.one("#<portlet:namespace/>scdbid").get("value");  	
	var url = '<%=checkSampleCollectionNameIdURL.toString()%>';
	
	/* Check for duplicate sample collection name */
	A.one("#<portlet:namespace/>name").on('blur', function(event){
		var sampleCollectionName = A.one("#<portlet:namespace/>name").get("value");
		A.io.request(
			url, 
			{
		        method: 'get',
		        data: {
		        	<portlet:namespace/>name :sampleCollectionName,
		        	<portlet:namespace/>sampleCollectionDbId :sampleCollectionDbId,
		        	<portlet:namespace/>type :"scName"
		        },
		        dataType: 'json',
	       		on:{
		        	success: function(){
		        		if(this.get('responseData') != null && this.get('responseData').sampleCollectionNameExists){
			        		A.one("#<portlet:namespace/>name").get('parentNode').removeClass('success').addClass('error');
			        		A.one("#<portlet:namespace/>name").addClass('error-field lfr-input-text').removeClass('success-field');
			        		A.one("#<portlet:namespace/>name").get('parentNode').append(A.one('#sampleCollectionNameError').show());
			        		
		        		}
		        		else{
		        			A.one('#sampleCollectionNameError').hide();
		        		}
		        	}
	        	}
		});
		
	});
	
	
	/* Check for duplicate sample collection id */
	A.one("#<portlet:namespace/>sampleCollectionId").on('blur', function(event){
		var sampleCollectionId = A.one("#<portlet:namespace/>sampleCollectionId").get("value");
		A.io.request(
			url, 
			{
		        method: 'get',
		        data: {
		        	<portlet:namespace/>sampleCollectionId :sampleCollectionId,
		        	<portlet:namespace/>sampleCollectionDbId :sampleCollectionDbId,
		        	<portlet:namespace/>type :"scId"
		        },
		        dataType: 'json',
	       		on:{
		        	success: function(){
		        		if(this.get('responseData') != null && this.get('responseData').sampleCollectionIdExists){
			        		A.one("#<portlet:namespace/>sampleCollectionId").get('parentNode').removeClass('success').addClass('error');
			        		A.one("#<portlet:namespace/>sampleCollectionId").addClass('error-field lfr-input-text').removeClass('success-field');
			        		A.one("#<portlet:namespace/>sampleCollectionId").get('parentNode').append(A.one('#sampleCollectionIdError').show());
			        		
		        		}
		        		else{
		        			A.one('#sampleCollectionIdError').hide();
		        		}
		        	}
	        	}
   		});
		
	});
	
	/* Validation on submit */
	A.one("#<portlet:namespace/>fm").on('submit', function(event){
		var sampleCollectionName = A.one("#<portlet:namespace/>name").get("value");
		var sampleCollectionId = A.one("#<portlet:namespace/>sampleCollectionId").get("value");
		A.io.request(
			url, 
			{
		        method: 'get',
		        data: {
		        	<portlet:namespace/>name :sampleCollectionName,
		        	<portlet:namespace/>sampleCollectionId :sampleCollectionId,
		        	<portlet:namespace/>sampleCollectionDbId :sampleCollectionDbId,
		        	<portlet:namespace/>type :"scNamescId"
		        },
		        dataType: 'json',
	       		on:{
		        	success: function(){
		        		if(Object.keys(this.get('responseData')).length != 0 ){
		        			if(this.get('responseData').sampleCollectionNameExists){
				        		A.one("#<portlet:namespace/>name").get('parentNode').removeClass('success').addClass('error');
				        		A.one("#<portlet:namespace/>name").addClass('error-field lfr-input-text').removeClass('success-field');
				        		A.one("#<portlet:namespace/>name").get('parentNode').append(A.one('#sampleCollectionNameError').show());
			        		}
		        			
		        			if(this.get('responseData').sampleCollectionIdExists){
				        		A.one("#<portlet:namespace/>sampleCollectionId").get('parentNode').removeClass('success').addClass('error');
				        		A.one("#<portlet:namespace/>sampleCollectionId").addClass('error-field lfr-input-text').removeClass('success-field');
				        		A.one("#<portlet:namespace/>sampleCollectionId").get('parentNode').append(A.one('#sampleCollectionIdError').show());
				        		
			        		}
		        		}
		        		
		        		else{
		        			A.one('#sampleCollectionNameError').hide();
		        			A.one('#sampleCollectionIdError').hide();
		        			if(!validator.hasErrors()){
			        			document.<portlet:namespace/>fm.submit();
		        			}
		        		}
		        	}
	        	}
   		});
	});

</aui:script>