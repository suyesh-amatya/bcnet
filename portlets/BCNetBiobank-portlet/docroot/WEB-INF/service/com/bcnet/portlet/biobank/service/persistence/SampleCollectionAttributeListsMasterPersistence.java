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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the sample collection attribute lists master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMasterPersistenceImpl
 * @see SampleCollectionAttributeListsMasterUtil
 * @generated
 */
public interface SampleCollectionAttributeListsMasterPersistence
	extends BasePersistence<SampleCollectionAttributeListsMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleCollectionAttributeListsMasterUtil} to access the sample collection attribute lists master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sample collection attribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findByattributeListName(
		java.lang.String attributeListName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByattributeListName_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists master, or <code>null</code> if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByattributeListName_First(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByattributeListName_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists master in the ordered set where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists master, or <code>null</code> if a matching sample collection attribute lists master could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByattributeListName_Last(
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster[] findByattributeListName_PrevAndNext(
		long sampleCollectionAttributeListsMasterId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection attribute lists masters where attributeListName = &#63; from the database.
	*
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByattributeListName(java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute lists masters where attributeListName = &#63;.
	*
	* @param attributeListName the attribute list name
	* @return the number of matching sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public int countByattributeListName(java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sample collection attribute lists master in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster);

	/**
	* Caches the sample collection attribute lists masters in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListsMasters the sample collection attribute lists masters
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> sampleCollectionAttributeListsMasters);

	/**
	* Creates a new sample collection attribute lists master with the primary key. Does not add the sample collection attribute lists master to the database.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key for the new sample collection attribute lists master
	* @return the new sample collection attribute lists master
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster create(
		long sampleCollectionAttributeListsMasterId);

	/**
	* Removes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster remove(
		long sampleCollectionAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException} if it could not be found.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster findByPrimaryKey(
		long sampleCollectionAttributeListsMasterId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master, or <code>null</code> if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchByPrimaryKey(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sample collection attribute lists masters.
	*
	* @return the sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection attribute lists masters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute lists masters.
	*
	* @return the number of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}