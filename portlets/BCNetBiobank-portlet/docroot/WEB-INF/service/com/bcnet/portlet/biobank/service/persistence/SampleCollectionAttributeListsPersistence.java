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

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the sample collection attribute lists service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsPersistenceImpl
 * @see SampleCollectionAttributeListsUtil
 * @generated
 */
public interface SampleCollectionAttributeListsPersistence
	extends BasePersistence<SampleCollectionAttributeLists> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleCollectionAttributeListsUtil} to access the sample collection attribute lists persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @return the range of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute listses before and after the current sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionAttributeListsId the primary key of the current sample collection attribute lists
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists[] findBysampleCollectionDbId_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @return the matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @return the range of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute listses before and after the current sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionAttributeListsId the primary key of the current sample collection attribute lists
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists[] findBysampleCollectionDbId_attributeListName_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException} if it could not be found.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the sample collection attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists removeBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sample collection attribute lists in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists);

	/**
	* Caches the sample collection attribute listses in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListses the sample collection attribute listses
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> sampleCollectionAttributeListses);

	/**
	* Creates a new sample collection attribute lists with the primary key. Does not add the sample collection attribute lists to the database.
	*
	* @param sampleCollectionAttributeListsId the primary key for the new sample collection attribute lists
	* @return the new sample collection attribute lists
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists create(
		long sampleCollectionAttributeListsId);

	/**
	* Removes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists remove(
		long sampleCollectionAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException} if it could not be found.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findByPrimaryKey(
		long sampleCollectionAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection attribute lists with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists, or <code>null</code> if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchByPrimaryKey(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sample collection attribute listses.
	*
	* @return the sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sample collection attribute listses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection attribute listses
	* @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection attribute listses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection attribute listses.
	*
	* @return the number of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}