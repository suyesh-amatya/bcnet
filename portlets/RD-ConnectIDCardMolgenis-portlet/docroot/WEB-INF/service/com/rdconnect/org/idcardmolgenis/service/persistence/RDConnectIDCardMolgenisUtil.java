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

package com.rdconnect.org.idcardmolgenis.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis;

import java.util.List;

/**
 * The persistence utility for the r d connect i d card molgenis service. This utility wraps {@link RDConnectIDCardMolgenisPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenisPersistence
 * @see RDConnectIDCardMolgenisPersistenceImpl
 * @generated
 */
public class RDConnectIDCardMolgenisUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		getPersistence().clearCache(rdConnectIDCardMolgenis);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RDConnectIDCardMolgenis> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDConnectIDCardMolgenis> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDConnectIDCardMolgenis> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDConnectIDCardMolgenis update(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws SystemException {
		return getPersistence().update(rdConnectIDCardMolgenis);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDConnectIDCardMolgenis update(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rdConnectIDCardMolgenis, serviceContext);
	}

	/**
	* Caches the r d connect i d card molgenis in the entity cache if it is enabled.
	*
	* @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	*/
	public static void cacheResult(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		getPersistence().cacheResult(rdConnectIDCardMolgenis);
	}

	/**
	* Caches the r d connect i d card molgenises in the entity cache if it is enabled.
	*
	* @param rdConnectIDCardMolgenises the r d connect i d card molgenises
	*/
	public static void cacheResult(
		java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> rdConnectIDCardMolgenises) {
		getPersistence().cacheResult(rdConnectIDCardMolgenises);
	}

	/**
	* Creates a new r d connect i d card molgenis with the primary key. Does not add the r d connect i d card molgenis to the database.
	*
	* @param id the primary key for the new r d connect i d card molgenis
	* @return the new r d connect i d card molgenis
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the r d connect i d card molgenis with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was removed
	* @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException {
		return getPersistence().remove(id);
	}

	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis updateImpl(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdConnectIDCardMolgenis);
	}

	/**
	* Returns the r d connect i d card molgenis with the primary key or throws a {@link com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException} if it could not be found.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis
	* @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the r d connect i d card molgenis with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis, or <code>null</code> if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the r d connect i d card molgenises.
	*
	* @return the r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d connect i d card molgenises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect i d card molgenises
	* @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d connect i d card molgenises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d connect i d card molgenises.
	*
	* @return the number of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDConnectIDCardMolgenisPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDConnectIDCardMolgenisPersistence)PortletBeanLocatorUtil.locate(com.rdconnect.org.idcardmolgenis.service.ClpSerializer.getServletContextName(),
					RDConnectIDCardMolgenisPersistence.class.getName());

			ReferenceRegistry.registerReference(RDConnectIDCardMolgenisUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RDConnectIDCardMolgenisPersistence persistence) {
	}

	private static RDConnectIDCardMolgenisPersistence _persistence;
}