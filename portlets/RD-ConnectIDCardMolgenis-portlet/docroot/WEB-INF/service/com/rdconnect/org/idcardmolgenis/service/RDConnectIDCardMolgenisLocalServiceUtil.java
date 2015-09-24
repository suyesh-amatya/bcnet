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

package com.rdconnect.org.idcardmolgenis.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for RDConnectIDCardMolgenis. This utility wraps
 * {@link com.rdconnect.org.idcardmolgenis.service.impl.RDConnectIDCardMolgenisLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenisLocalService
 * @see com.rdconnect.org.idcardmolgenis.service.base.RDConnectIDCardMolgenisLocalServiceBaseImpl
 * @see com.rdconnect.org.idcardmolgenis.service.impl.RDConnectIDCardMolgenisLocalServiceImpl
 * @generated
 */
public class RDConnectIDCardMolgenisLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rdconnect.org.idcardmolgenis.service.impl.RDConnectIDCardMolgenisLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the r d connect i d card molgenis to the database. Also notifies the appropriate model listeners.
	*
	* @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis addRDConnectIDCardMolgenis(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRDConnectIDCardMolgenis(rdConnectIDCardMolgenis);
	}

	/**
	* Creates a new r d connect i d card molgenis with the primary key. Does not add the r d connect i d card molgenis to the database.
	*
	* @param id the primary key for the new r d connect i d card molgenis
	* @return the new r d connect i d card molgenis
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis createRDConnectIDCardMolgenis(
		long id) {
		return getService().createRDConnectIDCardMolgenis(id);
	}

	/**
	* Deletes the r d connect i d card molgenis with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was removed
	* @throws PortalException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis deleteRDConnectIDCardMolgenis(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRDConnectIDCardMolgenis(id);
	}

	/**
	* Deletes the r d connect i d card molgenis from the database. Also notifies the appropriate model listeners.
	*
	* @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis deleteRDConnectIDCardMolgenis(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRDConnectIDCardMolgenis(rdConnectIDCardMolgenis);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis fetchRDConnectIDCardMolgenis(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRDConnectIDCardMolgenis(id);
	}

	/**
	* Returns the r d connect i d card molgenis with the primary key.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis
	* @throws PortalException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis getRDConnectIDCardMolgenis(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDConnectIDCardMolgenis(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the r d connect i d card molgenises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect i d card molgenises
	* @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	* @return the range of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> getRDConnectIDCardMolgenises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDConnectIDCardMolgenises(start, end);
	}

	/**
	* Returns the number of r d connect i d card molgenises.
	*
	* @return the number of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public static int getRDConnectIDCardMolgenisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRDConnectIDCardMolgenisesCount();
	}

	/**
	* Updates the r d connect i d card molgenis in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis updateRDConnectIDCardMolgenis(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRDConnectIDCardMolgenis(rdConnectIDCardMolgenis);
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

	public static java.lang.String getUserCredential() {
		return getService().getUserCredential();
	}

	public static void clearService() {
		_service = null;
	}

	public static RDConnectIDCardMolgenisLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RDConnectIDCardMolgenisLocalService.class.getName());

			if (invokableLocalService instanceof RDConnectIDCardMolgenisLocalService) {
				_service = (RDConnectIDCardMolgenisLocalService)invokableLocalService;
			}
			else {
				_service = new RDConnectIDCardMolgenisLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RDConnectIDCardMolgenisLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RDConnectIDCardMolgenisLocalService service) {
	}

	private static RDConnectIDCardMolgenisLocalService _service;
}