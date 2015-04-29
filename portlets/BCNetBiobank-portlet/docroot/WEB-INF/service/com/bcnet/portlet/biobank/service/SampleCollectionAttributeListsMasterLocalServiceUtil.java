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
 * Provides the local service utility for SampleCollectionAttributeListsMaster. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMasterLocalService
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionAttributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsMasterLocalServiceImpl
 * @generated
 */
public class SampleCollectionAttributeListsMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sample collection attribute lists master to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster addSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
	}

	/**
	* Creates a new sample collection attribute lists master with the primary key. Does not add the sample collection attribute lists master to the database.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key for the new sample collection attribute lists master
	* @return the new sample collection attribute lists master
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster createSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId) {
		return getService()
				   .createSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Deletes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws PortalException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster deleteSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Deletes the sample collection attribute lists master from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster deleteSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Returns the sample collection attribute lists master with the primary key.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master
	* @throws PortalException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster getSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sample collection attribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection attribute lists masters
	* @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	* @return the range of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> getSampleCollectionAttributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionAttributeListsMasters(start, end);
	}

	/**
	* Returns the number of sample collection attribute lists masters.
	*
	* @return the number of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getSampleCollectionAttributeListsMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionAttributeListsMastersCount();
	}

	/**
	* Updates the sample collection attribute lists master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster updateSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
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

	public static void clearService() {
		_service = null;
	}

	public static SampleCollectionAttributeListsMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SampleCollectionAttributeListsMasterLocalService.class.getName());

			if (invokableLocalService instanceof SampleCollectionAttributeListsMasterLocalService) {
				_service = (SampleCollectionAttributeListsMasterLocalService)invokableLocalService;
			}
			else {
				_service = new SampleCollectionAttributeListsMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SampleCollectionAttributeListsMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(
		SampleCollectionAttributeListsMasterLocalService service) {
	}

	private static SampleCollectionAttributeListsMasterLocalService _service;
}