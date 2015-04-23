<nav class="${nav_css_class}" id="navigation" role="navigation">
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" id="topmenu" class="organization">
		<#list nav_items as nav_item>
			<#if nav_item.isSelected()>
				<#list nav_item.getChildren() as nav_child>
					<#list nav_child.getChildren() as nav_child_child>
						<#assign nav_item_attr_has_popup = "" />
						<#assign nav_item_attr_selected = "" />
						<#assign nav_item_css_class = "" />
						<#if nav_child_child.isSelected()>
							<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
							<#assign nav_item_attr_selected = "aria-selected='true'" />
							<#assign nav_item_css_class = "selected" />
						</#if>
						<li ${nav_item_attr_selected} class="${nav_item_css_class}" id="layout_${nav_child_child.getLayoutId()}" role="presentation">
							<a aria-labelledby="layout_${nav_child_child.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
								<span>${nav_child_child.icon()} ${nav_child_child.getName()}</span>
							</a>
						</li>
					</#list>
				</#list>
			</#if>	
		</#list>
	</ul>
</nav>