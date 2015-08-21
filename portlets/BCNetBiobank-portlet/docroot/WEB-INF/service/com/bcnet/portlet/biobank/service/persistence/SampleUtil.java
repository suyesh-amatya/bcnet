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

import com.bcnet.portlet.biobank.model.Sample;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sample service. This utility wraps {@link SamplePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SamplePersistence
 * @see SamplePersistenceImpl
 * @generated
 */
public class SampleUtil {
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
	public static void clearCache(Sample sample) {
		getPersistence().clearCache(sample);
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
	public static List<Sample> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sample> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sample> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Sample update(Sample sample) throws SystemException {
		return getPersistence().update(sample);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Sample update(Sample sample, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(sample, serviceContext);
	}

	/**
	* Returns all the samples where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @return the matching samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuuid(uuid_);
	}

	/**
	* Returns a range of all the samples where uuid_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid_ the uuid_
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @return the range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuuid(uuid_, start, end);
	}

	/**
	* Returns an ordered range of all the samples where uuid_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid_ the uuid_
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuuid(uuid_, start, end, orderByComparator);
	}

	/**
	* Returns the first sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample findByuuid_First(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuuid_First(uuid_, orderByComparator);
	}

	/**
	* Returns the first sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample fetchByuuid_First(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuuid_First(uuid_, orderByComparator);
	}

	/**
	* Returns the last sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample findByuuid_Last(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuuid_Last(uuid_, orderByComparator);
	}

	/**
	* Returns the last sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample fetchByuuid_Last(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuuid_Last(uuid_, orderByComparator);
	}

	/**
	* Returns the samples before and after the current sample in the ordered set where uuid_ = &#63;.
	*
	* @param sampleDbId the primary key of the current sample
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample[] findByuuid_PrevAndNext(
		long sampleDbId, java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuuid_PrevAndNext(sampleDbId, uuid_, orderByComparator);
	}

	/**
	* Removes all the samples where uuid_ = &#63; from the database.
	*
	* @param uuid_ the uuid_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuuid(java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuuid(uuid_);
	}

	/**
	* Returns the number of samples where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @return the number of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuuid(java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuuid(uuid_);
	}

	/**
	* Caches the sample in the entity cache if it is enabled.
	*
	* @param sample the sample
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.Sample sample) {
		getPersistence().cacheResult(sample);
	}

	/**
	* Caches the samples in the entity cache if it is enabled.
	*
	* @param samples the samples
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.Sample> samples) {
		getPersistence().cacheResult(samples);
	}

	/**
	* Creates a new sample with the primary key. Does not add the sample to the database.
	*
	* @param sampleDbId the primary key for the new sample
	* @return the new sample
	*/
	public static com.bcnet.portlet.biobank.model.Sample create(long sampleDbId) {
		return getPersistence().create(sampleDbId);
	}

	/**
	* Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample remove(long sampleDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sampleDbId);
	}

	public static com.bcnet.portlet.biobank.model.Sample updateImpl(
		com.bcnet.portlet.biobank.model.Sample sample)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sample);
	}

	/**
	* Returns the sample with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleException} if it could not be found.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample findByPrimaryKey(
		long sampleDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(sampleDbId);
	}

	/**
	* Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample, or <code>null</code> if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.Sample fetchByPrimaryKey(
		long sampleDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sampleDbId);
	}

	/**
	* Returns all the samples.
	*
	* @return the samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the samples.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @return the range of samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the samples.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of samples
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the samples from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of samples.
	*
	* @return the number of samples
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SamplePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SamplePersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					SamplePersistence.class.getName());

			ReferenceRegistry.registerReference(SampleUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SamplePersistence persistence) {
	}

	private static SamplePersistence _persistence;
}