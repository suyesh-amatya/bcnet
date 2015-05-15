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

import com.bcnet.portlet.biobank.model.SampleCollectionContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the sample collection contact service. This utility wraps {@link SampleCollectionContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionContactPersistence
 * @see SampleCollectionContactPersistenceImpl
 * @generated
 */
public class SampleCollectionContactUtil {
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
		SampleCollectionContact sampleCollectionContact) {
		getPersistence().clearCache(sampleCollectionContact);
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
	public static List<SampleCollectionContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SampleCollectionContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SampleCollectionContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SampleCollectionContact update(
		SampleCollectionContact sampleCollectionContact)
		throws SystemException {
		return getPersistence().update(sampleCollectionContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SampleCollectionContact update(
		SampleCollectionContact sampleCollectionContact,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sampleCollectionContact, serviceContext);
	}

	/**
	* Returns all the sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns a range of all the sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of sample collection contacts
	* @param end the upper bound of the range of sample collection contacts (not inclusive)
	* @return the range of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId(sampleCollectionDbId, start, end);
	}

	/**
	* Returns an ordered range of all the sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of sample collection contacts
	* @param end the upper bound of the range of sample collection contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId(sampleCollectionDbId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_First(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_First(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_Last(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_Last(sampleCollectionDbId,
			orderByComparator);
	}

	/**
	* Returns the sample collection contacts before and after the current sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionContactPK the primary key of the current sample collection contact
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact[] findBysampleCollectionDbId_PrevAndNext(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK,
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_PrevAndNext(sampleCollectionContactPK,
			sampleCollectionDbId, orderByComparator);
	}

	/**
	* Removes all the sample collection contacts where sampleCollectionDbId = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the number of sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the number of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact);
	}

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact);
	}

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact, retrieveFromCache);
	}

	/**
	* Removes the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the sample collection contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact removeBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact);
	}

	/**
	* Returns the number of sample collection contacts where sampleCollectionDbId = &#63; and mainContact = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the number of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact);
	}

	/**
	* Caches the sample collection contact in the entity cache if it is enabled.
	*
	* @param sampleCollectionContact the sample collection contact
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact) {
		getPersistence().cacheResult(sampleCollectionContact);
	}

	/**
	* Caches the sample collection contacts in the entity cache if it is enabled.
	*
	* @param sampleCollectionContacts the sample collection contacts
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> sampleCollectionContacts) {
		getPersistence().cacheResult(sampleCollectionContacts);
	}

	/**
	* Creates a new sample collection contact with the primary key. Does not add the sample collection contact to the database.
	*
	* @param sampleCollectionContactPK the primary key for the new sample collection contact
	* @return the new sample collection contact
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact create(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK) {
		return getPersistence().create(sampleCollectionContactPK);
	}

	/**
	* Removes the sample collection contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact remove(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sampleCollectionContactPK);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionContact updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sampleCollectionContact);
	}

	/**
	* Returns the sample collection contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact findByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(sampleCollectionContactPK);
	}

	/**
	* Returns the sample collection contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact, or <code>null</code> if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sampleCollectionContactPK);
	}

	/**
	* Returns all the sample collection contacts.
	*
	* @return the sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the sample collection contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection contacts
	* @param end the upper bound of the range of sample collection contacts (not inclusive)
	* @return the range of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sample collection contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection contacts
	* @param end the upper bound of the range of sample collection contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sample collection contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sample collection contacts.
	*
	* @return the number of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SampleCollectionContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SampleCollectionContactPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					SampleCollectionContactPersistence.class.getName());

			ReferenceRegistry.registerReference(SampleCollectionContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SampleCollectionContactPersistence persistence) {
	}

	private static SampleCollectionContactPersistence _persistence;
}