/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SampleCollectionAttributeLists. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see SampleCollectionAttributeListsLocalService
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsLocalServiceImpl
 * @generated
 */
public class SampleCollectionAttributeListsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sample collection attribute lists to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists addSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	/**
	* Creates a new sample collection attribute lists with the primary key. Does not add the sample collection attribute lists to the database.
	*
	* @param sampleCollectionAttributeListsId the primary key for the new sample collection attribute lists
	* @return the new sample collection attribute lists
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists createSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId) {
		return getService()
				   .createSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Deletes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws PortalException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Deletes the sample collection attribute lists from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Returns the sample collection attribute lists with the primary key.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists
	* @throws PortalException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists getSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sample collection attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @return the range of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeListses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionAttributeListses(start, end);
	}

	/**
	* Returns the number of sample collection attribute listses.
	*
	* @return the number of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int getSampleCollectionAttributeListsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionAttributeListsesCount();
	}

	/**
	* Updates the sample collection attribute lists in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists updateSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeListsBySampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName(sampleCollectionDbId,
			attributeListName);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName_AttributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionAttributeListsBySampleCollectionDbId_AttributeListName_AttributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeListsBySampleCollectionDbId(
		long sampleCollectionDbId) {
		return getService()
				   .deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SampleCollectionAttributeListsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SampleCollectionAttributeListsLocalService.class.getName());

			if (invokableLocalService instanceof SampleCollectionAttributeListsLocalService) {
				_service = (SampleCollectionAttributeListsLocalService)invokableLocalService;
			}
			else {
				_service = new SampleCollectionAttributeListsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SampleCollectionAttributeListsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SampleCollectionAttributeListsLocalService service) {
	}

	private static SampleCollectionAttributeListsLocalService _service;
}