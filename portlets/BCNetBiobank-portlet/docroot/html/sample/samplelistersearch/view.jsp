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
				Search for <em>words</em> separated by spaces <code>blood</code> <code>snomed</code> <code>Ghana</code> <code>tumour</code>.
			</li>
			<li>
				Search for <em>phrases</em> containing one or more <em>words</em> <code>"buffy coat"</code> <code>"Chronic hepatitis"</code> 
				<code>"Malignant neoplasm"</code>.
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
				<code>anatomicalPartOntologyVersion</code>, <code>anatomicalPartOntologyCode</code>,<code>anatomicalPartOntologyDescription</code>, <code>anatomicalPartFreeText</code>,
				
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