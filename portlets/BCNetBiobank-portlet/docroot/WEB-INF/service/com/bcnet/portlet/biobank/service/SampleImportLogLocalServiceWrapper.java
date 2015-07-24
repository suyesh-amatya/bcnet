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
 * Provides a wrapper for {@link SampleImportLogLocalService}.
 *
 * @author suyama
 * @see SampleImportLogLocalService
 * @generated
 */
public class SampleImportLogLocalServiceWrapper
	implements SampleImportLogLocalService,
		ServiceWrapper<SampleImportLogLocalService> {
	public SampleImportLogLocalServiceWrapper(
		SampleImportLogLocalService sampleImportLogLocalService) {
		_sampleImportLogLocalService = sampleImportLogLocalService;
	}

	/**
	* Adds the sample import log to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleImportLog the sample import log
	* @return the sample import log that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog addSampleImportLog(
		com.bcnet.portlet.biobank.model.SampleImportLog sampleImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.addSampleImportLog(sampleImportLog);
	}

	/**
	* Creates a new sample import log with the primary key. Does not add the sample import log to the database.
	*
	* @param importId the primary key for the new sample import log
	* @return the new sample import log
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog createSampleImportLog(
		long importId) {
		return _sampleImportLogLocalService.createSampleImportLog(importId);
	}

	/**
	* Deletes the sample import log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importId the primary key of the sample import log
	* @return the sample import log that was removed
	* @throws PortalException if a sample import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog deleteSampleImportLog(
		long importId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.deleteSampleImportLog(importId);
	}

	/**
	* Deletes the sample import log from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleImportLog the sample import log
	* @return the sample import log that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog deleteSampleImportLog(
		com.bcnet.portlet.biobank.model.SampleImportLog sampleImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.deleteSampleImportLog(sampleImportLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sampleImportLogLocalService.dynamicQuery();
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
		return _sampleImportLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sampleImportLogLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _sampleImportLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _sampleImportLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _sampleImportLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog fetchSampleImportLog(
		long importId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.fetchSampleImportLog(importId);
	}

	/**
	* Returns the sample import log with the primary key.
	*
	* @param importId the primary key of the sample import log
	* @return the sample import log
	* @throws PortalException if a sample import log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog getSampleImportLog(
		long importId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.getSampleImportLog(importId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sample import logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample import logs
	* @param end the upper bound of the range of sample import logs (not inclusive)
	* @return the range of sample import logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.SampleImportLog> getSampleImportLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.getSampleImportLogs(start, end);
	}

	/**
	* Returns the number of sample import logs.
	*
	* @return the number of sample import logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSampleImportLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.getSampleImportLogsCount();
	}

	/**
	* Updates the sample import log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleImportLog the sample import log
	* @return the sample import log that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.bcnet.portlet.biobank.model.SampleImportLog updateSampleImportLog(
		com.bcnet.portlet.biobank.model.SampleImportLog sampleImportLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sampleImportLogLocalService.updateSampleImportLog(sampleImportLog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sampleImportLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sampleImportLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sampleImportLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SampleImportLogLocalService getWrappedSampleImportLogLocalService() {
		return _sampleImportLogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSampleImportLogLocalService(
		SampleImportLogLocalService sampleImportLogLocalService) {
		_sampleImportLogLocalService = sampleImportLogLocalService;
	}

	@Override
	public SampleImportLogLocalService getWrappedService() {
		return _sampleImportLogLocalService;
	}

	@Override
	public void setWrappedService(
		SampleImportLogLocalService sampleImportLogLocalService) {
		_sampleImportLogLocalService = sampleImportLogLocalService;
	}

	private SampleImportLogLocalService _sampleImportLogLocalService;
}