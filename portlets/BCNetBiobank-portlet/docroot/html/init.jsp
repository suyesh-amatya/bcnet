<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>

<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>



<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Company"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portal.model.Role" %>


<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.CountryServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>

<!-- Includes for searching the Site Templates -->
<%@ page import="com.liferay.portal.service.LayoutSetPrototypeServiceUtil" %>
<%@ page import="com.liferay.portal.model.LayoutSetPrototype" %>


<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.portlet.PortletRequest"%>

<%@ page import="com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankAttributeLists" %>
<%@ page import="com.bcnet.portlet.biobank.model.JuristicPerson" %>
<%@ page import="com.bcnet.portlet.biobank.model.Contact" %>
<%@ page import="com.bcnet.portlet.biobank.model.Biobank" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankGeneralInformation" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollection" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists" %>


<%@ page import="com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.ContactLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil"%>
<%@page import="com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />