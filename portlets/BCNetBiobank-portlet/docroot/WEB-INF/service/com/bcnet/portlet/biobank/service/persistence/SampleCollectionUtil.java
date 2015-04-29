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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.SampleCollection;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sample collection service. This utility wraps {@link SampleCollectionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionPersistence
 * @see SampleCollectionPersistenceImpl
 * @generated
 */
public class SampleCollectionUtil {
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
	public static void clearCache(SampleCollection sampleCollection) {
		getPersistence().clearCache(sampleCollection);
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
	public static List<SampleCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SampleCollection update(SampleCollection sampleCollection)
		throws SystemException {
		return getPersistence().update(sampleCollection);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SampleCollection update(SampleCollection sampleCollection,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sampleCollection, serviceContext);
	}

	/**
	* Caches the sample collection in the entity cache if it is enabled.
	*
	* @param sampleCollection the sample collection
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollection sampleCollection) {
		getPersistence().cacheResult(sampleCollection);
	}

	/**
	* Caches the sample collections in the entity cache if it is enabled.
	*
	* @param sampleCollections the sample collections
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollection> sampleCollections) {
		getPersistence().cacheResult(sampleCollections);
	}

	/**
	* Creates a new sample collection with the primary key. Does not add the sample collection to the database.
	*
	* @param sampleCollectionDbId the primary key for the new sample collection
	* @return the new sample collection
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollection create(
		long sampleCollectionDbId) {
		return getPersistence().create(sampleCollectionDbId);
	}

	/**
	* Removes the sample collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionDbId the primary key of the sample collection
	* @return the sample collection that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollection remove(
		long sampleCollectionDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sampleCollectionDbId);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollection updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollection sampleCollection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sampleCollection);
	}

	/**
	* Returns the sample collection with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionException} if it could not be found.
	*
	* @param sampleCollectionDbId the primary key of the sample collection
	* @return the sample collection
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollection findByPrimaryKey(
		long sampleCollectionDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(sampleCollectionDbId);
	}

	/**
	* Returns the sample collection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionDbId the primary key of the sample collection
	* @return the sample collection, or <code>null</code> if a sample collection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollection fetchByPrimaryKey(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sampleCollectionDbId);
	}

	/**
	* Returns all the sample collections.
	*
	* @return the sample collections
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollection> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sample collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collections
	* @param end the upper bound of the range of sample collections (not inclusive)
	* @return the range of sample collections
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollection> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sample collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collections
	* @param end the upper bound of the range of sample collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sample collections
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sample collections from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sample collections.
	*
	* @return the number of sample collections
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SampleCollectionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SampleCollectionPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					SampleCollectionPersistence.class.getName());

			ReferenceRegistry.registerReference(SampleCollectionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SampleCollectionPersistence persistence) {
	}

	private static SampleCollectionPersistence _persistence;
}