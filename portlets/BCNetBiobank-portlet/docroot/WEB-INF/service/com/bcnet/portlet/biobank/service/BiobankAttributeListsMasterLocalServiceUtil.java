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
 * Provides the local service utility for BiobankAttributeListsMaster. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsMasterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see BiobankAttributeListsMasterLocalService
 * @see com.bcnet.portlet.biobank.service.base.BiobankAttributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsMasterLocalServiceImpl
 * @generated
 */
public class BiobankAttributeListsMasterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.BiobankAttributeListsMasterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the biobank attribute lists master to the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMaster the biobank attribute lists master
	* @return the biobank attribute lists master that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster addBiobankAttributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster biobankAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobankAttributeListsMaster(biobankAttributeListsMaster);
	}

	/**
	* Creates a new biobank attribute lists master with the primary key. Does not add the biobank attribute lists master to the database.
	*
	* @param biobankAttributeListsMasterId the primary key for the new biobank attribute lists master
	* @return the new biobank attribute lists master
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster createBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId) {
		return getService()
				   .createBiobankAttributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Deletes the biobank attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank attribute lists master
	* @return the biobank attribute lists master that was removed
	* @throws PortalException if a biobank attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster deleteBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAttributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Deletes the biobank attribute lists master from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMaster the biobank attribute lists master
	* @return the biobank attribute lists master that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster deleteBiobankAttributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster biobankAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBiobankAttributeListsMaster(biobankAttributeListsMaster);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster fetchBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchBiobankAttributeListsMaster(biobankAttributeListsMasterId);
	}

	/**
	* Returns the biobank attribute lists master with the primary key.
	*
	* @param biobankAttributeListsMasterId the primary key of the biobank attribute lists master
	* @return the biobank attribute lists master
	* @throws PortalException if a biobank attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster getBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAttributeListsMaster(biobankAttributeListsMasterId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biobank attribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank attribute lists masters
	* @param end the upper bound of the range of biobank attribute lists masters (not inclusive)
	* @return the range of biobank attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster> getBiobankAttributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAttributeListsMasters(start, end);
	}

	/**
	* Returns the number of biobank attribute lists masters.
	*
	* @return the number of biobank attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int getBiobankAttributeListsMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBiobankAttributeListsMastersCount();
	}

	/**
	* Updates the biobank attribute lists master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param biobankAttributeListsMaster the biobank attribute lists master
	* @return the biobank attribute lists master that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster updateBiobankAttributeListsMaster(
		com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster biobankAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBiobankAttributeListsMaster(biobankAttributeListsMaster);
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

	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster addBiobankAttributeListsMaster(
		java.lang.String attributeListName, java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBiobankAttributeListsMaster(attributeListName,
			attributeListValue);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster> getAllBiobankAttributeListsMasters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobankAttributeListsMasters();
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster> getAllBiobankAttributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBiobankAttributeListsMasters(start, end);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster> getBiobankAttributeListsMasterByAttributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBiobankAttributeListsMasterByAttributeListName(attributeListName);
	}

	public static com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster updateBiobankAttributeListsMaster(
		long biobankAttributeListsMasterId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBiobankAttributeListsMaster(biobankAttributeListsMasterId,
			attributeListName, attributeListValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static BiobankAttributeListsMasterLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BiobankAttributeListsMasterLocalService.class.getName());

			if (invokableLocalService instanceof BiobankAttributeListsMasterLocalService) {
				_service = (BiobankAttributeListsMasterLocalService)invokableLocalService;
			}
			else {
				_service = new BiobankAttributeListsMasterLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BiobankAttributeListsMasterLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BiobankAttributeListsMasterLocalService service) {
	}

	private static BiobankAttributeListsMasterLocalService _service;
}