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
 * Provides a wrapper for {@link SampleCollectionAttributeListsService}.
 *
 * @author suyama
 * @see SampleCollectionAttributeListsService
 * @generated
 */
public class SampleCollectionAttributeListsServiceWrapper
	implements SampleCollectionAttributeListsService,
		ServiceWrapper<SampleCollectionAttributeListsService> {
	public SampleCollectionAttributeListsServiceWrapper(
		SampleCollectionAttributeListsService sampleCollectionAttributeListsService) {
		_sampleCollectionAttributeListsService = sampleCollectionAttributeListsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _sampleCollectionAttributeListsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sampleCollectionAttributeListsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sampleCollectionAttributeListsService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SampleCollectionAttributeListsService getWrappedSampleCollectionAttributeListsService() {
		return _sampleCollectionAttributeListsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSampleCollectionAttributeListsService(
		SampleCollectionAttributeListsService sampleCollectionAttributeListsService) {
		_sampleCollectionAttributeListsService = sampleCollectionAttributeListsService;
	}

	@Override
	public SampleCollectionAttributeListsService getWrappedService() {
		return _sampleCollectionAttributeListsService;
	}

	@Override
	public void setWrappedService(
		SampleCollectionAttributeListsService sampleCollectionAttributeListsService) {
		_sampleCollectionAttributeListsService = sampleCollectionAttributeListsService;
	}

	private SampleCollectionAttributeListsService _sampleCollectionAttributeListsService;
}