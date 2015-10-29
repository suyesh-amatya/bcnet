<%@ include file="/html/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/sample/samplelistersearch/sample_search_results.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/sample/samplelistersearch/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

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


<%

	//Parameters for permission Checking
	long groupId = scopeGroupId;
	String name = portletDisplay.getRootPortletId();
	String primKey = portletDisplay.getResourcePK();
	String actionId_edit_sample = "EDIT_SAMPLE";
	String actionId_delete_sample = "DELETE_SAMPLE";

	String sampleSearchResultsURL = PortalUtil.getCurrentURL(renderRequest);

    String keywords = ParamUtil.getString(request, "keywords");

	SearchContainer<Sample> sampleSearchContainer = new SearchContainer<Sample>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, searchURL, null, "no-samples-match-search-criteria");
	

    SearchContext searchContext = SearchContextFactory.getInstance(request);
    
    
	Hits hits = SampleLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords, sampleSearchContainer.getStart(), sampleSearchContainer.getEnd());

	List<SearchResult> srList = SearchResultUtil.getSearchResults(hits, null, searchURL);
	
	Map<Long, String> srMap = new HashMap<Long, String>();
	
	for(SearchResult sr : srList){
		srMap.put(sr.getClassPK(), sr.getSummary().getContent());
	}
	
	
	List<Sample> samples = new ArrayList<Sample>();

	for (int i = 0; i < hits.getDocs().length; i++) {
		Document doc = hits.doc(i);
		
		long sampleDbId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		Sample sample = null;
		
		try {
			sample = SampleLocalServiceUtil.getSample(sampleDbId);
		} catch (PortalException pe) {
		        _log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
		        _log.error(se.getLocalizedMessage());
		}
		
		samples.add(sample);
	}

	 String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
     String portletNamespace = PortalUtil.getPortletNamespace(portletId);
       
%>

<c:set var="portletNameSpaceVal" value="<%=portletNamespace%>" />

<div id="sample-search-results-container">
	<liferay-ui:search-container searchContainer="<%=sampleSearchContainer %>">
		
		<liferay-ui:search-container-results results="<%= samples %>" total="<%= hits.getLength() %>" />
		<p><b>Total Results:  <%= hits.getLength() %></b></p>
		<liferay-ui:search-container-row
			className="com.bcnet.portlet.biobank.model.Sample"
			keyProperty="sampleDbId" modelVar="sample" escapedModel="<%=true%>">
		
		<div class="well sample-search-results" >
			<div class="sample-search-results-title">
			
			<portlet:renderURL var="viewSampleDetailsURL">
				<portlet:param name="mvcPath" value="/html/sample/samplelistersearch/sample_detail.jsp" />
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="backURL" value="<%= sampleSearchResultsURL %>" />
			</portlet:renderURL>
			
			<%
				// Popup has permission issues for guest/unauthenticated users.
				/* Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
				long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
				
				LiferayPortletURL viewSampleDetailsURL = PortletURLFactoryUtil.create(request, "samplelistersearch_WAR_BCNetBiobankportlet", controlPanelPlid, "RENDER_PHASE");
				viewSampleDetailsURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
				viewSampleDetailsURL.setParameter("jspPage", "/html/sample/samplelistersearch/sample_detail.jsp");
				viewSampleDetailsURL.setParameter("sampleDbId", String.valueOf(sample.getSampleDbId()));
				
				viewSampleDetailsURL.setWindowState(LiferayWindowState.POP_UP); */
			%>
			
			<%-- <c:set var="portletURL" value="<%=viewSampleDetailsURL%>" />
			
			<aui:a href="#" onClick="${portletNameSpaceVal}showPopup('${portletURL}')"><%=srMap.get(sample.getSampleDbId()) %></aui:a> --%>
			
			<% 
				out.println("<a href="+viewSampleDetailsURL+">"+srMap.get(sample.getSampleDbId())+"</a> ");
			%>
			
			</div>
			<%
				String sampleBodyContent = sample.getDiseaseOntologyDescription()+" "+sample.getDiseaseFreeText()+" "+sample.getAnatomicalPartOntology()+" "+sample.getAnatomicalPartOntologyVersion()
						+" "+sample.getAnatomicalPartOntologyCode()+" "+sample.getAnatomicalPartOntologyDescription()+" "+sample.getAnatomicalPartFreeText()+"<br/>";
				
				if(!sample.getHashedIndividualId().equals("")){
					sampleBodyContent += sample.getHashedIndividualId()+" ";
				}
				if(!sample.getSex().equals("")){
					sampleBodyContent += sample.getSex()+" ";
				}
				if(sample.getAgeLow() > 0 && sample.getAgeHigh() > 0 && !sample.getAgeUnit().equals("")){
					sampleBodyContent += sample.getAgeLow()+"-"+sample.getAgeHigh()+" "+sample.getAgeUnit()+" ";
				}
				if(!sample.getCountryOfOrigin().equals("")){
					sampleBodyContent += sample.getCountryOfOrigin()+"<br/>";
				}
				if(sample.getSampledTime() != null){
					sampleBodyContent += new SimpleDateFormat("yyyy-MM-dd HH:mm").format(sample.getSampledTime())+" ";
				}
				if(!sample.getStorageTemperature().equals("")){
					sampleBodyContent += sample.getStorageTemperature()+" ";
				}
				if(!sample.getContainer().equals("")){
					sampleBodyContent += sample.getContainer()+"<br/>";
				}
				if(sample.getSampleCollectionDbId() > 0){
					String scPath = themeDisplay.getURLPortal()+"/sample-collections/general-information?scdbid="+sample.getSampleCollectionDbId();
					sampleBodyContent += "<a href="+scPath+">"+SampleCollectionLocalServiceUtil.getSampleCollection(sample.getSampleCollectionDbId()).getName()+" ";
				}
				if(sample.getBiobankDbId() > 0){
					Organization organization = OrganizationLocalServiceUtil.getOrganization(sample.getBiobankDbId());
					String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
					sampleBodyContent += "<a href="+orgPath+">"+BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(sample.getBiobankDbId()).getBiobankName()+"</a> ";
				}
				out.println(sampleBodyContent);
			%>
			
			
			<portlet:renderURL var="editSampleURL">
				<portlet:param name="mvcPath" value="/html/sample/samplelistersearch/edit_sample_search.jsp" />
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="redirect" value="<%= sampleSearchResultsURL %>" />
			</portlet:renderURL>

			<portlet:actionURL name="deleteSample" var="deleteSampleURL">
				<portlet:param name="sampleDbId" value="<%= String.valueOf(sample.getSampleDbId()) %>" />
				<portlet:param name="redirect" value="<%= sampleSearchResultsURL %>" />
			</portlet:actionURL>
			

			<c:choose>		
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_edit_sample) %>">
					<a href="<%=editSampleURL.toString()%>">
					<liferay-ui:icon image="edit" message="Edit Sample" cssClass="biobankOrganizationEdit"/>
					</a>
				</c:when>
			</c:choose>
			
			<c:choose>		
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_sample) %>">
					<liferay-ui:icon-delete url="<%= deleteSampleURL.toString() %>" message="Delete Sample" cssClass="biobankOrganizationDelete"
					confirmation="Are you sure you want to delete it?"/>
				</c:when>
			</c:choose>
			
		</div>
		
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<%
        if (Validator.isNotNull(keywords)) {
                String currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
                                pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.sample.samplelistersearch.sample_search_results.jsp");
%>

<aui:script>
     function <portlet:namespace />showPopup(url) {

         var url = url;

             Liferay.Util.openWindow(
                 {
                     dialog: {
                         cache: false,
                         width:800,
                         modal: true,
                         centered: true
                     },
                     id: 'samplelistersearch_WAR_BCNetBiobankportlet',                
                     uri: url
                 }
             );
     }
     
     
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