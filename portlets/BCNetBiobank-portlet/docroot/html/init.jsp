<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="org.apache.commons.beanutils.BeanComparator"%>


<%@ page import="com.liferay.portal.NoSuchUserException"%>


<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>

<%@ page import="com.liferay.portal.kernel.uuid.PortalUUIDUtil" %>



<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>



<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.model.Country"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.model.Company"%>
<%@ page import="com.liferay.portal.model.GroupConstants"%>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portal.model.Role" %>


<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.CountryServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil"%>

<!-- Includes for searching the Site Templates -->
<%@ page import="com.liferay.portal.service.LayoutSetPrototypeServiceUtil" %>
<%@ page import="com.liferay.portal.model.LayoutSetPrototype" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.portlet.PortletRequest"%>

<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.SearchResult"%>
<%@ page import="com.liferay.portal.kernel.search.SearchResultUtil"%>


<%@ page import="com.bcnet.portlet.biobank.NoSuchSampleCollectionException" %>

<%@ page import="com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankAttributeLists" %>
<%@ page import="com.bcnet.portlet.biobank.model.JuristicPerson" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankGeneralInformation" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollection" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleCollectionContact" %>
<%@ page import="com.bcnet.portlet.biobank.model.Sample" %>
<%@ page import="com.bcnet.portlet.biobank.model.SampleImportLog" %>


<%@ page import="com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.SampleLocalServiceUtil"%>





<liferay-theme:defineObjects />

<portlet:defineObjects />