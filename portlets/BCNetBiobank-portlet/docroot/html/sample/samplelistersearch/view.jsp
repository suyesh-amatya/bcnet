<%@ include file="/html/init.jsp" %>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/sample/samplelistersearch/sample_search_results.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" placeholder="type-your-query" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<div id="search-tips" >
	<h6 class="header toggler-header-collapsed"><a href="#">Show Search Tips</a></h6>
				
	<div class="content toggler-content-collapsed alert alert-info">
		<ul>
			<li>
				Search for <em>words</em> or <em>terms</em> separated by spaces <code>blood</code> <code>snomed</code> <code>Ghana</code> <code>tumour</code>.
			</li>
			<li>
				Search for <em>phrases</em> containing one or more <em>words</em> <code>"buffy coat"</code> <code>"Chronic hepatitis"</code> 
				<code>"Malignant neoplasm"</code>. <em>Phrases</em> should be surrounded in quotes.
			</li>
			<li>
				Single character wildcard searches with <em>?</em>. To search for <em>text</em> or <em>test</em> you can do <code>te?t</code>. 
				Multiple character wildcard searches with <em>*</em>. To search for <em>test</em> or <em>tests</em> or <em>tester</em> you can do 
				<code>test*</code>.
			</li>
			<li>
				A more <em>targeted</em> search is of the form <code>field:value</code> where you have to type in the exact <code>field</code> name followed by 
				<code>:</code> and <code>value</code>. The fields available to search are <code>biobankName</code>, <code>sampleCollectionName</code>, 
				<code>materialType</code>, <code>container</code>, <code>storageTemperature</code>, <code>sampledTime</code>, <code>anatomicalPartOntology</code>,  
				<code>anatomicalPartOntologyVersion</code>, <code>anatomicalPartOntologyCode</code>, <code>anatomicalPartOntologyDescription</code>, <code>anatomicalPartFreeText</code>, 
				<code>sex</code>, <code>ageLow</code>, <code>ageHigh</code>, <code>ageUnit</code>, <code>diseaseOntology</code>,  
				<code>diseaseOntologyVersion</code>, <code>diseaseOntologyCode</code>, <code>diseaseOntologyDescription</code>, <code>diseaseFreeText</code>,  
				<code>countryOfOrigin</code>.
			</li>
			<li>
				Search for <code>materialType:"buffy coat"</code>. Multiple fields and values <code>biobankName:iarc countryOfOrigin:France</code>.
			</li>
			<li>
				Search for <em>phrase "1.5 ml tube"</em> in the <em>container</em> field <b>AND</b> <em>term "female"</em> in the <em>sex</em> field <code>container:"1.5 ml tube" AND sex:female</code>.
			</li>
			<li>
				Also possible to <em>group</em> queries by including them inside parentheses. <code>(anatomicalPartFreeText:arm AND diseaseOntologyVersion:ICD10) OR sampledTime:2008</code>.
			</li>
			<li>
				Search for <em>"Hepatic fibrosis"</em> but not <em>"Alcoholic cirrhosis"</em>. <code>"Hepatic fibrosis" NOT "Alcoholic cirrhosis"</code>. 
				Same semantics with <code>"Hepatic fibrosis" -"Alcoholic cirrhosis"</code>. The <em>+</em>  symbol requires a <em>term</em> or <em>phrase</em> must 
				be present. To get the matches that <em>must</em> contain <em>C22.0</em> and may contain <em>plasma</em>, <code>+C22.0 plasma</code>.
			</li>
			<li>
				Also can be used with the <em>field:value</em>. Search for the <em>term</em> <em>international</em> but not <em>organization</em> in the <em>field biobankName</em>.
				<code>biobankName:international -biobankName:organization</code>. Similary the <em>biobanName</em> must contain <em>"iarc"</em> or <em>materialType</em> must cotain <em>"buffy coat"</em>
				<code>+biobankName:"iarc"   +materialType:"buffy coat"</code>
			</li>
			<li>
				Inclusive Range queries with <em>square brackets [ ]</em>. Find the matches where <em>sampledTime</em> are between <em>2002-01-03</em> and <em>2008-12-31</em>, 
				inclusive. <code>sampledTime:[20020103000000 TO 20081231000000]</code>.
			</li>
			<li>
				Exclusive Range queries with <em>curly brackets { }</em>. Find the matches where <em>biobankName</em> are between <em>Deutsche</em> and <em>Karolinska</em> but not including <em>Deutsche</em> and <em>Karolinska</em>. <code>biobankName:{Deutsche TO Karolinska}</code>.
			</li>
		</ul>
	</div> 
</div>

<aui:script>
	AUI().use('aui-toggler', function(A){
		A.all("h6 .header, .toggler-header-collapsed").on('click', function(event){
			if(event.target.get('text')=='Show Search Tips'){
			 event.target.set('text', 'Hide Search Tips');
			}
			else{
			 event.target.set('text', 'Show Search Tips');
			}
			 
			var containerId = event.target.get('parentNode').get('parentNode').get('id');
			new A.TogglerDelegate(
		    	{
			        animated: true,
			        closeAllOnExpand: true,
			        container: "#"+containerId,
			        content: '.content',
			        expanded: false,
			        header: '.header',
			        transition: {
						duration: 0.2,
						easing: 'cubic-bezier(0, 0.1, 0, 1)'
			        }
		    	}
			); 
		});
	});
</aui:script>