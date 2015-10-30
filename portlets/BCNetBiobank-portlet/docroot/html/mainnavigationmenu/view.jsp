<%@ include file="/html/init.jsp" %> 

<%
  	//System.out.println((String) request.getAttribute(WebKeys.PORTLET_ID));
	Role curatorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Curator");
	Role administratorRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator");
	
%>


<nav class="sort-pages modify-pages" id="navigation" role="navigation">
	<ul role="menubar" id="topmenu">
		<%
		//List<Layout> mainlayouts = LayoutLocalServiceUtil.getLayouts(10184, false);
		List<Layout> mainlayouts = LayoutLocalServiceUtil.getLayouts(Long.parseLong(PropsUtil.get("bcnet.scopeGroupId")), false);
		int count = 0;
		String menuepoint = "";
		
		
		for(Layout mainlayout : mainlayouts) {
			if(mainlayout.getParentLayoutId() != 0) {
				break;
			}

			if(count == 1) {
				menuepoint = menuepoint.replaceAll("updateclassstring", "firstli");
			} else {
				menuepoint = menuepoint.replaceAll("updateclassstring", "");
			}
			
			menuepoint += "<li id=\"layout_" + mainlayout.getLayoutId() + "\" class=\"updateclassstring lfr-nav-deletable lfr-nav-sortable lfr-nav-updateable yui3-dd-drop\" role=\"presentation\">";
			menuepoint += "<a role=\"menuitem\" href=\"" + mainlayout.getFriendlyURL() + "\" aria-labelledby=\"layout_" + mainlayout.getLayoutId() + "\"><span>" + mainlayout.getNameCurrentValue() +"</span></a>";
			
			boolean childulappended = false;
			
			if(mainlayout.hasChildren()) {
				int childcount = 0;
				
				/*menuepoint += "<ul class=\"child-menu\" role=\"menu\">";*/
				String childul = "";
				
				Iterator<Layout> childIterator = mainlayout.getChildren().iterator();
				
				
				while(childIterator.hasNext()){
					String childli = "";
					
					if(childcount == 0){
						childli = "class=\"firstli\"";
					}
					
					Layout childsetup = childIterator.next();
					if(!(childIterator.hasNext()) && (childcount > 0)){
						
						childli = "class=\"lastli\"";
					}
					childcount++;
					
					
					//for(Layout childsetup : mainlayout.getChildren()) {
					
					if(childsetup.getNameCurrentValue().equals("Add Biobank") || childsetup.getNameCurrentValue().equals("Add Sample Collection")
							|| childsetup.getNameCurrentValue().equals("Import Sample") || childsetup.getNameCurrentValue().equals("Sample Import Log")){
						if(UserLocalServiceUtil.hasRoleUser(administratorRole.getRoleId(), themeDisplay.getUserId()) 
								|| UserLocalServiceUtil.hasRoleUser(curatorRole.getRoleId(), themeDisplay.getUserId())){
							
							if(!childulappended){
								childul += "<ul class=\"child-menu\" role=\"menu\">";
								menuepoint +=childul;
								childulappended = true;
							}
							
							
							menuepoint += "<li id=\"layout_" + childsetup.getLayoutId() + "\"  " +childli + "  role=\"presentation\">";
							menuepoint += "<a role=\"menuitem\" href=\"" + childsetup.getFriendlyURL() + "\" aria-labelledby=\"layout_" + childsetup.getLayoutId() + "\"><span>" + childsetup.getNameCurrentValue() +"</span></a>";
							menuepoint += "</li>";
						}
					}
					else{
						if(!childulappended){
							childul += "<ul class=\"child-menu\" role=\"menu\">";
							menuepoint +=childul;
							childulappended = true;
						}
						menuepoint += "<li id=\"layout_" + childsetup.getLayoutId() + "\"  " +childli + "  role=\"presentation\">";
						menuepoint += "<a role=\"menuitem\" href=\"" + childsetup.getFriendlyURL() + "\" aria-labelledby=\"layout_" + childsetup.getLayoutId() + "\"><span>" + childsetup.getNameCurrentValue() +"</span></a>";
						menuepoint += "</li>";
					}
					//}
					
				}
				if(childulappended){
					menuepoint += "</ul>";
				}
				
				
				
				
				
			}
			menuepoint += "</li>";
			count++;
		}
		menuepoint = menuepoint.replaceAll("updateclassstring", "lastli");
		%>
		<%= menuepoint %>
	</ul>
</nav>

