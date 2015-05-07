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
 * Provides a wrapper for {@link SampleCollectionAttributeListsLocalService}.
 *
 * @author suyama
 * @see SampleCollectionAttributeListsLocalService
 * @generated
 */
public class SampleCollectionAttributeListsLocalServiceWrapper
	implements SampleCollectionAttributeListsLocalService,
		ServiceWrapper<SampleCollectionAttributeListsLocalService> {
	public SampleCollectionAttributeListsLocalServiceWrapper(
		SampleCollectionAttributeListsLocalService sampleCollectionAttributeListsLocalService) {
		_sampleCollectionAttributeListsLocalService = sampleCollectionAttributeListsLocalService;
	}

	/**
	* Adds the sample collection attribute lists to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists addSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.addSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	/**
	* Creates a new sample collection attribute lists with the primary key. Does not add the sample collection attribute lists to the database.
	*
	* @param sampleCollectionAttributeListsId the primary key for the new sample collection attribute lists
	* @return the new sample collection attribute lists
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists createSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId) {
		return _sampleCollectionAttributeListsLocalService.createSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Deletes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws PortalException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.deleteSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Deletes the sample collection attribute lists from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.deleteSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleCollectionAttributeListsLocalService.dynamicQuery();
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
		return _sampleCollectionAttributeListsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sampleCollectionAttributeListsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sampleCollectionAttributeListsLocalService.dynamicQuery(dynamicQuery,
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
		return _sampleCollectionAttributeListsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sampleCollectionAttributeListsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists fetchSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.fetchSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	/**
	* Returns the sample collection attribute lists with the primary key.
	*
	* @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	* @return the sample collection attribute lists
	* @throws PortalException if a sample collection attribute lists with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists getSampleCollectionAttributeLists(
		long sampleCollectionAttributeListsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.getSampleCollectionAttributeLists(sampleCollectionAttributeListsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeListses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.getSampleCollectionAttributeListses(start,
			end);
	}

	/**
	* Returns the number of sample collection attribute listses.
	*
	* @return the number of sample collection attribute listses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSampleCollectionAttributeListsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.getSampleCollectionAttributeListsesCount();
	}

	/**
	* Updates the sample collection attribute lists in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionAttributeLists the sample collection attribute lists
	* @return the sample collection attribute lists that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists updateSampleCollectionAttributeLists(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.updateSampleCollectionAttributeLists(sampleCollectionAttributeLists);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sampleCollectionAttributeListsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sampleCollectionAttributeListsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sampleCollectionAttributeListsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists> getSampleCollectionAttributeListsBySampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleCollectionAttributeListsLocalService.getSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists deleteSampleCollectionAttributeListsBySampleCollectionDbId(
		long sampleCollectionDbId) {
		return _sampleCollectionAttributeListsLocalService.deleteSampleCollectionAttributeListsBySampleCollectionDbId(sampleCollectionDbId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SampleCollectionAttributeListsLocalService getWrappedSampleCollectionAttributeListsLocalService() {
		return _sampleCollectionAttributeListsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSampleCollectionAttributeListsLocalService(
		SampleCollectionAttributeListsLocalService sampleCollectionAttributeListsLocalService) {
		_sampleCollectionAttributeListsLocalService = sampleCollectionAttributeListsLocalService;
	}

	@Override
	public SampleCollectionAttributeListsLocalService getWrappedService() {
		return _sampleCollectionAttributeListsLocalService;
	}

	@Override
	public void setWrappedService(
		SampleCollectionAttributeListsLocalService sampleCollectionAttributeListsLocalService) {
		_sampleCollectionAttributeListsLocalService = sampleCollectionAttributeListsLocalService;
	}

	private SampleCollectionAttributeListsLocalService _sampleCollectionAttributeListsLocalService;
}