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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sample collection attribute lists service. This utility wraps {@link SampleCollectionAttributeListsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsPersistence
 * @see SampleCollectionAttributeListsPersistenceImpl
 * @generated
 */
public class SampleCollectionAttributeListsUtil {
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
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		getPersistence().clearCache(sampleCollectionAttributeLists);
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
	public static List<SampleCollectionAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleCollectionAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleCollectionAttributeLists> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SampleCollectionAttributeLists update(
		SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws SystemException {
		return getPersistence().update(sampleCollectionAttributeLists);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SampleCollectionAttributeLists update(
		SampleCollectionAttributeLists sampleCollectionAttributeLists,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(sampleCollectionAttributeLists, serviceContext);
	}

	/**
	* Returns all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysampleCollectionDbId(sampleCollectionDbId);
	}

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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId(sampleCollectionDbId, start, end);
	}

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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId(sampleCollectionDbId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_First(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_First(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_Last(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_Last(sampleCollectionDbId,
			orderByComparator);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists[] findBysampleCollectionDbId_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_PrevAndNext(sampleCollectionAttributeListsId,
			sampleCollectionDbId, orderByComparator);
	}

	/**
	* Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @return the matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName);
	}

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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName, start, end);
	}

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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName, start, end, orderByComparator);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName_First(sampleCollectionDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_attributeListName_First(sampleCollectionDbId,
			attributeListName, orderByComparator);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName_Last(sampleCollectionDbId,
			attributeListName, orderByComparator);
	}

	/**
	* Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_attributeListName_Last(sampleCollectionDbId,
			attributeListName, orderByComparator);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists[] findBysampleCollectionDbId_attributeListName_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		java.lang.String attributeListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName_PrevAndNext(sampleCollectionAttributeListsId,
			sampleCollectionDbId, attributeListName, orderByComparator);
	}

	/**
	* Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName);
	}

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue);
	}

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
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue, retrieveFromCache);
	}

	/**
	* Removes the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the sample collection attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists removeBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param attributeListName the attribute list name
	* @param attributeListValue the attribute list value
	* @return the number of matching sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, java.lang.String attributeListName,
		java.lang.String attributeListValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue);
	}

	/**
	* Caches the sample collection attribute lists in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		getPersistence().cacheResult(sampleCollectionAttributeLists);
	}

	/**
	* Caches the sample collection attribute listses in the entity cache if it is enabled.
	*
	* @param sampleCollectionAttributeListses the sample collection attribute listses
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> sampleCollectionAttributeListses) {
		getPersistence().cacheResult(sampleCollectionAttributeListses);
	}

	/**
	* Creates a new sample collection attribute lists with the primary key. Does not add the sample collection attribute lists to the database.
	*
	* @param sampleCollectionAttributeListsId the primary key for the new sample collection attribute lists
	* @return the new sample collection attribute lists
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists create(
		long sampleCollectionAttributeListsId) {
		return getPersistence().create(sampleCollectionAttributeListsId);
	}

	/**
	* Removes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists remove(
		long sampleCollectionAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sampleCollectionAttributeListsId);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sampleCollectionAttributeLists);
	}

	/**
	* Returns the sample collection attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException} if it could not be found.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists findByPrimaryKey(
		long sampleCollectionAttributeListsId)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryKey(sampleCollectionAttributeListsId);
	}

	/**
	* Returns the sample collection attribute lists with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists, or <code>null</code> if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchByPrimaryKey(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(sampleCollectionAttributeListsId);
	}

	/**
	* Returns all the sample collection attribute listses.
	*
	* @return the sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sample collection attribute listses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sample collection attribute listses.
	*
	* @return the number of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SampleCollectionAttributeListsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SampleCollectionAttributeListsPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					SampleCollectionAttributeListsPersistence.class.getName());

			ReferenceRegistry.registerReference(SampleCollectionAttributeListsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		SampleCollectionAttributeListsPersistence persistence) {
	}

	private static SampleCollectionAttributeListsPersistence _persistence;
}