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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SampleCollectionAttributeListsMasterLocalService}.
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMasterLocalService
 * @generated
 */
public class SampleCollectionAttributeListsMasterLocalServiceWrapper
	implements SampleCollectionAttributeListsMasterLocalService,
		ServiceWrapper<SampleCollectionAttributeListsMasterLocalService> {
	public SampleCollectionAttributeListsMasterLocalServiceWrapper(
		SampleCollectionAttributeListsMasterLocalService sampleCollectionAttributeListsMasterLocalService) {
		_sampleCollectionAttributeListsMasterLocalService = sampleCollectionAttributeListsMasterLocalService;
	}

	/**
	* Adds the sample collection attribute lists master to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster addSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.addSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
	}

	/**
	* Creates a new sample collection attribute lists master with the primary key. Does not add the sample collection attribute lists master to the database.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key for the new sample collection attribute lists master
	* @return the new sample collection attribute lists master
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster createSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId) {
		return _sampleCollectionAttributeListsMasterLocalService.createSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Deletes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws PortalException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster deleteSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.deleteSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Deletes the sample collection attribute lists master from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster deleteSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.deleteSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster fetchSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.fetchSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	/**
	* Returns the sample collection attribute lists master with the primary key.
	*
	* @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	* @return the sample collection attribute lists master
	* @throws PortalException if a sample collection attribute lists master with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster getSampleCollectionAttributeListsMaster(
		long sampleCollectionAttributeListsMasterId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.getSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMasterId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> getSampleCollectionAttributeListsMasters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.getSampleCollectionAttributeListsMasters(start,
			end);
	}

	/**
	* Returns the number of sample collection attribute lists masters.
	*
	* @return the number of sample collection attribute lists masters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSampleCollectionAttributeListsMastersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.getSampleCollectionAttributeListsMastersCount();
	}

	/**
	* Updates the sample collection attribute lists master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	* @return the sample collection attribute lists master that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster updateSampleCollectionAttributeListsMaster(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.updateSampleCollectionAttributeListsMaster(sampleCollectionAttributeListsMaster);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sampleCollectionAttributeListsMasterLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sampleCollectionAttributeListsMasterLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sampleCollectionAttributeListsMasterLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster> getSampleCollectionAttributeListsMasterByAttributeListName(
		java.lang.String attributeListName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsMasterLocalService.getSampleCollectionAttributeListsMasterByAttributeListName(attributeListName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SampleCollectionAttributeListsMasterLocalService getWrappedSampleCollectionAttributeListsMasterLocalService() {
		return _sampleCollectionAttributeListsMasterLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSampleCollectionAttributeListsMasterLocalService(
		SampleCollectionAttributeListsMasterLocalService sampleCollectionAttributeListsMasterLocalService) {
		_sampleCollectionAttributeListsMasterLocalService = sampleCollectionAttributeListsMasterLocalService;
	}

	@Override
	public SampleCollectionAttributeListsMasterLocalService getWrappedService() {
		return _sampleCollectionAttributeListsMasterLocalService;
	}

	@Override
	public void setWrappedService(
		SampleCollectionAttributeListsMasterLocalService sampleCollectionAttributeListsMasterLocalService) {
		_sampleCollectionAttributeListsMasterLocalService = sampleCollectionAttributeListsMasterLocalService;
	}

	private SampleCollectionAttributeListsMasterLocalService _sampleCollectionAttributeListsMasterLocalService;
}