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
	* @param sampleId the primary key for the new sample
	* @return the new sample
	*/
	public com.bcnet.portlet.biobank.model.Sample create(long sampleId);

	/**
	* Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleId the primary key of the sample
	* @return the sample that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample remove(long sampleId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.Sample updateImpl(
		com.bcnet.portlet.biobank.model.Sample sample)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleException} if it could not be found.
	*
	* @param sampleId the primary key of the sample
	* @return the sample
	* @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample findByPrimaryKey(
		long sampleId)
		throws com.bcnet.portlet.biobank.NoSuchSampleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sampleId the primary key of the sample
	* @return the sample, or <code>null</code> if a sample with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.Sample fetchByPrimaryKey(
		long sampleId)
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