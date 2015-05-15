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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the sample collection contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionContactPersistenceImpl
 * @see SampleCollectionContactUtil
 * @generated
 */
public interface SampleCollectionContactPersistence extends BasePersistence<SampleCollectionContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleCollectionContactUtil} to access the sample collection contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.SampleCollectionContact[] findBysampleCollectionDbId_PrevAndNext(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK,
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection contacts where sampleCollectionDbId = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection contacts where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the number of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the matching sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact findBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the sample collection contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact removeBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection contacts where sampleCollectionDbId = &#63; and mainContact = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param mainContact the main contact
	* @return the number of matching sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sample collection contact in the entity cache if it is enabled.
	*
	* @param sampleCollectionContact the sample collection contact
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact);

	/**
	* Caches the sample collection contacts in the entity cache if it is enabled.
	*
	* @param sampleCollectionContacts the sample collection contacts
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> sampleCollectionContacts);

	/**
	* Creates a new sample collection contact with the primary key. Does not add the sample collection contact to the database.
	*
	* @param sampleCollectionContactPK the primary key for the new sample collection contact
	* @return the new sample collection contact
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact create(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK);

	/**
	* Removes the sample collection contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact remove(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.SampleCollectionContact updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact
	* @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact findByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample collection contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact, or <code>null</code> if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.SampleCollectionContact fetchByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sample collection contacts.
	*
	* @return the sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sample collection contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sample collection contacts.
	*
	* @return the number of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}