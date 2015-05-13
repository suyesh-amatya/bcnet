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

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sample collection attribute lists master service. This utility wraps {@link SampleCollectionAttributeListsMasterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMasterPersistence
 * @see SampleCollectionAttributeListsMasterPersistenceImpl
 * @generated
 */
public class SampleCollectionAttributeListsMasterUtil {
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
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		getPersistence().clearCache(sampleCollectionAttributeListsMaster);
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
	public static List<SampleCollectionAttributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleCollectionAttributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleCollectionAttributeListsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SampleCollectionAttributeListsMaster update(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws SystemException {
		return getPersistence().update(sampleCollectionAttributeListsMaster);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SampleCollectionAttributeListsMaster update(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(sampleCollectionAttributeListsMaster, serviceContext);
	}

	/**
	* Returns all the sample collection attribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattributeListName(attributeListName);
	}

	/**
	* Returns a range of all the sample collection attribute lists masters where attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of sample collection attribute lists masters
	* @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	* @return the range of matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattributeListName(attributeListName, start, end);
	}

	/**
	* Returns an ordered range of all the sample collection attribute lists masters where attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of sample collection attribute lists masters
	* @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattributeListName(attributeListName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByattributeListName_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattributeListName_First(attributeListName,
			orderByComparator);
	}

	/**
	* Returns the first sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists master, or <code>null</code> if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByattributeListName_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattributeListName_First(attributeListName,
			orderByComparator);
	}

	/**
	* Returns the last sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByattributeListName_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattributeListName_Last(attributeListName,
			orderByComparator);
	}

	/**
	* Returns the last sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists master, or <code>null</code> if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByattributeListName_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattributeListName_Last(attributeListName,
			orderByComparator);
	}

	/**
	* Returns the sample collection attribute lists masters before and after the current sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the current sample collection attribute lists master
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster[] findByattributeListName_PrevAndNext(
		long sampleCollectionAttributeListsMasterId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattributeListName_PrevAndNext(sampleCollectionAttributeListsMasterId,
			attributeListName, orderByComparator);
	}

	/**
	* Removes all the sample collection attribute lists masters where attributeListName = &#63; from the database.
	*
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByattributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByattributeListName(attributeListName);
	}

	/**
	* Returns the number of sample collection attribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the number of matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByattributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByattributeListName(attributeListName);
	}

	/**
	* Caches the sample collection attribute lists master in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		getPersistence().cacheResult(sampleCollectionAttributeListsMaster);
	}

	/**
	* Caches the sample collection attribute lists masters in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListsMasters the sample collection attribute lists masters
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> sampleCollectionAttributeListsMasters) {
		getPersistence().cacheResult(sampleCollectionAttributeListsMasters);
	}

	/**
	* Creates a new sample collection attribute lists master with the primary key. Does not add the sample collection attribute lists master to the database.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key for the new sample collection attribute lists master
	* @return the new sample collection attribute lists master
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster create(
		long sampleCollectionAttributeListsMasterId) {
		return getPersistence().create(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Removes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster remove(
		long sampleCollectionAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sampleCollectionAttributeListsMasterId);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sampleCollectionAttributeListsMaster);
	}

	/**
	* Returns the sample collection attribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException} if it could not be found.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByPrimaryKey(
		long sampleCollectionAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryKey(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Returns the sample collection attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master, or <code>null</code> if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByPrimaryKey(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Returns all the sample collection attribute lists masters.
	*
	* @return the sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sample collection attribute lists masters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection attribute lists masters
	* @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sample collection attribute lists masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sample collection attribute lists masters.
	*
	* @return the number of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SampleCollectionAttributeListsMasterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SampleCollectionAttributeListsMasterPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					SampleCollectionAttributeListsMasterPersistence.class.getName());

			ReferenceRegistry.registerReference(SampleCollectionAttributeListsMasterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		SampleCollectionAttributeListsMasterPersistence persistence) {
	}

	private static SampleCollectionAttributeListsMasterPersistence _persistence;
}