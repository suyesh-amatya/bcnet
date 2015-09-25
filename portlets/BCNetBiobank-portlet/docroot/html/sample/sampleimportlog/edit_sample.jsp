<%@ include file="/html/init.jsp" %>

<%
	long sampleDbId = ParamUtil.getLong(request, "sampleDbId");
	String redirect =  ParamUtil.getString(request, "redirect");
	
	Sample sample = SampleLocalServiceUtil.getSample(sampleDbId);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<portlet:actionURL name="editSample" var="editSampleURL">
	<portlet:param name="sampleDbId" value="<%= String.valueOf(sampleDbId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>


<div class="sample-edit-form">
	<div class="sample-edit-form-header">Edit Sample</div>
	<div class="sample-edit-form-container">
		<aui:form action="<%= editSampleURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="sampleCollectionId" label="Sample Collection Id"
							value="<%=sample.getSampleCollectionId() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="hashedSampleId" label='Hashed Sample Id <i class="icon-asterisk"></i>' showRequiredLabel="false" value="<%=sample.getHashedSampleId() %>">
						<aui:validator name="required" errorMessage="The Hashed Sample Id field is required."/>
						</aui:input>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="materialType" label='Material Type <i class="icon-asterisk"></i>' showRequiredLabel="false" value="<%=sample.getMaterialType() %>">
						<aui:validator name="required" errorMessage="The Material Type field is required."/>
						</aui:input>
					</aui:column>
				</aui:row>
				
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="container" label="Container" value="<%=sample.getContainer() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="storageTemperature" label="Storage Temperature" value="<%=sample.getStorageTemperature() %>"/>
					</aui:column>
					<%
					
						Calendar c = Calendar.getInstance();
						String yearmonthday = null; 
						int hour = -1, minute = -1;
						if(sample.getSampledTime() != null){
							c.setTime(sample.getSampledTime());
							hour = c.get(Calendar.HOUR_OF_DAY);
							minute = c.get(Calendar.MINUTE);
							yearmonthday = sdf.format(sample.getSampledTime());
						}
					%>
					<aui:column columnWidth="30">
						<div id="sample-year-month-day">
						<%-- <div id="sample-year-month-day">
							<div class="control-group">
								<label class="control-label">Sampled Date</label>
								<liferay-ui:input-date yearParam="year"  monthParam="month"  dayParam="day" 
														yearValue="<%=year %>" monthValue="<%=month %>" dayValue="<%=day %>" name="yearmonthday"
														>
								</liferay-ui:input-date>
							</div>
						</div> --%>
							<aui:input name="yearmonthday" label="Sampled Date" value="<%=yearmonthday%>" placeholder="yyyy-mm-dd"></aui:input>
						</div>
						<div id="sample-hour">
							<aui:select name="hour">
								<aui:option>Select</aui:option>
								<aui:option value="00" selected="<%=0==hour %>">00</aui:option>
								<aui:option value="01" selected="<%=1==hour %>">01</aui:option>
								<aui:option value="02" selected="<%=2==hour %>">02</aui:option>
								<aui:option value="03" selected="<%=3==hour %>">03</aui:option>
								<aui:option value="04" selected="<%=4==hour %>">04</aui:option>
								<aui:option value="05" selected="<%=5==hour %>">05</aui:option>
								<aui:option value="06" selected="<%=6==hour %>">06</aui:option>
								<aui:option value="07" selected="<%=7==hour %>">07</aui:option>
								<aui:option value="08" selected="<%=8==hour %>">08</aui:option>
								<aui:option value="09" selected="<%=9==hour %>">09</aui:option>
								<aui:option value="10" selected="<%=10==hour %>">10</aui:option>
								<aui:option value="11" selected="<%=11==hour %>">11</aui:option>
								<aui:option value="12" selected="<%=12==hour %>">12</aui:option>
								<aui:option value="13" selected="<%=13==hour %>">13</aui:option>
								<aui:option value="14" selected="<%=14==hour %>">14</aui:option>
								<aui:option value="15" selected="<%=15==hour %>">15</aui:option>
								<aui:option value="16" selected="<%=16==hour %>">16</aui:option>
								<aui:option value="17" selected="<%=17==hour %>">17</aui:option>
								<aui:option value="18" selected="<%=18==hour %>">18</aui:option>
								<aui:option value="19" selected="<%=19==hour %>">19</aui:option>
								<aui:option value="20" selected="<%=20==hour %>">20</aui:option>
								<aui:option value="21" selected="<%=21==hour %>">21</aui:option>
								<aui:option value="22" selected="<%=22==hour %>">22</aui:option>
								<aui:option value="23" selected="<%=23==hour %>">23</aui:option>
							</aui:select>
						</div>
					
						<div id="sample-minute">
							<aui:select name="minute">
								<aui:option>Select</aui:option>
								<aui:option value="00" selected="<%=0==minute %>">00</aui:option>
								<aui:option value="01" selected="<%=1==minute %>">01</aui:option>
								<aui:option value="02" selected="<%=2==minute %>">02</aui:option>
								<aui:option value="03" selected="<%=3==minute %>">03</aui:option>
								<aui:option value="04" selected="<%=4==minute %>">04</aui:option>
								<aui:option value="05" selected="<%=5==minute %>">05</aui:option>
								<aui:option value="06" selected="<%=6==minute %>">06</aui:option>
								<aui:option value="07" selected="<%=7==minute %>">07</aui:option>
								<aui:option value="08" selected="<%=8==minute %>">08</aui:option>
								<aui:option value="09" selected="<%=9==minute %>">09</aui:option>
								<aui:option value="10" selected="<%=10==minute %>">10</aui:option>
								<aui:option value="11" selected="<%=11==minute %>">11</aui:option>
								<aui:option value="12" selected="<%=12==minute %>">12</aui:option>
								<aui:option value="13" selected="<%=13==minute %>">13</aui:option>
								<aui:option value="14" selected="<%=14==minute %>">14</aui:option>
								<aui:option value="15" selected="<%=15==minute %>">15</aui:option>
								<aui:option value="16" selected="<%=16==minute %>">16</aui:option>
								<aui:option value="17" selected="<%=17==minute %>">17</aui:option>
								<aui:option value="18" selected="<%=18==minute %>">18</aui:option>
								<aui:option value="19" selected="<%=19==minute %>">19</aui:option>
								<aui:option value="20" selected="<%=20==minute %>">20</aui:option>
								<aui:option value="21" selected="<%=21==minute %>">21</aui:option>
								<aui:option value="22" selected="<%=22==minute %>">22</aui:option>
								<aui:option value="23" selected="<%=23==minute %>">23</aui:option>
								<aui:option value="24" selected="<%=24==minute %>">24</aui:option>
								<aui:option value="25" selected="<%=25==minute %>">25</aui:option>
								<aui:option value="26" selected="<%=26==minute %>">26</aui:option>
								<aui:option value="27" selected="<%=27==minute %>">27</aui:option>
								<aui:option value="28" selected="<%=28==minute %>">28</aui:option>
								<aui:option value="29" selected="<%=29==minute %>">29</aui:option>
								<aui:option value="30" selected="<%=30==minute %>">30</aui:option>
								<aui:option value="31" selected="<%=31==minute %>">31</aui:option>
								<aui:option value="32" selected="<%=32==minute %>">32</aui:option>
								<aui:option value="33" selected="<%=33==minute %>">33</aui:option>
								<aui:option value="34" selected="<%=34==minute %>">34</aui:option>
								<aui:option value="35" selected="<%=35==minute %>">35</aui:option>
								<aui:option value="36" selected="<%=36==minute %>">36</aui:option>
								<aui:option value="37" selected="<%=37==minute %>">37</aui:option>
								<aui:option value="38" selected="<%=38==minute %>">38</aui:option>
								<aui:option value="39" selected="<%=39==minute %>">39</aui:option>
								<aui:option value="40" selected="<%=40==minute %>">40</aui:option>
								<aui:option value="41" selected="<%=41==minute %>">41</aui:option>
								<aui:option value="42" selected="<%=42==minute %>">42</aui:option>
								<aui:option value="43" selected="<%=43==minute %>">43</aui:option>
								<aui:option value="44" selected="<%=44==minute %>">44</aui:option>
								<aui:option value="45" selected="<%=45==minute %>">45</aui:option>
								<aui:option value="46" selected="<%=46==minute %>">46</aui:option>
								<aui:option value="47" selected="<%=47==minute %>">47</aui:option>
								<aui:option value="48" selected="<%=48==minute %>">48</aui:option>
								<aui:option value="49" selected="<%=49==minute %>">49</aui:option>
								<aui:option value="50" selected="<%=50==minute %>">50</aui:option>
								<aui:option value="51" selected="<%=51==minute %>">51</aui:option>
								<aui:option value="52" selected="<%=52==minute %>">52</aui:option>
								<aui:option value="53" selected="<%=53==minute %>">53</aui:option>
								<aui:option value="54" selected="<%=54==minute %>">54</aui:option>
								<aui:option value="55" selected="<%=55==minute %>">55</aui:option>
								<aui:option value="56" selected="<%=56==minute %>">56</aui:option>
								<aui:option value="57" selected="<%=57==minute %>">57</aui:option>
								<aui:option value="58" selected="<%=58==minute %>">58</aui:option>
								<aui:option value="59" selected="<%=59==minute %>">59</aui:option>
							</aui:select>
						</div>
					</aui:column>
				</aui:row>
			
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="anatomicalPartOntology" label="Anatomical Part Ontology" value="<%=sample.getAnatomicalPartOntology() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="anatomicalPartOntologyVersion" label="Anatomical Part Ontology Version" value="<%=sample.getAnatomicalPartOntologyVersion() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="anatomicalPartOntologyCode" label="Anatomical Part Ontology Code" value="<%=sample.getAnatomicalPartOntologyCode() %>" />
					</aui:column>
				</aui:row>
				
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="anatomicalPartOntologyDescription" label="Anatomical Part Ontology Description" value="<%=sample.getAnatomicalPartOntologyDescription() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="anatomicalPartFreeText" label="Anatomical Part Free Text" value="<%=sample.getAnatomicalPartFreeText() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:select name="sex">
							<aui:option>Select</aui:option>
							<aui:option value="Male" selected="<%=\"Male\".equalsIgnoreCase(sample.getSex()) %>">Male</aui:option>
							<aui:option value="Female" selected="<%=\"Female\".equalsIgnoreCase(sample.getSex()) %>">Female</aui:option>
							<aui:option value="Unknown" selected="<%=\"Unknown\".equalsIgnoreCase(sample.getSex()) %>">Unknown</aui:option>
							<aui:option value="Undifferentiated" selected="<%=\"Undifferentiated\".equalsIgnoreCase(sample.getSex()) %>">Undifferentiated</aui:option>
						</aui:select>
					</aui:column>
				</aui:row>
				
				<aui:row>
					<aui:column columnWidth="30">
						<div id="sample-age-low">
							<aui:input name="ageLow" label="Age Low" value="<%=sample.getAgeLow() %>"/>
						</div>
						<div id="sample-age-high">
							<aui:input name="ageHigh" label="Age High" value="<%=sample.getAgeHigh() %>"/>
						</div>
						<div id="sample-age-unit">
							<aui:select name="ageUnit" label="Age Unit">
								<aui:option>Select</aui:option>
								<aui:option value="Years" selected="<%=\"Years\".equalsIgnoreCase(sample.getAgeUnit()) %>">Years</aui:option>
								<aui:option value="Months" selected="<%=\"Months\".equalsIgnoreCase(sample.getAgeUnit()) %>">Months</aui:option>
								<aui:option value="Weeks" selected="<%=\"Weeks\".equalsIgnoreCase(sample.getAgeUnit()) %>">Weeks</aui:option>
								<aui:option value="Days" selected="<%=\"Days\".equalsIgnoreCase(sample.getAgeUnit()) %>">Days</aui:option>
							</aui:select>
						</div>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="diseaseOntology" label="Disease Ontology" value="<%=sample.getDiseaseOntology() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="diseaseOntologyVersion" label="Disease Ontology Version" value="<%=sample.getDiseaseOntologyVersion() %>"/>
					</aui:column>
				</aui:row>
				
				<aui:row>
					<aui:column columnWidth="30">
						<aui:input name="diseaseOntologyCode" label="Disease Ontology Code" value="<%=sample.getDiseaseOntologyCode() %>" />
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="diseaseOntologyDescription" label="Disease Ontology Description" value="<%=sample.getDiseaseOntologyDescription() %>"/>
					</aui:column>
					<aui:column columnWidth="30">
						<aui:input name="diseaseFreeText" label="Disease Free Text" value="<%=sample.getDiseaseFreeText() %>"/>
					</aui:column>
				</aui:row>
			</aui:fieldset>
		
			<aui:button-row>
				<aui:column columnWidth="30">
					<aui:button type="submit" />
					<aui:button onClick="<%= redirect.toString() %>"  type="cancel" />
				</aui:column>
			</aui:button-row>
		</aui:form>
	</div>
</div>

<portlet:resourceURL var="autocompleteURL"></portlet:resourceURL>

<aui:script>
/* AUI().use(
 'autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
  function(A) {
    new A.AutoCompleteList(
      {
      	inputNode: '#<portlet:namespace/>test',
        source: ['America', 'Europe', 'Asia'],
        delimChar: ',',
        typeAhead: true,
        resultFilters    : 'phraseMatch',
    	resultHighlighter: 'phraseMatch',
      }
    ).render();
  }
); */ 



/* YUI's version should be used for autocomplete. */
YUI().use('autocomplete', 'autocomplete-filters', 'autocomplete-highlighters', 'io', "json-parse", function (Y) {
	var url = '<%=autocompleteURL.toString()%>';
	
	/* Sample Collection Id AutoComplete */
	
	Y.io(url,{
		method: "GET",
		data:{<portlet:namespace/>type:"sampleCollectionId"},
		on:{
			success: populateSampleCollectionId
		}
	});
	
	function populateSampleCollectionId(tx, r){
		var sampleCollectionId = Y.JSON.parse(r.responseText);
		
		var sampleCollectionIdInputNode = Y.one('#<portlet:namespace/>sampleCollectionId');
		
		sampleCollectionIdInputNode.plug(Y.Plugin.AutoComplete, {
	    	minQueryLength: 0,
	    	queryDelay: 0,
			resultFilters    : 'phraseMatch',
			resultHighlighter: 'phraseMatch',
			source           : sampleCollectionId,
			
	    	resultFilters: ['phraseMatch', function (query, results) {
		      	var selected = sampleCollectionIdInputNode.get('value').split(/\s*,\s*/);
		
				selected = Y.Array.hash(selected);
				
				return Y.Array.filter(results, function (result) {
					return !selected.hasOwnProperty(result.text);
		      	});
	   		}]
		});
		
		sampleCollectionIdInputNode.on('focus', function () {
			sampleCollectionIdInputNode.ac.sendRequest('');
		});

		sampleCollectionIdInputNode.ac.after('select', function () {
			setTimeout(function () {
				sampleCollectionIdInputNode.ac.sendRequest('');
				sampleCollectionIdInputNode.ac.show();
			}, 1);
		});
	}
	
	/* Material Type AutoComplete */
	
	Y.io(url,{
		method: "GET",
		data:{<portlet:namespace/>type:"materialType"},
		on:{
			success: populateMaterialType
		}
	});
	
	function populateMaterialType(tx, r){
		var materialType = Y.JSON.parse(r.responseText);
		
		var materialTypeInputNode = Y.one('#<portlet:namespace/>materialType');
		
		materialTypeInputNode.plug(Y.Plugin.AutoComplete, {
	    	minQueryLength: 0,
	    	queryDelay: 0,
			resultFilters    : 'phraseMatch',
			resultHighlighter: 'phraseMatch',
			source           : materialType,
			
			// Chain together a startsWith filter followed by a custom result filter
	    	// that only displays tags that haven't already been selected.
	    	resultFilters: ['phraseMatch', function (query, results) {
	      		// Split the current input value into an array based on comma delimiters.
		      	var selected = materialTypeInputNode.get('value').split(/\s*,\s*/);
		
				// Convert the array into a hash for faster lookups.
				selected = Y.Array.hash(selected);
				
				// Filter out any results that are already selected, then return the
				// array of filtered results.
				return Y.Array.filter(results, function (result) {
					return !selected.hasOwnProperty(result.text);
		      	});
	   		}]
		});
		
		// When the input node receives focus, send an empty query to display the full
	  	// list of tag suggestions.
		materialTypeInputNode.on('focus', function () {
		  materialTypeInputNode.ac.sendRequest('');
		});

		// After a tag is selected, send an empty query to update the list of tags.
		materialTypeInputNode.ac.after('select', function () {
			// Send the query on the next tick to ensure that the input node's blur
			// handler doesn't hide the result list right after we show it.
			setTimeout(function () {
				materialTypeInputNode.ac.sendRequest('');
				materialTypeInputNode.ac.show();
			}, 1);
		});

	}
	
    	
	
	/* Storage Temperature AutoComplete*/
	
	Y.io(url,{
		method: "GET",
		data:{<portlet:namespace/>type:"storageTemperature"},
		on:{
			success: populateStorageTemperature
		}
	});
	
	function populateStorageTemperature(tx, r){
		var storageTemperature = Y.JSON.parse(r.responseText);
		
		var storageTemperatureInputNode = Y.one('#<portlet:namespace/>storageTemperature');
		
		storageTemperatureInputNode.plug(Y.Plugin.AutoComplete, {
	    	minQueryLength: 0,
	    	queryDelay: 0,
			resultFilters    : 'phraseMatch',
			resultHighlighter: 'phraseMatch',
			source           : storageTemperature,
			
	    	resultFilters: ['phraseMatch', function (query, results) {
		      	var selected = storageTemperatureInputNode.get('value').split(/\s*,\s*/);
		
				selected = Y.Array.hash(selected);
				
				return Y.Array.filter(results, function (result) {
					return !selected.hasOwnProperty(result.text);
		      	});
	   		}]
		});
		
		storageTemperatureInputNode.on('focus', function () {
			storageTemperatureInputNode.ac.sendRequest('');
		});

		storageTemperatureInputNode.ac.after('select', function () {
			setTimeout(function () {
				storageTemperatureInputNode.ac.sendRequest('');
				storageTemperatureInputNode.ac.show();
			}, 1);
		});
	}
    
	
});

</aui:script>

<script type="text/javascript">


$( "#<portlet:namespace/>yearmonthday" ).datepicker({
	dateFormat: "yy-mm-dd"
});

</script>