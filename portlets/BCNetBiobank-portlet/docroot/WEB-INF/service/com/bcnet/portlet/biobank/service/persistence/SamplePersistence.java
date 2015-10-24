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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the sample service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SamplePersistenceImpl
 * @see SampleUtil
 * @generated
 */
public interface SamplePersistence extends BasePersistence<Sample> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SampleUtil} to access the sample persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the samples where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @return the matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findByuuid(
		java.lang.String uuid_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findByuuid_First(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchByuuid_First(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findByuuid_Last(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchByuuid_Last(
		java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bcnet.portlet.biobank.model.Sample[] findByuuid_PrevAndNext(
		long sampleDbId, java.lang.String uuid_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the samples where uuid_ = &#63; from the database.
	*
	* @param uuid_ the uuid_
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuuid(java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of samples where uuid_ = &#63;.
	*
	* @param uuid_ the uuid_
	* @return the number of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public int countByuuid(java.lang.String uuid_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the samples where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBybiobankDbId(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the samples where biobankDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @return the range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBybiobankDbId(
		long biobankDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the samples where biobankDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankDbId the biobank db ID
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBybiobankDbId(
		long biobankDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchBybiobankDbId_First(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchBybiobankDbId_Last(
		long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the samples before and after the current sample in the ordered set where biobankDbId = &#63;.
	*
	* @param sampleDbId the primary key of the current sample
	* @param biobankDbId the biobank db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample[] findBybiobankDbId_PrevAndNext(
		long sampleDbId, long biobankDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the samples where biobankDbId = &#63; from the database.
	*
	* @param biobankDbId the biobank db ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of samples where biobankDbId = &#63;.
	*
	* @param biobankDbId the biobank db ID
	* @return the number of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public int countBybiobankDbId(long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the samples where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBysampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the samples where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @return the range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the samples where sampleCollectionDbId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param start the lower bound of the range of samples
	* @param end the upper bound of the range of samples (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sample in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sample in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sample, or <code>null</code> if a matching sample could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the samples before and after the current sample in the ordered set where sampleCollectionDbId = &#63;.
	*
	* @param sampleDbId the primary key of the current sample
	* @param sampleCollectionDbId the sample collection db ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample[] findBysampleCollectionDbId_PrevAndNext(
		long sampleDbId, long sampleCollectionDbId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the samples where sampleCollectionDbId = &#63; from the database.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of samples where sampleCollectionDbId = &#63;.
	*
	* @param sampleCollectionDbId the sample collection db ID
	* @return the number of matching samples
	* @throws SystemException if a system exception occurred
	*/
	public int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sample in the entity cache if it is enabled.
	*
	* @param sample the sample
	*/
	public void cacheResult(com.bcnet.portlet.biobank.model.Sample sample);

	/**
	* Caches the samples in the entity cache if it is enabled.
	*
	* @param samples the samples
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.Sample> samples);

	/**
	* Creates a new sample with the primary key. Does not add the sample to the database.
	*
	* @param sampleDbId the primary key for the new sample
	* @return the new sample
	*/
	public com.bcnet.portlet.biobank.model.Sample create(long sampleDbId);

	/**
	* Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample remove(long sampleDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.Sample updateImpl(
		com.bcnet.portlet.biobank.model.Sample sample)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleException} if it could not be found.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findByPrimaryKey(
		long sampleDbId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleDbId the primary key of the sample
	* @return the sample, or <code>null</code> if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchByPrimaryKey(
		long sampleDbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the samples.
	*
	* @return the samples
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bcnet.portlet.biobank.model.Sample> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the samples from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of samples.
	*
	* @return the number of samples
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}